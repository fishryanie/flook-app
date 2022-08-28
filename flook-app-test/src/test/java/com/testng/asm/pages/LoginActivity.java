package com.testng.asm.pages;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class LoginActivity extends BaseActivity{
    public LoginActivity(AndroidDriver<WebElement> driver) {
        super(driver);
    }

    public WebElement getBackIcon() {
        String imgBackIconCssSelector = "[resource-id='touch-goback-login']";
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

    public boolean enterUsername(String username) {
        try {
            actionKeyword.setText(actionKeyword.findElementByFullText("Enter your username"), username);
            return true;
        } catch (Exception exception) {
            System.out.println(exception.getMessage());
            return false;
        }
    }

    public boolean enterPassword(String password) {
        try {
            actionKeyword.setText(actionKeyword.findElementByFullText("Enter your password"), password);
            return true;
        } catch (Exception exception) {
            System.out.println(exception.getMessage());
            return false;
        }
    }

    public boolean clickOnLoginButton() {
        try {
            return actionKeyword.clickOnElementByFullText("Login");
        } catch (Exception exception) {
            System.out.println(exception.getMessage());
            return false;
        }
    }

    public boolean login(String username, String password) {
        return enterUsername(username) &&
                enterPassword(password) &&
                clickOnLoginButton();
    }

    public boolean navigateToForgetPassActivity() {
        try {
            return actionKeyword.clickOnElementByFullText("Click here to get password");
        } catch (Exception exception) {
            System.out.println(exception.getMessage());
            return false;
        }
    }

    public boolean navigateToSignUpActivity() {
        try {
            return actionKeyword.clickOnElementByFullText("Sign up now");
        } catch (Exception exception) {
            System.out.println(exception.getMessage());
            return false;
        }
    }
}
