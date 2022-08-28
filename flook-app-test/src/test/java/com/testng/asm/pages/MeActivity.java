package com.testng.asm.pages;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.WebElement;

public class MeActivity extends BaseActivity{
    public MeActivity(AndroidDriver<WebElement> driver) {
        super(driver);
    }

    public boolean navigateToLoginActivity() {
        try {
            return actionKeyword.clickOnElementByFullText("Bấm để đăng nhập");
        } catch (Exception exception) {
            System.out.println(exception.getMessage());
            return false;
        }
    }

    public boolean navigateToSignUpActivity() {
        try {
            return actionKeyword.clickOnElementByFullText("Đăng kí");
        } catch (Exception exception) {
            System.out.println(exception.getMessage());
            return false;
        }
    }

    public boolean navigateToScoreActivity() {
        try {
            return actionKeyword.clickOnElementByFullText("Nạp tiền");
        } catch (Exception exception) {
            System.out.println(exception.getMessage());
            return false;
        }
    }

    public boolean navigateToForgetPassActivity() {
        try {
            return actionKeyword.clickOnElementByFullText("Quên mật khẩu");
        } catch (Exception exception) {
            System.out.println(exception.getMessage());
            return false;
        }
    }
}
