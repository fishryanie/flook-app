package com.testng.asm.pages;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.WebElement;

public class FilterActivity extends BaseActivity{
    public FilterActivity(AndroidDriver<WebElement> driver) {
        super(driver);
    }

    public boolean clickOnCloseButton() {
        try {
            return actionKeyword.clickOnElementByFullText("Đóng");
        } catch (Exception exception) {
            System.out.println(exception.getMessage());
            return false;
        }
    }

    public boolean clickOnClearButton() {
        try {
            return actionKeyword.clickOnElementByFullText("Xóa");
        } catch (Exception exception) {
            System.out.println(exception.getMessage());
            return false;
        }
    }

    public boolean clickOnFilterButton() {
        try {
            return actionKeyword.clickOnElementByFullText("Lọc");
        } catch (Exception exception) {
            System.out.println(exception.getMessage());
            return false;
        }
    }

    public boolean clickOnAuthorsButton() {
        try {
            return actionKeyword.clickOnElementByFullText("Tác giả");
        } catch (Exception exception) {
            System.out.println(exception.getMessage());
            return false;
        }
    }

    public boolean clickOnGenresButton() {
        try {
            return actionKeyword.clickOnElementByFullText("Thể loại");
        } catch (Exception exception) {
            System.out.println(exception.getMessage());
            return false;
        }
    }

    public boolean clickOnStatusButton() {
        try {
            return actionKeyword.clickOnElementByFullText("Trạng thái");
        } catch (Exception exception) {
            System.out.println(exception.getMessage());
            return false;
        }
    }

    public boolean clickOnNumberOfChaptersButton() {
        try {
            return actionKeyword.clickOnElementByFullText("Số chương");
        } catch (Exception exception) {
            System.out.println(exception.getMessage());
            return false;
        }
    }

    public boolean clickOnAgeButton() {
        try {
            return actionKeyword.clickOnElementByFullText("Độ tuổi");
        } catch (Exception exception) {
            System.out.println(exception.getMessage());
            return false;
        }
    }

    public boolean clickOnSortButton() {
        try {
            return actionKeyword.clickOnElementByFullText("Sắp xếp");
        } catch (Exception exception) {
            System.out.println(exception.getMessage());
            return false;
        }
    }

    public boolean selectAuthorByAuthorName(String authorName) {
        try {
            clickOnAuthorsButton();
            actionKeyword.clickOnElementByFullText(authorName);
            clickOnAuthorsButton();
            return true;
        } catch (Exception exception) {
            System.out.println(exception.getMessage());
            return false;
        }
    }

    public boolean selectGenreByGenreName(String genreName) {
        try {
            clickOnGenresButton();
            actionKeyword.clickOnElementByFullText(genreName);
            clickOnGenresButton();
            return true;
        } catch (Exception exception) {
            System.out.println(exception.getMessage());
            return false;
        }
    }

    public boolean selectStatus(String status) {
        try {
            clickOnStatusButton();
            actionKeyword.clickOnElementByFullText(status);
            clickOnStatusButton();
            return true;
        } catch (Exception exception) {
            System.out.println(exception.getMessage());
            return false;
        }
    }

    public boolean selectNumberOfChapters(String numberOfChapters) {
        try {
            clickOnNumberOfChaptersButton();
            actionKeyword.clickOnElementByFullText(numberOfChapters);
            clickOnNumberOfChaptersButton();
            return true;
        } catch (Exception exception) {
            System.out.println(exception.getMessage());
            return false;
        }
    }

    public boolean selectAge(String age) {
        try {
            clickOnAgeButton();
            actionKeyword.clickOnElementByFullText(age);
            clickOnAgeButton();
            return true;
        } catch (Exception exception) {
            System.out.println(exception.getMessage());
            return false;
        }
    }

    public boolean selectSortOption(String sortOption) {
        try {
            clickOnSortButton();
            actionKeyword.clickOnElementByFullText(sortOption);
            clickOnSortButton();
            return true;
        } catch (Exception exception) {
            System.out.println(exception.getMessage());
            return false;
        }
    }
}
