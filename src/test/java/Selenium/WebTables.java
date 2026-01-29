package Selenium;

import Base.Utility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class WebTables extends Utility {
    WebDriver driver = getDriver();
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
    public void webTable_Method()
    {
        getURL("https://cosmocode.io/automation-practice-webtable/"); maximizeWindow();
        List<WebElement>table = driver.findElements(By.xpath("//table/tbody/tr"));
        for (int i = 0; i < table.size(); i++) {
           WebElement row = table.get(i);

            List<WebElement>data = row.findElements(By.xpath("./td"));
            for (int j = 1; j <data.size() ; j++) {
                String text = data.get(j).getText();
                System.out.print(text+ " | ");

            }
            System.out.println();


        }

    }

    public static void main(String[] args) {
        WebTables wt = new WebTables();
        wt.webTable_Method();
    }
}
