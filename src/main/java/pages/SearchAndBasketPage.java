package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.Random;

import static junit.framework.Assert.assertEquals;

public class SearchAndBasketPage extends PageBase {

    public SearchAndBasketPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }
    String StringPrice;
    String StringBasketPrice;

    By searchBox = By.xpath(" //input [@class='search-box']");
    By searchResult = By.xpath("//div [@class = 'p-card-chldrn-cntnr']/a");
    By addItem = By.className("add-to-bs");
    By goBasket = By.className("goBasket");
    By basketPrice = By.xpath("//div[@class='pb-basket-item-price']");
    By itemPieceAdd = By.xpath("//button [@class='ty-numeric-counter-button']");
    By itemPiece = By.xpath("//input [@class='counter-content']");
    By trash = By.className("i-trash");
    By trashOk = By.xpath("//div[ @class='btn-box-remove-item']//span");
    By trashCheck = By.xpath("//a [@class='btn shoppingStart']");

    public void SearchBox(String search){
        driver.findElement(searchBox).sendKeys(search+Keys.ENTER);
    }

    public void searchPageResult(){
        List<WebElement> PageResult;
        PageResult = driver.findElements(searchResult);
        int maxResult = PageResult.size();
        Random random = new Random();
        int randomProduct = random.nextInt(maxResult);
        PageResult.get(randomProduct).click();

    }

    public void ItemPriceAndClear(){
        StringPrice = driver.findElement(By.className("pr-in-cn")).findElement(By.className("prc-slg")).getText();
        StringPrice = StringPrice.replaceAll("\n", " ");
        StringPrice = StringPrice.replaceAll("TL", " ");
        StringPrice = StringPrice.replaceAll("\\.", "");
        StringPrice = StringPrice.replaceAll(",", "");
        StringPrice = StringPrice.trim();
    }

    public void AddItem(){
        driver.findElement(addItem).click();
    }

    public void GoBasket(){
        driver.findElement(By.className("productPriceBox")).findElement(goBasket).click();
    }


    public boolean BasketPriceAndCheck(){
        StringBasketPrice = driver.findElement(basketPrice).getText();
        StringBasketPrice = StringBasketPrice.replaceAll("\n", "");
        StringBasketPrice = StringBasketPrice.replaceAll("TL", "");
        StringBasketPrice = StringBasketPrice.replaceAll(",", "");
        StringBasketPrice = StringBasketPrice.replaceAll("\\.", "");
        String[] BasketPriceSplit = StringBasketPrice.split(" ");
        String BasketPrice;
        String str;
        if (BasketPriceSplit.length == 2){
            str = BasketPriceSplit[1];
        }
        else {
            str = BasketPriceSplit[0];
        }
        BasketPrice = str.trim();

        return BasketPrice.equals(StringPrice);
    }
    public boolean Itempiece () throws InterruptedException {

        driver.findElement(itemPieceAdd).click();
        Thread.sleep(3000);
        String pieceString = driver.findElement(itemPiece).getAttribute("value");
        return pieceString.equals("2");
    }
    public boolean CheckRemove() throws InterruptedException {
        driver.findElement(trash).click();
        Thread.sleep(1000);
        driver.findElement(trashOk).click();

        String link= "https://www.trendyol.com/";
        String BasketLink = driver.findElement(trashCheck).getAttribute("href");

        return BasketLink.equals(link);
    }

}
