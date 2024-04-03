package PageObjects.Railway;

import Common.Constant.Constant;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class TicketPricePage extends GeneralPage{
    public final By btnBookTicket = By.xpath("//*[@id=\"content\"]/table/tbody/tr[2]/td[3]/a");
    public WebElement getbtnBookTicket() { return Constant.WEBDRIVER.findElement(btnBookTicket); }
    public BookTicketPage gotobookticketPage() {
        this.getbtnBookTicket().click();
        return new BookTicketPage();
    }
}
