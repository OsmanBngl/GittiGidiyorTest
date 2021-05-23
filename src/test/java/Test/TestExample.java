package Test;

import Base.BaseTest;
import Page.*;
import Utils.Constants;
import org.junit.Test;

public class TestExample extends BaseTest {

    HomePage homePage;
    LoginPage loginPage;
    ProductListPage productListPage;
    ProductDetailPage productDetailPage;
    BasketPage basketPage;


    @Test
    public void testiniumCase() throws InterruptedException {

        loginPage = new LoginPage(driver);
        homePage = new HomePage(driver);
        productListPage = new ProductListPage(driver);
        productDetailPage=new ProductDetailPage(driver);
        basketPage=new BasketPage(driver);

       // homePage.goToLogin();
       // loginPage.login(Constants.email, Constants.password);
       // Thread.sleep(4000);
       // loginPage.loginControl(Constants.expectedUsername);

        homePage.search("Bilgisayar");
        Thread.sleep(4000);

        homePage.searchControl(Constants.expectedSearchText);

        Thread.sleep(1000);
        Thread.sleep(1000);
        productListPage.secondPage();
        Thread.sleep(1000);

        productListPage.controlSecondPage();

        Thread.sleep(5000);

        productListPage.selectRandomProduct();

        Thread.sleep(5000);

        productDetailPage.addToBasket();

        Thread.sleep(3000);
        productDetailPage.gotoBasketPage();

        Thread.sleep(3000);

        basketPage.compareProductPrice();
        Thread.sleep(3000);

        basketPage.increaseProductAmount("2");

        Thread.sleep(3000);

        basketPage.controlProductAmount("2");

        Thread.sleep(3000);

        basketPage.deleteBasket();
        Thread.sleep(3000);

        basketPage.controlIsBasketPageEmpty();
        Thread.sleep(3000);

    }


}
