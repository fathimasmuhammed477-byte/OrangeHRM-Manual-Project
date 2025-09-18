package Pack_ParaBank;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;


import java.util.List;

public class Account_Overview {
    public static void main(String[] args) {

 
    	System.setProperty("webdriver.gecko.driver","C:\\Users\\Hashinclude\\Documents\\FATHIMA\\geckodriver-v0.26.0-win64\\geckodriver.exe");
		
        WebDriver driver = new FirefoxDriver();
        driver.manage().window().maximize();

        try {
            
            driver.get("https://parabank.parasoft.com/parabank/index.htm");

         
            driver.findElement(By.name("username")).sendKeys("Fathima");  
            driver.findElement(By.name("password")).sendKeys("Muhammed");  
            driver.findElement(By.xpath("//input[@value='Log In']")).click();
            System.out.println("Login successful");

            System.out.println("Accounts Overview page loaded");

            WebElement table = driver.findElement(By.xpath("//table[@id='accountTable']"));

            
            List<WebElement> rows = table.findElements(By.xpath(".//tbody/tr"));

            System.out.println("Account Details:");
            for (WebElement row : rows) {
                List<WebElement> cols = row.findElements(By.tagName("td"));
                if (cols.size() >= 3) {
                    String accountNumber = cols.get(0).getText();
                    String balance = cols.get(1).getText();
                    String availableAmount = cols.get(2).getText();
                    System.out.println("Account: " + accountNumber +
                            " | Balance: " + balance +
                            " | Available: " + availableAmount);
                }
            }

        } catch (Exception e) {
            System.out.println("Automation failed: " + e.getMessage());
        } finally {
            driver.quit();
        }
    }
}
