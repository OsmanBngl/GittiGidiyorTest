import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.Random;

public class ProductDetailPage extends BasePage {
    By addToCartButtonLocator=By.id("add-to-basket");

    public ProductDetailPage(WebDriver driver) {
        super(driver);
    }


    public void selectRandomProduct() {
        List<WebElement> allProducts = driver.findElements(By.className("catalog-view clearfix products-container"));
        Random rand = new Random();
        int randomProduct = rand.nextInt(allProducts.size());
        allProducts.get(randomProduct).click();


    }
    public void addToCart() {
        click(addToCartButtonLocator);
    }
}
