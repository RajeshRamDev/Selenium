package Selenium;

import Base.Utility;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class FlipKart extends Utility {
    WebDriver driver = getDriver();
    Actions acts = new Actions(driver);
    public void tvAppliancesMethod()
    {
       getURL("https://www.flipkart.com/");
       maximizeWindow();
       applyImplicit();
        try {
            WebElement closePopup =driver.findElement(By.xpath("//span[contains(text(),'✕')]"));
            closePopup.click();
            System.out.println("Close Log in Popup");
        } catch (Exception e) {
            System.out.println("No login Popup found");
        }
        WebElement tvApp = driver.findElement(By.xpath("//span[contains(text(),'Appliances')]"));
        tvApp.click();
      WebElement tvAppTitle =  driver.findElement(By.xpath("//h1[contains(text(),'Appliance')]"));
      String tvTitle = tvAppTitle.getText();
        System.out.println("Title: "+tvTitle);
        WebElement tvApp1 = driver.findElement(By.xpath("//span[contains(text(),'Appliances')]"));
        acts.moveToElement(tvApp1).click().build().perform();
        WebElement tv = driver.findElement(By.linkText("Television"));
        String tvTitle1 = tv.getText();
        System.out.println("Title in TV Dropdown box: "+tvTitle1);
        acts.moveToElement(tv).click().build().perform();
        try {
            WebElement tvStore = driver.findElement(By.xpath("//h1[text()='Televisions Store']"));
            String tvStoreTitle = tvStore.getText();
            System.out.println("Title in TVs Page:  "+tvStoreTitle);
        } catch (Exception e) {
            System.out.println("TV Page is not loaded, search for TVs");
        }
        WebElement tvSearch = driver.findElement(By.xpath("//input[@placeholder='Search Brand']"));
        tvSearch.sendKeys("SONY", Keys.ENTER);
        WebElement sonySearch = driver.findElement(By.xpath("//div[text()='SONY']"));
        String sonySear = sonySearch.getText();
        System.out.println("TV Brand you searched for is: "+sonySear);
        acts.moveToElement(sonySearch).click().build().perform();
        WebElement sortBy = driver.findElement(By.xpath("//span[text()='Sort By']"));
        String sort = sortBy.getText();
        System.out.println(sort);
        try {
            WebElement bravia = driver.findElement(By.xpath("//a[contains(text(),'BRAVIA 2 II 108 cm')]"));
           String parentWindow = driver.getWindowHandle();
            bravia.click();
            System.out.println("Waiting to load new window");
            for (String windowHandle : driver.getWindowHandles()) {
                if (!windowHandle.equals(parentWindow)) {
                    driver.switchTo().window(windowHandle);
                    break;
                }
            }
  WebElement braviaSony = driver.findElement(By.xpath("//*[contains(text(),'SONY BRAVIA 2 II')]"));
            String brav = braviaSony.getText();
            System.out.println("The TV you have chosen is: "+brav);
        } catch (Exception e) { 
            System.out.println("Search for TV only");
        }


    }

    public static void main(String[] args) {
        FlipKart ft = new FlipKart();
        ft.tvAppliancesMethod();
    }
}
