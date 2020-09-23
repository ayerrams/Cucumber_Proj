package Runner;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features = {"src/test/resource/Login/RegisterUserLogin.feature"},
        glue = {"stepdefs"},
        dryRun = true,
        monochrome=true,
        strict=true,
        plugin= {"html:testoutput/testoutput.html","junit:testoutput/cucumber.xml","json:testoutput/cucumber.json"}
)
public class Test_runner {

}
