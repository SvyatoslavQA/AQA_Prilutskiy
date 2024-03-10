import core.BrowserService;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LaminatTest {
    private WebDriver driver;

    @BeforeMethod
    public void setupBrowser() {
        driver = new BrowserService().getDriver();
    }

    @Test
    public void laminateAmountTest() throws InterruptedException {
        driver.get("https://calc.by/building-calculators/laminate.html");
        Thread.sleep(15000); //убираю капчу руками если всплывает
        WebElement roomLength = driver.findElement(By.id("ln_room_id"));
        roomLength.clear();
        roomLength.sendKeys("100");
        WebElement roomWidth = driver.findElement(By.id("wd_room_id"));
        roomWidth.clear();
        roomWidth.sendKeys("100");
        WebElement panelLength = driver.findElement(By.id("ln_lam_id"));
        panelLength.clear();
        panelLength.sendKeys("100");
        WebElement panelWidth = driver.findElement(By.id("wd_lam_id"));
        panelWidth.clear();
        panelWidth.sendKeys("100");
        WebElement selectDropdown = driver.findElement(By.id("laying_method_laminate"));
        Select dropDirection = new Select(selectDropdown);
        dropDirection.selectByIndex(1);
        Thread.sleep(2000);
        WebElement directionFloor = driver.findElement(By.id("direction-laminate-id1"));
        directionFloor.click();
        WebElement calculationBtn = driver.findElement(By.className("calc-btn"));
        calculationBtn.click();
        Thread.sleep(2000);
        WebElement calculatePlankAmount = driver.findElement(By.xpath("//*[@id=\"t3-content\"]/div[3]/article/section/div[2]/div[3]/div[2]/div[1]"));
        Assert.assertEquals(calculatePlankAmount.getText().trim(),"Требуемое количество досок ламината: 102");

    }

    @AfterMethod
    public void quitBrowser() {
        driver.quit();
    }

}