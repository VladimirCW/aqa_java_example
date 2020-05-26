package test.java.ui.po;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import test.java.ui.po.pages.ContactPage;
import test.java.ui.po.pages.FaqPage;
import test.java.ui.po.pages.HomePage;

import static org.testng.Assert.assertTrue;

public class TestA extends BaseTestSetup{
    HomePage homePage;
    ContactPage contactPage;
    FaqPage faqPage;
    String searchStr = "iPhone";

    @BeforeMethod
    public void initialize() {
        homePage = new HomePage(driver);
        contactPage = new ContactPage(driver);
        faqPage = new FaqPage(driver);
    }

    @Test
    public void test1() {
        homePage.open()
                .search("iPhone")
                //.search("meizu")
                //.search("xiaomi")
                ///.clickSearch()
                ///.clickSuggestion()
                .clickContacts();
        contactPage.clickFaq();
        faqPage.getQuestions();
        assertTrue(true);
    }

}
