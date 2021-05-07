package javascript;

import base.BaseTest;
import org.testng.annotations.Test;
import pages.LargeAndDeepDomPage;

public class JavaScriptTests extends BaseTest {

    @Test
    public void testJS(){
        LargeAndDeepDomPage largeAndDeepDomPage = homePage.clickLargeAndDeepDom();
        largeAndDeepDomPage.scrollToTable();
    }
   /* @Test
    public void testScrollToParagraph(){
        InfiniteScrollPage infiniteScrollPage = homePage.clickInfiniteScroll();
        infiniteScrollPage.scrollToParagraph(5);
    }*/
}
