package Selenium;

import Base.Utility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class XpathDemoSite extends Utility {
    WebDriver driver = getDriver();
    Actions acts = new Actions(driver);
    public void xpathDemo()
    {
        getURL("https://vinothqaacademy.com/mouse-event/");
        maximizeWindow();
        applyImplicit();
       WebElement demoSite = driver.findElement(By.linkText("Demo Sites"));
       demoSite.click();
        try {
            WebElement xDemo = driver.findElement(By.linkText("XPath Demo Page"));
            acts.moveToElement(xDemo).click().build().perform();
            WebElement xpathHeader = driver.findElement(By.xpath("//h2[text()='XPath Axes Practice Lab']"));
            String xpathTitle = xpathHeader.getText();
            System.out.println("The Page loaded is: "+xpathTitle);
        } catch (Exception e) {
            System.out.println("XPath PAGE is not Loaded");
        }
        WebElement userName = driver.findElement(By.id("usernameInput"));
        userName.sendKeys("raj123");
        acts.moveToElement(userName).click().build().perform();
        WebElement pass = driver.findElement(By.xpath("//input[@type='password']"));
        userName.sendKeys("R@j#123");
        acts.moveToElement(pass).click().build().perform();
        WebElement signIn = driver.findElement(By.xpath("//button[text()='Sign In']"));
        acts.moveToElement(signIn).click().build().perform();

    }

    public static void main(String[] args) {
        XpathDemoSite xd = new XpathDemoSite();
        xd.xpathDemo();
    }
}
