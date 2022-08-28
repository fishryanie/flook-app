package com.finaltest.selenium.keyword;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class ActionKeyword {
    public WebDriver driver;
    public WebDriverWait wait;

    public ActionKeyword(WebDriver driver){
        this.driver = driver;
        wait = new WebDriverWait(driver, 5);
    }

    public WebElement findElementByText(String text){
        return findElementCustom(By.xpath(String.format("//*[contains(text(), '%s')]", text)));
    }

    public WebElement findButtonByText(String text){
        return findElementCustom(By.xpath(String.format("//button[contains(text(), '%s')]", text)));
    }

    public List<WebElement> findElementsByText(String text){
        return findElementsCustom(By.xpath(String.format("//*[contains(text(), '%s')]", text)));
    }

    public WebElement findElementByFullText(String text){
        return findElementCustom(By.xpath(String.format("//*[text()='%s']", text)));
    }

    public boolean verifyElementIsDisplayByText(String text) {
        try {
            return driver.findElement(By.xpath(String.format("//*[text()='%s']", text))).isDisplayed();
        } catch (NoSuchElementException elementException) {
            return false;
        }
    }

    public boolean verifyManyElementsAreDisplayByText(String text) {
        try {
            return driver.findElements(By.xpath(String.format("//*[contains(text(), '%s')]", text))).size() > 0;
        } catch (NoSuchElementException elementException) {
            return false;
        }
    }

    public void clickOnElementByText(String text) {
        click(findElementByText(text));
    }

    public void clickOnButtonByText(String text) {
        click(findButtonByText(text));
    }

    public void clickOnElementByFullText(String text) {
        click(findElementByFullText(text));
    }

    /**
     * The function checks if the path is valid or not.
     * @param url Path.
     * @throws Exception
     */
    public void checkUrl(String url) throws Exception {
        if(!(url.startsWith("https://") || url.startsWith("http://"))){
            throw new Exception("Incorrect URL format!");
        }
        driver.get(url);
    }

    /**
     * Rewrite function to find and return object.
     * @param locator Xpath or cssSelector.
     * @return Web element.
     */
    public WebElement findElementCustom(By locator){
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    /**
     * Rewrite the function to find and return a list of objects.
     * @param locator Xpath or cssSelector.
     * @return List of elements.
     */
    public List<WebElement> findElementsCustom(By locator){
        return wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(locator));
    }

    /**
     * Function to move to element and click.
     * @param webElement The object need to be interacted with.
     */
    public void click(WebElement webElement){
        Actions actions = new Actions(driver);
        actions.moveToElement(webElement).build().perform();
        webElement.click();
    }

    /**
     * The function deletes the existing content and fills in the new content.
     * @param webElement The object need to be interacted with.
     * @param text New content to fill.
     */
    public void setText(WebElement webElement, String text){
        try{
            webElement.clear();
            webElement.sendKeys(text);
        }
        catch (WebDriverException e){
            throw new WebDriverException("An error occurred while entering data!");
        }
    }

    public void uploadImage(WebElement webElement, String absolutePathToTheFile){
        webElement.sendKeys(absolutePathToTheFile);
    }

    /**
     * The function selects a value from the dropdown list, based on the input requirements.
     * @param element Dropdown list.
     * @param type How to determine.
     * @param option Value to choose.
     * @throws Exception
     */
    public void select(WebElement element, SelectType type, String option) throws Exception {
        Select select = new Select(element);
        System.out.println("ok-detailsize");
        switch (type) {
            case SELECT_BY_INDEX:
                try {
                    select.selectByIndex(Integer.parseInt(option));
                } catch (Exception e) {
                    throw new Exception("SelectType.SELECT_BY_INDEX needs to enter the option as an integer!");
                }
                break;
            case SELECT_BY_TEXT:
                select.selectByVisibleText(option);
                break;
            case SELECT_BY_VALUE:
                select.selectByValue(option);
                break;
            default:
                throw new Exception("An error occurred during the selection process!");
        }
    }

    public enum SelectType {
        SELECT_BY_INDEX,
        SELECT_BY_TEXT,
        SELECT_BY_VALUE,
    }
}
