package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class FramesPage {
    private WebDriver driver;
    private By nestedFramesLocator = By.linkText("Nested Frames");

    public FramesPage(WebDriver driver) {
        this.driver = driver;
    }

    public FramesPage.NestedFramesPage clickNestedFrames() {
        driver.findElement(nestedFramesLocator).click();
        return new FramesPage.NestedFramesPage(driver);
    }

    public class NestedFramesPage {

        private WebDriver driver;
        private By middleFrame = By.xpath("//div[@id='content']");
        private By bottomFrame = By.xpath("/html/body");

        public NestedFramesPage(WebDriver driver) {
            this.driver = driver;
        }
        public String getMiddleText(){
        driver.switchTo().frame(0);
        driver.switchTo().frame(1);
            return driver.findElement(middleFrame).getText();
        }
        public String getBottomText(){
            driver.switchTo().defaultContent();
            driver.switchTo().frame("frame-bottom");
            return driver.findElement(bottomFrame).getText();
        }
    }
}
