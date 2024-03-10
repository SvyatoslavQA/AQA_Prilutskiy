//id
//name
//classname
//tagname
//linktext
//partiallinktext
//xpath
//Поиск по атрибуту, например By.xpath("//tag[@attribute='value']");
//Поиск по тексту, например By.xpath("//tag[text()='text']");
//Поиск по частичному совпадению атрибута, например By.xpath("//tag[contains(@attribute,'text')]");
//Поиск по частичному совпадению текста, например By.xpath("//tag[contains(text(),'text')]");
//ancestor, например //*[text()='Enterprise Testing']//ancestor::div
//descendant
//following
//parent
//preceding
//Подсказка:  XPath Axes
//*поиск элемента с условием AND, например //input[@class='_2zrpKA _1dBPDZ' and @type='text']
//css
//.class
//.class1.class2
//.class1 .class2
//#id
//tagname
//tagname.class
//[attribute=value]
//[attribute~=value]
//[attribute|=value]
//[attribute^=value]
//[attribute$=value]
//[attribute*=value]
//Подсказка: https://www.w3schools.com/cssref/css_selectors.asp


import configuration.ReadProperties;
import core.BrowserService;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LocatorTest {
    private WebDriver driver;

    @BeforeMethod
    public void setup() throws InterruptedException {
        driver = new BrowserService().getDriver();
        driver.get(ReadProperties.getUrl());
        Thread.sleep(2000);
        driver.findElement(By.name("user-name")).sendKeys("standard_user");
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        driver.findElement(By.cssSelector("#login-button")).click();
        Thread.sleep(2000);
    }


    @AfterMethod()
    public void quitBrowser() {
        driver.quit();
    }

}
