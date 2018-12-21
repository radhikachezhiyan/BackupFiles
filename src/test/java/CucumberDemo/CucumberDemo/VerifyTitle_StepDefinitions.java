package CucumberDemo.CucumberDemo;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import junit.framework.Assert;



public class VerifyTitle_StepDefinitions {
	
	WebDriver driver;
	//String expectedValue ="Facebook - Log In or Sign Up";
	String actualValue;
	
	@Given("^User is on the landing page$")
		public void user_is_on_the_landing_page() throws Throwable {
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get("http://www.facebook.com/");

	}

	@When("^User checks the title$")
	public void user_checks_the_title() throws Throwable {
		actualValue = driver.getTitle();
		System.out.println("Actual Page Title is: " + actualValue);
	}

	@Then("^It must say \"([^\"]*)\"$")
	public void it_must_say(String arg1) throws Throwable {
		Assert.assertEquals(actualValue, arg1);
		driver.quit();
	}
}
