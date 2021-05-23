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
    public void testiniumCase()  {

        loginPage = new LoginPage(driver);
        homePage = new HomePage(driver);
        productListPage = new ProductListPage(driver);
        productDetailPage=new ProductDetailPage(driver);
        basketPage=new BasketPage(driver);

        homePage.goToLogin();
        loginPage.login(Constants.email, Constants.password);
        homePage.wait(4);
        loginPage.loginControl(Constants.expectedUsername);

        homePage.search("Bilgisayar");
        homePage.wait(4);

        homePage.searchControl(Constants.expectedSearchText);

        productListPage.wait(1);
        productListPage.wait(1);
        productListPage.secondPage();
        productListPage.wait(1);

        productListPage.controlSecondPage();

        productListPage.wait(5);

        productListPage.selectRandomProduct();

        productListPage.wait(5);

        productDetailPage.addToBasket();

        productDetailPage.wait(3);
        productDetailPage.gotoBasketPage();

        productDetailPage.wait(3);

        basketPage.compareProductPrice();
        basketPage.wait(3);

        basketPage.increaseProductAmount("2");

        basketPage.wait(3);

        basketPage.controlProductAmount("2");

        basketPage.wait(3);

        basketPage.deleteBasket();
        basketPage.wait(3);

        basketPage.controlIsBasketPageEmpty();
        basketPage.wait(3);

    }

}

