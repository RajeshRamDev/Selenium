package Selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

import java.time.Duration;

public class BrowserTest2 {
    WebDriver driver = new EdgeDriver();
    public void startWebPage() throws InterruptedException {
        driver.get("https://www.facebook.com/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
       WebElement element = driver.findElement(By.id("email"));
       element.sendKeys("RRRJ");
       WebElement password = driver.findElement(By.id("pass"));
       password.sendKeys("###ASAS");
       WebElement login = driver.findElement(By.name("login"));
       login.click();
       Thread.sleep(10000);
       driver.quit();

    }

    public static void main(String[] args) throws InterruptedException {
        BrowserTest2 bt = new BrowserTest2();
        bt.startWebPage();
    }
}
