package Base;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class BasePage {
    public WebDriver driver;

    private static Logger logger = Logger.getLogger(BasePage.class);

    public BasePage(WebDriver driver){
        this.driver=driver;
    }

    public WebElement find(By locator){
        return driver.findElement(locator);
    }

    public List<WebElement> findAll(By locator){
       return driver.findElements(locator);
    }

    public void click(By locator){
        try {
            WebElement element =driver.findElement(locator);
            element.click();
            logger.info(locator + " by li elemente tiklandi.");
        }catch (Exception e){
            logger.error(locator+ " by li elemente tiklanamadi.");
        }
    }

    public void type(By locator, String text){
        try {
            WebElement element =driver.findElement(locator);
            element.sendKeys(text);
            logger.info(locator + " by li elemente "+text+" degeri yazildi.");
        }catch (Exception e){
            logger.error(locator+ " by li elemente "+text+" degeri yazılmadı.");
        }
    }

    public String getElementText(By locator){
        return find(locator).getText();
    }

    public void wait(int seconds) {
        try {
            Thread.sleep(seconds*1000);
            logger.info(seconds +" saniye süre beklendi.");
        }catch (Exception e){
            logger.error(seconds +" saniye süre beklenmedi.");
        }
    }

    public void pageScrollDown(int pixel){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,"+pixel+")");
        logger.info(pixel+" aşağıya kaydırıldı.");
    }

    public void mouseOver(By locator){
        try {
            Actions actions = new Actions(driver);
            WebElement element = find(locator);
            actions.moveToElement(element).perform();
            logger.info("Mouse " +locator+ " locatorlu elementin üstüne getirildi.");
        }catch (Exception e){
            logger.error("Mouse " +locator+ " locatorlu elementin üstüne getirilemedi.");
        }
    }

    public Boolean isDisplayed(By locator){
        return find(locator).isDisplayed();
    }

    public void selectWithVisibleText(By locator,String option){
        try {
            Select select = new Select(find(locator));
            select.selectByVisibleText(option);
            logger.info(locator+ " dropdown elementte "+option+" seçildi.");
        }catch (Exception e){
            logger.error(locator+ " dropdown elementte "+option+" secilemedi.");
        }
    }

    public String getSelectedValueOnDropdown(By locator){
        Select select = new Select(find(locator));
        return select.getFirstSelectedOption().getText();
    }
}





