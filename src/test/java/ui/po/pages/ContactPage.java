package test.java.ui.po.pages;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ContactPage {
    Logger logger = LogManager.getLogger(ContactPage.class);
    private final WebDriver driver;
    private final WebDriverWait wait;
    private final By qAndABn = By.cssSelector("[href='https://rozetka.com.ua/faq/']");

    public ContactPage(WebDriver driver) {
        logger.debug("Initialized new instance of Contact page");
        this.driver = driver;
        wait = new WebDriverWait(this.driver, 10);
    }

    public ContactPage clickFaq() {
        logger.info("Click FAQ");
        wait.until(ExpectedConditions.elementToBeClickable(qAndABn));
        driver.findElement(qAndABn).click();
        return this;
    }

    public ContactPage open() {
        logger.info("Open");
        driver.get("https://rozetka.com.ua/contacts/");
        return this;
    }
}
