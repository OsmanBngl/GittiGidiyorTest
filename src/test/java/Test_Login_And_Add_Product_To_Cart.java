import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;

public class Test_Login_And_Add_Product_To_Cart extends BaseTest{

    HomePage homePage;
    LoginPage loginPage;
    ProductsPage productsPage;
    ProductDetailPage productDetailPage;
    CartPage cartPage;

    @Test
    @Order(1)
    public void login(){
      homePage=new HomePage(driver);
      loginPage=new LoginPage(driver);
      loginPage.goToLogin();
      loginPage.authenticationUser();


    }

    @Test
    @Order(2)
    public void search_a_product(){
        homePage= new HomePage(driver);
        productsPage=new ProductsPage(driver);
        homePage.searchBox().search("Bilgisayar");
        productsPage.setCloseAdvertisement();
        productsPage.closeCookies();
        productsPage.secondPage();

    }


    @Test
    @Order(3)
    public void select_random_a_product(){
        productDetailPage=new ProductDetailPage(driver);
        productDetailPage.selectRandomProduct();

    }

    @Test
    @Order(4)
    public void add_product_to_cart(){
      productDetailPage.addToCart();
      Assertions.assertTrue(homePage.IsOnProductCountUp(),
              "Product count old not increase!");
    }


    @Test
    @Order(5)
    public void go_to_cart(){
        cartPage=new CartPage(driver);
        homePage.goToCart();
        Assertions.assertTrue(cartPage.checkIfProductAdded(),
               "Product was not added to cart");
    }

}
