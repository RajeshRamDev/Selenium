package Selenium;

import Base.Utility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import javax.swing.*;

public class MouseActions extends Utility {
    WebDriver driver = getDriver();
    Actions actions = new Actions(driver);
    public void mouseAct()
    {
        getURL("https://vinothqaacademy.com/mouse-event/");
        maximizeWindow();
        applyImplicit();
        WebElement drag = findElement(By.id("draggableElement"));
        WebElement drop = findElement(By.id("droppableElement"));
        actions.dragAndDrop(drag,drop).perform();
      WebElement dClick = findElement(By.id("dblclick"));
      actions.moveToElement(dClick).doubleClick().build().perform();
      WebElement cnf = dClick.findElement(By.xpath("following-sibling::p"));
      String text = cnf.getText();
        System.out.println(text);
        WebElement rClick = findElement(By.id("rightclick"));
        actions.contextClick(rClick).perform();
       WebElement regn = rClick.findElement(By.xpath("following-sibling::div//a[contains(text(),'Registration')]"));
        actions.moveToElement(regn).click().build().perform();
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            System.out.println("Sleep not applied");
        }
    }
    public void registrationForm()
    {
        WebElement header = findElement(By.xpath("//h3[text()='Registration Form']"));
        if(header.isDisplayed())
        {
            System.out.println("Registration Page is Loaded");
        }
        else
        {
            System.out.println("Reload Page");
        }
//        WebElement firstName = findElement(By.xpath("//input[@name='vfb-5']"));
//        firstName.sendKeys("Rajesh Ram Dev");
//        WebElement lastName = findElement(By.xpath("//input[@name='vfb-7']"));
//        lastName.sendKeys("R");
//        WebElement male = findElement(By.xpath("//input[@value='Male']"));
//        male.click();
//        WebElement seleniumWevDriver = findElement( By.xpath("//input[@value='Selenium WebDriver']"));
//        seleniumWevDriver.click();
//        WebElement fieldName = findElement(By.xpath("//input[@name='vfb-13[address]']"));
//        fieldName.sendKeys("13/7 Valli Vilas");
//      WebElement streetAddress = findElement(By.xpath("//input[@name='vfb-13[address-2]']"));
//      streetAddress.sendKeys("Norton Second Street");
//      WebElement city = findElement(By.xpath("//input[@name='vfb-13[zip]']"));
//      city.sendKeys("Chennai");
//




    }

    public static void main(String[] args) {
        MouseActions ma = new MouseActions();
        ma.mouseAct();
        // ma.registrationForm();
    }
}
