package PageObjects.Railway;
import Common.Constant.Constant;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
public class LoginPage extends GeneralPage{
    // Locations
    private final By _txtUsername = By.xpath("//*[@id=\"username\"]");
    private final By _txtPassword = By.xpath("//*[@id=\"password\"]");
    private final By _btnLogin = By.xpath("//*[@id=\"content\"]/form/fieldset/p/input");
    private final By _lblLoginErrorMsg = By.xpath("//p[@class='message error LoginForm']");
    private final By _txtEmailAddress = By.xpath("//*[@id=\"email\"]");
    private final By _btnSendIn = By.xpath("//*[@id=\"content\"]/form/fieldset/p[2]/input");
    // Elements
    public WebElement getTxtUsername()
    {
        return Constant.WEBDRIVER.findElement(_txtUsername);
    }

    public WebElement getTxtPassword()
    {

        return Constant.WEBDRIVER.findElement(_txtPassword);
    }
    public WebElement getTxtBtnLogin()
    {
        return Constant.WEBDRIVER.findElement(_btnLogin);
    }
    public WebElement getlblLoginErrorMsg()
    {
        return Constant.WEBDRIVER.findElement(_lblLoginErrorMsg);
    }
    public WebElement getlblBookTicketErrorMsg()
    {
        return Constant.WEBDRIVER.findElement(_lblLoginErrorMsg);
    }
    public WebElement getTxtEmailAddress()
    {
        return Constant.WEBDRIVER.findElement(_txtEmailAddress);
    }
    public WebElement getBtnSendIn()
    {
        return Constant.WEBDRIVER.findElement(_btnSendIn);
    }
    // Methods
    public HomePage login(String username, String password)
    {
        //Submit login credentials
        this.getTxtUsername().sendKeys(username);
        this.getTxtPassword().sendKeys(password);
        getTxtBtnLogin().submit();
        //JavascriptExecutor executor = (JavascriptExecutor) Constant.WEBDRIVER;
       // executor.executeScript("arguments[0].click();", this.getTxtBtnLogin());
//        Actions actions = new Actions(Constant.WEBDRIVER);
//        actions.moveToElement(getTxtBtnLogin()).click().perform();
//        this.getTxtBtnLogin().click();
        return new HomePage();
    }
    public LoginPage Getemail(String sendemail){
        this.getTxtEmailAddress().sendKeys(sendemail);
        getBtnSendIn().submit();
        return new LoginPage();
    }
}

