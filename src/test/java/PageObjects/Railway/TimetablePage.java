package PageObjects.Railway;

import Common.Constant.Constant;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class TimetablePage extends GeneralPage{
    private final By tabbookticket =By.xpath("//*[@id=\"content\"]/div/div/table/tbody/tr[24]/td[7]/a");
    public WebElement gettabbookticket(){
        return Constant.WEBDRIVER.findElement(tabbookticket);
    }
    String Url_Login_Page;
    public  String getCurrentPage(){
        Url_Login_Page = Constant.WEBDRIVER.getCurrentUrl();
        return Url_Login_Page;
    }
    public TimetablePage gotobookticketPage() {
        this.gettabbookticket().click();
        return new TimetablePage();
    }
}
