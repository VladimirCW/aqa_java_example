package test.java.ui.po.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class HomePage {
    private String searchStr;
    private final WebDriver driver;
    private final WebDriverWait wait;
    private final String closePopUpStr = "[class='popup-close']";
    private final String popupStr = "[class='popup-css lang-switcher-popup sprite-side']";

    @FindBy(css = "[class='rz-header-search-input-text passive']")
    private WebElement search;
    @FindBy(css = "[data-rz-gtm-event='suggestedQuery']")
    private WebElement suggestion;
    @FindBy(xpath = "//div[@class='g-i-tile-i-title clearfix']/a[contains(text(), 'iPhone')]")
    private WebElement iPhone;
    @FindBy(css = popupStr)
    private WebElement popUp;
    @FindBy(css = popupStr + " " + closePopUpStr)
    private WebElement closePopup;
    /*@FindBys({
            @FindBy(css = ""),
            @FindBy(xpath = "")
    })*/
    //@FindBy(css = popupStr + " " + closePopUpStr)
    @FindBy(how = How.CSS, using = popupStr + " " + closePopUpStr)
    //@CacheLookup
    private List<WebElement> closePopups;

    public HomePage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, 20);
        PageFactory.initElements(driver, this);
    }

    public HomePage open() {
        driver.get("https://rozetka.com.ua/notebooks/c80004/");
        return this;
    }

    public HomePage open(String url) {
        driver.get(url);
        return this;
    }

    public HomePage search(String searchStr) {
        this.searchStr = searchStr;
        wait.until(ExpectedConditions.or(
                ExpectedConditions.elementToBeClickable(search),
                ExpectedConditions.visibilityOf(popUp)
                //ExpectedConditions.elementToBeClickable(driver.findElement(popUp))
        ));
        if( closePopups.size() > 0 ) {
            wait.until(ExpectedConditions.elementToBeClickable(closePopup)).click();
        }
        search.sendKeys(searchStr);
        search.sendKeys(Keys.ENTER);
        wait.until(ExpectedConditions.urlContains("#search_text=" + searchStr.toLowerCase()));
        return this;
    }

    public HomePage search2(String searchStr) {
        String popupStrSelect = "[class='popup-css lang-switcher-popup sprite-side']";
        By popup = By.cssSelector(popupStrSelect);
        By popupClose = By.cssSelector(popupStrSelect + " [class='popup-close']");
        By search = By.cssSelector("[name='search']");
        this.searchStr = searchStr;
        //By searchResultItem = By.xpath("//span[contains(text(), '" + searchStr + "')]");
        WebElement searchEl = driver.findElement(search);
        wait.until(ExpectedConditions.elementToBeClickable(searchEl));
        if( driver.findElements(popup).size() > 0 ) {
            driver.findElement(popupClose).click();
        }
        searchEl.clear();
        searchEl.sendKeys(this.searchStr);
        searchEl.sendKeys(Keys.ENTER);
        By searchResultItem = By.xpath("//span[contains(translate(text(), 'ABCDEFGHIJKLMNOPQRSTUVWXYZ', 'abcdefghijklmnopqrstuvwxyz') ,'" + searchStr.toLowerCase() + "')]");
        if(!searchStr.toLowerCase().equals("iphone"))
        {
            wait.until(ExpectedConditions.not(
                    ExpectedConditions
                            .presenceOfAllElementsLocatedBy(By
                                    .xpath("//span[contains(translate(text(), 'ABCDEFGHIJKLMNOPQRSTUVWXYZ', 'abcdefghijklmnopqrstuvwxyz') ,'iphone')]")))
            );
           /* wait.until(new ExpectedCondition<Boolean>() {
                @Override
                public Boolean apply(WebDriver webDriver) {
                    int amount = driver.findElements(By.xpath("//span[contains(translate(text(), 'ABCDEFGHIJKLMNOPQRSTUVWXYZ', 'abcdefghijklmnopqrstuvwxyz') ,'iphone')]")).size();
                    return amount == 0;
                }
            });*/
        }
        wait.until(ExpectedConditions.and(
                ExpectedConditions.urlContains("text=" + searchStr.toLowerCase()),
                ExpectedConditions.presenceOfElementLocated(searchResultItem)
        ));
        //wait.until(ExpectedConditions.urlContains("text=" + searchStr.toLowerCase()));
        //wait.until(ExpectedConditions.presenceOfElementLocated(searchResultItem));
        return this;
    }

    public HomePage clickSearch() {
        wait.until(ExpectedConditions.or(
                ExpectedConditions.elementToBeClickable(search),
                ExpectedConditions.visibilityOf(popUp)
                //ExpectedConditions.elementToBeClickable(driver.findElement(popUp))
        ));
        //wait.until(ExpectedConditions.not(ExpectedConditions.presenceOfElementLocated(search))) //Example
        if( closePopups.size() > 0 ) {
            wait.until(ExpectedConditions.elementToBeClickable(closePopup)).click();
        }

        search.click();
        return this;
    }

    public HomePage clickSuggestion() {
        wait.until(ExpectedConditions.elementToBeClickable(suggestion));
        suggestion.click();
        //(new WebDriverWait(driver, 10)).until(ExpectedConditions.visibilityOfElementLocated(iPhone));
        //(new WebDriverWait(driver, 10)).until(ExpectedConditions.visibilityOfElementLocated(iPhone)).click();
        //WebElement el = (new WebDriverWait(driver, 10)).until(ExpectedConditions.visibilityOfElementLocated(iPhone));
        wait.until(ExpectedConditions.and(
                ExpectedConditions.urlContains("#search_text=" + searchStr.toLowerCase()),
                ExpectedConditions.elementToBeClickable(iPhone)
        ));
        return this;
    }
}
