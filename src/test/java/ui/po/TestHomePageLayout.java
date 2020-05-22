package test.java.ui.po;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;
import ru.yandex.qatools.ashot.comparison.ImageDiff;
import ru.yandex.qatools.ashot.comparison.ImageDiffer;
import ru.yandex.qatools.ashot.shooting.ShootingStrategies;
import test.java.ui.po.pages.HomePage;

import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;

import static org.testng.Assert.assertEquals;

public class TestHomePageLayout extends BaseTestSetup{
    HomePage homePage;
    ImageDiff diff;

    @BeforeMethod
    public void initialize() {
        homePage = new HomePage(driver);
    }

    @Test
    public void getScreen() {
        homePage.open();
        Screenshot actualScreenshot = new AShot()
                .shootingStrategy(ShootingStrategies.viewportPasting(100))
                .takeScreenshot(driver);
        Screenshot expectedScreenshot;
        File actualFile = new File("actual_screens\\\\" + "actual-hello" + ".png");
        try {
            ImageIO.write(actualScreenshot.getImage(), "png", actualFile);
            expectedScreenshot = new Screenshot(ImageIO.read(new File("expected_screens\\\\" + "expected-hello" + ".png")));
            diff = new ImageDiffer().makeDiff(expectedScreenshot, actualScreenshot);
        } catch (IOException e) {
            e.printStackTrace();
        }
        assertEquals(diff.getDiffSize(), 0);
    }

    @AfterMethod
    public void tearDown() {
        File diffFile = new File("diff_screens\\\\" + "diff-hello" + ".png");
        try {
            ImageIO.write(diff.getMarkedImage(), "png", diffFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
