package cucumberOptions;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
    features = "src/test/java/features", // Path to your feature files
    // Package where your step definitions reside
    monochrome = true, dryRun = true
)
public class TestRunner {
  // Leave this class empty; it's used as a runner for Cucumber tests
}