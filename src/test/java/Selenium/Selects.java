package Selenium;

import Base.Utility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Selects extends Utility {
    WebDriver driver = getDriver();
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
    Actions acts = new Actions(driver);
    Select sl;
    public void select_Method()
    {
        getURL("https://proleed.academy/exercises/selenium/automation-practice-form-with-radio-button-check-boxes-and-drop-down.php");
        maximizeWindow();
        applyImplicit();
      WebElement prefix =  driver.findElement(By.id("prefix"));
      sl= new Select(prefix);
      sl.selectByValue("mr.");
      WebElement month = driver.findElement(By.id("dob_month"));
      sl = new Select(month);
      sl.selectByVisibleText("November");
      WebElement date = driver.findElement(By.id("dob_date"));
      sl = new Select(date);
      sl.selectByIndex(5);
      WebElement year = driver.findElement(By.id("dob_year"));
      sl =new Select(year);
      sl.selectByValue("1994");
      WebElement countryCode = driver.findElement(By.id("country_code"));
      sl = new Select(countryCode);
      sl.selectByValue("91");
      WebElement nationality = driver.findElement(By.id("nationality"));
      sl = new Select(nationality);
      sl.selectByValue("indian");
      WebElement country = driver.findElement(By.id("country"));
      sl = new Select(country);
      sl.selectByValue("India");
    }

    public static void main(String[] args) {
        Selects ss = new Selects();
        ss.select_Method();
    }
}
