package frames;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.FramesPage;

public class NestedFrameTest extends BaseTest {
    @Test
    public void nestedFrameTests(){
        FramesPage framesPage = homePage.clickFrames();
        FramesPage.NestedFramesPage nestedFramesPage = framesPage.clickNestedFrames();

        Assert.assertEquals(nestedFramesPage.getMiddleText(), "MIDDLE", "wrong middle text");
        Assert.assertEquals(nestedFramesPage.getBottomText(), "BOTTOM", "wrong bottom text");
    }
}
