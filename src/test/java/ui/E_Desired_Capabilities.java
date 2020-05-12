package test.java.ui;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.util.HashMap;
import java.util.Map;

public class E_Desired_Capabilities {
    public static void main(String[] args) throws InterruptedException {
        //depricated
        Map capabilitiesMap = new HashMap();
        capabilitiesMap.put("takesScreenShot", true);
        DesiredCapabilities capabilities = new DesiredCapabilities(capabilitiesMap);
        System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://sketch.io/sketchpad/");
        Thread.sleep(5000);

        driver.quit();
    }
}
