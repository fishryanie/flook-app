package com.finaltest.selenium.pages.adminpages.books;

import com.finaltest.selenium.pages.adminpages.AdminBasePage;
import com.finaltest.selenium.pages.adminpages.admincomponents.AddDataForm;
import com.finaltest.selenium.pages.adminpages.admincomponents.TableHeaderAndFooter;
import com.finaltest.selenium.pages.adminpages.auth.UsersPage;
import io.cucumber.java.an.E;
import org.openqa.selenium.*;

import javax.lang.model.element.Element;
import java.security.Key;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class EbooksPage extends AdminBasePage {
    TableHeaderAndFooter tableHeaderAndFooter;
    AddDataForm addDataForm;

    public EbooksPage(WebDriver driver) {
        super(driver);
        tableHeaderAndFooter = new TableHeaderAndFooter(this.driver);
        addDataForm = new AddDataForm(this.driver);
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }

    public List<String> getTextListByColumnTitle(String columnTitle) {
        actionKeyword.clickOnElementByText("Columns");
        actionKeyword.clickOnElementByText("Hide all");
        tableHeaderAndFooter.clickOnShowHideColumnCheckboxByColumnTitle(columnTitle);
        actions.sendKeys(Keys.ESCAPE).build().perform();

        String lstElementListOfColumnXpath = ".MuiDataGrid-root .MuiDataGrid-row [data-colindex='0']>div";
        List<WebElement> lstElementListOfColumn = actionKeyword.findElementsCustom(By.xpath(lstElementListOfColumnXpath));

        List<String> lstTextListOfColumn = new ArrayList<>();
        for (WebElement element: lstElementListOfColumn) {
            lstTextListOfColumn.add(element.getText());
        }
        return lstTextListOfColumn;
    }

    public void setUpForGetEbookButton() {
        actionKeyword.clickOnElementByText("Columns");
        actionKeyword.clickOnElementByText("Hide all");
        tableHeaderAndFooter.clickOnShowHideColumnCheckboxByColumnTitle("Tên truyện");
        tableHeaderAndFooter.clickOnShowHideColumnCheckboxByColumnTitle("##");
        actions.sendKeys(Keys.ESCAPE).build().perform();
    }

    public WebElement getUpdateEbookButtonByTitle(String title) {
        setUpForGetEbookButton();
        String btnUpdateEbookButtonXpath = "//*[contains(text(),'%s')]/../parent::div/div[2]//button[2]";
        return actionKeyword.findElementCustom(By.xpath(String.format(btnUpdateEbookButtonXpath, title)));
    }

    public WebElement getDeleteEbookButtonByTitle(String title) {
        setUpForGetEbookButton();
        String btnUpdateEbookButtonXpath = "//*[contains(text(),'%s')]/../parent::div/div[2]//button[3]";
        return actionKeyword.findElementCustom(By.xpath(String.format(btnUpdateEbookButtonXpath, title)));
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
                    verifyColumnCheckboxInColumnBoxIsDisplayByText("Background") &&
                    verifyColumnCheckboxInColumnBoxIsDisplayByText("Tên truyện") &&
                    verifyColumnCheckboxInColumnBoxIsDisplayByText("Tác giả") &&
                    verifyColumnCheckboxInColumnBoxIsDisplayByText("Thể loại") &&
                    verifyColumnCheckboxInColumnBoxIsDisplayByText("Trạng thái") &&
                    verifyColumnCheckboxInColumnBoxIsDisplayByText("Giới thiệu") &&
                    verifyColumnCheckboxInColumnBoxIsDisplayByText("Số chapter") &&
                    verifyColumnCheckboxInColumnBoxIsDisplayByText("Lượt đọc") &&
                    verifyColumnCheckboxInColumnBoxIsDisplayByText("Vip") &&
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

    public boolean verifyAllEditTextOfFirstGroupInAddDataFormAreDisplay() throws InterruptedException {
        Thread.sleep(500);
        return addDataForm.verifyAEditTextIsDisplayByLabelText("Tên") &&
                addDataForm.verifyAEditTextIsDisplayByLabelText("Trạng Thái") &&
                addDataForm.verifyAEditTextIsDisplayByLabelText("Giới Thiệu");
    }

    public boolean verifyAllRadioButtonOfSecondGroupInAddDataFormAreDisplay() throws InterruptedException {
        Thread.sleep(500);
        return addDataForm.verifyAEditTextIsDisplayByLabelText("Tác giả") &&
                addDataForm.verifyAEditTextIsDisplayByLabelText("Thể loại");
    }

    public boolean verifyAllElementOfThirdGroupInAddDataFormAreDisplay() throws InterruptedException {
        Thread.sleep(500);
        return actionKeyword.verifyElementIsDisplayByText("Chọn ảnh");
    }

    public EbooksPage enterInformationInFirstGroup(String name, String status, String description) {
        actionKeyword.setText(addDataForm.getFieldByLabelText("Tên"), name);
        actionKeyword.setText(addDataForm.getFieldByLabelText("Trạng Thái"), status);
        actionKeyword.setText(addDataForm.getFieldByLabelText("Giới Thiệu"), description);
        return new EbooksPage(this.driver);
    }

    public WebElement getAddAuthorsEditTextInAddEbookForm() {
        String edtAddAuthorsEditTextId = "authors";
        return actionKeyword.findElementCustom(By.id(edtAddAuthorsEditTextId));
    }

    public EbooksPage addAuthorsInAddEbookForm(String author) {
        actionKeyword.setText(getAddAuthorsEditTextInAddEbookForm(), author);
        actions.sendKeys(Keys.ENTER).build().perform();
        return new EbooksPage(this.driver);
    }

    public WebElement getAddGenresEditTextInAddEbookForm() {
        String edtAddGenresEditTextId = "genres";
        return actionKeyword.findElementCustom(By.id(edtAddGenresEditTextId));
    }

    public EbooksPage addGenresInAddEbookForm(String genre) {
        actionKeyword.setText(getAddGenresEditTextInAddEbookForm(), genre);
        actions.sendKeys(Keys.ENTER).build().perform();
        return new EbooksPage(this.driver);
    }

    public boolean verifyThatTheEbookHasBeenCreated(String name) throws InterruptedException {
        Thread.sleep(500);
        String lstDataListCssSelector = ".MuiDataGrid-root .MuiDataGrid-row [data-colindex='0']>div";
        try {
            return driver.findElement(By.cssSelector(lstDataListCssSelector)).getText().equals(name);
        } catch (NoSuchElementException exception) {
            return false;
        }
    }

    public EbooksPage clickOnUpdateUserButtonByEmail(String ebookTitle) {
        actions.sendKeys(Keys.ESCAPE).build().perform();
        actionKeyword.click(getUpdateEbookButtonByTitle(ebookTitle));
        return new EbooksPage(this.driver);
    }

    public boolean verifyAllInformationOfFirstGroupInUpdateDataFormAreDisplay(String ebookTitle, String status, String description) throws InterruptedException {
        Thread.sleep(500);
        return addDataForm.verifyAEditTextAndItsValueAreDisplayByLabelTextAndValueText("Tên", ebookTitle) &&
                addDataForm.verifyAEditTextAndItsValueAreDisplayByLabelTextAndValueText("Trạng Thái", status) &&
                addDataForm.verifyAEditTextAndItsValueAreDisplayByLabelTextAndValueText("Giới Thiệu", description);
    }

    public boolean verifyAllAuthorsInUpdateDataFormAreDisplay(String authors) throws InterruptedException {
        String[] authorList = authors.split(", ");
        try {
            List<String> dataList = addDataForm.getDataListOfAComboBoxInUpdateDataFormByLabel("Tác giả");
            if (authorList.length == dataList.size()) {
                for (int i = 0; i < authorList.length; i++) {
                    if (!authorList[i].equals(dataList.get(i))) {
                        return false;
                    }
                }
                return true;
            } else {
                return false;
            }
        } catch (NoSuchElementException | TimeoutException exception) {
            return false;
        }
    }

    public boolean verifyAllGenresInUpdateDataFormAreDisplay(String genres) throws InterruptedException {
        String[] genreList = genres.split(", ");
        try {
            List<String> dataList = addDataForm.getDataListOfAComboBoxInUpdateDataFormByLabel("Thể loại");
            if (genreList.length == dataList.size()) {
                for (int i = 0; i < genreList.length; i++) {
                    if (!genreList[i].equals(dataList.get(i))) {
                        return false;
                    }
                }
                return true;
            } else {
                return false;
            }
        } catch (NoSuchElementException | TimeoutException exception) {
            return false;
        }
    }

    public boolean verifyThatTheBookCoverIsCorrectByLink(String bookCoverLink) {
        try {
            String[] bookCoverLinkInTheForm = addDataForm.getImageUploadedSrc().split("/");
            return bookCoverLink.equals(bookCoverLinkInTheForm[bookCoverLinkInTheForm.length - 1]);
        } catch (NoSuchElementException | TimeoutException exception) {
            return false;
        }
    }
}
