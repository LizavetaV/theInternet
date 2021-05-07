package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class JavaScriptAlertsPage {
    private By triggerAlert = By.xpath("//button[text()='Click for JS Alert']");
    private By triggerConfirm = By.xpath("//button[text()='Click for JS Confirm']");
    private By triggerPromt = By.xpath("//button[text()='Click for JS Prompt']");
    private By result = By.id("result");

    private WebDriver driver;

    public JavaScriptAlertsPage(WebDriver driver) {
        this.driver = driver;
    }

    public void clickAlertButton() {
        driver.findElement(triggerAlert).click();
    }

    public void clickConfirmButton() {
        driver.findElement(triggerConfirm).click();
    }

    public void clickPromttButton() {
        driver.findElement(triggerPromt).click();
    }

    public String getResultText() {
        return driver.findElement(result).getText();
    }

    public void acceptPopup() {
        driver.switchTo().alert().accept();
    }

    public void dismissPopup() {
        driver.switchTo().alert().dismiss();
    }

    public String getConfirmText() {
        return driver.switchTo().alert().getText();
    }

    public void setPromtInput(String text) {
        driver.switchTo().alert().sendKeys(text);
    }
}
