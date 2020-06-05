package LogIn;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LogInPage {

        private WebDriver driver;
        public LogInPage(WebDriver driver) {
            this.driver = driver;
        }

    public void loginAs(String user, String password) {
        WebElement loginInput = driver.findElement(By.name("email"));
        loginInput.click();
        loginInput.clear();
        loginInput.sendKeys(user);

        WebElement passwordInput = driver.findElement(By.name("password"));
        passwordInput.click();
        passwordInput.clear();
        passwordInput.sendKeys(password);

        WebElement submitButton = driver.findElement(By.id("submit-login"));
        submitButton.click();
    }
        public String getLoggedUserName() {
        WebElement loggedUserName = driver.findElement(By.xpath("//a[@class='account']"));
        return loggedUserName.getText();
        }
    }
