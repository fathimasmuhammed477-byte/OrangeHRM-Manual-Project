package Pack_ParaBank;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.Select;

public class Bill_Pay {
    public static void main(String[] args) {

        System.setProperty("webdriver.gecko.driver","C:\\Users\\Hashinclude\\Documents\\FATHIMA\\geckodriver-v0.26.0-win64\\geckodriver.exe");

        WebDriver driver = new FirefoxDriver();
        driver.manage().window().maximize();

        try {
            WebDriverWait wait = new WebDriverWait(driver, 50);

      
            driver.get("https://parabank.parasoft.com/parabank/index.htm");

            WebElement usernameField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("username")));
            WebElement passwordField = driver.findElement(By.name("password"));
            usernameField.sendKeys("Fathima");
            passwordField.sendKeys("Muhammed");
            driver.findElement(By.xpath("//input[@value='Log In']")).click();
            System.out.println(" Login successful");

            WebElement billPayLink = wait.until(ExpectedConditions.elementToBeClickable(By.linkText("Bill Pay")));
            billPayLink.click();
            System.out.println("Bill Pay page opened");

          
            driver.findElement(By.name("payee.name")).sendKeys("Electric Company");
            driver.findElement(By.name("payee.address.street")).sendKeys("123 Main St");
            driver.findElement(By.name("payee.address.city")).sendKeys("New York");
            driver.findElement(By.name("payee.address.state")).sendKeys("NY");
            driver.findElement(By.name("payee.address.zipCode")).sendKeys("10001");
            driver.findElement(By.name("payee.phoneNumber")).sendKeys("1234567890");
            driver.findElement(By.name("payee.accountNumber")).sendKeys("987654321");
            driver.findElement(By.name("verifyAccount")).sendKeys("987654321");
            driver.findElement(By.name("amount")).sendKeys("100");

    
            WebElement fromAccountDropdown = driver.findElement(By.name("fromAccountId"));
            Select selectAccount = new Select(fromAccountDropdown);
            selectAccount.selectByIndex(0);

           
            WebElement sendPaymentBtn = driver.findElement(By.xpath("//input[@value='Send Payment']"));
            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", sendPaymentBtn);
            sendPaymentBtn.click();

      
            WebElement successMsg = wait.until(ExpectedConditions.visibilityOfElementLocated(
                    By.xpath("//h1[contains(text(),'Bill Payment Complete')]")));
            if (successMsg.isDisplayed()) {
                System.out.println(" Bill payment completed successfully!");
            }

        } catch (Exception e) {
            System.out.println("Automation failed: " + e.getMessage());
        } finally {
            driver.quit();
        }
    }
}
