package features;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;

import pages.HamBurgerPage;
import pages.HomePage;
import Utils.BrowserFactory;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class HamStepDef {
	public WebDriver driver;
	private HomePage homePage;
	private HamBurgerPage ham;
	@Before
    public void start()
    {
        driver = BrowserFactory.getDriver();
    }

		@When("^I click on the Hamburger menu$")
		public void i_click_on_the_Hamburger_menu() throws Throwable {
			homePage = new HomePage();
			homePage.openHamBurgerMenu();
			
		   }

		@When("^I click on the link \"(.*?)\"$")
		public void i_click_on_the_link(String Department) throws Throwable {
			ham = new HamBurgerPage();
			ham.clickOnDepartmentLink(Department);
			
		}

		@Then("^I navigate to the  Department page$")
		public void i_navigate_to_the_Department_page() throws Throwable {
			homePage = new HomePage();
			homePage.searchLinkIsPresent();
		}

		@Then("^I select the specific department \"(.*?)\"$")
		public void i_select_the_specific_department(String arg1) throws Throwable {
			ham = new HamBurgerPage();
		   ham.selectTheSpecificDepartment(arg1); 
		}

		@Then("^Add the item into the basket$")
		public void add_the_item_into_the_basket() throws Throwable {
			ham = new HamBurgerPage();
		    ham.addItem();
		}

		@When("^click on the Hamburger menu$")
		public void click_on_the_Hamburger_menu() throws Throwable {
			homePage = new HomePage();
			homePage.openHamBurgerMenu();
		}

@When("^click on the link \"(.*?)\"$")
public void click_on_the_link(String arg1) throws Throwable {
	ham = new HamBurgerPage();
   ham.clickOnPartnershipCard();
}

		@Then("^I should navigate to the Apply Partnership card page$")
		public void i_should_navigate_to_the_Apply_Partnership_card_page() throws Throwable {
			ham = new HamBurgerPage();
		  ham.navigatedToCardPage();
		}
		@After
		/**
		 * Embed a screenshot in test report if test is marked as failed
		 */
		public void embedScreenshot(Scenario scenario) {

		    if (scenario.isFailed()) {
		        try {
		            scenario.write("Current Page URL is " + driver.getCurrentUrl());
//		        byte[] screenshot = getScreenshotAs(OutputType.BYTES);
		            byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
		            scenario.embed(screenshot, "image/png");
		        } catch (WebDriverException somePlatformsDontSupportScreenshots) {
		            System.err.println(somePlatformsDontSupportScreenshots.getMessage());
		        }
		}}
}
