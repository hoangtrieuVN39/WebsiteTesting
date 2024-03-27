package PageObjects.Railway;

import Common.Constant.Constant;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class MyTicketPage extends GeneralPage{
    private final By _txtTicket = By.xpath("//h1[@align='center']");
    public  WebElement getMyTicketPage(){
        return Constant.WEBDRIVER.findElement(_txtTicket);
    }
}

