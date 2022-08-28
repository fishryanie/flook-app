package com.testng.asm.pages;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class EbookActivity extends BaseActivity{
    public EbookActivity(AndroidDriver<WebElement> driver) {
        super(driver);
    }

    public WebElement getCloseButton() {
        String textViewListXpath = "//*[@class='android.widget.TextView']";
        List<WebElement> elementList = driver.findElements(By.xpath(textViewListXpath));
        return elementList.get(elementList.size()-1);
    }

    public String getRakingScore() {
        String txtRankingStoreXpath = "//*[@text='RATING']/following-subling::*[@class='android.widget.TextView']";
        return driver.findElement(By.xpath(txtRankingStoreXpath)).getText();
    }

    public String getNumberOnChapters() {
        String txtRankingStoreXpath = "//*[@text='CHAPTERS']/following-subling::*[@class='android.widget.TextView']";
        return driver.findElement(By.xpath(txtRankingStoreXpath)).getText();
    }

    public String getStatus() {
        String txtRankingStoreXpath = "//*[@text='STATUS']/following-subling::*[@class='android.widget.TextView']";
        return driver.findElement(By.xpath(txtRankingStoreXpath)).getText();
    }

    public List<String> getGenreList() {
        String txtRankingStoreXpath = "//*[@class='android.widget.HorizontalScrollView']//*[@class='android.widget.TextView']";
        List<WebElement> elementList = driver.findElements(By.xpath(txtRankingStoreXpath));
        List<String> genreList = new ArrayList<>();
        for (WebElement element : elementList) {
            genreList.add(element.getText());
        }
        return genreList;
    }

    public String getAuthorName() {
        String txtAuthorNameXpath = "//*[@class='android.widget.HorizontalScrollView']/following-sibling::*[@class='android.widget.TextView']";
        return driver.findElement(By.xpath(txtAuthorNameXpath)).getText();
    }

    public boolean clickOnCloseButton() {
        try {
            getCloseButton().click();
            return true;
        } catch (Exception exception) {
            System.out.println(exception.getMessage());
            return false;
        }
    }

    public WebElement getSeeMoreButton() {
        String textViewListXpath = "//*[@text='RATING']/parent::*/following-sibling::*[@class='android.widget.HorizontalScrollView']";
        List<WebElement> elementList = driver.findElements(By.xpath(textViewListXpath));
        return elementList.get(elementList.size()-1);
    }

    public boolean clickOnSeeMoreButton() {
        try {
            getSeeMoreButton().click();
            return true;
        } catch (Exception exception) {
            System.out.println(exception.getMessage());
            return false;
        }
    }

    public boolean clickOnReadingButton() {
        try {
            return actionKeyword.clickOnElementByFullText("Đọc Truyện");
        } catch (Exception exception) {
            System.out.println(exception.getMessage());
            return false;
        }
    }

    public boolean clickOnShareButton() {
        String btnShareButton = "//*[@resource-id='touch-share-detail']";
        try {
            actionKeyword.scrollToElementByVisibleText("Đọc Truyện");
            driver.findElement(By.xpath(btnShareButton)).click();
            return true;
        } catch (Exception exception) {
            System.out.println(exception.getMessage());
            return false;
        }
    }

    public boolean clickOnLikeButton() {
        String btnShareButton = "//*[@resource-id='touch-add-favorite-detail']";
        try {
            actionKeyword.scrollToElementByVisibleText("Đọc Truyện");
            driver.findElement(By.xpath(btnShareButton)).click();
            return true;
        } catch (Exception exception) {
            System.out.println(exception.getMessage());
            return false;
        }
    }

    public String getStatusOfLikeButton() {
        String btnShareButton = "//*[@resource-id='touch-add-favorite-detail']";
        try {
            actionKeyword.scrollToElementByVisibleText("Đọc Truyện");
            WebElement element = driver.findElement(By.xpath(btnShareButton));
            return element.getAttribute("checked");
        } catch (Exception exception) {
            System.out.println(exception.getMessage());
            return "";
        }
    }
}
