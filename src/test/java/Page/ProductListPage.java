package Page;

import Base.BasePage;
import org.apache.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.Random;


public class ProductListPage extends BasePage {
    private static Logger logger = Logger.getLogger(ProductListPage.class);

    By secondPageButton=By.linkText("2");
    By secondPageControl=By.cssSelector("a.current");;
    By products=By.xpath("//div[@class='product-info-con clearfix ']");

  public ProductListPage(WebDriver driver) {
        super(driver);
    }


   public void secondPage(){
       JavascriptExecutor js=(JavascriptExecutor) driver;
       js.executeScript("window.scrollTo(0,document.body.scrollHeight)");
       click(secondPageButton);
   }


    public void controlSecondPage(){
        Assert.assertTrue(getElementText(secondPageControl).contains("2"));
        logger.info("2. sayfa basarlı sekilde acildi.");
    }

    public void selectRandomProduct(){
        List<WebElement> elementList=findAll(products);
        int randomNumber=new Random().nextInt(elementList.size());
        WebElement selectedProduct=elementList.get(randomNumber);
        selectedProduct.click();
        logger.info(randomNumber+". urune tıklandı.");
    }


}
