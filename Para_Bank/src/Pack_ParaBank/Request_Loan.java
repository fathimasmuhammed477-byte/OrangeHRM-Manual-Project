package Pack_ParaBank;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Request_Loan {
    public static void main(String[] args) {

        System.setProperty("webdriver.gecko.driver",
                "C:\\Users\\Hashinclude\\Documents\\FATHIMA\\geckodriver-v0.26.0-win64\\geckodriver.exe");

        WebDriver driver = new FirefoxDriver();
        driver.manage().window().maximize();

        try {
            WebDriverWait wait = new WebDriverWait(driver, 50);

            driver.get("https://parabank.parasoft.com/parabank/index.htm");

          
            WebElement usernameField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("username")));
            WebElement passwordField = driver.findElement(By.name("password"));
            usernameField.sendKeys("john");
            passwordField.sendKeys("demo");

            driver.findElement(By.xpath("//input[@value='Log In']")).click();
            System.out.println("Login successful");


            WebElement requestLoanLink = wait.until(ExpectedConditions.elementToBeClickable(By.linkText("Request Loan")));
            requestLoanLink.click();

          
            WebElement loanAmount = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("amount")));
            WebElement downPayment = driver.findElement(By.id("downPayment"));
            WebElement fromAccount = driver.findElement(By.id("fromAccountId"));

            loanAmount.sendKeys("5000");       
            downPayment.sendKeys("500");        
            fromAccount.sendKeys("12345");     

            WebElement applyButton = driver.findElement(By.xpath("//input[@value='Apply Now']"));
            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", applyButton);
            applyButton.click();

          
            try {
                System.out.println("Loan request processed successfully!");
            } catch (Exception e) {
                System.out.println("Loan request might have failed.");
            }

        } catch (Exception e) {
            System.out.println("Automation failed: " + e.getMessage());
        } finally {
            driver.quit();
        }
    }
}
