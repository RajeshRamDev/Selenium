package Selenium;

import Base.Utility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Amazon extends Utility {

    WebDriver driver = getDriver();
    Actions acts = new Actions(driver);
    public void mobileShopping() {
        getURL("https://www.amazon.in/");
        maximizeWindow();
        applyImplicit();

        try {
            WebElement mobiles = driver.findElement(By.xpath("//a[text()='Mobiles']"));
            acts.moveToElement(mobiles).click().build().perform();
            WebElement titleMobiles = driver.findElement(By.xpath("//h2[contains(text(),'Accessories')]"));
            String mobileTitle = titleMobiles.getText();
            System.out.println("The page is loaded to: " + mobileTitle);
        } catch (Exception e) {
            System.out.println("Reload Web Page");
        }

        try {
            WebElement a45g = driver.findElement(By.xpath("//span[contains(text(),'Redmi A4 5G')]"));
            a45g.click();
            WebElement a45gTitle = driver.findElement(By.xpath("//span[@id='productTitle']"));
            String titleA4g5 = a45gTitle.getText();
            System.out.println("The Mobile Chosen from the list is: " + titleA4g5);
            WebElement buy = driver.findElement(By.xpath("//input[@id='buy-now-button']"));
            acts.moveToElement(buy).click().build().perform();
            System.out.println("You have purchased: "+titleA4g5);
        } catch (Exception e) {
            System.out.println("Choose a mobile from the list");
        }
    }
    public static void main(String[] args) {
        Amazon an = new Amazon();
        an.mobileShopping();
    }
}
