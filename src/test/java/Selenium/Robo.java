package Selenium;

import Base.Utility;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.awt.*;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.Set;

public class Robo extends Utility {
    WebDriver driver = getDriver();
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
    Robot ro;
    public void roboActs() throws InterruptedException {
        getURL("https://smallpdf.com/excel-to-pdf"); maximizeWindow(); applyImplicit();
        WebElement choose = driver.findElement(By.xpath("//span[text()='Choose Files']"));
        choose.click();
        Thread.sleep(2000);
        String filePath = "C:\\Users\\Rajesh Ramdev\\Desktop\\FileHandlingExcel.xlsx";
        StringSelection select = new StringSelection(filePath);
        Clipboard clip = Toolkit.getDefaultToolkit().getSystemClipboard();
        clip.setContents(select, null);
        try {
            ro = new Robot();
            ro.keyPress(KeyEvent.VK_CONTROL);
            ro.keyPress(KeyEvent.VK_V);
            ro.keyRelease(KeyEvent.VK_V);
            ro.keyRelease(KeyEvent.VK_CONTROL);
            ro.keyPress(KeyEvent.VK_ENTER);
            ro.keyRelease(KeyEvent.VK_ENTER);
        } catch (AWTException e) {
            System.out.println("System not loaded");
        }

       wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='Download']")));
       // wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[text()='Download']"))).click();
       Thread.sleep(5000);
        TakesScreenshot ts = (TakesScreenshot) driver;
        File src =  ts.getScreenshotAs(OutputType.FILE);
        File target = new File("target/Screenshots/robot.png");
        try {
            FileUtils.copyFile(src,target);
        } catch (IOException e) {
            System.out.println("Unable to take screenshot");
        } Thread.sleep(10000);
    wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[text()='Download']"))).click();


//        String webPage = driver.getWindowHandle();
//        Set<String>pdfPage = driver.getWindowHandles();
//        for(String latestWin:pdfPage)
//        {
//            if(!latestWin.equals(webPage))
//            {
//                driver.switchTo().window(latestWin);
//            }
//        }
//        Thread.sleep(3000);
//        TakesScreenshot ts = (TakesScreenshot) driver;
//      File src =  ts.getScreenshotAs(OutputType.FILE);
//      File target = new File("target/Screenshots/robot1.png");
//        try {
//            FileUtils.copyFile(src,target);
//        } catch (IOException e) {
//            System.out.println("Unable to take screenshot");
//        }
//

    }

    public static void main(String[] args) throws InterruptedException {
        Robo rb = new Robo();
        rb.roboActs();
    }
}
