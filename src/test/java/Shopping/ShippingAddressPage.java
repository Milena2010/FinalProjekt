package Shopping;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class ShippingAddressPage {
    private static WebDriver driver;

    public ShippingAddressPage(WebDriver driver) {
        this.driver = driver;

        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//article")
    private List<WebElement> addressList;
    @FindBy(css = ".btn.btn-primary.continue.float-xs-right")
    private WebElement clickButton;
    @FindBy(xpath = "//*[@id='js-delivery']/button")
    private WebElement clickShippingMetod;
    @FindBy(id = "payment-option-1")
    private WebElement choosePayByCheck;
    @FindBy(id = "conditions_to_approve[terms-and-conditions]")
    private WebElement clickAgree;
    @FindBy(xpath = "//*[@id='payment-confirmation']/div[1]/button")
    private WebElement obligationToPay;

    public void setCheckAddress(){
        WebElement tilesCheck = addressList.get(addressList.size() - 1);
        System.out.println(tilesCheck.getText());
    }
    public String getCheckAddress() {
        WebElement tiles = addressList.get(addressList.size() - 1);
        return tiles.getText();
    }

    public void setClickButton() {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        clickButton.click();
    }

    public void setClickShippingMetod() {
        clickShippingMetod.click();
    }
    public void setChoosePayByCheck() {
        choosePayByCheck.click();
    }

    public void setClickAgree() {
            clickAgree.click();
        }

    public void setObligationToPay() {
        obligationToPay.click();
    }
}

