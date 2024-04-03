package PageObjects.Railway;

import Common.Constant.Constant;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class MyTicketPage extends GeneralPage{
    private final By _txtTicket = By.xpath("//h1[@align='center']");
    private final String btnCancel1 = "//input[@onclick='DeleteTicket(" ;
    private final String btnCancel2 = ");']";
    public  WebElement getMyTicketPage(){
        return Constant.WEBDRIVER.findElement(_txtTicket);
    }
    public void CancelTicket (String id) {
        By btnCancel = By.xpath(btnCancel1+id+btnCancel2);
        Constant.WEBDRIVER.findElement(btnCancel).click();
    }
}

