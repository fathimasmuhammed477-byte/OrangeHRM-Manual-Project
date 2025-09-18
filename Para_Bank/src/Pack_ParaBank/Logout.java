package Pack_ParaBank;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;



public class Logout {
    public static void main(String[] args) {
        
    	System.setProperty("webdriver.gecko.driver","C:\\Users\\Hashinclude\\Documents\\FATHIMA\\geckodriver-v0.26.0-win64\\geckodriver.exe");
		

        WebDriver driver = new FirefoxDriver();

        try {
            driver.manage().window().maximize();
            driver.get("https://parabank.parasoft.com/parabank/index.htm");

            
            driver.findElement(By.name("username")).sendKeys("Fathima");
            driver.findElement(By.name("password")).sendKeys("Muhammed");
            driver.findElement(By.xpath("//input[@value='Log In']")).click();

         
            WebDriverWait wait = new WebDriverWait(driver,20);
            WebElement logoutLink = wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.linkText("Log Out"))
            );

        
            System.out.println("🎉 Login successful as JOHN");

       
            logoutLink.click();

         
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("username")));
            System.out.println("✅ Logout successful");

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            driver.quit(); 
        }
    }
}
