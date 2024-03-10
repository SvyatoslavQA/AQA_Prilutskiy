import core.BrowserService;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class SkfTest {
    private WebDriver driver;

    @BeforeMethod
    public void setupBrowser() {
        driver = new BrowserService().getDriver();
    }

    @Test
    public void validateSKF() throws InterruptedException {
        driver.get("https://bymed.top/calc/%D1%81%D0%BA%D1%84-2148");
        Thread.sleep(5000);
        driver.switchTo().frame(1);
        WebElement ageField = driver.findElement(By.id("age"));
        ageField.sendKeys("32");
        WebElement sexSelectElem = driver.findElement(By.id("sex"));
        Select sexDropdown = new Select(sexSelectElem);
        sexDropdown.selectByIndex(0);
        WebElement creatinineField = driver.findElement(By.id("cr"));
        creatinineField.sendKeys("100");
        WebElement weightField = driver.findElement(By.id("mass"));
        weightField.sendKeys("82");
        WebElement heightField = driver.findElement(By.id("grow"));
        heightField.sendKeys("175");
        WebElement calculBtn = driver.findElement(By.xpath("//*[@id=\"input-data\"]/p[7]/button"));
        calculBtn.click();
        WebElement mdrdResult = driver.findElement(By.id("mdrd"));
        WebElement cgeResult = driver.findElement(By.id("cge"));
        Thread.sleep(5000);
        Assert.assertTrue(mdrdResult.getText().startsWith("75.11 мл/мин"));
        Assert.assertEquals(cgeResult.getText().trim(),"108.73 мл/мин");
    }

    @AfterMethod
    public void browserQuit() {
        driver.quit();
    }
}