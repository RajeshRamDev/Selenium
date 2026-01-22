package Selenium;

import Base.Utility;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class AlertPractice extends Utility {
    WebDriver driver = getDriver();
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
    Actions acts = new Actions(driver);
    public void practice_Alerts() throws InterruptedException {
        getURL("https://www.tutorialspoint.com/selenium/practice/alerts.php");
        maximizeWindow(); applyImplicit();
        WebElement simpleAlert = driver.findElement(By.xpath("//button[text()='Alert']"));
        simpleAlert.click();
        Thread.sleep(2000);
        Alert al = driver.switchTo().alert();
        al.accept();
        WebElement clickMe1 = driver.findElement(By.xpath("//button[@onclick='myMessage()']"));
        clickMe1.click();
        Thread.sleep(5000);
        al.accept();
        WebElement clickMe2 = driver.findElement(By.xpath("//button[@onclick='myDesk()']"));
            clickMe2.click();
            Thread.sleep(2000);
            al.accept();

            WebElement succcessMessage = driver.findElement(By.xpath("//div[text()='You pressed OK!']"));
            String sm = succcessMessage.getText();
            System.out.println("The message u get on pressing the confirm box is: "+sm);

            WebElement promptBox = driver.findElement(By.xpath("//button[@onclick='myPromp()']"));
            promptBox.click();
            Thread.sleep(5000);
            al.sendKeys("RAJESH");
        System.out.println(al.getText());
            al.accept();


    }

    public static void main(String[] args) throws InterruptedException {
        AlertPractice ap = new AlertPractice();
        ap.practice_Alerts();
    }
}

