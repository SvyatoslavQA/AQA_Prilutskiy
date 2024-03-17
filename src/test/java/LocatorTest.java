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
        Thread.sleep(1000);
    }

    @Test
    public void cssAppLogoTest() {
        Assert.assertTrue(driver.findElement(By.cssSelector(".app_logo")).isDisplayed());
    }

    @Test
    public void idTest() {
        Assert.assertTrue(driver.findElement(By.cssSelector("#shopping_cart_container")).isDisplayed());
    }

    @Test
    public void classTest() {
        Assert.assertTrue(driver.findElement(By.cssSelector(".bm-burger-button")).isDisplayed());
    }

    @Test
    public void tagTest() {
        Assert.assertEquals(20, driver.findElements(By.cssSelector("a")).size());
    }

    @Test
    public void attributeNameTest() {
        Assert.assertEquals(10, driver.findElements(By.cssSelector("[name]")).size());
    }

    @Test
    public void enabledTest() {
        Assert.assertEquals(6, driver.findElements(By.cssSelector(":enabled")).size());
    }


    @Test
    public void parentTest() {
        Assert.assertTrue(driver.findElement(By.xpath("//option/parent::select")).isDisplayed());
    }

    @Test
    public void ancestorTest() {
        Assert.assertTrue(driver.findElement(By.xpath("//a/ancestor::ul")).isDisplayed());
    }

    @Test
    public void attributeTest() {
        Assert.assertTrue(driver.findElement(By.xpath("//*[@id = 'inventory_container']")).isDisplayed());
    }

    @Test
    public void containsTest() {
        Assert.assertTrue(driver.findElement(By.xpath("//div[contains(@id, 'button')]")).isDisplayed());
    }

    @Test
    public void indexElementTest() {
        Assert.assertTrue(driver.findElement(By.xpath("//div[@class = 'inventory_item_img']/a[1]")).isDisplayed());
    }

    @Test
    public void divClassTest() {
        Assert.assertTrue(driver.findElement(By.xpath("//div[@class = 'shopping_cart_container']/a[1]")).isDisplayed());

    }

    @Test
    public void fullTextTest() {
        Assert.assertTrue(driver.findElement(By.xpath("//div[text()='Sauce Labs Onesie']")).isDisplayed());
    }

    @Test
    public void containsTextTest() {
        Assert.assertTrue(driver.findElement(By.xpath("//div[contains(text(), 'bike at night.')]")).isDisplayed());
    }

    @Test
    public void notFoundDescendantTest() {
        Assert.assertFalse(driver.findElement(By.xpath("//div/descendant::a")).isDisplayed());
    }

    @Test
    public void followingTest() {
        Assert.assertTrue(driver.findElement(By.xpath("//div/div[@class='inventory_item']/following::img")).isDisplayed());
    }

    @Test
    public void precedingTest() {
        Assert.assertTrue(driver.findElement(By.xpath("//div/div[@class='inventory_item']/preceding::img")).isDisplayed());
    }


    @AfterMethod()
    public void quitBrowser() {
        driver.quit();
    }

}
