package Selenium;

import Base.Utility;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Set;

public class Practice1 extends Utility {
    WebDriver driver = getDriver();
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
    Actions act = new Actions(driver);
    Select sl;
    public void practiceMethod()
    {
        getURL("https://rahulshettyacademy.com/AutomationPractice/");maximizeWindow();applyImplicit();
        WebElement radio = driver.findElement(By.xpath("//input[@value='radio2']"));
        radio.click();
        WebElement country = driver.findElement(By.xpath("//input[@placeholder ='Type to Select Countries']"));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].value='India';",country);
        WebElement select = driver.findElement(By.id("dropdown-class-example"));
        sl = new Select(select);
        sl.selectByValue("option1");
        WebElement switchWin = driver.findElement(By.id("openwindow"));
        switchWin.click();
        String currentWin = driver.getWindowHandle();
        Set<String>allWin = driver.getWindowHandles();
            for(String latestWin:allWin)
            {
                if(!latestWin.equals(currentWin))
                {
                    driver.switchTo().window(latestWin);
                }
            }
            driver.switchTo().window(currentWin);
            WebElement tab = driver.findElement(By.id("opentab"));
            tab.click();
            Set<String>allTabs = driver.getWindowHandles();
            for (String latestTab:allTabs)
            {
                if (!latestTab.equals(currentWin))
                {
                    driver.switchTo().window(latestTab);
                }
            }
            driver.switchTo().window(currentWin);
                WebElement name = driver.findElement(By.xpath("//input[@placeholder ='Enter Your Name']"));
                name.sendKeys("RAJESH RAMDEV");
        driver.findElement(By.id("alertbtn")).click();
        Alert al = driver.switchTo().alert();
        al.accept();
        WebElement hide = driver.findElement(By.id("hide-textbox"));
        hide.click();
        js.executeScript("arguments[0].style.display='block';", hide);

        //js.executeScript("arguments[0].removeAttribute('style');",hide);
        js.executeScript("arguments[0].value='Hidden Message';",hide);
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }


    }

    public static void main(String[] args) {
        Practice1 pr = new Practice1();
        pr.practiceMethod();
    }
}
