package com.testng.asm.pages;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class ForgetPassActivity extends BaseActivity{
    public ForgetPassActivity(AndroidDriver<WebElement> driver) {
        super(driver);
    }

    public boolean enterEmail(String email) {
        try {
            actionKeyword.setText(actionKeyword.findElementByFullText("Enter your username"), email);
            return true;
        } catch (Exception exception) {
            System.out.println(exception.getMessage());
            return false;
        }
    }

    public boolean clickOnGetPassButton() {
        try {
            return actionKeyword.clickOnElementByFullText("Get New Password");
        } catch (Exception exception) {
            System.out.println(exception.getMessage());
            return false;
        }
    }

    public boolean navigateToSignInActivity() {
        try {
            return actionKeyword.clickOnElementByFullText("Sign in now");
        } catch (Exception exception) {
            System.out.println(exception.getMessage());
            return false;
        }
    }

    public WebElement getBackIcon() {
        String imgBackIconCssSelector = "[resource-id='touch-goback-forgotpass']";
        return driver.findElement(By.cssSelector(imgBackIconCssSelector));
    }

    public boolean clickOnBackIcon() {
        try {
            getBackIcon().click();
            return true;
        } catch (Exception exception) {
            System.out.println(exception.getMessage());
            return false;
        }
    }
}
