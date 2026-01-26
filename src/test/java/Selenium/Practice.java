package Selenium;

import Base.Utility;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Set;

public class Practice extends Utility {
    WebDriver driver = getDriver();
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
    Actions acts = new Actions(driver);
    Select sl;
    public void practice_Method() throws InterruptedException {
        getURL("https://www.letskodeit.com/practice"); maximizeWindow(); applyImplicit();
        WebElement radio = driver.findElement(By.id("benzradio"));
        radio.click();
        WebElement check = driver.findElement(By.id("bmwcheck"));
        check.click();
        WebElement openWindow = driver.findElement(By.id("openwindow"));
        openWindow.click();
        String currentWin = driver.getWindowHandle();
        Set<String>allWin = driver.getWindowHandles();
        for(String latestWin: allWin)
        {
            if(!latestWin.equals(currentWin))
            {
                driver.switchTo().window(latestWin);
            }
        }
        WebElement course1 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[contains(@href, 'javascript-for-beginners')]")));
        assert course1 != null;
        course1.click();
        driver.switchTo().window(currentWin);
        WebElement tab = driver.findElement(By.id("opentab"));
        tab.click();
        Set<String>allWinTab = driver.getWindowHandles();
        for (String latestTab: allWinTab)
        {
            if(!latestTab.equals(currentWin))
            {
                    driver.switchTo().window(latestTab);
            }
        }
        WebElement course2 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(  "//p[contains(text(),' Web + API Test Framework')]")));
        assert course2 != null;
        course2.click();
        driver.switchTo().window(currentWin);
        WebElement select = driver.findElement(By.id("carselect"));
        sl = new Select(select);
        sl.selectByValue("honda");
        WebElement multiple = driver.findElement(By.id("multiple-select-example"));
        sl = new Select(multiple);
        sl.selectByValue("apple");
        sl.selectByValue("orange");
        sl.selectByValue("peach");
        WebElement autoSuggestion = driver.findElement(By.id("autosuggest"));
        autoSuggestion.sendKeys("TESLA");
        WebElement disable = driver.findElement(By.id("disabled-button"));
        disable.click();
        JavascriptExecutor js = (JavascriptExecutor) driver;
        WebElement textBox = driver.findElement(By.xpath("//input[@placeholder='Enabled/Disabled Field']"));
        js.executeScript("arguments[0].removeAttribute('placeholder');",textBox);
        js.executeScript("arguments[0].disabled =false;",textBox);
        textBox.sendKeys("Enabled Text Box");
        WebElement hide = driver.findElement(By.id("hide-textbox"));
        hide.click();
        WebElement hiddenMessage = driver.findElement(By.xpath("//input[@placeholder='Hide/Show Example']"));
        js.executeScript("arguments[0].removeAttribute('style')",hiddenMessage);
        js.executeScript("arguments[0].value='Hidden Message';",hiddenMessage);
        WebElement name = driver.findElement(By.id("name"));
        js.executeScript("arguments[0].value='RAJESH RAMDEV';",name);
        WebElement alert = driver.findElement(By.id("alertbtn"));
        alert.click();
        Alert al = driver.switchTo().alert();
        Thread.sleep(5000);
        al.accept();
        WebElement confirm = driver.findElement(By.id("confirmbtn"));
        confirm.click();
        al.accept();
        WebElement hover = driver.findElement(By.id("mousehover"));
        hover.click();
        WebElement top = driver.findElement(By.xpath("//a[text()='Top']"));
        top.click();






    }

    public static void main(String[] args) throws InterruptedException {
        Practice pr = new Practice();
        pr.practice_Method();
    }
}
