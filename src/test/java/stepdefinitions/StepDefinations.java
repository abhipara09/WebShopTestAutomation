package stepdefinitions;

import Config.Propertyfile;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import PageObjects.HomePage;
import PageObjects.ProductManager;

import static org.junit.Assert.assertEquals;


public class StepDefinations implements Propertyfile {

    private WebDriver driver;
    private ProductManager productPage;
    private HomePage homePage;

    @Before
    public void setUp() {
        if (browser.equals("chrome")) {
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
        }
    }

    @Given("User is on Landing Page")
    public void user_is_on_Landing_Page() {
        // Write code here that turns the phrase above into concrete actions
        homePage = new HomePage(driver);
        homePage.openURL(demohomeUrl);
        assertEquals("Failed to load URL:http://demowebshop.tricentis.com/", true, homePage.isHomePage());
    }

    @Given("User enters the search keywords")
    public void user_enters_the_search_keywords() {
        homePage.Searchproduct();

    }

    @Given("User clicks on the search button")
    public void user_clicks_on_the_search_button() {
        System.out.println("search button clicked");
        assertEquals("Failed to search product",true,homePage.isSearchSuccess());

    }

    @Then("user should see the search result")
    public void user_should_see_the_search_result() {
        homePage.ClickProduct();
        System.out.println("user is able to see searched product");

    }


    @Given("User is on Product Page")
    public void user_is_on_Product_Page_health_Book() {
        productPage = new ProductManager(driver);
        productPage.openURL(productUrl);
        assertEquals("Cant navigate to product page",true,productPage.isProductpage());
    }

    @Given("User enters required quantity")
    public void user_enters_required_quantity() {
        // Write code here that turns the phrase above into concrete actions
        productPage.UpdateQuantity();
    }

    @Given("User clicks on Add To Cart button")
    public void user_clicks_on_Add_To_Cart_button() {
        // Write code here that turns the phrase above into concrete actions
        productPage.ClickAddToCart();
    }

    @Then("product should be added successfully to the cart")
    public void product_should_be_added_successfully_to_the_cart() {
        // Write code here that turns the phrase above into concrete actions
        assertEquals("Cant  add product to cart",true,productPage.isProductAdded());
    }

    @Given("User is validating the broken links")
    public void  validations_of_broken_links (){
    System.out.println("validations of all the links are staring now...");
    homePage.brokenLinks();
    }

    @Given("User is on shopping cart page")
        public void shopping_cart(){
        productPage.gotocart();
        System.out.println("User has navigated to the cart page");
    }

    @Given("click on remove check box of product")
    public void remove_check_box (){
        productPage.removechkbx();
    }
    @Given("Click on Update Shopping cart button")
    public void update_shop_carrt(){
        productPage.updateshopcart();
    }
    @Given("product should be removed successfully from the cart")
    public void removed_success (){
        assertEquals("Cart hasnt updated",true,productPage.successmessage());
    }

    @After
    public void tearDown() {
        driver.quit();
    }

}
