package Selenium;

import Base.Utility;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class MobileShopping extends Utility {
    WebDriver driver = getDriver();
    Actions acts = new Actions(driver);
    public void mobile_Purchase()
    {
        getURL("https://www.flipkart.com/");
        maximizeWindow();
        applyImplicit();
        WebElement search = driver.findElement(By.xpath("//input[@title='Search for Products, Brands and More']"));
        search.sendKeys("Mobiles", Keys.ENTER);
        try {
            WebElement title = driver.findElement(By.xpath("//a[text()='Mobiles']"));
            String titlePage = title.getText();
            System.out.println("You searched for: "+titlePage);
        } catch (Exception e) {
            System.out.println("Mobile Page is not loaded");
        }
        WebElement iqoo = driver.findElement(By.xpath("//input[@placeholder='Search Brand']"));
        iqoo.sendKeys("IQOO");
        acts.moveToElement(iqoo).click().build().perform();
        try {
            WebElement iqooCheck = driver.findElement(By.xpath("//div[text()= 'IQOO']"));
            String iqooMobile = iqooCheck.getText();
            System.out.println("The Brand you searched for: "+iqooMobile);
            acts.moveToElement(iqooCheck).click().build().perform();
        } catch (Exception e) {
            System.out.println("IQOO mobiles are not available");
        }


    }

    public static void main(String[] args) {
        MobileShopping ms = new MobileShopping();
        ms.mobile_Purchase();
    }
}
