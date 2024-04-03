package Testcases.Railway;
import Common.Common.Utilities;
import PageObjects.Railway.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import Common.Constant.Constant;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.Assert;

import java.io.Console;
import java.util.Random;

public class LoginTest {
    @BeforeMethod
    public void beforeMethod() {
        System.out.println("Pre-condition");
        System.setProperty("webdriver.edge.driver", "Executables/msedgedriver.exe");
        Constant.WEBDRIVER = new EdgeDriver();
        Constant.WEBDRIVER.manage();
    }

    @AfterMethod
    public void afterMethod() {
        System.out.println("Post-condition");
//        Constant.WEBDRIVER.quit();
    }

    @Test
    public void TC01() {
        System.out.println("TC01 - User can log into Railway with valid username and password");
        HomePage homePage = new HomePage();
        homePage.open();
        LoginPage loginPage = homePage.gotoLoginPage();
        String actualMsg = loginPage.login(Constant.USERNAME, Constant.PASSWORD).getWelcomeMessage();
        String expectedMsg = "Welcome " + Constant.USERNAME;
        Assert.assertEquals(actualMsg, expectedMsg, "Welcome message is not displayed as expected");
    }

    @Test
    public void TC02() {
        System.out.println("User can't login with blank 'Username' textbox");
        HomePage homePage = new HomePage();
        homePage.open();
        LoginPage LoginPage = homePage.gotoLoginPage();
        LoginPage.login("", Constant.PASSWORD);
        String actualErrorMsg = LoginPage.getlblLoginErrorMsg().getText();
        String expectedErrorMsg = "There was a problem with your login and/or errors exist in your form.";
        Assert.assertEquals(actualErrorMsg, expectedErrorMsg, "Error message is not displayed as expected");
    }

    @Test
    public void TC03() {
        System.out.println("User can't login with blank 'Username' textbox");
        HomePage homePage = new HomePage();
        homePage.open();
        LoginPage LoginPage = homePage.gotoLoginPage();
        LoginPage.login("", Constant.USERNAME);
        String actualErrorMsg = LoginPage.getlblLoginErrorMsg().getText();
        String expectedErrorMsg = "There was a problem with your login and/or errors exist in your form.";
        Assert.assertEquals(actualErrorMsg, expectedErrorMsg, "Error message is not displayed as expected");
    }

    @Test
    public void TC04() {
        System.out.println("Login page displays when un-logged User clicks on Book ticket");
        HomePage homePage = new HomePage();
        homePage.open();
        BookTicketPage bookPage = new BookTicketPage();
        bookPage = homePage.gotoBookTicketPage();
        String actualURL = bookPage.getURL();
        String expectedURL = Constant.RAILWAY_LOGIN_URL;
        Assert.assertEquals(actualURL, expectedURL, "Error message is not displayed as expected");
    }

    @Test
    public void TC05() {
        System.out.println("TC05 - System shows message when user enters wrong password several times");
        HomePage homePage = new HomePage();
        homePage.open();
        LoginPage loginPage = homePage.gotoLoginPage();
        for (int i = 0; i < 5; i++) {
            loginPage.login(Constant.USERNAME, "invalidPassword");
        }
        loginPage.login(Constant.USERNAME, "invalidPassword");
        String actualErrorMsg = loginPage.getlblLoginErrorMsg().getText();
        String expectedErrorMsg = "You have used 4 out of 5 login attempts. After all 5 have been used, you will be unable to login for 15 minutes.";
        Assert.assertEquals(actualErrorMsg, expectedErrorMsg, "Error message is not displayed as expected");
    }

    @Test
    public void TC06() {
        System.out.println("Additional pages display once user logged in");
        HomePage homePage = new HomePage();
        homePage.open();
        LoginPage loginPage = homePage.gotoLoginPage();
        loginPage.login(Constant.USERNAME, Constant.PASSWORD).getWelcomeMessage();
        MyTicketPage ticketPage = new MyTicketPage();
        ticketPage = homePage.gotoMyTicketPage();
        String actualMsgTicket = ticketPage.getMyTicketPage().getText();
        String expectedMsgTicket = "Manage ticket";
        Assert.assertEquals(actualMsgTicket, expectedMsgTicket, "Welcome message is not displayed as expected");
        ChangePasswordPage  ChangePasswordPage = new ChangePasswordPage();
        ChangePasswordPage = ticketPage.gotoChangePasswordPage();
        String actualMsgCP = ticketPage.getMyTicketPage().getText();
        String expectedMsgCP = "Change password";
        Assert.assertEquals(actualMsgCP, expectedMsgCP, "Welcome message is not displayed as expected");
    }

    @Test
    public void TC07() {
        System.out.println("User can create new account");
        HomePage homePage = new HomePage();
        homePage.open();
        RegisterPage Registerpage = new RegisterPage();
        Registerpage = homePage.gotoRegisterPage();
        String actualMsg = Registerpage.login(Constant.EMAIL,Constant.password,Constant.CFpassword,Constant.PID).getWelcomeRegister();
        String expectedMsg = "You're here";
//        String expectedMsg = "Registration Confirmed! You can now log in to the site.";
        Assert.assertEquals(actualMsg, expectedMsg, "Welcome message is not displayed as expected");
    }

    @Test
    public void TC08() {
        System.out.println("User can't login with an account hasn't been activated");
        HomePage homePage = new HomePage();
        homePage.open();
        LoginPage LoginPage = homePage.gotoLoginPage();
        LoginPage.login("gfdhfhf", "gfdgdfg");
        String actualErrorMsg = LoginPage.getlblLoginErrorMsg().getText();
        String expectedErrorMsg = "Invalid username or password. Please try again.";
        Assert.assertEquals(actualErrorMsg, expectedErrorMsg, "Error message is not displayed as expected");
    }

