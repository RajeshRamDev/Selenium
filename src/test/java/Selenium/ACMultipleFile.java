package Selenium;

import Base.Utility;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;
import java.util.Set;

public class ACMultipleFile extends Utility {
    WebDriver driver = getDriver();
    Actions acts = new Actions(driver);
    public void AC_Shopping()
    {
        getURL("https://www.flipkart.com/");
        maximizeWindow();
        applyImplicit();
       // wait = new org.openqa.selenium.support.ui.WebDriverWait(driver, java.time.Duration.ofSeconds(10));
        wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        WebElement searchAC = driver.findElement(By.xpath("//input[@title='Search for Products, Brands and More']"));
        searchAC.sendKeys("LG AC 1.5 Ton", Keys.ENTER);
       List<WebElement>lgACist = driver.findElements(By.xpath("//div[@class ='col col-7-12']"));
        System.out.println("Number of LG Brand 1.5 ton AC in Flipkart: "+lgACist.size());
        WebElement lg2025 = wait.until(ExpectedConditions.elementToBeClickable(lgACist.get(1)));
        assert lg2025 != null;
        lg2025.click();
        String currentWin = driver.getWindowHandle();
        System.out.println("Current WindowID: "+currentWin);
        Set<String>allWin = driver.getWindowHandles();
        System.out.println("All WindowsID: "+allWin);
        for(String latestWinID:allWin)
        {
            if(!latestWinID.equals(currentWin))
            {
                driver.switchTo().window(latestWinID);
            }
        }
        WebElement cart = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[text()='Add to cart']")));
        assert cart != null;
        cart.click();






    }

    public static void main(String[] args) {
        ACMultipleFile mf = new ACMultipleFile();
        mf.AC_Shopping();
    }
}
