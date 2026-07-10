import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features="src/test/java/chethan/cucumber/features",glue="chethan/cucumber/StepDefinition",monochrome=true,plugin={"pretty","html:target/cucumber-reports.html"})
public class TestRunner extends AbstractTestNGCucumberTests  {

}
