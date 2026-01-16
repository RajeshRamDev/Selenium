import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class CSSTwitter {
    WebDriver driver = new ChromeDriver();
    public void twitterCreator() throws InterruptedException {
        driver.get("https://x.com/home");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
//    WebElement Signin = driver.findElement(By.cssSelector("span[class='nsm7Bb-HzV7m-LgbsSe-BPrWId']"));
//    Signin.click();
//      WebElement AppleSignin = driver.findElement(By.cssSelector("span[class='css-1jxf684 r-bcqeeo r-1ttztb7 r-qvutc0 r-poiln3']"));
//        AppleSignin.click();
      WebElement email = driver.findElement(By.cssSelector("input[autocomplete='username']"));
       email.sendKeys("REREE");
//    WebElement next = driver.findElement(By.cssSelector("div[class='css-146c3p1 r-bcqeeo r-qvutc0 r-37j5jr r-q4m81j r-a023e6 r-rjixqe r-b88u0q r-1awozwy r-6koalj r-18u37iz r-16y2uox r-1777fci'][style='color: rgb(255, 255, 255)']"));
//      next.click();
//       WebElement forgot = driver.findElement(By.cssSelector("span[class='css-1jxf684 r-bcqeeo r-1ttztb7 r-qvutc0 r-poiln3']"));
//      forgot.click();
        Thread.sleep(10000);
        driver.quit();


    }

    public static void main(String[] args) throws InterruptedException {
        CSSTwitter ct = new CSSTwitter();
        ct.twitterCreator();
    }

}
