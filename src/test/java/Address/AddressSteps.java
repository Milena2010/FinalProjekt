package Address;

import LogIn.LogInPage;
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

    private LogInPage loginPage;
    private CreateNewAddress createNewAddress;
    private String alias;
    private String city;
    private String postCode;
    private String country;
    private String phone;
    private String address;


    @Given("User can logged to MyStore shop site from CodersLab")
    public void userIsLooggedInToMyStoreShop() {

        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exec");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get("https://prod-kurs.coderslab.pl/index.php?controller=authentication");

        LogInPage logInPage = new LogInPage(driver);
        logInPage.loginAs("idasierpniowa@coderslab.pl", "Kurs123");
        Assert.assertEquals("Ida Sierpniowa", logInPage.getLoggedUserName());

        WebElement signIn = driver.findElement(By.xpath("//*[@id='_desktop_user_info']/div/a[2]/span"));
        signIn.click();

        driver.get("https://prod-kurs.coderslab.pl/index.php?controller=addresses");

            CreateNewAddress createNewAddress = new CreateNewAddress(driver);
            createNewAddress.setCreateNewAddress();
}

    @When("User create new address form (.*), (.*), (.*), (.*), (.*), (.*)")
    public void userGoesToAddressPage(String alias, String address, String city, String postCode, String country, String phone) {

        this.createAddressPage = new CreateAddressPage(driver);

// uzupełnienie danych adresowych
        createAddressPage.setAliasInput(alias);
        this.alias = alias;
        createAddressPage.setAddressInput(address);
        this.address = address;
        createAddressPage.setCityInput(city);
        this.city = city;
        createAddressPage.setPostCodeInput(postCode);
        this.postCode = postCode;
        createAddressPage.setRoleDropCountry(country);
        this.country = country;
        createAddressPage.setPhoneInput(phone);
        this.phone = phone;

// zapisanie danych adresowych
        createAddressPage.setSaveAddressInfo();

        createAddressPage.checkTiles();
        String actualText = createAddressPage.getCheckTiles();
        Assert.assertTrue(actualText.contains("Mrs."));
        Assert.assertTrue(actualText.contains(this.alias));

        createAddressPage.setUpdateButton();
    }

    @Then("User check address")

    public void checkAddress() {
        this.createNewAddress = new CreateNewAddress(driver);
        Assert.assertEquals(this.alias, createAddressPage.getAliasCheck());
        System.out.println("Alias field pass");
        Assert.assertEquals(this.address, createAddressPage.getAddressCheck());
        System.out.println("Address field pass");
        Assert.assertEquals(this.city, createAddressPage.getCityCheck());
        System.out.println("City field pass");
        Assert.assertEquals(this.postCode, createAddressPage.getPostCodeCheck());
        System.out.println("Zip/Post code field pass");
        Assert.assertEquals(this.country, createAddressPage.getCountryCheck());
        System.out.println("Country field pass");
        Assert.assertEquals(this.phone, createAddressPage.getPhoneCheck());
        System.out.println("Phone field pass");
    }
}