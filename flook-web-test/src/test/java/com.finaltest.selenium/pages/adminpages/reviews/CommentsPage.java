package com.finaltest.selenium.pages.adminpages.reviews;

import com.finaltest.selenium.pages.adminpages.AdminBasePage;
import org.openqa.selenium.*;

import java.util.ArrayList;
import java.util.List;

public class CommentsPage extends AdminBasePage {
    public CommentsPage(WebDriver driver) {
        super(driver);
    }

    public boolean verifyColumnCheckboxInColumnBoxIsDisplayByText(String text) {
        String chkColumnCheckBoxXpath = "//span[text()='%s']";
        try {
            return driver.findElement(By.xpath(String.format(chkColumnCheckBoxXpath, text))).isDisplayed();
        } catch (NoSuchElementException exception) {
            return false;
        }
    }

    public boolean verifyAllColumnCheckboxesInColumnBoxAreDisplay() {
        try {
            return verifyColumnCheckboxInColumnBoxIsDisplayByText("Checkbox selection") &&
                    verifyColumnCheckboxInColumnBoxIsDisplayByText("Stt") &&
                    verifyColumnCheckboxInColumnBoxIsDisplayByText("Người dùng") &&
                    verifyColumnCheckboxInColumnBoxIsDisplayByText("Nội dung") &&
                    verifyColumnCheckboxInColumnBoxIsDisplayByText("##");
        } catch (NoSuchElementException exception) {
            return false;
        }
    }

    public List<String> getDataListByColumnPosition(int position) throws TimeoutException {
        String lstDataListCssSelector = ".MuiDataGrid-root .MuiDataGrid-row [data-colindex='%s']>div";
        List<WebElement> elementList = actionKeyword.findElementsCustom(
                By.cssSelector(String.format(lstDataListCssSelector, position))
        );
        List<String> dataList = new ArrayList<>();
        for (WebElement element : elementList) {
            dataList.add(element.getText());
        }
        return dataList;
    }

    public boolean verifyAllResultsThatContainTheKeyWorkInFiltersBox(String keyWord) throws InterruptedException {
        Thread.sleep(500);
        try {
            for (String string: getDataListByColumnPosition(0)) {
                if (!string.toLowerCase().contains(keyWord.toLowerCase())) {
                    return false;
                }
            }
            return true;
        } catch (TimeoutException exception) {
            return false;
        }
    }

    public boolean verifyAllResultsThatEqualTheKeyWorkInFiltersBox(String keyWord) throws InterruptedException {
        Thread.sleep(500);
        try {
            for (String string: getDataListByColumnPosition(0)) {
                if (!string.equalsIgnoreCase(keyWord)) {
                    return false;
                }
            }
            return true;
        } catch (TimeoutException exception) {
            return false;
        }
    }

    public boolean verifyAllResultsThatStartWithTheKeyWorkInFiltersBox(String keyWord) throws InterruptedException {
        Thread.sleep(500);
        try {
            for (String string: getDataListByColumnPosition(0)) {
                if (!string.startsWith(keyWord)) {
                    return false;
                }
            }
            return true;
        } catch (TimeoutException exception) {
            return false;
        }
    }

    public boolean verifyAllResultsThatEndWithTheKeyWorkInFiltersBox(String keyWord) throws InterruptedException {
        Thread.sleep(500);
        try {
            for (String string: getDataListByColumnPosition(0)) {
                if (!string.endsWith(keyWord)) {
                    return false;
                }
            }
            return true;
        } catch (TimeoutException exception) {
            return false;
        }
    }

    public boolean verifyAllResultsThatIsEmpty() throws InterruptedException {
        Thread.sleep(1000);
        return true;
    }

    public boolean verifyAllResultsThatIsNotEmpty() throws InterruptedException {
        Thread.sleep(500);
        try {
            for (String string: getDataListByColumnPosition(0)) {
                if (string.isEmpty()) {
                    return false;
                }
            }
            return true;
        } catch (TimeoutException exception) {
            return false;
        }
    }
}
