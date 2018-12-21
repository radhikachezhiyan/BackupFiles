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

public class InvalidLogin_StepDefinitions {
	
	WebDriver driver;
	
	@Given("^A User is on the Login Page$")
	public void a_User_is_on_the_Login_Page() throws Throwable {
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get("http://www.facebook.com/");
	}

	@When("^User enters an invalid \"([^\"]*)\"$")
	public void user_enters_an_invalid(String arg1) throws Throwable {
		driver.findElement(By.id("email")).sendKeys(arg1);
	}

	@When("^enters an invalid \"([^\"]*)\"$")
	public void enters_an_invalid(String arg1) throws Throwable {
		driver.findElement(By.cssSelector("#pass")).sendKeys(arg1);
	}

	@When("^User clicks on the Sign in button$")
	public void user_clicks_on_the_Sign_in_button() throws Throwable {
		driver.findElement(By.id("u_0_2")).click();
	}

	@Then("^User must not be able to log in to the application$")
	public void user_must_not_be_able_to_log_in_to_the_application() throws Throwable {
		String expectedValue ="The email you’ve entered doesn’t match any account. Sign up for an account.";
		String actualValue;
		actualValue = "";
		actualValue = driver.findElement(By.xpath("//*[@id=\"globalContainer\"]/div[3]/div/div/div")).getText();
		System.out.println("Actual Value: " + actualValue);
		Assert.assertEquals(actualValue, expectedValue);
		driver.quit();
	}
}
