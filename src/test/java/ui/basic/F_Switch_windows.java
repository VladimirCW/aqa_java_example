package test.java.ui.basic;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

public class F_Switch_windows {
    public static void main(String[] args) throws InterruptedException {
        By firstGood = By.cssSelector("[class='goods-tile__picture']");

        System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-notifications");
        options.setExperimentalOption("useAutomationExtension", false);
        WebDriver driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.get("https://rozetka.com.ua/notebooks/c80004/");
        Thread.sleep(5000);

        Actions builder = new Actions(driver);
        builder.keyDown(Keys.CONTROL).click(driver.findElement(firstGood)).keyUp(Keys.CONTROL).perform();

        for(String window: driver.getWindowHandles()) driver.switchTo().window(window);

        driver.quit();
    }
}
