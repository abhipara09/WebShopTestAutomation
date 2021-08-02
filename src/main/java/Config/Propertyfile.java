package Config;

public interface Propertyfile {

    String browser        = System.getProperty("browser", "chrome");
    String searchstring   = System.getProperty("searchst","book");
    String productpagetitle    = System.getProperty("productpage","Demo Web Shop. Jewelry");
    String productpagetitleserch    = System.getProperty("productpage","Demo Web Shop. Health Book");
    String searchpagetitle    = System.getProperty("searchpage","Demo Web Shop. Search");
    String homepagetitle    = System.getProperty("searchpage","Demo Web Shop");
    String prodquantity         = System.getProperty("productquantity","3");
    String demohomeUrl        = System.getProperty("homepageurl","http://demowebshop.tricentis.com/");
    String productUrl        = System.getProperty("prodpageurl","http://demowebshop.tricentis.com/jewelry");
    String productcartUrl        = System.getProperty("prdcrtgeurl","http://demowebshop.tricentis.com/cart");


}
