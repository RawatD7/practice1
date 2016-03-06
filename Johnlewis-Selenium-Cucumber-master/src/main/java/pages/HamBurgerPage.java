package pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import Utils.Utils;
import Utils.VerifyUtils;

public class HamBurgerPage extends BasePage {


    @FindBy(how= How.XPATH,using = "//a[contains(.,'Browse by Department')]")
    public WebElement Department_link;
    
    @FindBy(how= How.XPATH,using =  "//span[contains(.,'Electricals')]")
    public WebElement Select_Department;
	                                
    @FindBy(how= How.XPATH,using ="//summary[contains(.,'Sound & Vision')]")
    public WebElement Item_select;
    
 
    @FindBy(how= How.XPATH,using  = "un_prod_name")
    public WebElement Product_name;
    @FindBy(how = How.XPATH,using = "//input[@value='Add to Basket']")
    public WebElement Add_to_basket;
    @FindBy(how = How.XPATH,using =  "//a[contains(.,'Partnership Card')]")
    public WebElement Card_link;
    
    
    public  HamBurgerPage(){
    	 PageFactory.initElements(driver,this);
    }
    
    public void clickOnDepartmentLink(String Department)
    {
    	Department_link.click();
    	
    }
 
    
    
    public void selectTheSpecificDepartment(String arg1){
    	Select_Department.click();
    }
    public void addItem(){ 
    	Item_select.click();
    	Utils.sleep(2);
    	Product_name.click();
    	 Add_to_basket.click();
    	
    	 }
	public void clickOnPartnershipCard() {
		Card_link.click();
		}
public void navigatedToCardPage(){
	Assert.assertTrue(driver.findElement(By.xpath("//img[@alt='Partnership card™']")).isDisplayed());
	
}
}
