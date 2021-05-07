package base;

import com.google.common.io.Files;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import pages.HomePage;
import utils.EventReporter;
import utils.WindowManager;

import java.io.File;
import java.io.IOException;


public class BaseTest {

    private EventFiringWebDriver driver;
    public HomePage homePage;

    @BeforeClass
    public void setUp() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        driver = new EventFiringWebDriver(new ChromeDriver(getChromeOptions()));
        driver.register(new EventReporter());
        //driver = new ChromeDriver();
        /*Dimension dimension = new Dimension(750, 550);*/
        /* driver.get(link);*/
        driver.manage().window().maximize();
        goHome();
        setCookie();
        //driver.manage().window().setSize(dimension);
      /*   List<WebElement> aLinks=driver.findElements(By.tagName("a"));*/
        /*System.out.println(aLinks.size());*/
        /*Assert.assertEquals(aLinks.size(),46,"Wrong number of links");*/
        homePage = new HomePage(driver);
    }

    @BeforeMethod
    public void goHome() {
        //private WebDriver driver;
        String link = "http://the-internet.herokuapp.com/";
        driver.get(link);
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }

    public WindowManager getWindowManager(){
        return new WindowManager(driver);
    }

    public void takeScreenshot(ITestResult result) throws IOException {
        TakesScreenshot camera = (TakesScreenshot) driver;
        File screenshot = camera.getScreenshotAs(OutputType.FILE);
        //System.out.println(screenshot.getAbsolutePath());
        Files.move(screenshot,new File ("src/test/resources/screenshots/screenshot_" + result.getName()+ ".png"));
    }
    @AfterMethod

    public void recordFailure(ITestResult result) throws IOException {
        if(result.getStatus()== ITestResult.FAILURE){
            takeScreenshot(result);
        }
    }
    private ChromeOptions getChromeOptions(){
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.setExperimentalOption("excludeSwitches", new String[]{"enable-automation"});
        //chromeOptions.setHeadless(true); - не показывается отработка на экране (открытие хрома)
        return chromeOptions;
    }

    private void setCookie(){
        Cookie cookie = new Cookie.Builder("Stormnet", "1234")
                .domain("http://the-internet.herokuapp.com/")
                .domain("the-internet.herokuapp.com")
                .build();
        driver.manage().addCookie(cookie);
        driver.manage().deleteCookieNamed("optimizelyBuckets");
    }

  /*  public static void main(String[] args) {
        BaseTest test = new BaseTest();
        try {
            test.setUp();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        test.tearDown();
    }*/
}
