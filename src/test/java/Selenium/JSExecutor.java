package Selenium;

import Base.Utility;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;
import java.util.Set;

public class JSExecutor extends Utility {
    WebDriver driver = getDriver();
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
    public void amazon_Shopping() throws InterruptedException {
        getURL("https://www.amazon.in/");
        maximizeWindow(); applyImplicit();
        WebElement search = driver.findElement(By.id("twotabsearchtextbox"));
        search.sendKeys("ONE PLUS MOBILE", Keys.ENTER);
        List<WebElement>mobiles = driver.findElements(By.xpath("//h2[@class='a-size-medium a-spacing-none a-color-base a-text-normal']"));
        System.out.println("The total number of One plus mobiles available is: "+mobiles.size());
        WebElement page1 = driver.findElement(By.xpath("//span[@aria-label='Page 1']"));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        //js.executeScript("arguments[0].scrollIntoView(true);", page1);
        js.executeScript("arguments[0].scrollIntoView({behavior: 'smooth', block: 'center'});", page1);
        js.executeScript("arguments[0].click();", mobiles.get(1));
        String currentWin = driver.getWindowHandle();
        System.out.println("Current WindowID: "+currentWin);
        Set<String>allWin = driver.getWindowHandles();
        System.out.println("All Window IDs: "+allWin);
        for (String latestWin:allWin)
        {
            if(!latestWin.equals(currentWin))
            {
                driver.switchTo().window(latestWin);
            }
        }
        WebElement buy = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@title='Buy Now']")));
        assert  buy != null;
        Thread.sleep(2000);
        js.executeScript("arguments[0].scrollIntoView({block: 'center'});", buy);


        js.executeScript("arguments[0].click();", buy);






    }

    public static void main(String[] args) throws InterruptedException {
        JSExecutor je = new JSExecutor();
        je.amazon_Shopping();
    }
}
