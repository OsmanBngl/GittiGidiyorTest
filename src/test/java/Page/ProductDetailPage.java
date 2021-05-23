package Page;

import Base.BasePage;
import Utils.Constants;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class ProductDetailPage extends BasePage {
    By addToCartButtonLocator=By.id("add-to-basket");
    By productPriceText=By.id("sp-price-discountPrice");
    By basketPageOpenPopupButton=By.cssSelector("span.basket-title");
    By basketPageButton=By.xpath("//a[@class='gg-ui-btn-default padding-none']");

    public ProductDetailPage(WebDriver driver) {
        super(driver);
    }


    public void addToBasket() {
        pageScrollDown(500);
        Constants.expectedProductPrice=getElementText(productPriceText);
        click(addToCartButtonLocator);
    }

    public void gotoBasketPage(){
        mouseOver(basketPageOpenPopupButton);
        click(basketPageButton);
    }

}

