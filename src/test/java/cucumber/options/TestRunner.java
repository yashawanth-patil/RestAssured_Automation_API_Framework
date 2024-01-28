package cucumber.options;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/java/features",plugin="json:target/jsonReports/cucumber-report.json", glue = {"StepDefinations"})
//, tags =  "@deletePlace"  
public class TestRunner {

}







// running the test from maven frm command line 
// below are the commands
// mvn test (it will run the complete project and provide the results

//mvn test -Dcucumber.options="--tags @addplace"   (D stands for parameters)



// @CucumberOptions(features = "src/test/java/features", this will run the features package in which it will execute all the feature file present in it
// to run any one of the particular feature file give the path of it : for example src/test/java/features/***********your feature file here*********"

//    add the plugin in test runner as above added and 
// find the dependency in the following link :https://github.com/damianszczepanik/cucumber-reporting
// add it and save and create one folder with name jsonReports (name shouldbe as it is in the plugin from the link provided)
// after that run the test to verify the reports 
