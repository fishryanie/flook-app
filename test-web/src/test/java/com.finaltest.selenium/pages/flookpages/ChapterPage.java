package com.finaltest.selenium.pages.flookpages;

import com.finaltest.selenium.pages.adminpages.admincomponents.AddDataForm;
import com.finaltest.selenium.pages.adminpages.admincomponents.TableHeaderAndFooter;
import com.finaltest.selenium.pages.adminpages.auth.UsersPage;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class ChapterPage extends BasePage {
    public TableHeaderAndFooter tableHeaderAndFooter;
    public AddDataForm addDataForm;
    public ChapterPage(WebDriver driver) {
        super(driver);
        tableHeaderAndFooter = new TableHeaderAndFooter(this.driver);
        addDataForm = new AddDataForm(this.driver);
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }

    /* Tiêu đề của truyện. */
    @FindBy(css = "section.page_head>h1")
    public WebElement txtEbookTitle;

    /* Tên chapter (Chapter bao nhiêu). */
    @FindBy(css = "section.page_head span")
    public WebElement txtChapterName;

    /* Nút chuyển đến chapter trước đó. */
    @FindBy(css = "section.page_head>div>a:first-child")
    public WebElement btnPreviousChapter;

    /* Nút chuyển đến chapter sau. */
    @FindBy(css = "section.page_head>div>a:last-child")
    public WebElement btnNextChapter;

    /* Nút hiển thị các trang truyện full màn hình. */
    @FindBy(css = "[data-front='Full Screen Reader']")
    public WebElement btnFullScreen;

    /* Nút tải chapter. */
    @FindBy(css = "[data-front='Download Chapter']")
    public WebElement btnDownloadChapter;

    /* Khung chọn chapter. */
    @FindBy(css = "div.dropdown_select")
    public WebElement ddlSelectChapter;

    /**
     * Hàm nhấn vào nút chuyển đến chapter trước đó.
     * @return Trang chapter.
     */
    public ChapterPage clickOnPreviousChapterButton() {
        actionKeyword.click(btnPreviousChapter);
        return new ChapterPage(this.driver);
    }

    /**
     * Hàm nhấn vào nút chuyển đến chapter sau.
     * @return Trang chapter.
     */
    public ChapterPage clickOnNextChapterButton() {
        actionKeyword.click(btnNextChapter);
        return new ChapterPage(this.driver);
    }

    /**
     * Hàm nhấn vào nút xem ở chế độ full màn hình.
     * @return Trang chapter.
     */
    public ChapterPage clickOnFullScreenButton() {
        actionKeyword.click(btnFullScreen);
        return new ChapterPage(this.driver);
    }

    /**
     * Hàm nhấn vào nút tải chapter.
     * @return Trang chapter.
     */
    public ChapterPage clickOnDownloadChapterButton() {
        actionKeyword.click(btnDownloadChapter);
        return new ChapterPage(this.driver);
    }

    /**
     * Hàm di chuyển con trỏ chuột đến vị trí nút chọn chapter.
     * @return Trang chapter.
     */
    public ChapterPage moveToSelectChapterElement() {
        actions.moveToElement(ddlSelectChapter);
        return new ChapterPage(this.driver);
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
                    verifyColumnCheckboxInColumnBoxIsDisplayByText("Tên") &&
                    verifyColumnCheckboxInColumnBoxIsDisplayByText("Truyện") &&
                    verifyColumnCheckboxInColumnBoxIsDisplayByText("Lượt đọc") &&
                    verifyColumnCheckboxInColumnBoxIsDisplayByText("Trạng thái") &&
                    verifyColumnCheckboxInColumnBoxIsDisplayByText("Lượt thích") &&
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
        for (String result: getDataListByColumnPosition(0)) {
            if (!result.isEmpty()) {
                return false;
            }
        }
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

    public boolean verifyAllEditTextOfFirstGroupInAddDataFormAreDisplay() throws InterruptedException {
        Thread.sleep(500);
        return addDataForm.verifyAEditTextIsDisplayByLabelText("Tên") &&
                addDataForm.verifyAEditTextIsDisplayByLabelText("Trạng Thái");
    }

    public boolean verifyAllRadioButtonOfSecondGroupInAddDataFormAreDisplay() throws InterruptedException {
        Thread.sleep(500);
        return addDataForm.verifyAEditTextIsDisplayByLabelText("Truyện");
    }

    public boolean verifyAllElementOfThirdGroupInAddDataFormAreDisplay() throws InterruptedException {
        Thread.sleep(500);
        return actionKeyword.verifyElementIsDisplayByText("Chọn ảnh");
    }

    public ChapterPage enterInformationInFirstGroup(String chapterName, String status) {
        actionKeyword.setText(addDataForm.getFieldByLabelText("Tên"), chapterName);
        actionKeyword.setText(addDataForm.getFieldByLabelText("Trạng Thái"), status);
        return new ChapterPage(this.driver);
    }

    public WebElement getAddRolesEditTextInAddUserForm() {
        String edtAddChapterEditTextId = "ebooks";
        return actionKeyword.findElementCustom(By.id(edtAddChapterEditTextId));
    }

    public ChapterPage addEbookInAddChapterForm(String ebook) {
        actionKeyword.setText(getAddRolesEditTextInAddUserForm(), ebook);
        actions.sendKeys(Keys.ENTER).build().perform();
        return new ChapterPage(this.driver);
    }

    public boolean verifyThatTheChapterHasBeenCreated(String chapterName) throws InterruptedException {
        Thread.sleep(500);
        String lstDataListCssSelector = ".MuiDataGrid-root .MuiDataGrid-row [data-colindex='0']>div";
        try {
            return driver.findElement(By.cssSelector(lstDataListCssSelector)).getText().equals(chapterName);
        } catch (NoSuchElementException exception) {
            return false;
        }
    }
}
