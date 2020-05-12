package test.java.ui;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class C_Interact_With_Elements {
    public static void main(String[] args) throws InterruptedException {
        By ruLang = By.cssSelector("[hreflang='ru-RU']");
        By search = By.className("form-control.form-lg");
        By phone = By.className("phone_header");


        System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("http://iteaua-develop.demo.gns-it.com/about-itea/");
        Thread.sleep(5000);
        //driver.findElement(ruLang).click();
        driver.findElement(search).sendKeys("Hello");
        driver.findElement(search).clear();
        driver.findElement(search).sendKeys("By");
        String searchValue = driver.findElement(search).getText();
        System.out.println(searchValue);
        driver.quit();
    }
}
