package runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;


@RunWith (Cucumber.class)
@CucumberOptions(
        features = "src/main/resources/BBC.feature",
        glue = "StepDefenitions"
)
public class RunnerTests{

}