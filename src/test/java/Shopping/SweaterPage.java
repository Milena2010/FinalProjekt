package Shopping;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class SweaterPage {
    private WebDriver driver;

    public SweaterPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//*[@id='main']/div[1]/div[2]/div[1]/div[2]/div/span[1]")
    private WebElement price;

    @FindBy(id = "group_1")
    private WebElement roleDropSize;

    @FindBy(xpath = "//*[@id='quantity_wanted']")
    private WebElement pieces;

    @FindBy(css = ".btn.btn-primary.add-to-cart")
    private WebElement addToBasket;

    @FindBy(xpath = "//*[@id='myModalLabel']")
    private WebElement successInformation;

    @FindBy(xpath = "//a[@class = 'btn btn-primary']")
    private WebElement proceedToCheckOut;

    @FindBy(xpath = "//a[@class = 'btn btn-primary']")
    private WebElement toCheckOut;

    public void setSize(String value) {
        Select drop = new Select(roleDropSize);
        drop.selectByValue(value);
    }
    public void setPieces(String value) {
        pieces.click();
        pieces.clear();
        pieces.clear();
        pieces.clear();
        pieces.clear();
        pieces.clear();
        pieces.clear();
        pieces.clear();
        pieces.clear();
        pieces.clear();
        pieces.clear();
        pieces.sendKeys(value);
    }
    public void setAddToBasket() {
        addToBasket.click();
    }

    public String getSize() {
        Select sizeChoose = new Select(roleDropSize);
        return sizeChoose.getFirstSelectedOption().getAttribute("value");
    }
    public String getPiece() {
        return pieces.getAttribute("value");
    }
    public String getInformation() {
        return successInformation.getAttribute("value");
    }

    public void setProceedToCheckOut()  {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        proceedToCheckOut.click();
    }
    public void setToCheckOut() {
        toCheckOut.click();
    }

//    public String getPrice() {
//        return price.getAttribute("value");
//    }
  }