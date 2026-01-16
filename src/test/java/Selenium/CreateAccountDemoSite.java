package Selenium;

import Base.Utility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class CreateAccountDemoSite extends Utility {
    WebDriver driver = getDriver();
    Actions acts = new Actions(driver);
    public void accountCreation()
    {
        getURL("https://vinothqaacademy.com/mouse-event/");
        maximizeWindow();
        applyImplicit();
       WebElement demoSite = driver.findElement(By.linkText("Demo Sites"));
       acts.moveToElement(demoSite).click().build().perform();
        try {
            WebElement accCreate = driver.findElement(By.linkText("Create Account Demo Page"));
            acts.moveToElement(accCreate).click().build().perform();
            WebElement titleAcc = driver.findElement((By.xpath("//h2[text()='Create Your Account']")));
            String headerAcc = titleAcc.getText();
            System.out.println("The page loaded is: "+headerAcc);
        } catch (Exception e) {
            System.out.println("Account Creation Page is Not Loaded");
        }
        try {
            WebElement firstName = driver.findElement(By.id("firstName"));
            firstName.sendKeys("RAJESH RAMDEV");
            WebElement lastName = driver.findElement(By.id("lastName"));
            lastName.sendKeys("Rajasekaran");
            WebElement address = driver.findElement(By.id("address"));
            address.sendKeys("13/7,Norton Second Street, Mandaiveli");
            WebElement city = driver.findElement(By.id("city"));
            city.sendKeys("Chennai");
            WebElement state = driver.findElement(By.id("state"));
            state.sendKeys("Tamil Nadu");
            WebElement zip = driver.findElement(By.id("zip"));
            zip.sendKeys("600028");
            WebElement phone = driver.findElement(By.id("phone"));
            phone.sendKeys("7812882803");
            WebElement email = driver.findElement(By.id("email"));
            email.sendKeys("rajeshramdeveeee56@gmail.com");
            WebElement register = driver.findElement(By.id("registerBtn"));
            acts.moveToElement(register).click().build().perform();
            WebElement success = driver.findElement(By.id("successMessage"));
            String message = success.getText();
            System.out.println("Final status of account: "+message);
        } catch (Exception e) {
            System.out.println("Details are not filled properly, refill the form");
        }


    }

    public static void main(String[] args) {
        CreateAccountDemoSite ca = new CreateAccountDemoSite();
        ca.accountCreation();
    }

}
