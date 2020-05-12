package test.java.ui.basic;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Rozetka {
    public static void main(String[] args) throws InterruptedException {
        By search = By.cssSelector("[name='search']");

        System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        //options.addArguments("--disable-notifications");
        WebDriver driver = new ChromeDriver(options);
        driver.get("https://rozetka.com.ua/notebooks/c80004/");
        Thread.sleep(2000);
        driver.findElement(search).sendKeys("Hello");
        driver.findElement(search).getAttribute("placeholder");
        driver.findElement(search).sendKeys(Keys.chord(Keys.SHIFT, "good by MY friend"));
        for (int i = 0; i < 10; i++) {
            driver.findElement(search).sendKeys(Keys.chord(Keys.BACK_SPACE));
        }
        driver.findElement(search).sendKeys(Keys.chord(Keys.CONTROL, "a"));
        driver.findElement(search).sendKeys(Keys.BACK_SPACE);
        driver.findElement(search).sendKeys("Hello");
        //driver.findElement(search).submit();
        driver.findElement(search).sendKeys(Keys.ENTER);
        driver.findElement(By.cssSelector("[data-goods-id='163775130']")).getCssValue("border");
        driver.getCurrentUrl();
        driver.findElement(search).getLocation();
        driver.findElement(search).getSize();
        driver.findElement(search).getText();
        driver.findElement(search).isSelected();
        Thread.sleep(5000);

        driver.quit();
    }
}
