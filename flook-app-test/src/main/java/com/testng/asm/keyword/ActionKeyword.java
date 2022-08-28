package com.testng.asm.keyword;

import io.appium.java_client.MobileBy;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class ActionKeyword {
    public AndroidDriver<WebElement> driver;
    Actions actions;

    public ActionKeyword(AndroidDriver<WebElement> driver){
        this.driver = driver;
        actions = new Actions(driver);
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
    }

    public WebElement findElementByFullText(String text){
        scrollToElementByVisibleText(text);
        String txtViewTextXpath = "//*[@text='%s']";
        return driver.findElement(By.xpath(String.format(txtViewTextXpath, text)));
    }

    public WebElement findElementByFullTextHorizontal(WebElement element, String text){
        return driver.findElement(MobileBy.AndroidUIAutomator(
                "new UiScrollable(new UiSelector().scrollable(true)).setAsHorizontalList()" +
                        ".scrollIntoView(new UiSelector().text(\"" + text + "\"))"));
    }

    public List<WebElement> findElementsByFullText(String text){
        scrollToElementByVisibleText(text);
        String txtViewTextXpath = "//*[@text='%s']";
        return driver.findElements(By.xpath(String.format(txtViewTextXpath, text)));
    }

    public boolean clickOnElementByFullText(String text) {
        try {
            scrollToElementByVisibleText(text);
            actions.click(findElementByFullText(text));
            return true;
        } catch (Exception exception) {
            return false;
        }
    }

    public void setText(WebElement webElement, String text){
        try{
            webElement.clear();
            webElement.sendKeys(text);
        }
        catch (WebDriverException e){
            throw new WebDriverException("An error occurred while entering data!");
        }
    }

    public void scrollToElementByVisibleText(String visibleText) {
        String uiSelector = "new UiSelector().text(\"" + visibleText + "\")";
        String command = "new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(" + uiSelector + ");";
        driver.findElementByAndroidUIAutomator(command);
    }

    public void scrollToElementById(String id) {
        String uiSelector = "new UiSelector().resourceId(\"" + id + "\")";
        String command = "new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(" + uiSelector + ");";
        driver.findElementByAndroidUIAutomator(command);
    }

    public void scrollToElementByClass(String classname) {
        String uiSelector = "new UiSelector().className(\"" + classname + "\")";
        String command = "new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(" + uiSelector + ");";
        driver.findElementByAndroidUIAutomator(command);
    }
}
