package runner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/resources/features/",
                 glue = "step_definitions", 
                 dryRun = false, 
                 monochrome = true,
		      // tags = "@Test_suit_register_03",
		         plugin = { "pretty", "html:target/DsalgoXpathers_Home.html",
		        		 "io.qameta.allure.cucumber7jvm.AllureCucumber7Jvm",
		        		 "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"
})
public class Test_runner {

}

// Tips for final run
// Make sure to have the correct user name and pwd. Reg.feature file 79 has to be changed
