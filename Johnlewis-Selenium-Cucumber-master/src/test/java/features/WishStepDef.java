package features;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;

import pages.HomePage;
import pages.SignInPage;
import pages.WishListPage;
import Utils.BrowserFactory;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class WishStepDef  {
	public WebDriver driver;
	private HomePage homePage;
	private WishListPage list;
	private SignInPage sign;
	 @Before
	    public void start()
	    {
	        driver = BrowserFactory.getDriver();
	    }
@Given("^I shoulld be on the home page$")
public void i_shoulld_be_on_the_home_page() throws Throwable {
	homePage = new HomePage();
    homePage.wishListPresent();
}

@When("^I Search for the required item \"(.*?)\"$")
public void i_Search_for_the_required_item(String arg1) throws Throwable {
   homePage.searchWithKeyword(arg1);
}

@When("^I click on item \"(.*?)\"$")
public void i_click_on_item(String arg1) throws Throwable {
	list = new WishListPage();
	list.addFirstItem();
}
@When("^I click on the  Signin to Add to wishlist$")
public void i_click_on_the_Signin_to_Add_to_wishlist() throws Throwable {
	sign = new SignInPage();
    sign.onSignInPage("lewis@yopmail.com", "Lewis1yopmail");
    sign.onClickingSignIn();
}

@When("^I click on wishList link after sign in$")
public void i_click_on_wishList_link_after_sign_in() throws Throwable {
	list.checkWishList();
}

@Then("^I can see the selected item in the WishList$")
public void i_can_see_the_selected_item_in_the_WishList() throws Throwable {
   list.presentInWishList();


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
}}
}
