package com.finaltest.selenium.pages.adminpages;

import com.finaltest.selenium.keyword.ActionKeyword;
import com.finaltest.selenium.pages.adminpages.auth.RolesPage;
import com.finaltest.selenium.pages.adminpages.auth.UsersPage;
import com.finaltest.selenium.pages.adminpages.books.AuthorsPage;
import com.finaltest.selenium.pages.adminpages.books.EbooksPage;
import com.finaltest.selenium.pages.adminpages.books.GenresPage;
import com.finaltest.selenium.pages.adminpages.dashboard.DashBoardPage;
import com.finaltest.selenium.pages.adminpages.reviews.CommentsPage;
import com.finaltest.selenium.pages.adminpages.reviews.ReviewsPage;
import com.finaltest.selenium.pages.flookpages.ChapterPage;
import com.finaltest.selenium.pages.flookpages.HomePage;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class AdminBasePage {
    public WebDriver driver;
    public ActionKeyword actionKeyword;
    public Actions actions;

    public AdminBasePage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(this.driver, this);
        this.actionKeyword = new ActionKeyword(driver);
        actions = new Actions(this.driver);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @FindBy(css = "span a.MuiButtonBase-root")
    public WebElement imgLogo;

    @FindBy(css = "span.MuiBox-root~button")
    public WebElement btnMenuButton;

    @FindBy(css = ".MuiPaper-elevation.MuiDrawer-paper")
    public WebElement mnuLeftMenu;

    @FindBy(id = "input-search-header")
    public WebElement edtSearch;

    @FindBy(css = "#input-search-header~div>button")
    public WebElement btnSearchSetting;

    @FindBy(xpath = "//*[contains(@class, 'icon-tabler-bell')]/../parent::button")
    public WebElement btnNotificationButton;

    @FindBy(css = ".MuiButtonBase-root.MuiChip-root")
    public WebElement btnUserSettingButton;

    @FindBy(id = "upload_file")
    public WebElement btnUploadImage;

    public void closeBox() {
        actions.sendKeys(Keys.ESCAPE).build().perform();
    }

    public HomePage clickOnHeaderLogo() {
        actionKeyword.click(imgLogo);
        return new HomePage(this.driver);
    }

    public WebElement getUserSettingBoxSearchEditText() {
        String edtUserSettingBoxSearchEditTextId = "input-search-profile";
        return actionKeyword.findElementCustom(By.id(edtUserSettingBoxSearchEditTextId));
    }

    public WebElement getCheckboxTitleInColumnBoxByText(String checkBoxTitle) {
        String txtCheckboxTitleInColumnBox = "//span[contains(text(),'%s')]";
        return actionKeyword.findElementCustom(By.xpath(String.format(txtCheckboxTitleInColumnBox, checkBoxTitle)));
    }

    public void clickOnMenuButton() {
        actionKeyword.click(btnMenuButton);
    }

    public void enterKeyWordInSearchEditText(String keyWord) {
        actionKeyword.setText(edtSearch, keyWord);
        actions.sendKeys(Keys.ENTER).build().perform();
    }

    public void clickOnNotificationButton() {
        actionKeyword.click(btnNotificationButton);
    }

    public void clickOnUserSettingButton() {
        actionKeyword.click(btnUserSettingButton);
    }

    public void clickOnUserSettingBoxSearchEditText() {
        actionKeyword.click(getUserSettingBoxSearchEditText());
    }

    public void clickOnAccountSettingButtonOnAccountSettingBox() {
        try {
            actionKeyword.clickOnElementByText("Cài đặt tài khoản");
        } catch (TimeoutException ignored) {}
    }

    public void clickOnLogoutButtonOnAccountSettingBox() {
        try {
            actionKeyword.clickOnElementByText("Đăng xuất");
        } catch (TimeoutException ignored) {}
    }

    public UsersPage clickOnUserTabInLeftMenu() {
        actionKeyword.clickOnElementByText("Bộ Dữ Liệu");
        actionKeyword.clickOnElementByText("Người dùng");
        actionKeyword.click(actionKeyword.findElementsByText("Người dùng").get(1));
        return new UsersPage(this.driver);
    }

    public RolesPage clickOnRolesTabInLeftMenu() {
        actionKeyword.clickOnElementByText("Bộ Dữ Liệu");
        actionKeyword.clickOnElementByText("Người dùng");
        actionKeyword.clickOnElementByText("Vai trò");
        return new RolesPage(this.driver);
    }

    public EbooksPage clickOnEbooksTabInLeftMenu() {
        actionKeyword.clickOnElementByText("Bộ Dữ Liệu");
        actionKeyword.clickOnElementByText("Truyện");
        actionKeyword.clickOnElementByText("Truyện tranh");
        return new EbooksPage(this.driver);
    }

    public AuthorsPage clickOnAuthorsTabInLeftMenu() {
        actionKeyword.clickOnElementByText("Bộ Dữ Liệu");
        actionKeyword.clickOnElementByText("Truyện");
        actionKeyword.clickOnElementByText("Tác giả");
        return new AuthorsPage(this.driver);
    }

    public GenresPage clickOnGenresTabInLeftMenu() {
        actionKeyword.clickOnElementByText("Bộ Dữ Liệu");
        actionKeyword.clickOnElementByText("Truyện");
        actionKeyword.clickOnElementByText("Thể loại");
        return new GenresPage(this.driver);
    }

    public ChapterPage clickOnChaptersTabInLeftMenu() {
        actionKeyword.clickOnElementByText("Bộ Dữ Liệu");
        actionKeyword.clickOnElementByText("Truyện");
        actionKeyword.clickOnElementByText("Chapters");
        return new ChapterPage(this.driver);
    }

    public ReviewsPage clickOnReviewsTabInLeftMenu() {
        actionKeyword.clickOnElementByText("Bộ Dữ Liệu");
        actionKeyword.clickOnElementByText("Đánh Giá");
        actionKeyword.clickOnElementByFullText("Đánh giá");
        return new ReviewsPage(this.driver);
    }

    public CommentsPage clickOnCommentsTabInLeftMenu() {
        actionKeyword.clickOnElementByText("Bộ Dữ Liệu");
        actionKeyword.clickOnElementByText("Đánh Giá");
        actionKeyword.clickOnElementByText("Bình luận");
        return new CommentsPage(this.driver);
    }

    public DashBoardPage clickOnDashboardTabInLeftMenu() {
        actionKeyword.clickOnElementByText("Thống kê");
        return new DashBoardPage(this.driver);
    }

    public void clickOnCheckboxInColumnBoxByColumnName(String columnName) {
        actionKeyword.click(getCheckboxTitleInColumnBoxByText(columnName));
    }

    public boolean leftMenuIsDisplay() {
        String leftMenuStyleText = mnuLeftMenu.getAttribute("style");
        return !leftMenuStyleText.contains("visibility: hidden");
    }

    public boolean dataContainKeywordIsDisplay(String keyWord) throws InterruptedException {
        Thread.sleep(500);
        try {
            return actionKeyword.verifyElementIsDisplayByText(keyWord) ||
                    actionKeyword.verifyElementIsDisplayByText("Chức năng đang cập nhật!");
        } catch (NoSuchElementException exception) {
            return false;
        }
    }

    public boolean messageIsDisplay(String message) throws InterruptedException {
        Thread.sleep(500);
        try {
            return actionKeyword.verifyElementIsDisplayByText(message);
        } catch (NoSuchElementException exception) {
            return false;
        }
    }

    public boolean allElementsInUserSettingBoxAreDisplay() throws InterruptedException {
        Thread.sleep(500);
        try {
            return actionKeyword.verifyElementIsDisplayByText("Cài đặt tài khoản") &&
                    actionKeyword.verifyElementIsDisplayByText("Đăng xuất") &&
                    getUserSettingBoxSearchEditText().isDisplayed();
        } catch (NoSuchElementException exception) {
            return false;
        }
    }

    public boolean verifyColumnIsDisplayByText(String columnTitle) throws InterruptedException {
        Thread.sleep(500);
        String pnlColumnTitleXpath = "//div[contains(@class, 'MuiDataGrid-columnHeaderTitleContainerContent')]/div[text()='%s']";
        String chkCheckAllCheckboxCssSelector = "[aria-label='Select all rows']";
        try {
            if (columnTitle.equals("Checkbox selection")) {
                return driver.findElement(By.cssSelector(chkCheckAllCheckboxCssSelector)).isDisplayed();
            } else {
                return driver.findElement(By.xpath(String.format(pnlColumnTitleXpath, columnTitle))).isDisplayed();
            }
        } catch (NoSuchElementException exception) {
            return false;
        }
    }

    public void uploadImageInAddDataForm(String absolutePath) throws InterruptedException {
        Thread.sleep(500);
        actionKeyword.uploadImage(btnUploadImage, absolutePath);
        Thread.sleep(2500);
    }
}