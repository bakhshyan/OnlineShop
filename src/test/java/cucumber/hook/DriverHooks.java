package cucumber.hook;

import driver.DriverSigleton;
import io.cucumber.java.After;
import io.cucumber.java.Before;

public class DriverHooks {

    @Before
    public void openBrowser() {

        DriverSigleton.setupDriver();
    }

    @After
    public void tearDown() {
        DriverSigleton.closeDriver();
    }

}
