package pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import Utils.Utils;

public class WishListPage extends BasePage {
	 @FindBy(how = How.CLASS_NAME, using = "txt")
	    public WebElement search_icon;
	 
	 @FindBy(how = How.CLASS_NAME,using = "un_prod_name")
	    public WebElement product_name;
	 
	 @FindBy(how = How.XPATH,using = "//a[contains(.,'Sign in to add to Wish List')]")
	    public WebElement Wish_link;
	 
	 @FindBy(how = How.CLASS_NAME,using = "un_added_single_message")
	 public WebElement Add_wish;
	 
	 @FindBy(how = How.XPATH,using = "//a[contains(.,'My Wish List')]")
	 public WebElement click_wish;
	//a[contains(.,'My Wishlist')]
	 
	 public WishListPage()  {

	        PageFactory.initElements(driver,this);
	    }
	 
	 public void clickIcon(){
		 search_icon.click(); 
	 }

	    public void addFirstItem(){
	        Assert.assertTrue(driver.findElement(By.className("un_prod_name")).isDisplayed());
	        product_name.click();
	        Wish_link.click();

	    }
	    
	public void checkWishList(){
		
		click_wish.click();
		
		
	}
	
	 public void presentInWishList(){
	        
	       
	        Assert.assertTrue(driver.findElement(By.className("un_general_link")).isDisplayed());
	 
}
}
