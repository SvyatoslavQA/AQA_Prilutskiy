package data;

import org.testng.annotations.DataProvider;

public class StaticProvider {

    @DataProvider (name = "dataForDiv", parallel = true)
    public static Object[][] dataForDivTest() {
        return new Object[][] {
                {-10, -5, 2},
                {0, 0, 0},
                {6, 3, 2}
        };
    }
}
