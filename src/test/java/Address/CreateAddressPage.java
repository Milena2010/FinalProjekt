package Address;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class CreateAddressPage {
    private static WebDriver driver;

    public CreateAddressPage(WebDriver driver) {
        this.driver = driver;

        PageFactory.initElements(driver, this);
    }

    @FindBy(name = "alias")
    private WebElement aliasInput;
    @FindBy(name = "address1")
    private WebElement addressInput;
    @FindBy(name = "postcode")
    private WebElement postalCodeInput;
    @FindBy(name = "city")
    private WebElement cityInput;
    @FindBy(name = "id_country")
    private WebElement countryDropdown;
    @FindBy(name = "phone")
    private WebElement phoneInput;
    @FindBy(css = ".btn.btn-primary.float-xs-right")
    private WebElement submitButton;
    @FindBy(css = ".alert.alert-success")
    private WebElement successInformation;
    @FindBy(css = ".alert.alert-success")
    private WebElement successAddressDeleted;

    public void setAliasInput(String alias) {
        aliasInput.click();
        aliasInput.clear();
        aliasInput.sendKeys(alias);
    }

    public void setAddressInput(String address) {
        addressInput.click();
        addressInput.clear();
        addressInput.sendKeys(address);
    }

    public void setPostalCodeInput(String postalCode) {
        postalCodeInput.click();
        postalCodeInput.clear();
        postalCodeInput.sendKeys(postalCode);
    }

    public void setCityInput(String city) {
        cityInput.click();
        cityInput.clear();
        cityInput.sendKeys(city);
    }

    public void setCountryDropDown(String value) {
        Select country = new Select(countryDropdown);
        country.selectByValue(value);
    }

    public void setPhoneInput(String phone) {
        phoneInput.click();
        phoneInput.clear();
        phoneInput.sendKeys(phone);
    }

    public void saveAddressInfo() {
        submitButton.click();
    }

    public String getAliasCheck() {
        return aliasInput.getText();
    }

    public String getAddressCheck() {
        return addressInput.getText();
    }

    public String getPostalCodeCheck() {
        return postalCodeInput.getText();
    }

    public String getCityCheck() {
        return cityInput.getText();
    }

    public String getCountryCheck() {
        return countryDropdown.getText();
    }

    public String getPhoneCheck() {
        return phoneInput.getText();
    }

    public String getUpdateInformation() {
        return successInformation.getText();
    }

    public String getDeleteInformation() {
        return successAddressDeleted.getText();
    }
}
