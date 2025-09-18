package Pack_ParaBank;



import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Update_Contact_Info {

    public static void main(String[] args) {

    	System.setProperty("webdriver.gecko.driver","C:\\Users\\Hashinclude\\Documents\\FATHIMA\\geckodriver-v0.26.0-win64\\geckodriver.exe");
		

        WebDriver driver = new FirefoxDriver();
        driver.manage().window().maximize();

        // Open ParaBank
        driver.get("https://parabank.parasoft.com/parabank/index.htm");

        // Login
        driver.findElement(By.name("username")).sendKeys("john");
        driver.findElement(By.name("password")).sendKeys("demo");
        driver.findElement(By.xpath("//input[@value='Log In']")).click();

        WebDriverWait wait = new WebDriverWait(driver, 15);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.linkText("Accounts Overview")));

        System.out.println("✅ Login successful");

        // Navigate to Update Contact Info
        wait.until(ExpectedConditions.elementToBeClickable(By.linkText("Update Contact Info"))).click();
        System.out.println("✅ Update Contact Info page opened");

        // Fill in update form
        driver.findElement(By.id("customer.firstName")).clear();
        driver.findElement(By.id("customer.firstName")).sendKeys("John");

        driver.findElement(By.id("customer.lastName")).clear();
        driver.findElement(By.id("customer.lastName")).sendKeys("Doe");

        driver.findElement(By.id("customer.address.street")).clear();
        driver.findElement(By.id("customer.address.street")).sendKeys("123 Main St");

        driver.findElement(By.id("customer.address.city")).clear();
        driver.findElement(By.id("customer.address.city")).sendKeys("Metropolis");

        driver.findElement(By.id("customer.address.state")).clear();
        driver.findElement(By.id("customer.address.state")).sendKeys("NY");

        driver.findElement(By.id("customer.address.zipCode")).clear();
        driver.findElement(By.id("customer.address.zipCode")).sendKeys("10001");

        driver.findElement(By.id("customer.phoneNumber")).clear();
        driver.findElement(By.id("customer.phoneNumber")).sendKeys("1234567890");

        // Click Update Profile
        driver.findElement(By.xpath("//input[@value='Update Profile']")).click();
        System.out.println("✅ Profile updated successfully");

        driver.quit();
    }
}
