package pages;

import Utils.Utils;
import Utils.VerifyUtils;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.io.File;
import java.io.IOException;
import java.util.List;

import junit.framework.Assert;

/**
 * 
 */
public class HomePage extends BasePage {

    static Logger LOGGER = Logger.getLogger(HomePage.class);


    @FindBy(how = How.CLASS_NAME, using = "dealer-name")
    public WebElement header;

    @FindBy(how = How.ID, using = "Subject")
    public WebElement Subject;

    @FindBy(how = How.CLASS_NAME, using = "hamburger_button")
    public WebElement hamburger_button;

    @FindBy(how = How.ID, using = "")
    public WebElement editableContent;

    @FindBy(how = How.CSS, using = "span.header_links.shop_link")
    public WebElement shop_button;

    @FindBy(how = How.CSS, using = "span.header_links.search_link")
    public WebElement search_button;

    @FindBy(how = How.LINK_TEXT, using = "Show all shops")
    public WebElement Show_all_shops;

    @FindBy(how = How.NAME, using = "search-keywords")
    public WebElement keyword_input_textbox;
    
    @FindBy(how= How.NAME,using = "newsletter-email")
    public WebElement Email_text;
    
    @FindBy(how=How.XPATH,using ="//footer[@class='footer big-footer']")
    public WebElement Signup_button;
   
    @FindBy(how=How.XPATH,using="//input[@value='Create an account now']")
    public WebElement create_account;
    
    @FindBy(how=How.XPATH,using="//a[contains(.,'Sign in / register')]")
    public WebElement register_button;

    @FindBy(how=How.XPATH,using="//a[contains(.,'Sign out')]")
    public WebElement Signoutlink;
    
    @FindBy(how=How.XPATH,using="//a[contains(.,'lewis@yopmail.com�-�Sign out')]")
    public WebElement signout_button;
    
    @FindBy(how=How.LINK_TEXT,using="Sign in / register")
    public WebElement Registerlink;
    //
    
    
    
    //a[contains(.,'Sign in to your account')]
    @FindBy(how=How.XPATH,using="//a[contains(.,'Sign in to your account')]")
    public WebElement signin_link;
    public HomePage() {

        PageFactory.initElements(driver, this);
        Utils.waitElementPresent(By.linkText("Basket"));
        if (!driver.findElement(By.linkText("Basket")).isDisplayed())
            throw new RuntimeException("No home page shown");
    }


    public void enterBody(String body) {

        driver.switchTo().frame("iframeCommonBody");
        editableContent.sendKeys(body);
        driver.switchTo().defaultContent();

    }

    public void sendMessage() {
        ((JavascriptExecutor) driver).executeScript("checkLimitBeforeSend('/web_com/SendMessage?', 'send')");
//        driver.findElement(By.xpath("//button[contains(text(),'Send')]")).click();
    }

    public boolean checkHeader(String message) {
        return header.getText().contains(message);
    }


    public boolean getHeader(String header) {
        return this.header.getText().contains(header);
    }

    public boolean getButton(String buttontext) {
        List<WebElement> elements = driver.findElements(By.tagName("button"));

        for (WebElement element : elements) {
            try {
                element.findElement(By.tagName("span")).getText().contains(buttontext);
                return true;
            } catch (Exception e) {
                //ignore
            }
        }

        return false;
    }

    public void openHamBurgerMenu() {
        hamburger_button.click();
    }

    public void openAllShops() {
        shop_button.click();
        Utils.sleep(3);
        Show_all_shops.click();

    }

    public void checkBranchIsShown(String branch) {
        VerifyUtils.True("Checking that the branch " + branch + " is available", Utils.isElementPresent(By.linkText(branch)));
    }

    public void openTheBranch(String branch) {
        driver.findElement(By.linkText(branch)).click();
    }

    public void checkBranchText(String branch) {
        VerifyUtils.ContainsTrue("Checking the branch details are shown " + branch, Utils.getVisibleText(), "John Lewis " + branch);
    }


    public void searchWithKeyword(String keyword)
    {
        //click on search icon
        search_button.click();
        //enter the product name
        Utils.sleep(2);

        keyword_input_textbox.clear();
        keyword_input_textbox.sendKeys(keyword);

        Utils.sleep(1);
        //click on search button
        keyword_input_textbox.sendKeys(Keys.ENTER.toString());
    }
    public void searchLinkIsPresent(){
		VerifyUtils.True(driver.findElement(By.className("departments_title")).getText().contains("Departments"));
		

    	}
    public void enterDetail(String email){
    	 Email_text.click();
    	 Email_text.sendKeys(email);
    
    	 }
    public void clickOnsignup(){ 
      	 Signup_button.click();
     	  Utils.sleep(1);
    } 
    public void clickOnSignout()
    {
    	Utils.waitForElementToBeClickble(hamburger_button,30).click();
    	Utils.waitForElementToBeClickble(Signoutlink, 20).click();
    }
    public void message(String text){
    	   Utils.isTextPresent(text);
    	
    }
    public void onHomePage() throws InterruptedException, IOException
    {
    	
    	driver.get("www.facebook.com");
    	
    	//System.out.println("you are at point");
    	driver.findElement(By.id("u_0_1")).sendKeys("New element");

    	JavascriptExecutor javascript = (JavascriptExecutor) driver;
    	String CurrentURLUsingJS=(String)javascript.executeScript("return document.domain");
    	System.out.println("this is the domine name "+ CurrentURLUsingJS);
    	
    //DropdownBox  select the value 
    	  Boolean iselementpresent = driver.findElements(By.xpath("//*[@id='month']")).size()!= 0; 
    	  Assert.assertTrue(iselementpresent);
    	  System.out.println(iselementpresent);
    	  Select dropdown=new Select(driver.findElement(By.xpath("//*[@id='month']")));
          dropdown.selectByValue("4");
          Thread.sleep(2000);
          dropdown.selectByIndex(7);
          Thread.sleep(2000);
    	  dropdown.selectByVisibleText("May");
    	  
    	  /*File screenshot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE); 
    	  FileUtils.copyFile(screenshot, new File("/Users/riyan/one.png")); 
   */
    	  System.out.print("Multiple selections is supported");
    	  
    	  
    	  
    	  
    	  
    	  
    	  
    	  
    	  
    	  driver.get("http://only-testing-blog.blogspot.in/p/mouse-hover.html");
    	  
    	  
    	  Actions actions = new Actions(driver); 
    	  WebElement moveonmenu = driver.findElement(By.xpath("//div[@id='menu1']/div")); 
    	  Thread.sleep(3000);
    	  actions.moveToElement(moveonmenu).moveToElement(driver.findElement(By.xpath("//div[@id='menu1choices']/a"))).click().perform(); 
   
    	
    	  
    	  
    	  
    	  
    	  
    	  
    	  
    	  
    	  
    	  
    	  
    	  
    	  
    	  
    	  
    	 // Utils.waitForElementToBeClickble(hamburger_button,30).click();
    	  //Utils.waitForElementToBeClickble(register_button,30).click();
    	  //Utils.waitForElementToBeClickble(create_account,30).click();
    }
    public void clickOnSignin(){
    	hamburger_button.click();
        register_button.click();   
    	
   } 
   public void wishListPresent(){
	   VerifyUtils.True(driver.findElement(By.xpath("//a[contains(.,'My Wish List')]")).getText().contains("My Wish List"));
	   
   } 
    
    	
    
    public void signInLinkpresent(){
    	VerifyUtils.True(driver.findElement(By.xpath("//a[contains(.,'Sign in to your account')]")).getText().contains("Sign in to your account"));
    }
    
    
}
