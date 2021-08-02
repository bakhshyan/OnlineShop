package cucumber.runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        plugin = {"pretty", "html:target/cucumber-reports",
                "json:target/cucumber-reports/CucumberTests.json",
                "json:target/cucumber-reports/CucumberTests.xml"},
        monochrome = true,
        tags = "@smoke",
        glue = "cucumber",
        features = "classpath:cucumber/features"
)


public class CucumberTestRunner extends AbstractTestNGCucumberTests {


}
