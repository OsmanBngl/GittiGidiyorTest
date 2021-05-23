package Page;

import Base.BasePage;
import Utils.Constants;
import org.apache.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePage {
    private static Logger logger = Logger.getLogger(LoginPage.class);


    By emailTextBox=By.id("L-UserNameField");
    By passwordTextBox=By.name("sifre");
    By loginButton=By.id("gg-login-enter");
    By loginControlText=By.xpath("(//div[@class='gekhq4-4 egoSnI'])[1]//span");

    public LoginPage(WebDriver driver) {
        super(driver);
    }


    public void login(String email,String password){
        type(emailTextBox,email);
        wait(1);
        type(passwordTextBox,password);
        wait(2);
        click(loginButton);
    }
    public void loginControl(String expectedUsername){
        Assert.assertTrue(getElementText(loginControlText).contains(expectedUsername));
        logger.info("Kullanıcı basarılı sekilde login olmustur.");
    }


}
