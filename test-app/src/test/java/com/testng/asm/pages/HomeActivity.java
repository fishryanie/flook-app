package com.testng.asm.pages;

import io.appium.java_client.MobileBy;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class HomeActivity extends BaseActivity{
    Actions actions;
    public HomeActivity(AndroidDriver<WebElement> driver) {
        super(driver);
        actions = new Actions(driver);
    }

    public WebElement getEbookInABlockByBlockNameAndEbookTitle(String blockName, String ebookTitle) {
        String groupXpath = "//*[@text='%s']/parent::*/following-sibling::*[@class='android.widget.HorizontalScrollView']";
        actionKeyword.scrollToElementByVisibleText(blockName);
        WebElement rootElement = driver.findElement(By.xpath(String.format(groupXpath, blockName)));
        return actionKeyword.findElementByFullTextHorizontal(rootElement, ebookTitle);
    }

    public boolean clickOnEbookInABlockByBlockNameAndEbookTitle(String blockName, String ebookTitle) {
        try {
            getEbookInABlockByBlockNameAndEbookTitle(blockName, ebookTitle).click();
            return true;
        } catch (Exception exception) {
            System.out.println(exception.getMessage());
            return false;
        }
    }

    public WebElement getSeeMoreLinkByBlockName(String blockName) {
        String groupXpath = "//*[@text='%s']/parent::*/following-sibling::*[@class='android.view.ViewGroup']/*";
        actionKeyword.scrollToElementByVisibleText(blockName);
        return driver.findElement(By.xpath(String.format(groupXpath, blockName)));
    }

    public boolean clickOnSeeMoreLinkByBlockName(String blockName) {
        try {
            getSeeMoreLinkByBlockName(blockName).click();
            return true;
        } catch (Exception exception) {
            System.out.println(exception.getMessage());
            return false;
        }
    }

    public boolean clickOnGenreByGenreName(String genreName) {
        try {
            actionKeyword.clickOnElementByFullText(genreName);
            return true;
        } catch (Exception exception) {
            System.out.println(exception.getMessage());
            return false;
        }
    }

    public boolean clickOnSearchView() {
        try {
            driver.findElement(By.xpath("//*[@text='Find your next book...']")).click();
            return true;
        } catch (Exception exception) {
            System.out.println(exception.getMessage());
            return false;
        }
    }

    public boolean clickOnRankingButton() {
        try {
            driver.findElement(By.xpath("//*[@text='BXH']")).click();
            return true;
        } catch (Exception exception) {
            System.out.println(exception.getMessage());
            return false;
        }
    }

    public boolean clickOnGenresButton() {
        try {
            return actionKeyword.clickOnElementByFullText("Danh mục");
        } catch (Exception exception) {
            System.out.println(exception.getMessage());
            return false;
        }
    }

    public boolean clickOnScoreButton() {
        try {
            return actionKeyword.clickOnElementByFullText("Điểm Của Tôi");
        } catch (Exception exception) {
            System.out.println(exception.getMessage());
            return false;
        }
    }

    public boolean clickOnSubscribeButton() {
        try {
            return actionKeyword.clickOnElementByFullText("Theo dõi");
        } catch (Exception exception) {
            System.out.println(exception.getMessage());
            return false;
        }
    }

    public boolean rankingButtonIsDisplayed() {
        try {
            return actionKeyword.findElementByFullText("BXH").isDisplayed();
        } catch (Exception exception) {
            System.out.println(exception.getMessage());
            return false;
        }
    }

    public boolean genresButtonIsDisplayed() {
        try {
            return actionKeyword.findElementByFullText("BXH").isDisplayed();
        } catch (Exception exception) {
            System.out.println(exception.getMessage());
            return false;
        }
    }

    public boolean scoreButtonIsDisplayed() {
        try {
            return actionKeyword.findElementByFullText("Điểm của tôi").isDisplayed();
        } catch (Exception exception) {
            System.out.println(exception.getMessage());
            return false;
        }
    }

    public boolean subscribeButtonIsDisplayed() {
        try {
            return actionKeyword.findElementByFullText("Theo dõi").isDisplayed();
        } catch (Exception exception) {
            System.out.println(exception.getMessage());
            return false;
        }
    }
}
