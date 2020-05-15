package test.java.ui.waits;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class A_Inro {
    public static void main(String[] args) {
        final int IMPLICIT_WAIT = 20;
        String searchStr = "iPhone";
        String closePopUpStr = "[class='popup-close']";
        String popupStr = "[class='popup-css lang-switcher-popup sprite-side']";
        By search = By.cssSelector("[class='rz-header-search-input-text passive']");
        By suggestion = By.cssSelector("[data-rz-gtm-event='suggestedQuery']");
        By iPhone = By.xpath("//div[@class='g-i-tile-i-title clearfix']/a[contains(text(), '" + searchStr + "')]");
        By popUp = By.cssSelector(popupStr);
        By closePopup = By.cssSelector(popupStr + " " + closePopUpStr);

        System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-notifications"); //usefull
        //options.addArguments("--incognito");
        WebDriver driver = new ChromeDriver(options);
        WebDriverWait wait = new WebDriverWait(driver, 20);
        //driver.manage().timeouts().implicitlyWait(IMPLICIT_WAIT, TimeUnit.SECONDS);

        driver.get("https://rozetka.com.ua/notebooks/c80004/");

        //driver.manage().timeouts().implicitlyWait(10, TimeUnit.MILLISECONDS);
        wait.until(ExpectedConditions.or(
                ExpectedConditions.elementToBeClickable(driver.findElement(search)),
                ExpectedConditions.presenceOfElementLocated(popUp)
                //ExpectedConditions.elementToBeClickable(driver.findElement(popUp))
        ));
        if( driver.findElements(closePopup).size() > 0 ) {
            wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(closePopup))).click();
        }
        //driver.manage().timeouts().implicitlyWait(IMPLICIT_WAIT, TimeUnit.SECONDS);

        driver.findElement(search).sendKeys(searchStr);
        driver.findElement(search).sendKeys(Keys.ENTER);
        wait.until(ExpectedConditions.urlContains("#search_text=" + searchStr.toLowerCase()));
        driver.get("https://rozetka.com.ua/notebooks/c80004/");

        //driver.manage().timeouts().implicitlyWait(0, TimeUnit.MILLISECONDS);
        wait.until(ExpectedConditions.or(
                ExpectedConditions.elementToBeClickable(driver.findElement(search)),
                ExpectedConditions.presenceOfElementLocated(popUp)
                //ExpectedConditions.elementToBeClickable(driver.findElement(popUp))
        ));
        //wait.until(ExpectedConditions.not(ExpectedConditions.presenceOfElementLocated(search))) //Example
        if( driver.findElements(closePopup).size() > 0 ) {
            wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(closePopup))).click();
        }
        //driver.manage().timeouts().implicitlyWait(IMPLICIT_WAIT, TimeUnit.SECONDS);

        driver.findElement(search).click();
        wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(suggestion)));
        driver.findElement(suggestion).click();
        //(new WebDriverWait(driver, 10)).until(ExpectedConditions.visibilityOfElementLocated(iPhone));
        //(new WebDriverWait(driver, 10)).until(ExpectedConditions.visibilityOfElementLocated(iPhone)).click();
        //WebElement el = (new WebDriverWait(driver, 10)).until(ExpectedConditions.visibilityOfElementLocated(iPhone));
        wait.until(ExpectedConditions.and(
                ExpectedConditions.urlContains("#search_text=" + searchStr.toLowerCase()),
                ExpectedConditions.elementToBeClickable(iPhone)
        ));
        System.out.println(driver.getCurrentUrl());

        driver.quit();
    }
}
