package com.finaltest.selenium.pages.adminpages.admincomponents;

import com.finaltest.selenium.keyword.ActionKeyword;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;

public class BaseComponent {
    public WebDriver driver;
    public ActionKeyword actionKeyword;
    public Actions actions;

    public BaseComponent(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(this.driver, this);
        actionKeyword = new ActionKeyword(driver);
        actions = new Actions(driver);
    }
}
