package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import Utils.Utils;
import Utils.VerifyUtils;

public class SignInPage extends BasePage {
	
	@FindBy(how = How.ID, using = "um-email")
    public WebElement email1;

    @FindBy(how = How.ID, using = "um-pwd")
    public WebElement password1;
    
    @FindBy(how = How.XPATH,using = "//input[@name='sign-in']")
    public WebElement signin_button;
    
    @FindBy(how = How.XPATH,using = "//a[contains(.,'lewis@yopmail.com�-�Sign out')]")
    public WebElement signout_link;
    
    
    
   public  SignInPage(){

        PageFactory.initElements(driver, this);
   
        
    }
   
   public void onSignInPage(String username, String password){
   email1.sendKeys(username);
   password1.sendKeys(password);
   }

	public void onClickingSignIn(){
		 Utils.waitForElementToBeClickble(signin_button,30).click();	
	}
	
	public void onClickingSignOut()
	{	
		Utils.sleep(3);	
		signout_link.click();
	}
	public void sigInpresent(){
		
	VerifyUtils.True("checking that signin option is present",driver.findElement(By.xpath("//a[contains(.,'Sign in to your account')]")).getText().contains("Sign in to your account"));
	
	}
	public void signoutpresent(){
		
		VerifyUtils.True(driver.findElement(By.xpath("//a[contains(.,'lewis@yopmail.com�-�Sign out')]")).getText().contains("lewis@yopmail.com - Sign out"));
		
	{
	
	
	}


}}
