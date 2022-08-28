package com.testng.asm.pages;

import com.testng.asm.keyword.ActionKeyword;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.concurrent.TimeUnit;

public class BaseActivity {
    public AndroidDriver<WebElement> driver;
    public ActionKeyword actionKeyword;

    public BaseActivity(AndroidDriver<WebElement> driver){
        this.driver = driver;
        this.actionKeyword = new ActionKeyword(driver);
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }

    public boolean clickOnBottomTabByName(String bottomTabName) {
        try {
            driver.findElement(By.xpath(String.format("//*[@text='%s']", bottomTabName))).click();
            return true;
        } catch (Exception exception) {
            System.out.println(exception.getMessage());
            return false;
        }
    }

    public boolean homeTabIsDisplayed() {
        try {
            return driver.findElement(By.xpath("//*[@text='Trang chủ']")).isDisplayed();
        } catch (Exception exception) {
            System.out.println(exception.getMessage());
            return false;
        }
    }

    public boolean bookcaseTabIsDisplayed() {
        try {
            return driver.findElement(By.xpath("//*[@text='Tủ sách']")).isDisplayed();
        } catch (Exception exception) {
            System.out.println(exception.getMessage());
            return false;
        }
    }

    public boolean forumTabIsDisplayed() {
        try {
            return driver.findElement(By.xpath("//*[@text='Diễn đàn']")).isDisplayed();
        } catch (Exception exception) {
            System.out.println(exception.getMessage());
            return false;
        }
    }

    public boolean notificationTabIsDisplayed() {
        try {
            return driver.findElement(By.xpath("//*[@text='Thông báo']")).isDisplayed();
        } catch (Exception exception) {
            System.out.println(exception.getMessage());
            return false;
        }
    }

    public boolean meTabIsDisplayed() {
        try {
            return driver.findElement(By.xpath("//*[@text='Cá nhân']")).isDisplayed();
        } catch (Exception exception) {
            System.out.println(exception.getMessage());
            return false;
        }
    }

    public boolean verifyATabIsDisplayedByText(String text) {
        try {
            if (text.equals("Cá nhân")) {
                return driver.findElement(By.xpath("//*[@text='Bấm để đăng nhập']")).isDisplayed();
            } else {
                return driver.findElement(By.xpath(String.format("//*[@text='%s' and @class='android.view.View']", text))).isDisplayed();
            }
        } catch (Exception exception) {
            System.out.println(exception.getMessage());
            return false;
        }
    }

    public boolean verifyAViewIsDisplayedByText(String text) {
        try {
            return driver.findElement(By.xpath(String.format("//*[@text='%s']", text))).isDisplayed();
        } catch (Exception exception) {
            System.out.println(exception.getMessage());
            return false;
        }
    }
}