package Base;

import org.jspecify.annotations.Nullable;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;
import java.util.Set;

public class Utility {
    WebDriver driver;
   public WebDriverWait wait;

    public WebDriver getDriver() {
        this.driver = new ChromeDriver();

        return driver;
    }
    public void getURL(String url)
    {
        driver.get(url);

    }
    public void maximizeWindow()
    {
        driver.manage().window().maximize();
    }
    public void applyImplicit()
    {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

    }
    public WebElement findElement(By locator) {
        wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        return  element;
    }
    public void quit()
    {
        driver.quit();
    }



}