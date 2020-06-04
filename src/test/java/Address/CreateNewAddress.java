package Address;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateNewAddress {
    private static WebDriver driver;

    public CreateNewAddress(WebDriver driver) {
        this.driver = driver;

        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath="//*[@id='content']/div[2]/a")
    private WebElement createNewAddress;

    public void setCreateNewAddress() {
        createNewAddress.click();
    }
}