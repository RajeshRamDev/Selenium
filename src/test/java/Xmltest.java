import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Xmltest {
    WebDriver driver = new ChromeDriver();
    //To let the webpage explicitly wait to load results page under Mobiles search
    WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
    public void basicTest()
    {
        driver.get("https://www.amazon.in/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }
    public void xmlLocator()
    {
       WebElement search = driver.findElement(By.xpath("//input[@role='searchbox']"));
       search.sendKeys("Mobiles", Keys.ENTER);
       driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
       String title = driver.getTitle();
       if (title.contains("Mobiles"))
       {
           System.out.println("Navigate to Mobiles");
       }
       else
       {
           System.out.println("Reload Page");
       }
     WebElement result = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h2[text()='Results']")));
       if(result.isDisplayed()) // To check Assertion
       {
           System.out.println("Page is found");
       }
       else {
           System.out.println("Page not found");
       }
      WebElement relatedsearch = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h2[text()='Related searches']")));
       if(relatedsearch.isDisplayed())
       {
           System.out.println("Related Search is displayed");
       }
       else {
           System.out.println("Related Search is not found");
       }

    }

    public static void main(String[] args) {
        Xmltest xt = new Xmltest();
        xt.basicTest();
        xt.xmlLocator();
    }
}
