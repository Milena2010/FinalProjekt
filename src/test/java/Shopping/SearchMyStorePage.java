package Shopping;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SearchMyStorePage {
    private WebDriver driver;

    public SearchMyStorePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//*[@id='_desktop_logo']/a/img")
    private WebElement clickMyStory;
    @FindBy(name = "s")
    private WebElement clickSearch;
    @FindBy(xpath = "//button[@type='submit']")
    private WebElement searchSweater;
    @FindBy(xpath = "//button[@type='submit']")
    private WebElement clickLoup;
    @FindBy(xpath = "//*[@id='js-product-list']/div[1]/article/div/a/img")
    private WebElement chooseSweater;


    public void setClickMyStoreButton() {
        clickMyStory.click();
    }
    public void setClickSearch() {
        clickSearch.click();
    }
    public void setSearchSweater() {
        clickSearch.click();
        clickSearch.sendKeys("Hummingbird Printed Sweater");
    }
    public void setClickLoup() {
        clickLoup.click();
    }
    public void setChooseSweater() {
        chooseSweater.click();
    }
}



