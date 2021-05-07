package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class InfinitePageScroll {
    public WebDriver driver;

    private By paragraph=By.className("jscroll-added");

    public InfinitePageScroll(WebDriver driver) {
        this.driver=driver;
    }
}
