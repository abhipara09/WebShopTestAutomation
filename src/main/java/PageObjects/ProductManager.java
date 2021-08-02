package PageObjects;

import Config.Propertyfile;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class ProductManager extends ClassBase implements Propertyfile {

	// Initializing the Page Objects:
	public ProductManager(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}

	// Elements
	@FindBy (xpath = "//input[@id=\"addtocart_14_EnteredQuantity\"]")
	public WebElement WEquantity;

	@FindBy (linkText = "Black & White Diamond Heart")
	public WebElement productselct;

	@FindBy (xpath = "//input[@id=\"add-to-cart-button-14\"]")
	public WebElement WEaddtocart;

	@FindBy (xpath = "//a[text()=\"shopping cart\"]")
	public WebElement WEaddtocartsuccess;

	@FindBy (name = "removefromcart")
	public WebElement removecheckbx;
	@FindBy (name = "updatecart")
	public WebElement updateshopbtn;
	@FindBy (xpath = "//div[contains(text(),'Your Shopping Cart is empty!')]")
	public WebElement cartmessage;
	@FindBy (xpath = "//span[contains(text(),'Shopping cart')]")
    public WebElement shopcartlink;
	// Functions
	public void UpdateQuantity() {
		wait.until(ExpectedConditions.elementToBeClickable(WEquantity)).click();
		WEquantity.clear();
		WEquantity.sendKeys(prodquantity);
	}

	public void ClickAddToCart() {
		productselct.click();
		wait.until(ExpectedConditions.elementToBeClickable(WEaddtocart)).click();
	}

	//Assertion functions
	public boolean isProductAdded() {
		if (wait.until(ExpectedConditions.elementToBeClickable(WEaddtocartsuccess)).isDisplayed())
			return true;
		else
			return false;
	}

	public boolean isProductpage() {
		System.out.println(getPageTitle().toString());
		//return true;

		if (getPageTitle().toString().equals(productpagetitle))
			return true;
		else
			return false;
	}
	public boolean isSearchpage() {
		System.out.println(getPageTitle().toString());
		if (getPageTitle().toString().equals(productpagetitleserch))
			return true;
		else
			return false;
	}

	public void removechkbx() {
        wait.until(ExpectedConditions.elementToBeClickable(removecheckbx)).click();
	}

	public void updateshopcart() {
      updateshopbtn.click();
	}
	public boolean successmessage()
	{
		String message = cartmessage.getText();
		if (message.toString().matches("Your Shopping Cart is empty!")){
		return true;
	} return false;
    }
    public void gotocart() {
	    shopcartlink.click();
    }
}
