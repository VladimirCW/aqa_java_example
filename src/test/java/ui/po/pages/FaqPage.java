package test.java.ui.po.pages;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class FaqPage{
    Logger logger = LogManager.getLogger(FaqPage.class);
    private final WebDriver driver;
    private final WebDriverWait wait;
    private final By qaLinks = By.cssSelector("[name='slider-block-active'], [class='whitelink']");

    public FaqPage(WebDriver driver) {
        logger.debug("Initialized new instance of Faq page");
        this.driver = driver;
        wait = new WebDriverWait(this.driver, 10);
    }

    public List<WebElement> getQuestions() {
        logger.info("Get questions");
        wait.until(ExpectedConditions.visibilityOfElementLocated(qaLinks));
        return driver.findElements(qaLinks);
    }

    public FaqPage open() {
        logger.info("Open");
        driver.get("https://rozetka.com.ua/faq/");
        return this;
    }
}
