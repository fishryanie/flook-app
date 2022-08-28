package com.finaltest.selenium.pages.adminpages.books;

import com.finaltest.selenium.pages.adminpages.AdminBasePage;
import com.finaltest.selenium.pages.adminpages.admincomponents.AddDataForm;
import com.finaltest.selenium.pages.adminpages.admincomponents.TableHeaderAndFooter;
import com.finaltest.selenium.pages.adminpages.auth.UsersPage;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class AuthorsPage extends AdminBasePage {
    TableHeaderAndFooter tableHeaderAndFooter;
    AddDataForm addDataForm;

    public AuthorsPage(WebDriver driver) {
        super(driver);
        tableHeaderAndFooter = new TableHeaderAndFooter(this.driver);
        addDataForm = new AddDataForm(this.driver);
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }

    @FindBy(css = ".MuiDataGrid-root .MuiDataGrid-row [data-colindex='1']>div")
    public List<WebElement> lstOrdinalNumberList;

    @FindBy(css = ".MuiDataGrid-root .MuiDataGrid-row [data-colindex='3']>div")
    public List<WebElement> lstAuthorNameList;

    @FindBy(css = ".MuiDataGrid-root .MuiDataGrid-row [data-colindex='4']")
    public List<WebElement> lstLicenseList;

    public WebElement getUpdateAuthorButtonByAuthorName(String authorName) {
        String btnUpdateAuthorButtonXpath = "//*[contains(text(),'%s')]/../parent::div/div[last()-1]//button[2]";
        return actionKeyword.findElementCustom(By.xpath(String.format(btnUpdateAuthorButtonXpath, authorName)));
    }

    public WebElement getDeleteAuthorButtonByAuthorName(String authorName) {
        String btnDeleteAuthorButtonXpath = "//*[contains(text(),'%s')]/../parent::div/div[last()-1]//button[3]";
        return actionKeyword.findElementCustom(By.xpath(String.format(btnDeleteAuthorButtonXpath, authorName)));
    }

    public WebElement getAddLicenseDropdownList() {
        String ddlAddLicenseId = "license";
        return actionKeyword.findElementCustom(By.id(ddlAddLicenseId));
    }

    public AuthorsPage clickOnUpdateAuthorButtonByAuthorName(String authorName) {
        actionKeyword.click(getUpdateAuthorButtonByAuthorName(authorName));
        return new AuthorsPage(this.driver);
    }

    public AuthorsPage clickOnDeleteAuthorButtonByAuthorName(String authorName) {
        actionKeyword.click(getDeleteAuthorButtonByAuthorName(authorName));
        return new AuthorsPage(this.driver);
    }

    public AuthorsPage addLicenseInAddAuthorForm(String license) {
        actionKeyword.setText(getAddLicenseDropdownList(), license);
        actions.sendKeys(Keys.ENTER).build().perform();
        return new AuthorsPage(this.driver);
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
                    verifyColumnCheckboxInColumnBoxIsDisplayByText("Avatar") &&
                    verifyColumnCheckboxInColumnBoxIsDisplayByText("Tên") &&
                    verifyColumnCheckboxInColumnBoxIsDisplayByText("License") &&
                    verifyColumnCheckboxInColumnBoxIsDisplayByText("##");
        } catch (NoSuchElementException exception) {
            return false;
        }
    }

    public List<String> getDataListByColumnPosition(int position) {
        String lstDataListCssSelector = ".MuiDataGrid-root .MuiDataGrid-row [data-colindex='%s']>div";
        List<String> dataList = new ArrayList<>();
        try {
            List<WebElement> elementList = actionKeyword.findElementsCustom(
                    By.cssSelector(String.format(lstDataListCssSelector, position))
            );
            for (WebElement element : elementList) {
                dataList.add(element.getText());
            }
            return dataList;
        } catch (TimeoutException | NoSuchElementException exception) {
            return dataList;
        }
    }

    public boolean verifyAllResultsThatContainTheKeyWorkInFiltersBox(String keyWord) throws InterruptedException {
        Thread.sleep(500);
        try {
            for (String result: getDataListByColumnPosition(0)) {
                if (!result.toLowerCase().contains(keyWord.toLowerCase())) {
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
            for (String result: getDataListByColumnPosition(0)) {
                if (!result.equalsIgnoreCase(keyWord)) {
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
            for (String result: getDataListByColumnPosition(0)) {
                if (!result.startsWith(keyWord)) {
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
            for (String result: getDataListByColumnPosition(0)) {
                if (!result.endsWith(keyWord)) {
                    return false;
                }
            }
        } catch (TimeoutException exception) {
            return false;
        }
        return true;
    }

    public boolean verifyAllResultsThatIsEmpty() throws InterruptedException {
        Thread.sleep(500);
        for (String result: getDataListByColumnPosition(0)) {
            if (!result.isEmpty()) {
                return false;
            }
        }
        return true;
    }

    public boolean verifyAllResultsThatIsNotEmpty() throws InterruptedException {
        Thread.sleep(500);
        for (String result: getDataListByColumnPosition(0)) {
            if (result.isEmpty()) {
                return false;
            }
        }
        return true;
    }

    public boolean verifyAllEditTextOfFirstGroupInAddDataFormAreDisplay() throws InterruptedException {
        Thread.sleep(500);
        return addDataForm.verifyAEditTextIsDisplayByLabelText("Tên");
    }

    public boolean verifyAllElementOfSecondGroupInAddDataFormAreDisplay() throws InterruptedException {
        Thread.sleep(500);
        return addDataForm.verifyAEditTextIsDisplayByLabelText("License");
    }

    public AuthorsPage enterInformationInFirstGroup(String authorName) {
        actionKeyword.setText(addDataForm.getFieldByLabelText("Tên"), authorName);
        return new AuthorsPage(this.driver);
    }

    public boolean verifyThatTheAuthorHasBeenCreated(String authorName) throws InterruptedException {
        Thread.sleep(500);
        String lstDataListCssSelector = ".MuiDataGrid-root .MuiDataGrid-row [data-colindex='0']>div";
        try {
            return driver.findElement(By.cssSelector(lstDataListCssSelector)).getText().equals(authorName);
        } catch (NoSuchElementException exception) {
            return false;
        }
    }

    public boolean verifyAllInformationOfFirstGroupInUpdateDataFormAreDisplay(String authorName) throws InterruptedException {
        Thread.sleep(500);
        return addDataForm.verifyAEditTextAndItsValueAreDisplayByLabelTextAndValueText("Tên", authorName);
    }

    public boolean verifyAllInformationOfSecondGroupInUpdateDataFormAreDisplay(String licenses) throws InterruptedException {
        String[] licenseList = licenses.split(", ");
        try {
            List<String> dataList = addDataForm.getDataListOfAComboBoxInUpdateDataFormByLabel("License");
            if (licenseList.length == dataList.size()) {
                for (int i = 0; i < licenseList.length; i++) {
                    if (!licenseList[i].equals(dataList.get(i))) {
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

    public boolean verifyThatTheAvatarIsCorrectByLink(String avatarLink) {
        try {
            String[] avatarLinkInTheForm = addDataForm.getImageUploadedSrc().split("/");
            return avatarLink.equals(avatarLinkInTheForm[avatarLinkInTheForm.length - 1]);
        } catch (NoSuchElementException | TimeoutException exception) {
            return false;
        }
    }
}
