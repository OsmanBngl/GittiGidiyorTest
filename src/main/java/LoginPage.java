import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class LoginPage extends BasePage{


    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public void goToLogin(){

          WebElement element =driver.findElement(By.cssSelector("div[title='Giriş Yap']"));
          Actions action =new Actions(driver);
          action.moveToElement(element).build().perform();
          try{
              Thread.sleep(1000);
              WebElement loginButton=driver.findElement(By.cssSelector("a[data-cy='header-login-button']"));
              loginButton.click();
          }catch (Exception ex){
            System.out.print(ex.getMessage());
          }
    }
    public void authenticationUser(){
        driver.findElement(By.id("L-UserNameField")).sendKeys("gittigidiyordeneme34@gmail.com");
        driver.findElement(By.name("sifre")).sendKeys("34Gittigidiyor34");
        try{
            Thread.sleep(1000);
            driver.findElement(By.id("gg-login-enter")).click();
        }catch (Exception ex){
            System.out.print(ex.getMessage());
        }


    }



}
