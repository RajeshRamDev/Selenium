package Selenium;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;

public class BrowserTest {
    WebDriver driver = new FirefoxDriver();

    public void startBrowser() {
        driver.get("https://x.com/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));


    }

    public static void main(String[] args) {
        BrowserTest bt = new BrowserTest();
        bt.startBrowser();
    }
}