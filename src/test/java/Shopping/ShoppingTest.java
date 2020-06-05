package Shopping;

import Address.CreateNewAddress;
import LogIn.LogInPage;
import org.apache.commons.io.FileUtils;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import java.io.File;
import java.util.concurrent.TimeUnit;

public class ShoppingTest {
    ShippingAddressPage shippingAddressPage;
    SearchMyStorePage searchMyStorePage;
    SweaterPage sweaterPage;
    WebDriver driver;

    private LogInPage loginPage;

    private String rightSize = "2"; // Size: 1 = S, 2 = M, 3 = L, 4 = XL
    private String rightPieces = "5"; // podaj liczbę, którą chcesz dodać do koszyka
    private String rightInformation ="Product successfully added to your shopping cart.";

    @Before
    public void userGoToMyStoreShop() {

        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exec");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get("https://prod-kurs.coderslab.pl/index.php?");

    }

    @Test
        public void userBuyNewSweater() {
        // logowanie na użytkownika
        WebElement signIn = driver.findElement(By.xpath("//*[@id='_desktop_user_info']/div/a/span"));
        signIn.click();

        LogInPage logInPage = new LogInPage(driver);
        logInPage.loginAs("idasierpniowa@coderslab.pl", "Kurs123");
        Assert.assertEquals("Ida Sierpniowa", logInPage.getLoggedUserName());
        System.out.println("Poprawne zalogowanie użytkownika");

        this.searchMyStorePage = new SearchMyStorePage(driver);
        searchMyStorePage.setClickMyStoreButton();
        searchMyStorePage.setClickSearch();
        searchMyStorePage.setSearchSweater();
        searchMyStorePage.setClickLoup();
        searchMyStorePage.setChooseSweater();

        // określenie parametrów swetra
        this.sweaterPage = new SweaterPage(driver);

            sweaterPage.setSize(rightSize);
            sweaterPage.setPieces(rightPieces);
            sweaterPage.setAddToBasket();
            sweaterPage.setProceedToCheckOut();
            sweaterPage.setToCheckOut();

        // potwierdzenie adresu, wybór formy wysyłki i płatności
        this.shippingAddressPage = new ShippingAddressPage(driver);

        shippingAddressPage.setCheckAddress();
        String actualText = shippingAddressPage.getCheckAddress();
        Assert.assertTrue(actualText.contains("Wielka 3"));
        System.out.println("Address confirmation corected");

        shippingAddressPage.setClickButton();

        shippingAddressPage.setClickShippingMetod();
        shippingAddressPage.setChoosePayByCheck();
        shippingAddressPage.setClickAgree();
        shippingAddressPage.setObligationToPay();

        // zrzut ekranu z zamówieniem
        File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
            try {
                FileUtils.copyFile(scrFile, new File("/Users/Milena/Desktop/Pliki/screenshot.png"));
            } catch (Exception e) {
                System.out.println("File has not been saved to disk.");
            }
    }

    @After
        public void tearDown() throws Exception {
        driver.quit();
        }
}



