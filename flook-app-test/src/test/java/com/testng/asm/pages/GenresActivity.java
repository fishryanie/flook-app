package com.testng.asm.pages;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class GenresActivity extends BaseActivity{
    public GenresActivity(AndroidDriver<WebElement> driver) {
        super(driver);
    }

    public List<String> getAllGenresByBookTitle(String bookTitle) {
        String scrollViewXpath = "//*[@text='%s']/../parent::*//*[@class='android.widget.HorizontalScrollView']//*[@class='android.widget.TextView']";
        List<WebElement> elementList = driver.findElements(By.xpath(scrollViewXpath));
        List<String> genreList = new ArrayList<>();
        for (WebElement element : elementList) {
            genreList.add(element.getText());
        }
        return genreList;
    }

    public WebElement getFilterIcon() {
        String filterIconXpath = "//*[contains(@text,'book']/following-sibling::*[@class='android.view.ViewGroup']";
        return driver.findElement(By.xpath(filterIconXpath));
    }

    public boolean clickOnFilterIcon() {
        try {
            getFilterIcon().click();
            return true;
        } catch (Exception exception) {
            System.out.println(exception.getMessage());
            return false;
        }
    }

    public WebElement getBookCoverByBookTitle(String bookTitle) {
        actionKeyword.scrollToElementByVisibleText(bookTitle);
        String bookCoverXpath = "//*[@text='%s']/../parent::*/*[@resource-id='touch-image-go-to-detail']";
        return driver.findElement(By.xpath(String.format(bookCoverXpath, bookTitle)));
    }

    public boolean clickOnBookCoverByBookTitle(String bookTitle) {
        try {
            getBookCoverByBookTitle(bookTitle).click();
            return true;
        } catch (Exception exception) {
            System.out.println(exception.getMessage());
            return false;
        }
    }

    public boolean clickOnBookTitle(String bookTitle) {
        try {
            return actionKeyword.clickOnElementByFullText(bookTitle);
        } catch (Exception exception) {
            System.out.println(exception.getMessage());
            return false;
        }
    }
}
