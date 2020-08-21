package test.java.ui.waits;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

import static org.testng.Assert.assertEquals;

public class WaitsRozetka {
    WebDriver driver;
    WebDriverWait wait;
    By goodsCatalogBy = By.cssSelector("[id='m-main-ul'], [class='menu-categories menu-categories_type_main']");
    By cartBy = By.cssSelector("[id='cart_popup_header'], [class='header-actions__item header-actions__item_type_cart']");
    By wishesBy = By.cssSelector("[class='header-actions__item header-actions__item_type_wish js-app-wishlist']");
    By authorizeBy = By.xpath("//a[contains(text(), 'авторизуйтесь')]");
    By authEmailBy = By.id("auth_email");
    By authPassBy = By.id("auth_pass");
    By enterBy = By.xpath("//button[contains(text(), 'Войти')]");
    By errorMsgBy = By.cssSelector("[class='error-message error-message_type_tooltip error-message_type_text error-message_color_red']");
    By errorPassMsgBy = By.cssSelector("[class='error-message error-message_type_tooltip']");
    By getTempPassBy = By.xpath("//a[contains(text(), 'Пришлите мне временный пароль')]");

    @BeforeTest
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.setExperimentalOption("useAutomationExtension", false);
        options.addArguments("--disable-notifications");
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10000, TimeUnit.MILLISECONDS);
        //driver.manage().timeouts().pageLoadTimeout(1000, TimeUnit.MILLISECONDS);
        wait = new WebDriverWait(driver, 15);
    }

    @Test
    public void test1() throws InterruptedException {
        String email = "a@a.c";
        driver.get("https://rozetka.com.ua/");
        //driver.navigate().refresh();
        WebElement goodsCatalog = driver.findElement(goodsCatalogBy);
        WebElement cart = driver.findElement(cartBy);
        WebElement wishes = driver.findElement(wishesBy);
        Actions actions = new Actions(driver);
        wait.until(ExpectedConditions.elementToBeClickable(wishes));
        actions
                .moveToElement(wishes)
                .build().perform();
        wait.until(ExpectedConditions.elementToBeClickable(authorizeBy));
        wishes.findElement(authorizeBy).click();
        wait.until(ExpectedConditions.and(
                ExpectedConditions.elementToBeClickable(authEmailBy),
                ExpectedConditions.elementToBeClickable(authPassBy),
                ExpectedConditions.elementToBeClickable(enterBy)
        ));
        actions
                .sendKeys(driver.findElement(authEmailBy), email)
                .sendKeys(driver.findElement(authPassBy), "1")
                .click(driver.findElement(enterBy))
                .perform();
        /*driver.findElement(authEmailBy).sendKeys(email);
        driver.findElement(authPassBy).sendKeys("1");
        driver.findElement(enterBy).click();*/
        //Thread.sleep(5000);
        wait.until(ExpectedConditions.or(
                ExpectedConditions.presenceOfElementLocated(errorMsgBy),
                ExpectedConditions.presenceOfElementLocated(errorPassMsgBy)
        ));
        if(driver.findElement(errorPassMsgBy).isDisplayed()) {
            driver.findElement(getTempPassBy).click();
            wait.until(ExpectedConditions.and(
                    ExpectedConditions.presenceOfElementLocated(errorMsgBy),
                    ExpectedConditions.invisibilityOfElementLocated(getTempPassBy)
            ));
        }
        WebElement errorMsg = driver.findElement(errorMsgBy);
        //WebElement errorMsg = (new WebDriverWait(driver, 20)).until(ExpectedConditions.presenceOfElementLocated(errorMsgBy));
        /*(new WebDriverWait(driver, 10)).until(new ExpectedCondition<Boolean>() {
            @NullableDecl
            @Override
            public Boolean apply(@NullableDecl WebDriver driver) {
                return driver.findElement(errorMsgBy).getText().contains("Пользователь с логином");
            }
        });*/
        //(new WebDriverWait(driver, 10)).until(d -> d.findElement(errorMsgBy).getText().contains("ddd"));
        String emailFromError = errorMsg.findElement(By.cssSelector("[class='auth-modal__form-email']")).getText();
        String actualResult = errorMsg.getText();
        String expectedResult = String.format("Пользователь с логином %s не зарегистрирован", email);
        assertEquals(actualResult, expectedResult);
        //goodsCatalog.click();
        //Thread.sleep(5000);
    }

    @AfterTest
    public void tearDown() {
        driver.quit();
    }
}