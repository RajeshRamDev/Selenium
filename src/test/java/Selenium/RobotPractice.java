package Selenium;

import Base.Utility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.awt.*;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.time.Duration;

public class RobotPractice extends Utility {
    WebDriver driver = getDriver();
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
    Actions acts = new Actions(driver);
    Robot ro;
    public void robot_Practice() throws InterruptedException {
        getURL("https://www.ilovepdf.com/word_to_pdf"); maximizeWindow(); applyImplicit();
        WebElement choose = driver.findElement(By.xpath("//span[text()='Select WORD files']"));
        choose.click();
        Thread.sleep(5000);
        String filepath = "C:\\Users\\Rajesh Ramdev\\Desktop\\Java File Handling.txt.docx";
        StringSelection select = new StringSelection(filepath);
        Clipboard clip = Toolkit.getDefaultToolkit().getSystemClipboard();
        clip.setContents(select,null);
        try {
            ro = new Robot();
            ro.keyPress(KeyEvent.VK_CONTROL);
            ro.keyPress(KeyEvent.VK_V);
            ro.keyRelease(KeyEvent.VK_V);
            ro.keyRelease(KeyEvent.VK_CONTROL);
            ro.keyPress(KeyEvent.VK_ENTER);
            ro.keyRelease(KeyEvent.VK_ENTER);

        } catch (AWTException e) {
            System.out.println("File Path not clear");
        }
        WebElement pdf = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[text()='Convert to PDF']")));
        assert pdf != null;
        pdf.click();
        Thread.sleep(5000);

    }

    public static void main(String[] args) throws InterruptedException {
        RobotPractice rp  = new RobotPractice();
        rp.robot_Practice();
    }
}



