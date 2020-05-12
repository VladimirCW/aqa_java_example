package test.java.ui.basic;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class B_find_elements {
    public static void main(String[] args) throws InterruptedException {
        //By ruLang = By.xpath("//a[@hreflang='ru-RU']");
        //By ruLang = By.id("//a[@hreflang='ru-RU']"); what's is wrong
        //By phone = By.className(".phone_header"); // what's wrong
        //By search = By.className("form-control.form-lg"); //look at the dot
        By ruLang = By.cssSelector("[hreflang='ru-RU']");

        System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("http://iteaua-develop.demo.gns-it.com/about-itea/");
        Thread.sleep(2000);
        System.out.println(driver.findElement(ruLang).getText());
        driver.navigate().refresh();
        Thread.sleep(2000);
        System.out.println(driver.findElement(ruLang).getText());
        driver.quit();
    }
}
