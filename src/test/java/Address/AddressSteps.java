package Address;

import LogIn.LoginUserPage;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.concurrent.TimeUnit;

public class AddressSteps {
    CreateAddressPage createAddressPage;
    WebDriver driver;

    @Given("User can logged to MyStore shop site from CodersLab")
    public void userIsLooggedInToMyStoreShop() {
            System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exec");
            driver = new ChromeDriver();
            driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
            driver.manage().window().maximize();
            driver.get("https://prod-kurs.coderslab.pl/index.php?controller=authentication");

            LoginUserPage loginUserPage = new LoginUserPage(driver);
            loginUserPage.loginAs("idasierpniowa@coderslab.pl", "Kurs123");
            Assert.assertEquals("Ida Sierpniowa", loginUserPage.getLoggedUserName());

            WebElement signIn = driver.findElement(By.xpath("//*[@id='_desktop_user_info']/div/a[2]/span"));
            signIn.click();
    }

    @When("User create new address form (.*), (.*), (.*), (.*), (.*), (.*)  check information")
    public void userGoesToAddressPage(String alias, String address, String city, String postalCode, String country, String phone) {

            WebElement addAddress = driver.findElement(By.xpath("//*[@id='address-link']"));
            addAddress.click();

            this.createAddressPage = new CreateAddressPage(driver);
            createAddressPage.setAliasInput(alias);
            createAddressPage.setAddressInput(address);
            createAddressPage.setCityInput(city);
            createAddressPage.setPostalCodeInput(postalCode);
            createAddressPage.setCountryDropDown(country);
            createAddressPage.setPhoneInput(phone);
            Assert.assertEquals("Mrs.", createAddressPage.getAliasCheck());
            Assert.assertEquals("Wielka 3", createAddressPage.getAddressCheck());
            Assert.assertEquals("Wrocław", createAddressPage.getCityCheck());
            Assert.assertEquals("50-077", createAddressPage.getPostalCodeCheck());
            Assert.assertEquals("United Kingdom", createAddressPage.getCountryCheck());
            Assert.assertEquals("+55666777", createAddressPage.getPhoneCheck());
    }
    @And("User click save button")
    public void clickButton() {
        createAddressPage.saveAddressInfo();
    }
    @And("User sees information (.*)")
    public void successSave(String message) {
            Assert.assertEquals(message, createAddressPage.getUpdateInformation());
    }

    @Then("User remove address checking the deletion with information (.*)")
    public void addressRemove() {
        WebElement deleteAddress = driver.findElement(By.xpath("//*[@id='address-3587']/div[2]/a[2]"));
        deleteAddress.click();
    }
    public void successAddressDeleted(String message) {
        Assert.assertEquals(message, createAddressPage.getDeleteInformation());
    }
}
