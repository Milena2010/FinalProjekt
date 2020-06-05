package User;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateUserPage {
    private static WebDriver driver;

    public CreateUserPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(name = "firstname")
    private WebElement firstNameInput;
    @FindBy(name = "lastname")
    private WebElement lastNameInput;
    @FindBy(name = "email")
    private WebElement emailInput;
    @FindBy(name = "password")
    private WebElement passwordInput;
    @FindBy(name = "birthday")
    private WebElement birthdayInput;
    @FindBy(css = ".btn.btn-primary.float-xs-right")
    private WebElement submitButton;

    public void setFirstNameInput(String firstname) {
        firstNameInput.click();
        firstNameInput.clear();
        firstNameInput.sendKeys(firstname);
    }

    public void setLastNameInput(String lastname) {
        lastNameInput.click();
        lastNameInput.clear();
        lastNameInput.sendKeys(lastname);
    }
    public void setEmailInput(String email) {
        emailInput.click();
        emailInput.clear();
        emailInput.sendKeys(email);
    }
    public void setPasswordInput(String password) {
        passwordInput.click();
        passwordInput.clear();
        passwordInput.sendKeys(password);
    }
    public void setBirthdayInput(String birthday) {
        birthdayInput.click();
        birthdayInput.clear();
        birthdayInput.sendKeys(birthday);
    }
    public void saveUserInfo() {
        submitButton.click();
    }
}
