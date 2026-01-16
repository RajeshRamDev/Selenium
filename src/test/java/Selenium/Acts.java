package Selenium;

import Base.Utility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class Acts extends Utility {
    WebDriver driver = getDriver();
    Actions actions = new Actions(driver);
    public void flipkartBags()
    {
        getURL("https://www.flipkart.com/");
        maximizeWindow();
        applyImplicit();
        WebElement fashion = findElement(By.xpath("//div[@aria-label ='Fashion']"));
        actions.moveToElement(fashion).perform();
        WebElement luggage = findElement(By.xpath("//a[contains(text(),'Luggage')]"));
        luggage.click();
      WebElement result1 =  findElement((By.xpath("//h1[text()='Bags And Luggage']")));
      if(result1.isDisplayed())
      {
          System.out.println("Bags and Luggage is loaded");
      }
      else {
          System.out.println("Reload page");
      }

    }
    public void flipkartElectronics()
    {
        getURL("https://www.flipkart.com/");
        maximizeWindow();
        applyImplicit();
      WebElement electronics =  findElement(By.xpath("//div[@aria-label='Electronics']"));
     actions.moveToElement(electronics).perform();
   WebElement accessories = findElement(By.xpath("//a[text() ='Cameras & Accessories']"));
    accessories.click();
      WebElement result2 = findElement(By.xpath("//h1[text()='Cameras']"));
      if(result2.isDisplayed())
      {
          System.out.println("Cameras page is Loaded");
      }
      else
      {
          System.out.println("Reload webpage");
      }

    }

    public static void main(String[] args) {
        Acts act = new Acts();
        //act.flipkartBags();
        act.flipkartElectronics();

    }
}