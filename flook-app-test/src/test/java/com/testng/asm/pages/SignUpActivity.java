package com.testng.asm.pages;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class SignUpActivity extends BaseActivity{
    public SignUpActivity(AndroidDriver<WebElement> driver) {
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

    public WebElement getBackIcon() {
        String imgBackIconCssSelector = "[resource-id='touch-goback-register']";
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

    public boolean clickOnRegisterButton() {
        try {
            return actionKeyword.clickOnElementByFullText("Register");
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
}
