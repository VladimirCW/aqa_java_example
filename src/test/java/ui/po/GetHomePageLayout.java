package test.java.ui.po;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import test.java.ui.po.pages.HomePage;

public class GetHomePageLayout extends BaseTestSetup {
    HomePage homePage;

    @BeforeMethod
    public void initialize() {
        homePage = new HomePage(driver);
    }

    @Test
    public void getScreen() {
        homePage.open();
        //Screenshot screenshot1 = new AShot().takeScreenshot(driver);
        /*Screenshot screenshot1 = new AShot()
                .shootingStrategy(ShootingStrategies.viewportPasting(100))
                .takeScreenshot(driver);
        File actualFile = new File(
                "expected_screens\\\\"
                        + "expected-hello"
                        + ".png"
        );
        try {
            ImageIO.write(screenshot1.getImage(), "png", actualFile);
        } catch (IOException e) {
            e.printStackTrace();
        }*/
    }

}
