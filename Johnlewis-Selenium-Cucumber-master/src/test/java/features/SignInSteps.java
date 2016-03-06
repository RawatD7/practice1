package features;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;

import pages.HomePage;
import pages.LoginPage;
import pages.SignInPage;
import Utils.BrowserFactory;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class SignInSteps {
	public WebDriver driver;
    public LoginPage loginPage;// = new LoginPage();
    private HomePage homePage;
    private SignInPage page;
	
	
	  @Before
	    public void start()
	    {
	        driver = BrowserFactory.getDriver();
	    }



	
	@Given("^I should be on home page$")
	public void i_should_be_on_home_page() throws Throwable {
		homePage = new HomePage();
		homePage.signInLinkpresent();
	}

	@When("^I click on signin link$")
	public void i_click_on_signin_link() throws Throwable {
		homePage.clickOnSignin(); 
	}

	@When("^I enter  Email \"(.*?)\" ,Password \"(.*?)\"$")
	public void i_enter_Email_Password(String arg1, String arg2) throws Throwable {
		page = new SignInPage();
		page.onSignInPage(arg1, arg2);
	}

	@When("^I click on signin button$")
	public void i_click_on_signin_button() throws Throwable {

page.onClickingSignIn();
	    
	}

	@Then("^I should see signout$")
	public void i_should_see_signout() throws Throwable {
		page.signoutpresent();
	}

@When("^I click on sign out$")
public void i_click_on_sign_out() throws Throwable {
	page = new  SignInPage();
	page.onClickingSignOut();
}

@Then("^I should see signin option$")
public void i_should_see_signin_option() throws Throwable {
   page.sigInpresent();
}


@After
/**
 * Embed a screenshot in test report if test is marked as failed
 */
public void embedScreenshot(Scenario scenario) {

    if (scenario.isFailed()) {
        try {
            scenario.write("Current Page URL is " + driver.getCurrentUrl());
//        byte[] screenshot = getScreenshotAs(OutputType.BYTES);
            byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
            scenario.embed(screenshot, "image/png");
        } catch (WebDriverException somePlatformsDontSupportScreenshots) {
            System.err.println(somePlatformsDontSupportScreenshots.getMessage());
        }

    }

}}


