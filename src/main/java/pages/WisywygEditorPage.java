package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class WisywygEditorPage {
    private WebDriver driver;

    private String frameID = "mce_0_ifr";
    private By textArea=By.id("tinymce");
    private By increaseIndentButton = By.xpath(".//button[@title='Increase indent']");

    public WisywygEditorPage (WebDriver driver){
        this.driver = driver;
    }
    public void clearTextArea(){
        switchToTextArea();
        driver.findElement(textArea).clear();
        switchToMainArea();
    }

    public void switchToTextArea(){
        driver.switchTo().frame(frameID);
    }

    public void switchToMainArea(){
        driver.switchTo().parentFrame();
    }
    public void sendTextToTextArea(String text){
        switchToTextArea();
        driver.findElement(textArea).sendKeys(text);
        switchToMainArea();
    }
    public void increaseIndent(){
        driver.findElement(increaseIndentButton).click();
    }

    public String getTextAreaContent(){
        switchToTextArea();
        String text =driver.findElement(textArea).getText();
        switchToMainArea();
        return text;
    }

}
