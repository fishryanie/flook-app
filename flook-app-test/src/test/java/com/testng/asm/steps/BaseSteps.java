package com.testng.asm.steps;

import com.testng.asm.keyword.ActionKeyword;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.WebElement;

public class BaseSteps {
    public AndroidDriver<WebElement> driver;
    public ActionKeyword actionKeyword;
}
