package Selenium;

import Base.Utility;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.security.Key;

public class ACShopping extends Utility {
    WebDriver driver = getDriver();
    Actions acts = new Actions(driver);
    public void ac_Purchase(){
        getURL("https://www.flipkart.com/");
        maximizeWindow();
        applyImplicit();
        try {
            WebElement search = driver.findElement(By.xpath("//input[@title='Search for Products, Brands and More']"));
            search.sendKeys("AC", Keys.ENTER);
            WebElement acTitle = driver.findElement(By.xpath("//span[text()='AC']"));
            String acHead = acTitle.getText();
            System.out.println("The page loaded is: "+acHead);
        } catch (Exception e) {
            System.out.println("AC Page is not loaded");
        }
        WebElement searchAC = driver.findElement(By.xpath("//input[@placeholder='Search Brand']"));
        searchAC.sendKeys("IFB");
        try {
            WebElement checkIFB = driver.findElement(By.xpath("//div[text()='IFB']"));
            String ifb = checkIFB.getText();
            System.out.println("The AC Brand Page Loaded is: "+ifb);
            acts.moveToElement(checkIFB).click().build().perform();
        } catch (Exception e) {
            System.out.println("The Brand you chose is not available");
        }


    }

    public static void main(String[] args) {
        ACShopping ac = new ACShopping();
        ac.ac_Purchase();
    }
}
