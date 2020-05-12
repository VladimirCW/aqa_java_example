package test.java.ui;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

public class D_A_Action_builder {
    public static void main(String[] args) throws InterruptedException {
        By scretch = By.tagName("sketch-scrollarea");

        System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        //options.addArguments("--disable-notifications");
        WebDriver driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.get("https://sketch.io/sketchpad/");
        Thread.sleep(5000);
        Actions builder = new Actions(driver);
        builder
                .sendKeys(Keys.ESCAPE)
                .pause(2000)
                //.moveToElement(driver.findElement(scretch))
                .clickAndHold(driver.findElement(scretch))
                .pause(100)
                .moveByOffset(0, 200)
                .pause(100)
                .moveByOffset(200, 0)
                .pause(100)
                .moveByOffset(0, -200)
                .pause(100)
                .moveByOffset(-200, 0)
                .release()
                .contextClick()
                .perform();

        driver.quit();
    }
}
