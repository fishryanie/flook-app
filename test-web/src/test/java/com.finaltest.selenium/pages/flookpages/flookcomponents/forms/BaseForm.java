package com.finaltest.selenium.pages.flookpages.flookcomponents.forms;

import com.finaltest.selenium.keyword.ActionKeyword;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class BaseForm {
    public WebDriver driver;
    ActionKeyword actionKeyword;
    private final String FORM_FIELD_LOCATOR_BY_NAME = "[name='%s']";

    public BaseForm(WebDriver driver){
        this.driver = driver;
        actionKeyword = new ActionKeyword(driver);
    }

    /**
     * The function returns the field on the form based on the name.
     * @param fieldName
     * @return
     */
    public WebElement getFieldByName(String fieldName){
        return actionKeyword.findElementCustom(By.cssSelector(String.format(FORM_FIELD_LOCATOR_BY_NAME, fieldName)));
    }

    /**
     * Function to fill in the field
     * @param webElement
     * @param content
     */
    public void enterContentInField(WebElement webElement, String content) {
        actionKeyword.setText(webElement, content);
    }

    public void getFieldByNameAndEnterContent(String fieldName, String content) {
        enterContentInField(getFieldByName(fieldName), content);
    }
}
