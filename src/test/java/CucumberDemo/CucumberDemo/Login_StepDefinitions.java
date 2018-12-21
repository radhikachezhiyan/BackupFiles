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

public class Login_StepDefinitions {

	WebDriver driver;
	@Given("^A User is on the website$")
	public void a_User_is_on_the_website() throws Throwable {
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get("http://www.facebook.com/");
	}

	@When("^User types UserName$")
	public void user_types_UserName() throws Throwable {
		driver.findElement(By.id("email")).sendKeys("irfan@sdettraining.com");
	}

	@When("^Usertypes Password$")
	public void usertypes_Password() throws Throwable {
		driver.findElement(By.cssSelector("#pass")).sendKeys("Passw0rd!@#");
	}

	@When("^User clicks on the submit button$")
	public void user_clicks_on_the_submit_button() throws Throwable {
		driver.findElement(By.id("u_0_2")).click();
	}

	@Then("^User must log in successfully$")
	public void user_must_log_in_successfully() throws Throwable {
		String expectedValue ="The email you’ve entered doesn’t match any account. Sign up for an account.";
		String actualValue;
		actualValue = "";
		actualValue = driver.findElement(By.xpath("//*[@id=\"globalContainer\"]/div[3]/div/div/div")).getText();
		System.out.println("Actual Value: " + actualValue);
		Assert.assertEquals(actualValue, expectedValue);
		driver.quit();
	}
}
