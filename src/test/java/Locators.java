import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Locators {
    WebDriver driver = new ChromeDriver();
    public void locatorTester() throws InterruptedException {
        driver.get("https://www.facebook.com/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
       WebElement email = driver.findElement(By.id("email"));
       email.sendKeys("Kjjaa");
       WebElement pass = driver.findElement(By.id("pass"));
       pass.sendKeys("@esad");
      WebElement login = driver.findElement(By.name("login"));
      login.click();
      WebElement forgot = driver.findElement(By.linkText("Forgotten password?"));
       forgot.click();

//     WebElement email = driver.findElement(By.cssSelector("#email"));
//     email.sendKeys("eee");
//        WebElement pass = driver.findElement(By.cssSelector("#pass"));
//       pass.sendKeys("@esad");
//       WebElement login = driver.findElement(By.cssSelector("data-testid=\"royal-login-button\""));
//       login.click();
//       WebElement forgot = driver.findElement(By.linkText("Forgotten password?"));
//       forgot.click();

 Thread.sleep(5000);
 driver.quit();

    }

    public static void main(String[] args) throws InterruptedException {
        Locators ls = new Locators();
        ls.locatorTester();
    }
}
