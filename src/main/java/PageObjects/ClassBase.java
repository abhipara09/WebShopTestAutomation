package PageObjects;


import org.openqa.selenium.*;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;


import Config.Propertyfile;

public class ClassBase implements Propertyfile {

    protected WebDriver driver;
    protected WebDriverWait wait;


    public ClassBase(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(this.driver, 20);
        driver.manage().window().maximize();
		PageFactory.initElements(driver, this);
		//System.out.println("Base : Page Object : " + this.getClass());
    }

    public String getPageTitle(){
        System.out.println("Page Title: " + driver.getTitle());
        return driver.getTitle();
    }

    public void openURL(String url ){
        driver.get(url);
    }


}
