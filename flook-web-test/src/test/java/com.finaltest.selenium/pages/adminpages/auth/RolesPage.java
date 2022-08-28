package com.finaltest.selenium.pages.adminpages.auth;

import com.finaltest.selenium.pages.adminpages.admincomponents.AddDataForm;
import com.finaltest.selenium.pages.flookpages.BasePage;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class RolesPage extends BasePage {
    AddDataForm addDataForm;

    public RolesPage(WebDriver driver) {
        super(driver);
        addDataForm = new AddDataForm(this.driver);
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }

    public List<String> getDataListByColumnPosition(int position) {
        String lstDataListCssSelector = ".MuiDataGrid-root .MuiDataGrid-row [data-colindex='%s']>div";
        List<WebElement> elementList = new ArrayList<>();
        List<String> dataList = new ArrayList<>();
        try {
            elementList = actionKeyword.findElementsCustom(
                    By.cssSelector(String.format(lstDataListCssSelector, position))
            );
            dataList = new ArrayList<>();
            for (WebElement element : elementList) {
                dataList.add(element.getText());
            }
            return dataList;
        } catch (TimeoutException ignored) {
            return dataList;
        }
    }

    public WebElement getUpdateRoleButtonByRoleName(String roleName) {
        String btnUpdateRoleButtonXpath = "//*[text()='%s']/../parent::div/div[4]//button[2]";
        return actionKeyword.findElementCustom(By.xpath(String.format(btnUpdateRoleButtonXpath, roleName)));
    }

    public WebElement getDeleteRoleButtonByRoleName(String roleName) {
        String btnDeleteRoleButtonXpath = "//*[text()='%s']/../parent::div/div[4]//button[3]";
        return actionKeyword.findElementCustom(By.xpath(String.format(btnDeleteRoleButtonXpath, roleName)));
    }

    public WebElement getOpenCloseFeatureCheckboxByFeatureName(String featureName) {
        String chkOpenCloseFeatureCheckboxXpath = "//*[contains(text(), '%s')]/parent::div/following-sibling::span[1]";
        return actionKeyword.findElementCustom(By.xpath(String.format(chkOpenCloseFeatureCheckboxXpath, featureName)));
    }

    public RolesPage clickOnUpdateRoleButtonByRoleName(String roleName) {
        actionKeyword.click(getUpdateRoleButtonByRoleName(roleName));
        return new RolesPage(this.driver);
    }

    public RolesPage clickOnDeleteRoleButtonByRoleName(String roleName) {
        actionKeyword.click(getDeleteRoleButtonByRoleName(roleName));
        return new RolesPage(this.driver);
    }

    public RolesPage clickOnOpenCloseFeatureCheckboxByFeatureName(String featureName) {
        actionKeyword.click(getOpenCloseFeatureCheckboxByFeatureName(featureName));
        return new RolesPage(this.driver);
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
                    verifyColumnCheckboxInColumnBoxIsDisplayByText("Mô tả") &&
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

    public boolean verifyAllEditTextOfAddDataFormAreDisplay() throws InterruptedException {
        Thread.sleep(500);
        return addDataForm.verifyAEditTextIsDisplayByLabelText("Tên") &&
                addDataForm.verifyAEditTextIsDisplayByLabelText("Mô tả");
    }

    public RolesPage enterInformationInAddDataForm(String roleName, String description) {
        actionKeyword.setText(addDataForm.getFieldByLabelText("Tên"), roleName);
        actionKeyword.setText(addDataForm.getFieldByLabelText("Mô tả"), description);
        return new RolesPage(this.driver);
    }

    public boolean verifyThatTheRoleHasBeenCreated(String name) throws InterruptedException {
        Thread.sleep(500);
        String lstDataListCssSelector = ".MuiDataGrid-root .MuiDataGrid-row [data-colindex='0']>div";
        try {
            return driver.findElement(By.cssSelector(lstDataListCssSelector)).getText().equals(name);
        } catch (NoSuchElementException exception) {
            return false;
        }
    }

    public boolean verifyAllInformationOfUpdateDataFormAreDisplay(String roleName, String description) throws InterruptedException {
        Thread.sleep(500);
        return addDataForm.verifyAEditTextAndItsValueAreDisplayByLabelTextAndValueText("Tên", roleName) &&
                addDataForm.verifyAEditTextAndItsValueAreDisplayByLabelTextAndValueText("Mô tả", description);
    }
}
