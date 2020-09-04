package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class PageBase {
    public WebDriver driver;
    public WebDriverWait wait;

    //Constructor
    public PageBase(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
    }
}