package pages;

import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import Utils.Utils;
import Utils.VerifyUtils;

public class RegistrationPage extends BasePage {
	
	@FindBy(how = How.ID, using = "um-email-reg")
    public WebElement email_reg;
	@FindBy(how = How.ID, using = "um-pwd-reg")
    public WebElement pass_reg;
	
	@FindBy(how = How.ID, using = "um-pwd-reg2")
    public WebElement pass2_reg;
	
	@FindBy(how = How.NAME,using="create-account")
    public WebElement press_button;
	
	@FindBy(how=How.XPATH,using="//*[@id='ssl-register-confirm']/div[2]/div[1]/div[1]")
	public WebElement display;
	
	@FindBy(how=How.XPATH,using="//div[@class='error font12px font12px_descendant unErrorDescendant un_padding_tb_5 firepath-matching-node']")
	public WebElement display1;
	
	@FindBy(how=How.CLASS_NAME,using="un_green_btn")
	public WebElement continueshopping;
	

    public RegistrationPage() {

        PageFactory.initElements(driver, this);
        if (!email_reg.isDisplayed())
            throw new RuntimeException("Unable to see registration");
        
    }

    
    
	public void emailAdd(String email,String pass,String confirm ){
		

		
		Random rs = new Random();
		String Email = (String)(rs.nextInt(1000000) + email);
		System.out.println(Email);

		      
		Utils.waitForElementToBeClickble(email_reg,20).sendKeys(Email);
		Utils.waitForElementToBeClickble(pass_reg,20).sendKeys(pass);
		Utils.waitForElementToBeClickble(pass2_reg,30).sendKeys(confirm);
		
		
	}
	public void create(){
		press_button.click();
		Utils.sleep(2);
	}
	
	public void clickOnContinueshopping()
	{
		
		Utils.waitForElementToBeClickble(continueshopping, 20).click();
		
	}
	
	
	
	public void messageIsPresent(String message){
		
	
        VerifyUtils.True("Checking the message " + message + " is available", Utils.isElementPresent(By.xpath("//div[@class='font13px bold']")));
    }	
	}     

	
	
	
		
	

