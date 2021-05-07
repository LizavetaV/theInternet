package navigation;

import base.BaseTest;
import org.testng.annotations.Test;
import pages.DynamicLoadingPage;

public class NavigationTest extends BaseTest {
    @Test
    public void testNavigation(){
        DynamicLoadingPage dynamicLoadingPage=homePage.clickDynamicLoadings();
        DynamicLoadingPage.Example1Page example1Page = dynamicLoadingPage.clickExample1();

        getWindowManager().goBack();
        getWindowManager().refresh();
        getWindowManager().goForward();
        getWindowManager().goTo("https://tut.by");
    }
}
