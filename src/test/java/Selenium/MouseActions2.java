package Selenium;

import Base.Utility;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class MouseActions2 extends Utility {
    WebDriver driver = getDriver();
    Actions acts = new Actions(driver);
    public void regnForm() throws InterruptedException {
        getURL("https://vinothqaacademy.com/mouse-event/");
        maximizeWindow();
        applyImplicit();
        WebElement drag = findElement(By.id("draggableElement"));
        WebElement drop = findElement(By.id("droppableElement"));
       acts.dragAndDrop(drag,drop).build().perform();
       WebElement toolTip = findElement(By.xpath("//h3[text()='Mouse Actions - Tooltip']"));
       String tip = toolTip.getText();
        System.out.println(tip);
       WebElement textBox = findElement(By.id("textbox"));
       textBox.sendKeys("RAJESH");
       WebElement dbClick = findElement(By.id("dblclick"));
       acts.moveToElement(dbClick).doubleClick().build().perform();
     WebElement dbckPerform = dbClick.findElement(By.xpath("./following-sibling::p"));
     String text = dbckPerform.getText();
        System.out.println(text);
        WebElement rClick = findElement(By.id("rightclick"));
        acts.contextClick(rClick).build().perform();
       WebElement regnForm = rClick.findElement(By.xpath("./following-sibling::div//a[contains(text(),'Registration')]"));
        acts.moveToElement(regnForm).click().build().perform();
        Thread.sleep(5000);
    }
    public void fillForm()
    {
       WebElement regnHeader = findElement(By.xpath("//h3[text()='Registration Form']"));
       String regHead = regnHeader.getText();
        System.out.println(regHead);
      WebElement firstName = findElement(By.xpath("//input[@name='vfb-5']"));
      acts.moveToElement(firstName).click().build().perform();
      firstName.sendKeys("Rajesh Ram Dev");
    WebElement lastName = findElement(By.xpath("//input[@id = 'vfb-7']"));
      acts.moveToElement(lastName).click().build().perform();
      lastName.sendKeys("Rajasekaran");
      WebElement male = findElement(By.xpath("//input[@value='Male']"));
      acts.moveToElement(male).click().build().perform();
     WebElement selDriver = findElement(By.xpath("//input[@value = 'Selenium WebDriver']"));
     acts.moveToElement(selDriver).click().build().perform();
     WebElement addBox1 = findElement(By.xpath("//input[@id='vfb-13-address']"));
     acts.moveToElement(addBox1).click().build().perform();
     addBox1.sendKeys("13/7 Valli Vilas");
     WebElement addBox2 = findElement(By.xpath("//input[@id='vfb-13-address-2']"));
     acts.moveToElement(addBox2).click().build().perform();
     addBox2.sendKeys("Norton 2nd Street, Mandaiveli, Chennai");
     WebElement city = findElement(By.xpath("//input[@id='vfb-13-zip']"));
     acts.moveToElement(city).click().build().perform();
     city.sendKeys("600028");
     WebElement countrySelect1 = findElement(By.xpath("//span[@aria-controls='select2-vfb-13-country-container']"));
     countrySelect1.click();
     WebElement countrySelect2 = findElement(By.xpath("//input[@aria-controls='select2-vfb-13-country-results']"));
     countrySelect2.sendKeys("India");
        acts.sendKeys(Keys.ENTER).perform();
     WebElement email =findElement(By.xpath("//input[@id='vfb-14']"));

     email.sendKeys("rajeshramdeveee56@gmail.com");
     WebElement demoDate = findElement(By.xpath("//input[@data-dp-dateformat='mm/dd/yy']"));
     demoDate.sendKeys("14/03/26");
     demoDate.sendKeys(Keys.ESCAPE);
     WebElement hrsContainer = findElement(By.id("select2-vfb-16-hour-container"));
     acts.moveToElement(hrsContainer).click().build().perform();
     WebElement hrInput = findElement(By.xpath("//input[@class='select2-search__field']"));
     hrInput.sendKeys("11", Keys.ENTER);
     WebElement minContainer = findElement(By.id("select2-vfb-16-min-container"));
     acts.moveToElement(minContainer).click().build().perform();
     WebElement minInput = findElement(By.xpath("//input[@class='select2-search__field']"));
     minInput.sendKeys("00", Keys.ENTER);
     WebElement mob = findElement(By.xpath("//input[@name='vfb-19']"));
     mob.sendKeys("7812882803");
     WebElement textArea = findElement(By.id("vfb-23"));
     textArea.sendKeys("My first Xpath Code using Selenium Java");
     WebElement verify = findElement(By.id("vfb-3"));
     verify.sendKeys("22");
        //WebElement submit = driver.findElement(By.id("vfb-4"));
       // ((org.openqa.selenium.JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", submit);
     WebElement submit = findElement(By.id("vfb-4"));
    acts.moveToElement(submit).click().build().perform();
    try {
        WebElement finalPage = findElement(By.xpath("//div[contains(text(), 'Registration Form is Successfully Submitted')]"));
        String success = finalPage.getText();
        System.out.println("Final Status of your form: "+success);
    } catch (Exception e) {
        System.out.println("Form is incomplete refill the form");
    }









    }


    public static void main(String[] args) throws InterruptedException {
        MouseActions2 ma = new MouseActions2();
        ma.regnForm();
        ma.fillForm();
    }
}
