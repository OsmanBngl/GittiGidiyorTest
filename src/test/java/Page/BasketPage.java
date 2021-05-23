package Page;

import Base.BasePage;
import Utils.Constants;
import org.apache.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class BasketPage extends BasePage {

    private static Logger logger = Logger.getLogger(BasketPage.class);

    By basketPageProductPrice= By.cssSelector("p.new-price");
    By productAmountDropdown=By.xpath("//div[@class='gg-input gg-input-select ']//select");
    By deleteProductionButton = By.xpath("(//i[@class='gg-icon gg-icon-bin-medium'])[1]");
    By emptyBasketPageMessageText=By.xpath("//div[@class='gg-d-19 gg-w-21 gg-t-19 gg-m-18']//h2");


    public BasketPage(WebDriver driver) {
        super(driver);
    }

    public void compareProductPrice(){
        Assert.assertTrue(getElementText(basketPageProductPrice).contains(Constants.expectedProductPrice));
        logger.info("Secilen urunun fiyatı ile sepetteki fiyat eşittir");
    }

    public void increaseProductAmount(String amount){
        selectWithVisibleText(productAmountDropdown,amount);
    }

    public void controlProductAmount(String expectedAmount){
        Assert.assertTrue(expectedAmount.contains(getSelectedValueOnDropdown(productAmountDropdown)));
        logger.info("Sepette urun miktarı başarılı şekilde arttırıldı");
    }


    public void deleteBasket(){
        click(deleteProductionButton);
    }
    public void controlIsBasketPageEmpty(){
        Assert.assertTrue(Constants.expectedEmptyBasketPageMessage.contains(getElementText(emptyBasketPageMessageText)));
        logger.info("Sepetteki urunler başarılı bir şekilde silindi.");
   }
}


