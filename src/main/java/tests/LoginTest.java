package tests;
import org.junit.Test;
import pages.HomePage;
import static org.junit.Assert.*;
import org.openqa.selenium.By;
import pages.LoginPage;

import static org.junit.Assert.assertEquals;

public class LoginTest extends TestBase {
    //
    String email = "YourEmail";
    String pass = "YourPassword";

    @Test
    public void valid_Login()throws   InterruptedException {
        HomePage home = new HomePage(driver, wait);
        LoginPage login = new LoginPage(driver, wait);
        Thread.sleep(2000);
        home.FancyClose();
        Thread.sleep(2000);
        home.ClickOnAccountBtn();
        Thread.sleep(2000);
        assertEquals(login.Login(email, pass), true);
        Thread.sleep(2000);

    }
}


