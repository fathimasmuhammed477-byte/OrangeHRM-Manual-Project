package Pack_ParaBank;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;



public class Find_Transaction {

    public static void main(String[] args) throws InterruptedException {

        
        System.setProperty("webdriver.gecko.driver","C:\\Users\\Hashinclude\\Documents\\FATHIMA\\geckodriver-v0.26.0-win64\\geckodriver.exe");

        WebDriver driver = new FirefoxDriver();
        driver.manage().window().maximize();

        WebDriverWait wait = new WebDriverWait(driver, 15);

        driver.get("https://parabank.parasoft.com/parabank/index.htm");

        driver.findElement(By.name("username")).sendKeys("john");
        driver.findElement(By.name("password")).sendKeys("demo");
        driver.findElement(By.xpath("//input[@value='Log In']")).click();

        wait.until(ExpectedConditions.titleContains("ParaBank | Accounts Overview"));
        System.out.println(" Login successful");

      
        driver.findElement(By.linkText("Find Transactions")).click();
        wait.until(ExpectedConditions.titleContains("Find Transactions"));
        System.out.println("Navigated to Find Transactions page");

        
        Select accountDropdown = new Select(driver.findElement(By.id("accountId")));
        accountDropdown.selectByIndex(0); 
        System.out.println("Account selected");

        
        WebElement txnIdField = driver.findElement(By.cssSelector("#criteria\\.transactionId"));
        txnIdField.sendKeys("12345");
        driver.findElement(By.xpath("//input[@value='Find Transactions']")).click();
        System.out.println(" Search by Transaction ID executed");
        Thread.sleep(2000);

      
        WebElement onDateField = driver.findElement(By.cssSelector("#criteria\\.onDate"));
        onDateField.sendKeys("09-10-2025");
        driver.findElement(By.xpath("//input[@value='Find Transactions']")).click();
        System.out.println("Search by Date executed");
        Thread.sleep(2000);

     
        WebElement fromDate = driver.findElement(By.cssSelector("#criteria\\.fromDate"));
        WebElement toDate = driver.findElement(By.cssSelector("#criteria\\.toDate"));
        fromDate.sendKeys("09-01-2025");
        toDate.sendKeys("09-15-2025");
        driver.findElement(By.xpath("//input[@value='Find Transactions']")).click();
        System.out.println("Search by Date Range executed");
        Thread.sleep(2000);

   
        WebElement amountField = driver.findElement(By.cssSelector("#criteria\\.amount"));
        amountField.sendKeys("100");
        driver.findElement(By.xpath("//input[@value='Find Transactions']")).click();
        System.out.println(" Search by Amount executed");
        Thread.sleep(2000);

        
        driver.findElement(By.linkText("Log Out")).click();
        System.out.println("Logout successful");

        driver.quit();
    }
}
