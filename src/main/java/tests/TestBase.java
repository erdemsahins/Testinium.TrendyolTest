package tests;


import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;

public abstract class TestBase {
    protected static String ChromePath = "D:\\Drivers\\chromedriver.exe";
    protected static ChromeDriverService service;
    protected static WebDriver driver;
    protected static WebDriverWait wait;

    public void TestBase(){
    }

    @BeforeClass
    public static void Setup(){
        // Chrome_driver.exe dizininden servisi oluştur ve başlat
        service = new ChromeDriverService.Builder().
                usingDriverExecutable(new File(ChromePath)).
                usingAnyFreePort().
                build();
        try {
            service.start();
        } catch (Exception e) {
            e.printStackTrace();
        }          System.setProperty("webdriver.chrome.driver", ChromePath);
        // Driver nesnesini service bilgilerini kullanarak oluştur
        driver = new RemoteWebDriver(service.getUrl(), DesiredCapabilities.chrome());
        // Bütün sayfaları açarken 15ms bekle
        wait = new WebDriverWait(driver,20);

        // Penceri Büyüt
        driver.manage().window().maximize();
    }
    @AfterClass
    public static void Stop(){
        // Tarayıcıdan çıkış yapar
        driver.quit();           // Servisi Durdurur
        service.stop();
    }
}
