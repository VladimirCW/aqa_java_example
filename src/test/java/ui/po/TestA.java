package test.java.ui.po;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import test.java.ui.po.pages.HomePage;

import static org.testng.Assert.assertTrue;

public class TestA extends BaseTestSetup{
    HomePage homePage;
    String searchStr = "iPhone";

    @BeforeMethod
    public void initialize() {
        homePage = new HomePage(driver);
    }

    @Test
    public void test1() {
        homePage.open()
                .search(searchStr)
                .clickSearch()
                .clickSuggestion();
        assertTrue(true);
    }

}
