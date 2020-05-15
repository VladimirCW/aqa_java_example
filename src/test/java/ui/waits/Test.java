package test.java.ui.waits;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Test {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        //https://peter.sh/experiments/chromium-command-line-switches/
        //options.addArguments("start-maximized"); // 1
        //options.addArguments("--window-size=300,1080"); //2
        options.addArguments("--incognito");
        WebDriver driver = new ChromeDriver(options);
        driver.get("https://rozetka.com.ua/");
        Thread.sleep(5000);
        String name = driver.findElement(By.cssSelector("[class='link-dashed']")).getText();
        //System.out.println(name);
        String goodname = name.replaceAll("[-+)( ]","");
        System.out.println(goodname);
        driver.quit();
    }

}
