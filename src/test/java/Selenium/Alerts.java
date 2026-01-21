package Selenium;

import Base.Utility;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.tracing.opentelemetry.SeleniumSpanExporter;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Alerts extends Utility {
    WebDriver driver = getDriver();
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
    Actions acts = new Actions(driver);
    public void handling_Alerts() throws InterruptedException {
       getURL("https://testautomationpractice.blogspot.com/");
       maximizeWindow();
       applyImplicit();
        WebElement simpleAlert = driver.findElement(By.id("alertBtn"));
        simpleAlert.click();
        Thread.sleep(2000);
        Alert al = driver.switchTo().alert();
        al.accept();
        WebElement confirmationAlert = driver.findElement(By.id("confirmBtn"));
        confirmationAlert.click();
        Thread.sleep(2000);
        al.accept();
        WebElement promptAlert = driver.findElement(By.id("promptBtn"));
        promptAlert.click();
        Thread.sleep(2000);
        al.accept();
        WebElement text = driver.findElement(By.xpath("//p[text()='Hello Harry Potter! How are you today?']"));
        String success = text.getText();
        if(success.equals("Hello Harry Potter! How are you today?"))
        {
            System.out.println("Message is matched by Prompt Alert with message: "+success);
        } else {
            System.out.println("Mismatch message, User cancelled the prompt");
        }
        Thread.sleep(5000);


    }

    public static void main(String[] args) throws InterruptedException {
        Alerts at = new Alerts();
        at.handling_Alerts();
    }
}
