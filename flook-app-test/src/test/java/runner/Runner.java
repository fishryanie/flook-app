package runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.Test;

@Test
@CucumberOptions(
        features = "src/test/resources/home.feature",
        glue = {"com/testng/asm/steps"}
)

public class Runner extends AbstractTestNGCucumberTests {
}

