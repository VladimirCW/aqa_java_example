package test.java.ui.basic;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

public class D_Actions_builder {
    public static void main(String[] args) throws InterruptedException {
        By search = By.cssSelector("[name='search']");
        By cart = By.cssSelector("[href='https://my.rozetka.com.ua/profile/cart']");
        By comparison = By.cssSelector("[class='header-actions__item header-actions__item_type_comparison js-app-comparison']");

        System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        //options.addArguments("--disable-notifications");
        WebDriver driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.get("https://rozetka.com.ua/notebooks/c80004/");
        Thread.sleep(2000);
        driver.findElement(search).sendKeys("Hello");

        Actions builder = new Actions(driver);
        builder
                .keyDown(Keys.SHIFT)
                .sendKeys(driver.findElement(search), "hello")
                .keyUp(Keys.SHIFT)
                .sendKeys(driver.findElement(search), "by")
                .sendKeys(Keys.ENTER)
                .build()
                .perform();

        builder
                .moveToElement(driver.findElement(cart))
                .pause(2000)
                .moveByOffset(-50, 0)
                .pause(2000)
                .moveByOffset(-100, 0)
                .perform();
        /*Thread.sleep(2000);
        builder.moveByOffset(-50, 0).perform();
        Thread.sleep(2000);
        builder.moveByOffset(-100, 0).perform();*/


        driver.quit();
    }
}
