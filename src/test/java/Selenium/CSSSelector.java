package Selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class CSSSelector {
    WebDriver driver = new ChromeDriver();
    public void cssLocator() throws InterruptedException {
        driver.get("https://www.facebook.com/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
//      WebElement email = driver.findElement(By.cssSelector("input#email"));
//      email.sendKeys("Raaaj");
//      WebElement pass = driver.findElement(By.cssSelector("input[placeholder='Password']"));
//      pass.sendKeys("#feg");
//      WebElement login  = driver.findElement(By.cssSelector("button[data-testid='royal-login-button'][type='submit']"));
//      login.click();
      WebElement create = driver.findElement(By.cssSelector("a[href='/r.php?entry_point=login'][data-testid='open-registration-form-button']"));
      create.click();
      Thread.sleep(5000);
        driver.quit();


    }

    public static void main(String[] args) throws InterruptedException {
        CSSSelector cs = new CSSSelector();
        cs.cssLocator();
    }
}
