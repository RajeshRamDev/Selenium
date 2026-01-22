package Selenium;

import Base.Utility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class SelectPractice extends Utility {
    WebDriver driver = getDriver();
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
    Actions acts = new Actions(driver);
    Select sl;
    public void practice_Select()
    {
        getURL("https://practice.expandtesting.com/dropdown");
        maximizeWindow(); applyImplicit();
        WebElement simple =driver.findElement(By.id("dropdown"));
        sl = new Select(simple);
        sl.selectByValue("1");
        WebElement elements = driver.findElement(By.id("elementsPerPageSelect"));
        sl = new Select(elements);
        sl.selectByValue("50");
        WebElement country = driver.findElement(By.id("country"));
        sl = new Select(country);
        sl.selectByValue("IN");
    }

    public static void main(String[] args) {
        SelectPractice sp = new SelectPractice();
        sp.practice_Select();
    }
}

