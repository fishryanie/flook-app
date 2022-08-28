package com.finaltest.selenium.pages.adminpages.books;

import com.finaltest.selenium.pages.adminpages.AdminBasePage;
import com.finaltest.selenium.pages.adminpages.admincomponents.AddDataForm;
import com.finaltest.selenium.pages.adminpages.admincomponents.TableHeaderAndFooter;
import com.finaltest.selenium.pages.adminpages.auth.RolesPage;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class GenresPage extends AdminBasePage {
    TableHeaderAndFooter tableHeaderAndFooter;
    AddDataForm addDataForm;

    public GenresPage(WebDriver driver) {
        super(driver);
        tableHeaderAndFooter = new TableHeaderAndFooter(this.driver);
        addDataForm = new AddDataForm(this.driver);
    }

    public List<String> getDataListByColumnPosition(int position) {
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

    public WebElement getUpdateGenreButtonByRoleName(String genreName) {
        String btnUpdateGenreButtonXpath = "//*[text()='%s']/../parent::div/div[4]//button[2]";
        return actionKeyword.findElementCustom(By.xpath(String.format(btnUpdateGenreButtonXpath, genreName)));
    }

    public WebElement getDeleteGenreButtonByRoleName(String genreName) {
        String btnDeleteGenreButtonXpath = "//*[text()='%s']/../parent::div/div[4]//button[3]";
        return actionKeyword.findElementCustom(By.xpath(String.format(btnDeleteGenreButtonXpath, genreName)));
    }

    public GenresPage clickOnUpdateGenreButtonByGenreName(String genreName) {
        actionKeyword.click(getUpdateGenreButtonByRoleName(genreName));
        return new GenresPage(this.driver);
    }

    public GenresPage clickOnDeleteGenreButtonByRoleName(String genreName) {
        actionKeyword.click(getDeleteGenreButtonByRoleName(genreName));
        return new GenresPage(this.driver);
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
                    verifyColumnCheckboxInColumnBoxIsDisplayByText("Tên loại") &&
                    verifyColumnCheckboxInColumnBoxIsDisplayByText("##");
        } catch (NoSuchElementException exception) {
            return false;
        }
    }

    public boolean verifyAllResultsThatContainTheKeyWorkInFiltersBox(String keyWord) throws InterruptedException {
        Thread.sleep(500);
        for (String result: getDataListByColumnPosition(0)) {
            if (!result.toLowerCase().contains(keyWord.toLowerCase())) {
                return false;
            }
        }
        return true;
    }

    public boolean verifyAllResultsThatEqualTheKeyWorkInFiltersBox(String keyWord) throws InterruptedException {
        Thread.sleep(500);
        for (String result: getDataListByColumnPosition(0)) {
            if (!result.equalsIgnoreCase(keyWord)) {
                return false;
            }
        }
        return true;
    }

    public boolean verifyAllResultsThatStartWithTheKeyWorkInFiltersBox(String keyWord) throws InterruptedException {
        Thread.sleep(500);
        for (String result: getDataListByColumnPosition(0)) {
            if (!result.startsWith(keyWord)) {
                return false;
            }
        }
        return true;
    }

    public boolean verifyAllResultsThatEndWithTheKeyWorkInFiltersBox(String keyWord) throws InterruptedException {
        Thread.sleep(500);
        for (String result: getDataListByColumnPosition(0)) {
            if (!result.endsWith(keyWord)) {
                return false;
            }
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

    public GenresPage enterInformationInAddDataForm(String genreName) {
        actionKeyword.setText(addDataForm.getFieldByLabelText("Tên loại"), genreName);
        return new GenresPage(this.driver);
    }

    public boolean verifyAllEditTextOfAddDataFormAreDisplay() throws InterruptedException {
        Thread.sleep(500);
        return addDataForm.verifyAEditTextIsDisplayByLabelText("Tên loại");
    }

    public boolean verifyThatTheGenreHasBeenCreated(String name) throws InterruptedException {
        Thread.sleep(500);
        String lstDataListCssSelector = ".MuiDataGrid-root .MuiDataGrid-row [data-colindex='0']>div";
        try {
            return driver.findElement(By.cssSelector(lstDataListCssSelector)).getText().equals(name);
        } catch (NoSuchElementException exception) {
            return false;
        }
    }

    public boolean verifyAllInformationInUpdateDataFormAreDisplay(String genreName) throws InterruptedException {
        Thread.sleep(500);
        return addDataForm.verifyAEditTextAndItsValueAreDisplayByLabelTextAndValueText("Tên loại", genreName);
    }
}