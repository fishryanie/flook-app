package com.finaltest.selenium.pages.adminpages.admincomponents;

import com.finaltest.selenium.pages.adminpages.auth.UsersPage;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class TableHeaderAndFooter extends BaseComponent{
    public TableHeaderAndFooter(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = "[data-testid='MoreVertSharpIcon']")
    public WebElement btnTableHeaderMoreOptionsIcon;

    @FindBy(xpath = "//*[@data-testid='AddIcon']/../parent::li")
    public WebElement btnAddDataIcon;

    @FindBy(xpath = "//*[@data-testid='MoreHorizIcon']/../parent::li")
    public WebElement btnInsideMoreOptionsIcon;

    @FindBy(css = "[data-testid='MoreVertSharpIcon']")
    public WebElement chkTitleLineCheckAll;

    @FindBy(css = "[placeholder='Column title']")
    public WebElement edtShowHideColumnSearchBox;

    @FindBy(css = "[aria-haspopup='listbox']")
    public WebElement ddlNumberOfRows;

    @FindBy(css = "[aria-label='Go to previous page']")
    public WebElement btnGoToPreviousPage;

    @FindBy(css = "[aria-label='Go to next page']")
    public WebElement btnGoToNextPage;

    @FindBy(css = ".MuiDataGrid-root")
    public WebElement tblDataList;

    String txtNumberOfRowsSelectedXpath = "//*[contains(text(), ' row selected']";

    public WebElement getColumnHeaderMoreOptionsIconByColumnTitle(String columnTitle) {
        String btnColumnHeaderMoreOptionsIconXpath = "//*[contains(text(),'%s')]/../parent::div/following-sibling::div/button";
        return actionKeyword.findElementCustom(By.xpath(String.format(btnColumnHeaderMoreOptionsIconXpath, columnTitle)));
    }

    public WebElement getShowHideColumnCheckboxByColumnTitle(String columnTitle) {
        String chkShowHideColumnCheckboxXpath = "//span[contains(text(),'%s')]";
        return actionKeyword.findElementCustom(By.xpath(String.format(chkShowHideColumnCheckboxXpath, columnTitle)));
    }

    public WebElement getCloseButtonInFilterBox() {
        String btnCloseButtonCssSelector = "[data-testid='CloseIcon']";
        return actionKeyword.findElementCustom(By.cssSelector(btnCloseButtonCssSelector));
    }

    public WebElement getFirstColumnInFilterBox() {
        String ddlColumnTitle = ".MuiDataGrid-filterForm div:nth-child(3) select";
        return actionKeyword.findElementCustom(By.cssSelector(ddlColumnTitle));
    }

    public String getValueOfFirstColumnInFilterBox() {
        Select select = new Select(getFirstColumnInFilterBox());
        return select.getFirstSelectedOption().getText();
    }

    public List<WebElement> getAllOptionsOfFirstColumnInFilterBox() {
        String btnCloseButtonCssSelector = ".MuiDataGrid-filterForm div:nth-child(3) select option";
        return actionKeyword.findElementsCustom(By.cssSelector(btnCloseButtonCssSelector));
    }

    public WebElement getSecondColumnInFilterBox() {
        String ddlFilteredColumn = ".MuiDataGrid-filterForm div:nth-child(4) select";
        return actionKeyword.findElementCustom(By.cssSelector(ddlFilteredColumn));
    }

    public String getValueOfSecondColumnInFilterBox() {
        Select select = new Select(getSecondColumnInFilterBox());
        return select.getFirstSelectedOption().getText();
    }

    public List<WebElement> getAllOptionsOfSecondColumnInFilterBox() {
        String btnCloseButtonCssSelector = ".MuiDataGrid-filterForm div:nth-child(4) select option";
        return actionKeyword.findElementsCustom(By.cssSelector(btnCloseButtonCssSelector));
    }

    public WebElement getLastColumnInFilterBox() {
        String edtFilterKeyword = ".MuiDataGrid-filterForm div:nth-child(5) input";
        return actionKeyword.findElementCustom(By.cssSelector(edtFilterKeyword));
    }

    public String getValueOfLastColumnInFilterBox() {
        return getLastColumnInFilterBox().getAttribute("value");
    }

    public List<WebElement> getAllResultsInColumnBox() {
        String lstResultListCssSelector = "div.MuiDataGrid-panelContent span.MuiTypography-root";
        return actionKeyword.findElementsCustom(By.cssSelector(lstResultListCssSelector));
    }

    public List<WebElement> getAllCheckboxInColumnBox() {
        String lstCheckboxListCssSelector = "div.MuiDataGrid-columnsPanel span.MuiButtonBase-root";
        return actionKeyword.findElementsCustom(By.cssSelector(lstCheckboxListCssSelector));
    }

    public List<WebElement> getAllColumnTitlePanel() throws InterruptedException {
        Thread.sleep(500);
        String lstColumnTitlePanelCssSelector = "div.MuiDataGrid-columnHeaderTitleContainerContent";
        return driver.findElements(By.cssSelector(lstColumnTitlePanelCssSelector));
    }

    public int getNumberOfRowsSelectedText() {
        return Integer.parseInt(actionKeyword.findElementCustom(
                By.xpath(txtNumberOfRowsSelectedXpath)
        ).getText().replace(" row selected", ""));
    }

    public void enterColumnTitleInShowHideColumnSearchBoxEditText(String columnTitle) {
        actionKeyword.setText(edtShowHideColumnSearchBox, columnTitle);
    }

    public void clickOnShowHideColumnCheckboxByColumnTitle(String columnTitle) {
        actionKeyword.click(getShowHideColumnCheckboxByColumnTitle(columnTitle));
    }

    public void clickCloseButtonInFilterBox() {
        getCloseButtonInFilterBox().click();
    }

    public void selectOperationInFilterBox(String operation) {
        Select select = new Select(getSecondColumnInFilterBox());
        select.selectByVisibleText(operation);
    }

    public void selectColumnInFilterBox(String columnTitle) {
        Select select = new Select(getFirstColumnInFilterBox());
        select.selectByVisibleText(columnTitle);
    }

    public void enterKeywordInFilterBox(String keyWord) {
        actionKeyword.setText(getLastColumnInFilterBox(), keyWord);
    }

    public void clickOnTableHeaderMoreOptionsIcon() {
        actionKeyword.click(btnTableHeaderMoreOptionsIcon);
    }

    public void clickOnTitleLineCheckAllCheckbox() {
        actionKeyword.click(chkTitleLineCheckAll);
    }

    public void clickOnAddDataButton() {
        actionKeyword.click(btnAddDataIcon);
    }

    public void clickOnColumnButton() {
        actionKeyword.clickOnElementByText("Columns");
    }

    public void clickOnHideAllButton() {
        actionKeyword.clickOnElementByText("Hide all");
    }

    public void clickOnShowAllButton() {
        actionKeyword.clickOnElementByText("Show all");
    }

    public void clickOnFiltersButton() {
        actionKeyword.clickOnElementByText("Filters");
    }

    public void clickOnDensityButton() {
        actionKeyword.clickOnElementByText("Density");
    }

    public UsersPage clickOnColumnHeaderMoreOptionsIconByColumnTitle(String columnTitle) {
        moveToColumnTitle(columnTitle);
        actionKeyword.click(actionKeyword.findElementByText(columnTitle));
        return new UsersPage(this.driver);
    }

    public String checkDisplayModeOfList() {
        String classOfDataListTable = tblDataList.getAttribute("class");
        if (classOfDataListTable.contains("densityCompact")) {
            return "Compact";
        } else if (classOfDataListTable.contains("densityStandard")) {
            return "Standard";
        } else if (classOfDataListTable.contains("densityComfortable")) {
            return "Comfortable";
        } else {
            return "";
        }
    }

    public UsersPage moveToColumnTitle(String columnTitle) {
        actions.moveToElement(actionKeyword.findElementByText(columnTitle));
        return new UsersPage(this.driver);
    }

    public UsersPage selectNumberOfRowsInAPage(String option) {
        Select select = new Select(ddlNumberOfRows);
        select.selectByVisibleText(option);
        return new UsersPage(this.driver);
    }

    public boolean verifyColumnHeaderMoreOptionsIconIsDisplayByColumnTitle(String columnTitle) throws InterruptedException {
        Thread.sleep(500);
        try {
            return getColumnHeaderMoreOptionsIconByColumnTitle(columnTitle).getAttribute("aria-expanded").equals("true");
        } catch (Exception exception) {
            return false;
        }
    }

    public boolean verifyShowHideColumnCheckboxIsChecked(String columnTitle) throws InterruptedException{
        Thread.sleep(500);
        String chkShowHideColumnCheckboxFrameXpath = "//*[contains(text(),'%s')]/preceding-sibling::span/span[contains(@class,'Mui-checked')]";
        try {
            return driver.findElement(By.xpath(String.format(chkShowHideColumnCheckboxFrameXpath, columnTitle))).isDisplayed();
        } catch (NoSuchElementException exception) {
            return false;
        }
    }

    public boolean verifyFilterFormIsDisplay(String columnTitle) throws InterruptedException{
        Thread.sleep(500);
        String frmFilterFormCssSelector = ".MuiDataGrid-filterForm";
        try {
            return driver.findElement(By.xpath(frmFilterFormCssSelector)).isDisplayed();
        } catch (NoSuchElementException exception) {
            return false;
        }
    }

    public boolean verifyLastColumnInFilterBoxIsDisplay() throws InterruptedException {
        Thread.sleep(500);
        String edtFilterKeyword = ".MuiDataGrid-filterForm div:nth-child(5) input";
        try {
            return driver.findElement(By.cssSelector(edtFilterKeyword)).isDisplayed();
        } catch (NoSuchElementException exception) {
            return false;
        }
    }

    public boolean verifyNumberOfRowsSelectedTextIsDisplay() throws InterruptedException {
        Thread.sleep(500);
        try {
            return driver.findElement(By.xpath(txtNumberOfRowsSelectedXpath)).isDisplayed();
        } catch (NoSuchElementException exception) {
            return false;
        }
    }

    public String getPageName() throws InterruptedException {
        Thread.sleep(500);
        btnTableHeaderMoreOptionsIcon.click();
        Thread.sleep(500);
        return btnAddDataIcon.getText().replace("Thêm ", "");
    }

    public boolean verifyIsOnAPageByPageName(String pageName) throws InterruptedException {
        return getPageName().equals(pageName);
    }

    public boolean verifyIsOnAPageByPageName2(String pageName) throws InterruptedException {
        Thread.sleep(500);
        String[] urlTexts = driver.getCurrentUrl().split("/");
        return urlTexts[urlTexts.length-1].equals(pageName);
    }

    public boolean verifyIsOnDashboardPage() {
        return actionKeyword.verifyManyElementsAreDisplayByText("chart");
    }

    public boolean verifyColumnBoxSearchEditTextIsDisplay() {
        try {
            return edtShowHideColumnSearchBox.isDisplayed();
        } catch (NoSuchElementException exception) {
            return false;
        }
    }

    public boolean verifyColumnBoxHideAndShowAllButtonIsDisplay() {
        try {
            return actionKeyword.verifyElementIsDisplayByText("Hide all") &&
                    actionKeyword.verifyElementIsDisplayByText("Show all");
        } catch (NoSuchElementException exception) {
            return false;
        }
    }

    public boolean verifyAllResultsInColumnBoxMatchTheKeyWord(String keyWord) {
        for (WebElement element: getAllResultsInColumnBox()) {
            if (!element.getText().toLowerCase().contains(keyWord.toLowerCase())) {
                return false;
            }
        }
        return true;
    }

    public boolean verifyAllCheckboxesInColumnBoxUnchecked() {
        for (WebElement element: getAllCheckboxInColumnBox()) {
            if (element.getAttribute("class").contains("Mui-checked")) {
                return false;
            }
        }
        return true;
    }

    public boolean verifyAllCheckboxesInColumnBoxChecked() {
        for (WebElement element: getAllCheckboxInColumnBox()) {
            if (!element.getAttribute("class").contains("Mui-checked")) {
                return false;
            }
        }
        return true;
    }

    public boolean verifyAllColumnsAreNotDisplay() throws InterruptedException {
        try {
            return getAllColumnTitlePanel().size() == 0;
        } catch (NoSuchElementException exception) {
            return false;
        }
    }

    public boolean verifyAllColumnsAreDisplay(int size) throws InterruptedException {
        JavascriptExecutor executor = (JavascriptExecutor)driver;
        executor.executeScript("document.body.style.zoom = '0.5'");
        try {
            return getAllColumnTitlePanel().size() == size;
        } catch (NoSuchElementException exception) {
            return false;
        }
    }

    public boolean closeButtonInFiltersBoxIsDisplay() throws InterruptedException {
        Thread.sleep(500);
        try {
            return getCloseButtonInFilterBox().isDisplayed();
        } catch (NoSuchElementException exception) {
            return false;
        }
    }

    public boolean verifyFirstColumnInFiltersBoxIsDisplay() {
        try {
            return getFirstColumnInFilterBox().isDisplayed();
        } catch (NoSuchElementException exception) {
            return false;
        }
    }

    public boolean verifySecondColumnInFiltersBoxIsDisplay() {
        try {
            return getSecondColumnInFilterBox().isDisplayed();
        } catch (NoSuchElementException exception) {
            return false;
        }
    }

    public boolean verifyLastColumnInFiltersBoxIsDisplay() {
        try {
            return getLastColumnInFilterBox().isDisplayed();
        } catch (NoSuchElementException exception) {
            return false;
        }
    }

    public boolean verifyFirstColumnInFiltersBoxHaveFullOptions() throws InterruptedException {
        return (getAllColumnTitlePanel().size() - 2) == getAllOptionsOfFirstColumnInFilterBox().size();
    }

    public boolean verifySecondColumnInFiltersBoxHaveFullOptions() {
        return getAllOptionsOfSecondColumnInFilterBox().size() == 6;
    }

    public boolean verifyTheFirstDisplayOptionIsDisplay() {
        try {
            return actionKeyword.verifyElementIsDisplayByText("Compact");
        } catch (NoSuchElementException exception) {
            return false;
        }
    }

    public boolean verifyTheSecondDisplayOptionIsDisplay() {
        try {
            return actionKeyword.verifyElementIsDisplayByText("Standard");
        } catch (NoSuchElementException exception) {
            return false;
        }
    }

    public boolean verifyTheThirdDisplayOptionIsDisplay() {
        try {
            return actionKeyword.verifyElementIsDisplayByText("Comfortable");
        } catch (NoSuchElementException exception) {
            return false;
        }
    }

    public boolean verifyTheFirstOptionInMoreOptionsIconIsDisplay() {
        try {
            return btnAddDataIcon.isDisplayed();
        } catch (NoSuchElementException exception) {
            return false;
        }
    }

    public boolean verifyTheSecondOptionInMoreOptionsIconIsDisplay() {
        try {
            return actionKeyword.verifyElementIsDisplayByText("Xóa nhiều");
        } catch (NoSuchElementException exception) {
            return false;
        }
    }

    public boolean verifyTheThirdOptionInMoreOptionsIconIsDisplay() {
        try {
            return btnInsideMoreOptionsIcon.isDisplayed();
        } catch (NoSuchElementException exception) {
            return false;
        }
    }
}