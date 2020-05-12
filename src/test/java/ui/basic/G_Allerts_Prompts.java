package test.java.ui.basic;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class G_Allerts_Prompts {
    public static void main(String[] args) {
        //prompt('Сколько тебе лет?', 100);

        System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://rozetka.com.ua/notebooks/c80004/");
        Alert alert = driver.switchTo().alert();
        alert.sendKeys("DDD");
        alert.accept();
        System.out.println(alert.getText());
        /*driver.switchTo().alert().accept();
        driver.switchTo().alert().dismiss();
        driver.switchTo().alert().sendKeys("Hello");
        String allertText = driver.switchTo().alert().getText();*/

        //Thread.sleep(5000);
        driver.quit();
    }
}
