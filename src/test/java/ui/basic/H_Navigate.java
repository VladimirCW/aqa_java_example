package test.java.ui.basic;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class H_Navigate {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("http://iteaua-develop.demo.gns-it.com/about-itea/");
        Thread.sleep(2000);
        driver.navigate().refresh();
        driver.navigate().back();
        driver.navigate().forward();
        driver.navigate().to("https://google.com");
        driver.quit();
    }
}
