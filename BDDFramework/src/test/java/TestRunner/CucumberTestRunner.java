package TestRunner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
features= {"C:\\Users\\savan\\eclipse-workspace\\BDDFramework\\src\\test\\resources\\Features\\HomePageHeader.feature"},
glue= {"StepDefinations"},
plugin = {"pretty","html:target/htmlreport.html"})
public class CucumberTestRunner extends AbstractTestNGCucumberTests  {


}
