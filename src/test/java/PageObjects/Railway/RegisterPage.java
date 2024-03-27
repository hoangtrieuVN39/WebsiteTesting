package PageObjects.Railway;

import Common.Constant.Constant;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class RegisterPage extends GeneralPage{
    private final By _txtEmail = By.xpath("//*[@id=\"email\"]");
    private final By _txtPassword = By.xpath("//*[@id=\"password\"]");
    private final By _txtCfPassword = By.xpath("//*[@id=\"confirmPassword\"]");
    private final By _txtPID = By.xpath("//*[@id=\"pid\"]");
    private final By _btnRegister = By.xpath("//input[@value='Register']");
    private final By _lblRegisterErrorMsg = By.xpath("//p[@class='message error']");
    private final By _lblRegisterErrorpwMsg = By.xpath("//label[@for='password' and contains(@class, 'validation-error')]");
    private final By _lblRegisterErrorpidMsg = By.xpath("//label[@for='pid' and contains(@class, 'validation-error')]");
//    private final By _lblRegisterErrorpwMsg = By.cssSelector("label[for='password'].validation-error");
//    private final By _lblRegisterErrorpidMsg = By.cssSelector("label[for='pid'].validation-error");
    public WebElement gettxtEmail(){
        return Constant.WEBDRIVER.findElement(_txtEmail);
    }
    public WebElement gettxtPassword(){
        return Constant.WEBDRIVER.findElement(_txtPassword);
    }
    public WebElement gettxtCFPassword(){
        return Constant.WEBDRIVER.findElement(_txtCfPassword);
    }
    public WebElement gettxtPID(){
        return Constant.WEBDRIVER.findElement(_txtPID);
    }
    public WebElement getTxtBtnRegister()
    {
        return Constant.WEBDRIVER.findElement(_btnRegister);
    }
    public WebElement getlblRegisterErrorMsg()
    {
        return Constant.WEBDRIVER.findElement(_lblRegisterErrorMsg);
    }
    public WebElement getlblRegisterErrorpwMsg()
    {
        return Constant.WEBDRIVER.findElement(_lblRegisterErrorpwMsg);
    }
    public WebElement getlblRegisterErrorpidMsg()
    {
        return Constant.WEBDRIVER.findElement(_lblRegisterErrorpidMsg);
    }
//    String Url_Login_Page;
//    public  String getCurrentPage(){
//        Url_Login_Page = Constant.WEBDRIVER.getCurrentUrl();
//        return Url_Login_Page;
//    }
    public RegisterPage openRegisterPage()
    {
        Constant.WEBDRIVER.navigate().to(Constant.CONFIRM_URL);
        return this;
    }
    public RegisterPage login(String email, String password, String CFpassword, String PID) {
        this.gettxtEmail().sendKeys(email);
        this.gettxtPassword().sendKeys(password);
        this.gettxtCFPassword().sendKeys(CFpassword);
        this.gettxtPID().sendKeys(PID);
        getTxtBtnRegister().submit();
        return new RegisterPage();
    }
}
