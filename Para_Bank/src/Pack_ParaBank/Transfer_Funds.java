package Pack_ParaBank;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.Select;

public class Transfer_Funds {
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
            System.out.println("Login successful");

         
            WebElement transferFundsLink = wait.until(ExpectedConditions.elementToBeClickable(By.linkText("Transfer Funds")));
            transferFundsLink.click();
            System.out.println("Transfer Funds page opened");

      
            driver.findElement(By.id("amount")).sendKeys("100");

       
            WebElement fromAccountDropdown = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("fromAccountId")));
            wait.until(driver1 -> {
                Select select = new Select(fromAccountDropdown);
                return select.getOptions().size() > 0;
            });


            WebElement toAccountDropdown = driver.findElement(By.id("toAccountId"));
            wait.until(driver1 -> {
                Select select = new Select(toAccountDropdown);
                return select.getOptions().size() > 1;
            });

           
            Select fromSelect = new Select(fromAccountDropdown);
            fromSelect.selectByIndex(0); 

            Select toSelect = new Select(toAccountDropdown);
            toSelect.selectByIndex(1); 

            WebElement transferButton = driver.findElement(By.xpath("//input[@value='Transfer']"));
            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", transferButton);
            transferButton.click();

          
            WebElement successMsg = wait.until(ExpectedConditions.visibilityOfElementLocated(
                    By.xpath("//h1[contains(text(),'Transfer Complete')]")));
            if (successMsg.isDisplayed()) {
                System.out.println("Fund transfer completed successfully!");
            }

        } catch (Exception e) {
            System.out.println(" Automation failed: " + e.getMessage());
        } finally {
            driver.quit();
        }
    }
}
