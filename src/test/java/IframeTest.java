import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class IframeTest extends BaseTest {
    @Test
    public void iFrameTest() {
        driver.get("http://the-internet.herokuapp.com/iframe");
        driver.switchTo().frame("mce_0_ifr");
        WebElement placeholder = driver.findElement(By.xpath("//*[@id='tinymce']/p"));
        Assert.assertEquals(placeholder.getText(), "Your content goes here.");
        driver.switchTo().parentFrame();
    }
}