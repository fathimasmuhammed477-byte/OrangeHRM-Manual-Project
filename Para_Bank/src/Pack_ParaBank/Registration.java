package Pack_ParaBank;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.UUID;

public class Registration {

    public static void main(String[] args) throws InterruptedException {
       
        System.setProperty("webdriver.gecko.driver", 
            "C:\\Users\\Hashinclude\\Documents\\FATHIMA\\geckodriver-v0.26.0-win64\\geckodriver.exe");

        WebDriver driver = new FirefoxDriver();
        driver.manage().window().maximize();

       
        driver.get("https://parabank.parasoft.com/parabank/register.htm");

        String username = "user" + UUID.randomUUID().toString().substring(0, 5);
        String password = "Test@123";


        driver.findElement(By.id("customer.firstName")).sendKeys("Fathima");
        driver.findElement(By.id("customer.lastName")).sendKeys("Muhammed");
        driver.findElement(By.id("customer.address.street")).sendKeys("123 Main Street");
        driver.findElement(By.id("customer.address.city")).sendKeys("Kochi");
        driver.findElement(By.id("customer.address.state")).sendKeys("Kerala");
        driver.findElement(By.id("customer.address.zipCode")).sendKeys("682001");
        driver.findElement(By.id("customer.phoneNumber")).sendKeys("9876543210");
        driver.findElement(By.id("customer.ssn")).sendKeys("111-22-3333");

        driver.findElement(By.id("customer.username")).sendKeys(username);
        driver.findElement(By.id("customer.password")).sendKeys(password);
        driver.findElement(By.id("repeatedPassword")).sendKeys(password);

      
        driver.findElement(By.xpath("//input[@value='Register']")).click();

     
        try {
            WebElement welcomeMsg = driver.findElement(By.xpath("//h1[contains(text(),'Welcome')]"));
            if (welcomeMsg.isDisplayed()) {
                System.out.println("Registration successful!");
                System.out.println("Use credentials:");
                System.out.println("   Username: " + username);
                System.out.println("   Password: " + password);
            }
        } catch (Exception e) {
            System.out.println("Registration may have failed.");
        }

        Thread.sleep(4000);
        driver.quit();
    }
}
