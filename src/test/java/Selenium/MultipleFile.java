package Selenium;

import Base.Utility;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.time.Instant;
import java.util.List;
import java.util.Set;

public class MultipleFile extends Utility {
    WebDriver driver = getDriver();

    Actions acts = new Actions(driver);
    public void multipleWindows()
    {
        getURL("https://www.flipkart.com/");
        maximizeWindow();
        applyImplicit();
       wait = new org.openqa.selenium.support.ui.WebDriverWait(driver, java.time.Duration.ofSeconds(10));
        WebElement search = driver.findElement(By.xpath("//input[@title='Search for Products, Brands and More']"));
        search.sendKeys("Iphone17", Keys.ENTER);
        List<WebElement>mobiles = driver.findElements(By.xpath("//div[@class='col col-7-12']"));
        System.out.println("Number of Iphone found: "+mobiles.size());
      WebElement iphone =  wait.until(ExpectedConditions.elementToBeClickable(mobiles.get(1)));
        assert iphone != null;
        iphone.click();
        String currentWin = driver.getWindowHandle();
        System.out.println("Current Window ID: "+currentWin);
      Set<String>allWin = driver.getWindowHandles();
        System.out.println("All Window ID: "+allWin);
      for (String latestID : allWin)
      {
          if(!latestID.equals(currentWin))
          {
              driver.switchTo().window(latestID);
          }

      }

        WebElement cart = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[text()='Add to cart']")));
        cart.click();




    }

    public static void main(String[] args) {
        MultipleFile mf = new MultipleFile();
        mf.multipleWindows();
    }
}
