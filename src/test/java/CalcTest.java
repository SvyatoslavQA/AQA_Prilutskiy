import data.StaticProvider;
import org.testng.Assert;
import org.testng.annotations.Test;

import javax.swing.*;
import java.util.List;

public class CalcTest extends BaseTest {

    @Test
    public void testDiv() {
        Assert.assertEquals(calculator.div(6, 3), 2, "valid result...");
    }

    @Test(enabled = true, groups = "Main Suite")
    public void testDiv1() {
        Assert.assertEquals(calculator.div(6, 3), 2, "valid result...");
    }

    @Test(description = "some test description")
    public void testDiv2() {
        Assert.assertEquals(calculator.div(6, 3), 2, "valid result...");
    }

    @Test(testName = "Test with name", priority = 1)
    public void testDiv3() {
        Assert.assertEquals(calculator.div(6, 3), 2, "valid result...");
    }

    @Test(timeOut = 1000)
    public void waitLongTimeTest() throws InterruptedException {
        Thread.sleep(1000);
    }

    @Test(invocationCount = 3, invocationTimeOut = 1000, threadPoolSize = 3)
    public void invocationCountTest() throws InterruptedException {
        Thread.sleep(500);
        Assert.assertEquals(calculator.div(6, 3), 2, "valid result...");
    }

    @Test(dataProvider = "dataForDiv", dataProviderClass = StaticProvider.class, threadPoolSize = 3)
    public void testDataProvider(int a, int b, int expectedResult) {
        Assert.assertEquals(calculator.div(a, b), expectedResult, "valid result...");
    }

    @Test(expectedExceptions = NullPointerException.class)
    public void testExceptions() {
        List list = null;
        int size = list.size();
    }

    @Test()
    public void testDivDouble() {
        Assert.assertEquals(calculator.div(10.0, 1), 10.0, "not double");
    }
    @Test(testName = "Div POSITIVE_INFINITY...")
    public void testDoubleDivByZero() {
        Assert.assertEquals(Double.POSITIVE_INFINITY, calculator.div(10.1, 0), 0.0001);
    }
    @Test(testName = "Div NEGATIVE_INFINITY...")
    public void testNegativeDoubleDivByZero() {
        Assert.assertEquals(Double.NEGATIVE_INFINITY, calculator.div(-10.1, 0), 0.0001);
    }

    @Test(testName = "Div Double.NaN...")
    public void testNaN() {
        Assert.assertEquals(Double.NaN, calculator.div(0.0, 0.0), 0.0001);
    }
    @Test(testName = "retryAttempt", retryAnalyzer = Retry.class)
    public void retryTest() {
        Assert.assertEquals(calculator.div(15, 3), 5);
    }
    @Test(testName = "exception check")
    public void exceptionTest() {
            try {
                Assert.assertEquals(calculator.div(12, 0), 3, "wrong div");
            } catch (ArithmeticException e) {
                System.out.println("b == 0");
            }
        }

}
