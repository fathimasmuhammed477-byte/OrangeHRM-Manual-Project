package Pack_ParaBank;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ParaBankLogin {
    public static void main(String[] args) {
    
        System.setProperty("webdriver.gecko.driver","C:\\Users\\Hashinclude\\Documents\\FATHIMA\\geckodriver-v0.26.0-win64\\geckodriver.exe");

        WebDriver driver = new FirefoxDriver();
        
        try {
            driver.manage().window().maximize();
            driver.get("https://parabank.parasoft.com/parabank/index.htm");

            WebDriverWait wait = new WebDriverWait(driver, 10);

            WebElement username = wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.name("username"))
            );
            username.sendKeys("Fathima"); 

            WebElement password = driver.findElement(By.name("password"));
            password.sendKeys("Muhammed"); 

            driver.findElement(By.xpath("//input[@value='Log In']")).click();

            WebElement overview = wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.linkText("Accounts Overview"))
            );

            if (overview.isDisplayed()) {
                System.out.println("Login successful!");
            } else {
                System.out.println("Login failed!");
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            driver.quit();
        }
    }
}
