package Pack_ParaBank;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.Select;

public class OpenNewAccount {
    public static void main(String[] args) {

        System.setProperty("webdriver.gecko.driver", "C:\\Users\\Hashinclude\\Documents\\FATHIMA\\geckodriver-v0.26.0-win64\\geckodriver.exe");

        WebDriver driver = new FirefoxDriver();
        driver.manage().window().maximize();

        try {
            WebDriverWait wait = new WebDriverWait(driver, 50);

       
            driver.get("https://parabank.parasoft.com/parabank/index.htm");

            
            WebElement usernameField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("username")));
            WebElement passwordField = driver.findElement(By.name("password"));
            usernameField.sendKeys("Rezaan");
            passwordField.sendKeys("Mehza");

            driver.findElement(By.xpath("//input[@value='Log In']")).click();
            System.out.println("Login successful");

      
            WebElement openAccountLink = wait.until(ExpectedConditions.elementToBeClickable(By.linkText("Open New Account")));
            openAccountLink.click();
            System.out.println("Open New Account page opened");

            
            WebElement fromAccountDropdown = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("fromAccountId")));
            wait.until(driver1 -> {
                Select select = new Select(fromAccountDropdown);
                return select.getOptions().size() > 0;
            });

        
            WebElement accountType = driver.findElement(By.id("type"));
            accountType.sendKeys("CHECKING"); 

            Select fundingAccountDropdown = new Select(fromAccountDropdown);
            fundingAccountDropdown.selectByIndex(0); 

       
            WebElement openButton = driver.findElement(By.xpath("//input[@value='Open New Account']"));
            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", openButton);
            openButton.click();

            WebElement newAccountNum = wait.until(ExpectedConditions.visibilityOfElementLocated(
                    By.xpath("//a[contains(@href,'activity.htm?id=')]")));
            System.out.println("New account opened successfully! Account number: " + newAccountNum.getText());

        } catch (Exception e) {
            System.out.println(" Automation failed: " + e.getMessage());
        } finally {
            driver.quit();
        }
    }
}
