/**
 * @Copyright
 *
 * @author Babalu kumar
 * @since June 22, 2023
 */
package stepDefinitions;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(plugin = {"json:target/cucumber.json"},
        features = "classpath:features"
        )
public class CucumberTestRunner {
}
