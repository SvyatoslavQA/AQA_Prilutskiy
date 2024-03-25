import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Objects;

public class DummyFileUploadTest extends BaseTest {
    @Test
    public void dummyFileUploadTest() {
        driver.get("https://the-internet.herokuapp.com/upload");
        WebElement fileUploadButton = waitsService.waitForVisibilityLocatedBy(By.id("file-upload"));
        String path = Objects.requireNonNull(DummyFileUploadTest.class.getClassLoader().getResource("dummy.pdf")).getPath().substring(1);
        fileUploadButton.sendKeys(path);
        waitsService.waitForElementVisible(fileUploadButton).submit();
        Assert.assertEquals(waitsService.waitForElementClickable(By.id("uploaded-files")).getText(), "dummy.pdf");
    }
}