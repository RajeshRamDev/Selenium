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

public class SamsungShopping extends Utility {
    WebDriver driver = getDriver();
    Actions acts = new Actions(driver);
    public void earbuds_Shopping()
    {
        getURL("https://www.flipkart.com/");
        maximizeWindow();
        applyImplicit();
        wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        WebElement searchAC = driver.findElement(By.xpath("//input[@title='Search for Products, Brands and More']"));
        searchAC.sendKeys("Samsung ear buds", Keys.ENTER);
        List<WebElement>earBuds = driver.findElements(By.xpath("//div[@class='lWX0_T']"));
        System.out.println("Number of Samsung Ear buds in flipkart: "+earBuds.size());
        WebElement coreBlack = wait.until(ExpectedConditions.elementToBeClickable(earBuds.get(0)));
        assert coreBlack != null;
        coreBlack.click();
        String currentWin = driver.getWindowHandle();
        System.out.println("CurrentWindowID: "+currentWin);
        Set<String>allWin = driver.getWindowHandles();
        System.out.println("ALL Window IDs: "+allWin);
        for (String latestWin:allWin)
        {
            if(!latestWin.equals(currentWin))
            {
                driver.switchTo().window(latestWin);
            }
        }
        WebElement cart = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[text()='Add to cart']")));
        assert cart != null;
        cart.click();




    }

    public static void main(String[] args) {
        SamsungShopping ss = new SamsungShopping();
        ss.earbuds_Shopping();
    }

}
