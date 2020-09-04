package pages;
import pages.PageBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage extends PageBase{


    By accountBtn = By.id("accountBtn");
    By LoginForm = By.id("loginForm");
    By LoginEmail = By.name("email");
    By LoginPass = By.name("password");
    By LoginSubmit = By.id("loginSubmit");

    By CheckAccount =By.xpath("//*[@id='logged-in-container']/div/div[9]/a");


    public LoginPage(WebDriver driver, WebDriverWait wait){
        super(driver,wait);
    }

    public void ClickOnAccountBtn(){
        driver.findElement(accountBtn).click();
    }

    public boolean Login(String email, String pass){
        driver.findElement(By.id("loginForm")).findElement(By.name("email")).sendKeys(email);
        driver.findElement(By.id("loginForm")).findElement(By.name("password")).sendKeys(pass);
        driver.findElement(By.id("loginForm")).findElement(By.id("loginSubmit")).click();

        String account = driver.findElement(CheckAccount).getAttribute("href");
        if (account.equals("https://www.trendyol.com/authentication/logout")){
            System.out.println("login successful");
            return true;
        }else return false;
    }

}
