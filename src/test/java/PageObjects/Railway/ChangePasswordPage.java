package PageObjects.Railway;

import Common.Constant.Constant;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class ChangePasswordPage extends GeneralPage{
    private final By _txtChangePassword = By.xpath("//h1[@align='center']");
    private final By _txtcrPassword = By.xpath("//*[@id=\"currentPassword\"]");
    private final By _txtnewPassword = By.xpath("//*[@id=\"newPassword\"]");
    private final By _txtcfPassword = By.xpath("//*[@id=\"confirmPassword\"]");
    private final By _btnChangePassword = By.xpath("//input[@value='Change Password']");
    private final By _lblCPSuccessMsg = By.xpath("//p[@class='message success']");
    public WebElement gettxtcrPassword(){
        return Constant.WEBDRIVER.findElement(_txtcrPassword);
    }
    public WebElement gettxtnewPassword(){
        return Constant.WEBDRIVER.findElement(_txtnewPassword);
    }
    public WebElement gettxtcfPassword(){
        return Constant.WEBDRIVER.findElement(_txtcfPassword);
    }
    public WebElement getBtnChangePassword()
    {
        return Constant.WEBDRIVER.findElement(_btnChangePassword);
    }
    public WebElement getlblCPSuccessMsg()
    {
        return Constant.WEBDRIVER.findElement(_lblCPSuccessMsg);
    }
    public WebElement getChangePasswordPage(){
        return Constant.WEBDRIVER.findElement(_txtChangePassword);
    }
    public ChangePasswordPage change(String crpassword, String newpassword, String cfpassword) {
        this.gettxtcrPassword().sendKeys(crpassword);
        this.gettxtnewPassword().sendKeys(newpassword);
        this.gettxtcfPassword().sendKeys(cfpassword);
        getBtnChangePassword().submit();
        return new ChangePasswordPage();
    }
}
