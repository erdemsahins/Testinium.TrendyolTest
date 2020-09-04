package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage extends PageBase{

    public HomePage(WebDriver driver, WebDriverWait wait) {
        super(driver,   wait);
        driver.get("https://www.trendyol.com/");
    }

    By fancyClose = By.className("fancybox-close");
    By accountBtn = By.id("accountBtn");
    By modalClose = By.className("modal-close");


    public String link(){
        return driver.getCurrentUrl();
    }

    public void FancyClose() throws InterruptedException {
        Thread.sleep(1000);
        driver.findElement(fancyClose).click();
    }

    public void ModalClose() throws InterruptedException {
        Thread.sleep(2000);
        driver.findElement(modalClose).click();
    }


    public void ClickOnAccountBtn() throws InterruptedException {
        driver.findElement(accountBtn).click();
        Thread.sleep(1000);
    }
}
