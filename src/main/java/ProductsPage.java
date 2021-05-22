import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class ProductsPage extends BasePage{

     By goToSecondPage=By.xpath("//a[@href='/arama/?k=Bilgisayar&sf=2']");
     By closeCookiess=By.cssSelector("span[class=gg-icon gg-icon-close icon-close]");
     By closeAdvertisement=By.cssSelector("img[class=wis-clsbtn-9490]");
  public ProductsPage(WebDriver driver) {
        super(driver);
    }

    public void setCloseAdvertisement(){
      click(closeAdvertisement);
    }
    public void closeCookies(){
      click(closeCookiess);
    }
   public void secondPage(){
      click(goToSecondPage);
   }

  // private List<WebElement> getAllProducts(){
   //   return findAll();
   // }




}
