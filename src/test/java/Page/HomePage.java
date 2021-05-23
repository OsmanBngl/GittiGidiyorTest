package Page;

import Base.BasePage;
import org.apache.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class HomePage extends BasePage {


    private static Logger logger = Logger.getLogger(HomePage.class);

    By openLoginPopupButton=By.cssSelector("div[title='Giriş Yap']");
    By loginButton=By.cssSelector("a[data-cy='header-login-button']");
    By searchBoxLocator=By.name("k");
    By submitButtonLocator =By.cssSelector("button[data-cy=search-find-button]");
    By searchText =By.cssSelector("span.search-result-keyword");

    public HomePage(WebDriver driver) {
        super(driver);

    }

    public void goToLogin(){
        try{
            mouseOver(openLoginPopupButton);
            wait(1);
            click(loginButton);
            logger.info("Login butonuna tiklandı");
        }catch (Exception ex){
            logger.error("Login butonuna tıklanamadı.");
        }
    }
    public void search(String text) {
        type(searchBoxLocator,text);
        click(submitButtonLocator);
    }

    public void searchControl(String expectedSearchText){
        Assert.assertEquals(expectedSearchText,getElementText(searchText));
        logger.info("Arama işlemi basarılı bir şekilde gerçekleşmiştir");
    }

}
