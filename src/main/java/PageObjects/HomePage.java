package PageObjects;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import Config.Propertyfile;

public class HomePage extends ClassBase implements Propertyfile {

	// Initializing the Page Objects:
	public HomePage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}

	// Elements
	@FindBy (xpath = "//input[@id='small-searchterms']")
	public WebElement searchitem;
	@FindBy (xpath = "//input[@class='button-1 search-box-button']")
	public WebElement searchbutton;
	@FindBy (xpath = "//img[@title=\"Show details for Health Book\"]")
	public WebElement product;

	// Functions

	public void Searchproduct() {
		System.out.println(searchitem);
	wait.until(ExpectedConditions.elementToBeClickable(searchitem)).click();
		searchitem.sendKeys(searchstring);
	searchbutton.click();
	}

	public void ClickProduct() {
		wait.until(ExpectedConditions.elementToBeClickable(product)).click();
		}

	//Assertion functions
	public boolean isHomePage() {

		if (getPageTitle().toString().equals(homepagetitle))
			return true;
		else
			return false;
	}

	public boolean isSearchSuccess() {
		//System.out.println(getPageTitle().toString());
		//return true;

		if (getPageTitle().toString().equals(searchpagetitle))
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

	public void brokenLinks() {
		String homePage = demohomeUrl;
		String url = "";
		HttpURLConnection huc = null;
		int respCode = 200;

		List<WebElement> links = driver.findElements(By.tagName("a"));

		Iterator<WebElement> it = links.iterator();

		while(it.hasNext()){

			url = it.next().getAttribute("href");

			System.out.println(url);

			if(url == null || url.isEmpty()){
				System.out.println("URL is either not configured for anchor tag or it is empty");
				continue;
			}

			if(!url.startsWith(homePage)){
				System.out.println("URL belongs to another domain, skipping it.");
				continue;
			}

			try {
				huc = (HttpURLConnection)(new URL(url).openConnection());

				huc.setRequestMethod("HEAD");

				huc.connect();

				respCode = huc.getResponseCode();

				if(respCode >= 400){
					System.out.println(url+" is a broken link");
				}
				else{
					System.out.println(url+" is a valid link");
				}

			} catch (MalformedURLException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
