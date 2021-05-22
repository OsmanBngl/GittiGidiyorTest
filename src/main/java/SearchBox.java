import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SearchBox extends BasePage {

    By searchBoxLocator=By.name("k");
    By submitButtonLocator =By.cssSelector("button[data-cy=search-find-button]");

    public SearchBox(WebDriver driver) {
        super(driver);
    }

    public void search(String text) {
        type(searchBoxLocator,text);
        click(submitButtonLocator);
    }
}
