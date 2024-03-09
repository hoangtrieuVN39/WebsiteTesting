package Railway;

import Constant.Constant;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class LoginPage extends GeneralPage{
    // Locations
    private final By _txtUsername = By.xpath("");
    private final By _txtPassword = By.xpath("");
    private final By _btnLogin = By.xpath("");
    private final By _lblLoginErrorMsg = By.xpath("");
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
    // Methods
    public HomePage login(String username, String password)
    {
        //Submit login credentials
        this.getTxtUsername().sendKeys(username);
        this.getTxtPassword().sendKeys(password);
        this.getTxtBtnLogin().click();
        //land on Home page
        return new HomePage();
    }
}
