package features;


import org.openqa.selenium.WebDriver;

import pages.HomePage;
import pages.RegistrationPage;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class Step {
	
	public static WebDriver driver;
	private HomePage home ;
	private RegistrationPage regi ;
	 
	@Given("^I am on Home page$")
	public void i_am_on_Home_page() throws Throwable {
		home = new HomePage();
	    home.onHomePage();
	}

	@When("^I enter\"(.*?)\",\"(.*?)\",\"(.*?)\"$")
	public void i_enter(String email, String pass, String confirm) throws Throwable {
		regi = new  RegistrationPage();
		regi.emailAdd(email, pass, confirm);
	
	}
	
	
	@When("^I click on create account button$")
	public void i_click_on_create_account_button() throws Throwable {
	   regi.create();
	}



	@Then("^I get registered successfully \"(.*?)\"$")
	public void i_get_registered_successfully(String message) throws Throwable {
	   
	regi.messageIsPresent(message);
	regi.clickOnContinueshopping();
	home = new HomePage();
	home.clickOnSignout();
   
	


	    
	}
	@Then("^I should see signout link$")
	public void i_should_see_signout_link() throws Throwable {
	   
	}

	@Given("^I am on signout page$")
	public void i_am_on_signout_page() throws Throwable {
	   
	}

}
