package tests;

import org.junit.Test;
import pages.HomePage;
import pages.LoginPage;
import pages.PageBase;
import pages.SearchAndBasketPage;

import static org.junit.Assert.assertEquals;

public class SerchAndBasketTest extends TestBase {

    String email = "YourEmail";
    String pass = "YourPassword";
    String search = "Bilgisayar";


    @Test
    public void valid_Search()throws   InterruptedException {
        HomePage home = new HomePage(driver, wait);
        LoginPage login = new LoginPage(driver, wait);
        SearchAndBasketPage searchAndBasket = new SearchAndBasketPage(driver,wait);
        home.FancyClose();
        home.ClickOnAccountBtn();
        Thread.sleep(2000);
        login.Login(email,pass);
        Thread.sleep(2000);
        home.ModalClose();
        Thread.sleep(2000);
        searchAndBasket.SearchBox(search);
        Thread.sleep(2000);
        searchAndBasket.searchPageResult();
        Thread.sleep(2000);
        searchAndBasket.ItemPriceAndClear();
        Thread.sleep(2000);
        searchAndBasket.AddItem();
        Thread.sleep(1000);
        searchAndBasket.GoBasket();
        assertEquals(searchAndBasket.BasketPriceAndCheck(),true);
        Thread.sleep(1000);
        assertEquals(searchAndBasket.Itempiece(),true);
        Thread.sleep(1000);
        assertEquals(searchAndBasket.CheckRemove(),true);

    }

}
