package Base;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.log4j.PropertyConfigurator;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;


public class BaseTest{

    public WebDriver driver;
    @Before
    public void setup(){
        PropertyConfigurator.configure("log4j.properties");
        System.setProperty("webdriver.chrome.driver","driver/chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-notifications");
        options.addArguments("start-maximized");
        driver = new ChromeDriver(options);
        driver.get("https://www.gittigidiyor.com/");

    }

    @After
    public void close(){
        if(driver != null){
            driver.quit();
        }
    }


}
