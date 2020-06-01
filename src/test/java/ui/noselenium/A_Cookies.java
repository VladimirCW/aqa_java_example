package test.java.ui.noselenium;

import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class A_Cookies {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        //options.addArguments("--disable-notifications");
        WebDriver driver = new ChromeDriver(options);
        Cookie ckEn = new Cookie("language", "en-US", "/");
        Cookie ckRu = new Cookie("language", "ru-RU", "/");
        driver.get("http://www.redlipstick.club/AAA");
        driver.manage().addCookie(ckRu);
        driver.get("http://www.redlipstick.club/");
        for (Cookie el: driver.manage().getCookies()) {
            System.out.println(el.getName() + " " + el.getValue());
        }
        Thread.sleep(2000);
        driver.navigate().refresh();
        Thread.sleep(2000);
        driver.quit();
    }
}
