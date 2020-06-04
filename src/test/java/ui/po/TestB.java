package test.java.ui.po;

import io.qameta.allure.*;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import test.java.ui.po.pages.ContactPage;
import test.java.ui.po.pages.FaqPage;
import test.java.ui.po.pages.HomePage;

import static org.testng.Assert.assertTrue;

@TmsLink("TMS-111")
@Epic("Search menu")
@Feature("Search by one word")
public class TestB extends BaseTestSetup{
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

    @Link("https://google.com")
    @Story("Should search by one word")
    @Issues({
            @Issue("ISSUE-1"),
            @Issue("ISSUE-2")
    })
    @Test
    public void test1() {
        homePage.open()
                //.search("iPhone")
                //.search("meizu")
                //.search("xiaomi")
                ///.clickSearch()
                ///.clickSuggestion()
                .clickContacts();
        contactPage.clickFaq().sillyStep();
        faqPage.getQuestions();
        assertTrue(true);
    }

    @Story("Shouldn't search by two words")
    @Test
    public void test2() {
        homePage.open();
        homePage.open("https://google.com");
    }

    @Story("Should show error message")
    @Test
    public void test3() {
        homePage.open().clickContacts();
        contactPage.clickFaq();
        //faqPage.getQuestions();
        assertTrue(false);
    }

    @Story("Should show error message")
    @Test
    public void test5() {
        homePage.open().clickContacts();
        contactPage.clickFaq();
        faqPage.getQuestions();
        assertTrue(true);
    }

    @Story("Should show error message")
    @Test
    public void test4() {
        homePage.open().clickContacts();
        if(true) throw new Error("Just error!!!");
        contactPage.clickFaq();
        faqPage.getQuestions();
        assertTrue(true);
    }

}
