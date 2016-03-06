package features;

import org.openqa.selenium.WebDriver;

import Utils.BrowserFactory;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pages.HomePage;

public class Stepdefination {
	public static WebDriver driver;
	HomePage page = new HomePage();
	@Before
    public void start()
    {
        WebDriver driver = BrowserFactory.getDriver();
    }

	@Given("^I am on home page$")
	public void i_am_on_home_page() throws Throwable {
	 page.searchLinkIsPresent();
		
	}

	@When("^I enter \"(.*?)\"$")
	public void i_enter(String emai)throws Throwable {
		page.enterDetail(emai);
	  
	}

	@When("^click on sign up button$")
	public void click_on_sign_up_button() throws Throwable {
	   page.clickOnsignup();
	}

	@Then("^I should see a \"(.*?)\"$")
	public void i_should_see_a(String text)throws Throwable {
	    
	page.message(text);
	
	
	

}
}
