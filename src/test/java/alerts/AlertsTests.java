package alerts;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.JavaScriptAlertsPage;

public class AlertsTests extends BaseTest {
    @Test
    public void testAlert() {
        JavaScriptAlertsPage javaScriptAlertsPage = homePage.clickJavaScriptAlerts();
        javaScriptAlertsPage.clickAlertButton();
        javaScriptAlertsPage.acceptPopup();
        Assert.assertEquals(javaScriptAlertsPage.getResultText(), "You successfully clicked an alert", "Wrong result text");
    }

    @Test
    public void testConfirm() {
        JavaScriptAlertsPage javaScriptAlertsPage = homePage.clickJavaScriptAlerts();
        javaScriptAlertsPage.clickConfirmButton();
        String confirmText = javaScriptAlertsPage.getConfirmText();
        javaScriptAlertsPage.dismissPopup();
        Assert.assertEquals(javaScriptAlertsPage.getResultText(), "You clicked: Cancel", "Wrong confirm text");
    }

    @Test
    public void testPromt() {
        JavaScriptAlertsPage javaScriptAlertsPage = homePage.clickJavaScriptAlerts();
        javaScriptAlertsPage.clickPromttButton();
        String text = "Hey there!";
        javaScriptAlertsPage.setPromtInput(text);
        javaScriptAlertsPage.acceptPopup();
        Assert.assertEquals(javaScriptAlertsPage.getResultText(), "You entered: " + text, "Wrong promt test");
    }
}
