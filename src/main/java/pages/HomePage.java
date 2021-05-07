package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage {

    private WebDriver driver;

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    private WebElement clickLink(String linktext) {
        return driver.findElement(By.linkText(linktext));
    }

    public LoginPage clickFormAuthentication() {
        clickLink("Form Authentication").click();
        return new LoginPage(driver);
    }

    public ShiftingContentPage clickShiftingContent() {
        clickLink("Shifting Content").click();
        return new ShiftingContentPage(driver);
    }

    public DropDownPage clickDropDown() {
        clickLink("Dropdown").click();
        return new DropDownPage(driver);
    }

    public HoversPage clickHovers() {
        clickLink("Hovers").click();
        return new HoversPage(driver);
    }

    public KeyPressesPage clickKeyPresses() {
        clickLink("Key Presses").click();
        return new KeyPressesPage(driver);
    }

    public JavaScriptAlertsPage clickJavaScriptAlerts() {
        clickLink("JavaScript Alerts").click();
        return new JavaScriptAlertsPage(driver);
    }

    public FileUploadPage clickFileUploader() {
        clickLink("File Upload").click();
        return new FileUploadPage(driver);
    }

    public EntryAdPage clickEntryAd() {
        clickLink("Entry Ad").click();
        return new EntryAdPage(driver);
    }
    public WisywygEditorPage clickWisywyg() {
        clickLink("WYSIWYG Editor").click();
        return new WisywygEditorPage(driver);
    }
    public DynamicLoadingPage clickDynamicLoadings() {
        clickLink("Dynamic Loading").click();
        return new DynamicLoadingPage(driver);
    }
    public LargeAndDeepDomPage clickLargeAndDeepDom() {
        clickLink("Large & Deep DOM").click();
        return new LargeAndDeepDomPage(driver);
    }
    public InfinitePageScroll clickInfiniteScroll() {
        clickLink("Infinite Scroll").click();
        return new InfinitePageScroll(driver);
    }
    public FramesPage clickFrames() {
        clickLink("Frames").click();
        return new FramesPage(driver);
    }
}
