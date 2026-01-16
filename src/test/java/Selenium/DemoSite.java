package Selenium;

import Base.Utility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class DemoSite extends Utility {
    WebDriver driver = getDriver();
    Actions acts = new Actions(driver);

    public void demoMethod() {
        getURL("https://vinothqaacademy.com/mouse-event/");
        maximizeWindow();
        applyImplicit();
        WebElement demoSite = driver.findElement(By.linkText("Demo Sites"));
        acts.moveToElement(demoSite).click().build().perform();
        WebElement healthCare = driver.findElement(By.linkText("Healthcare Demo Page"));
        acts.moveToElement(healthCare).click().build().perform();
        WebElement patientDetails = driver.findElement(By.xpath("//h2[text()='Patient Details Form']"));
        String text = patientDetails.getText();
        System.out.println(text);
        WebElement patName = driver.findElement(By.id("patient-name"));
        patName.sendKeys("RAJESH RAMDEV");
        acts.moveToElement(patName).click().build().perform();
       WebElement patId = driver.findElement(By.id("patient-id"));
       acts.moveToElement(patId).click().build().perform();
      WebElement male = findElement(By.xpath("//input[@value='male']"));
      male.click();
     WebElement fever = driver.findElement(By.xpath("//input[@value='fever']"));
     fever.click();
     WebElement cough = driver.findElement(By.xpath("//input[@value='cough']"));
     cough.click();
     WebElement fatigue = driver.findElement(By.xpath("//input[@value='fatigue']"));
     fatigue.click();
     WebElement headAche = driver.findElement(By.xpath("//input[@value='headache']"));
     headAche.click();
     WebElement payment = driver.findElement(By.linkText("Payment Link"));
        acts.moveToElement(payment).click().build().perform();
       WebElement paySuccess = driver.findElement(By.id("success-message"));
     String textPayment = paySuccess.getText();
        System.out.println("Payment Details: "+textPayment);
     acts.moveToElement(payment).click().build().perform();
    WebElement submit = driver.findElement(By.xpath("//button[text()='Submit']"));
    acts.moveToElement(submit).click().build().perform();
    WebElement submitSuccess = driver.findElement(By.xpath("//div[text()='Patient data is updated successfully']"));
    String subSucc = submitSuccess.getText();
        System.out.println("Final Status: "+subSucc);
    }

    public static void main(String[] args) {
        DemoSite ds = new DemoSite();
        ds.demoMethod();
    }
}
