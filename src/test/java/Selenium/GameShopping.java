package Selenium;

import Base.Utility;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class GameShopping extends Utility {
    WebDriver driver = getDriver();
    Actions acts = new Actions(driver);
    public void gameFlipkart()
    {
        getURL("https://www.flipkart.com/");
        maximizeWindow();
        applyImplicit();
        try {
            WebElement search =driver.findElement(By.xpath("//input[@title='Search for Products, Brands and More']"));
            search.sendKeys("GAMES", Keys.ENTER);
            WebElement title = driver.findElement(By.xpath("//a[text()='Games']"));
            String titleGames = title.getText();
            System.out.println("Page loaded at: "+titleGames);
        } catch (Exception e) {
            System.out.println("Games page is not loaded");
        }

    }

    public static void main(String[] args) {
        GameShopping gs = new GameShopping();
        gs.gameFlipkart();
    }
}