    @Test
    public void TC09() {
        System.out.println("User can change password");
        HomePage homePage = new HomePage();
        homePage.open();
        LoginPage LoginPage = homePage.gotoLoginPage();
        LoginPage.login(Constant.USERNAME, Constant.PASSWORD);
        ChangePasswordPage  CPPage = new ChangePasswordPage();
        CPPage = homePage.gotoChangePasswordPage();
        CPPage.change(Constant.PASSWORD, Constant.PASSWORD, Constant.PASSWORD);
        String actualMsg = CPPage.getlblCPSuccessMsg().getText();
        String expectedMsg = "Your password has been updated!";
        Assert.assertEquals(actualMsg, expectedMsg, "Welcome message is not displayed as expected");
    }

    @Test
    public void TC10() {
        System.out.println("User can't create account with Confirm password is not the same with Password");
        HomePage homePage = new HomePage();
        homePage.open();
        RegisterPage Registerpage = new RegisterPage();
        Registerpage = homePage.gotoRegisterPage();
        Registerpage.login("ytu@gmail.com","thql47k14","jgkg","2233445566");
        String actualMsg = Registerpage.getlblRegisterErrorMsg().getText();
        String expectedMsg = "There're errors in the form. Please correct the errors and try again.";
        Assert.assertEquals(actualMsg, expectedMsg, "Welcome message is not displayed as expected");
    }
    @Test
    public void TC11() {
        System.out.println("User can't create account while password and PID fields are empty");
        HomePage homePage = new HomePage();
        homePage.open();
        RegisterPage Registerpage = new RegisterPage();
        Registerpage = homePage.gotoRegisterPage();
        Registerpage.login("due@gmail.com","","","");
        String actualMsg = Registerpage.getlblRegisterErrorMsg().getText();
        String actualMsgpw = Registerpage.getlblRegisterErrorpwMsg().getText();
        String actualMsgpid = Registerpage.getlblRegisterErrorpidMsg().getText();

        String expectedMsg = "There're errors in the form. Please correct the errors and try again.";
        String expectedMsgpw = "Invalid password length";
        String expectedMsgpid = "Invalid ID length";
        Assert.assertEquals(actualMsg, expectedMsg, "Welcome message is not displayed as expected");
        Assert.assertEquals(actualMsgpw, expectedMsgpw, "Welcome message is not displayed as expected");
        Assert.assertEquals(actualMsgpid, expectedMsgpid, "Welcome message is not displayed as expected");
    }
    @Test
    public void TC12() {
        System.out.println("Errors display when password reset token is blank");
        HomePage homePage = new HomePage();
        homePage.open();
        LoginPage lgp = new LoginPage();
        lgp = homePage.gotoLoginPage();
        lgp.gotofwpwPage();
        lgp.Getemail("TVTHUYEN2003@gmail.com");
    }
    @Test
    public void TC13() {
        System.out.println("Errors display if password and confirm password don't match when resetting password");
        HomePage homePage = new HomePage();
        homePage.open();
        LoginPage lgp = new LoginPage();
        lgp = homePage.gotoLoginPage();
        lgp.gotofwpwPage();
        lgp.Getemail("TVTHUYEN2003@gmail.com");
    }
    @Test
    public void TC14() {
        System.out.println("User can book 1 ticket at a time");
        HomePage homePage = new HomePage();
        homePage.open();
        LoginPage loginPage = homePage.gotoLoginPage();
        loginPage.login(Constant.USERNAME, Constant.PASSWORD);
        BookTicketPage Btk = new BookTicketPage();
        Btk = homePage.gotoBookTicketPage();
        Random random = new Random();
        int randomDateindex = random.nextInt(28) + 3;
        Btk.book(String.valueOf(randomDateindex),"Quãng Ngãi","Đà Nẵng","Hard bed","2");
        String actualMsg = Btk.getlblBookSuccessMsg().getText();
        String expectedMsg = "Ticket booked successfully!";
        Assert.assertEquals(actualMsg, expectedMsg, "Welcome message is not displayed as expected");
    }
    @Test
    public void TC15() {
        System.out.println("User can open \"Book ticket\" page by clicking on \"Book ticket\" link in \"Train timetable\" page");
        HomePage homePage = new HomePage();
        homePage.open();
        LoginPage loginPage = homePage.gotoLoginPage();
        loginPage.login(Constant.USERNAME, Constant.PASSWORD);
        TimetablePage ttp = homePage.gotoTimetablePage();
        BookTicketPage btp = ttp.gotobookticketPage("Huế", "Sài Gòn");
        String depart = btp.getselDepartfromvalue().getText();
        String arrive = btp.getselArrivevalue().getText();
        Assert.assertEquals(depart, "Huế", "Depart location is not displayed as expected");
        Assert.assertEquals(arrive, "Sài Gòn", "Arrive location is not displayed as expected");
    }
    @Test
    public void TC16() {
        System.out.println("User can open \"Book ticket\" page by clicking on \"Book ticket\" link in \"Train timetable\" page");
        HomePage homePage = new HomePage();
        homePage.open();
        LoginPage loginPage = homePage.gotoLoginPage();
        loginPage.login(Constant.USERNAME, Constant.PASSWORD);
        BookTicketPage Btk = new BookTicketPage();
        Btk = homePage.gotoBookTicketPage();
        Random random = new Random();
        int randomDateindex = random.nextInt(28) + 3;
        Btk = Btk.book(String.valueOf(randomDateindex),"Quãng Ngãi","Đà Nẵng","Hard bed","2");
        String url = Btk.getURL();
        String id = url.split("id=")[1];
        MyTicketPage Mtp = homePage.gotoMyTicketPage();
        Mtp.CancelTicket(id);

    }
}