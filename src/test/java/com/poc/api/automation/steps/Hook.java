package com.poc.api.automation.steps;

/*import static com.poc.api.automation.utils.WebdriverUtils.getDriverInstanceForChrome;
import static com.poc.api.automation.utils.WebdriverUtils.getDriverInstanceForRemote;
import static com.poc.api.automation.variables.DriverVariables.driverInstance;*/
import java.net.MalformedURLException;
/*import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;*/
import com.aventstack.extentreports.ExtentTest;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class Hook {

	Scenario scenario;
	public static ExtentTest test;

	String BROWSER = System.getProperty("browserPlatform");
	//To Be Changed
	String username = "kuldeepbhadauria_3YbtKy";
	String accessKey = "GPCt4t3pXpqYzNSsatWn";
	
	@Before
	public void setup(Scenario scenario) throws MalformedURLException {
		this.scenario = scenario;
	}

	@After
	public void tearDown() {
	}

}
