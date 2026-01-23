package Selenium;

import Base.Utility;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

public class EnableDisable extends Utility {
    WebDriver driver = getDriver();
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
    Actions acts = new Actions(driver);
    public void enabledisable_Demo()
    {
      getURL("https://www.letskodeit.com/practice");
      maximizeWindow(); applyImplicit();
        WebElement disable = driver.findElement(By.id("disabled-button"));
        disable.click();
        JavascriptExecutor js = (JavascriptExecutor) driver;
        WebElement textbox = driver.findElement(By.xpath("//input[@placeholder='Enabled/Disabled Field']"));
       js.executeScript("arguments[0].disabled = false;",textbox);
        textbox.sendKeys("Hello");
        WebElement hide = driver.findElement(By.id("hide-textbox"));
        hide.click();
        WebElement hideBox = driver.findElement(By.xpath("//input[@placeholder='Hide/Show Example']"));
        js.executeScript("arguments[0].removeAttribute('style');",hideBox);
        hideBox.sendKeys("Hidden Message");
        TakesScreenshot ts = (TakesScreenshot) driver;
        File src = ts.getScreenshotAs(OutputType.FILE);
        File target = new File("target/Screenshots/page1.png");
        try {
            FileUtils.copyFile(src,target);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }

    public static void main(String[] args) {
        EnableDisable ed = new EnableDisable();
        ed.enabledisable_Demo();
    }

}
