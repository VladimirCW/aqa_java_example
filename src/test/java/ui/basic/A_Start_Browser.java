package test.java.ui.basic;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class A_Start_Browser {

    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        //https://peter.sh/experiments/chromium-command-line-switches/
        //options.addArguments("start-maximized"); // 1
        options.addArguments("--window-size=300,1080"); //2
        //options.addArguments("--incognito"); usefull
        //options.addArguments("--disable-notifications"); usefull

        //options.addArguments("disable-infobars"); //depricated
        options.setExperimentalOption("useAutomationExtension", false);
        WebDriver driver = new ChromeDriver(options);
        driver.get("http://iteaua-develop.demo.gns-it.com/about-itea/");
        //driver.manage().window().maximize();  //3
        //driver.manage().window().setSize(new Dimension(100, 100)); // 4
        Dimension dimension = driver.manage().window().getSize();
        driver.quit();
    }
}
