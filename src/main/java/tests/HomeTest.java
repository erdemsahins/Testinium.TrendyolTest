package tests;

import static org.junit.Assert.*;
import pages.HomePage;
import org.junit.Test;

public class HomeTest extends TestBase {@Test

public void   valid_Links() throws InterruptedException{
    HomePage home = new HomePage(driver,wait);
    assertEquals(home.link(),"https://www.trendyol.com/");

    home.FancyClose();

}


}
