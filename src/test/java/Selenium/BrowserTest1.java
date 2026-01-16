package Selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class BrowserTest1 {
    WebDriver driver = new ChromeDriver();

    public void startDriver() throws InterruptedException {
       driver.get("https://www.facebook.com/");
       driver.manage().window().maximize();
       driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
       WebElement email = driver.findElement(By.id("email"));
       email.sendKeys("JJJJ");
       WebElement password = driver.findElement(By.id("pass"));
       password.sendKeys("12@we");
       WebElement logIn = driver.findElement(By.name("login"));
        logIn.click();
       // Or try this without exceptions, but the webpage closes fast
        // driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        Thread.sleep(10000);
        // If you use Thread, you have to handle the exception in this method and main()
       driver.quit(); // To close the webpage automatically

    }

    public static void main(String[] args) throws InterruptedException {
        BrowserTest1 bt = new BrowserTest1();
        bt.startDriver();
    }

}
