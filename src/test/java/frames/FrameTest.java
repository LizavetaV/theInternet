package frames;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.WisywygEditorPage;

public class FrameTest extends BaseTest {

    @Test
    public void testEditor(){
        WisywygEditorPage wisywygEditorPage=homePage.clickWisywyg();
        wisywygEditorPage.clearTextArea();

        String text1= "Hello ";
        String text2= "world!";
        wisywygEditorPage.sendTextToTextArea(text1);
        wisywygEditorPage.increaseIndent();
        wisywygEditorPage.sendTextToTextArea(text2);

        Assert.assertEquals(wisywygEditorPage.getTextAreaContent(), text1 + text2, "wrong text in text area");
    }
}
