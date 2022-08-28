package com.finaltest.selenium.pages.flookpages;

import com.finaltest.selenium.keyword.ActionKeyword;
import com.finaltest.selenium.pages.flookpages.flookcomponents.menus.Menu;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BasePage {
    public WebDriver driver;
    public Menu menu;
    public ActionKeyword actionKeyword;
    public Actions actions;

    public BasePage(WebDriver driver){
        this.driver = driver;
        menu = new Menu(driver);
        PageFactory.initElements(this.driver, this);
        this.actionKeyword = new ActionKeyword(driver);
        actions = new Actions(this.driver);
    }

    /* Ảnh logo ở đầu trang. */
    @FindBy(css = "a.logo")
    public WebElement imgHeaderLogo;

    /* Khung nhập từ khóa trong thanh công cụ tìm kiếm ở đầu trang. */
    @FindBy(css = "form.search-box>input")
    public WebElement edtHeaderKeyWord;

    /* Icon (nút) search trong thanh công cụ tìm kiếm ở đầu trang. */
    @FindBy(css = "i.bx-search-alt-2")
    public WebElement imgHeaderSearchIcon;

    /* Icon (nút) menu ở đầu trang. */
    @FindBy(css = ".MuiButtonBase-root.css-1n5sfnv-MuiButtonBase-root")
    public WebElement btnHeaderMenuButton;

    /* Icon (nút) thông báo ở đầu trang. */
    @FindBy(css = ".MuiButtonBase-root.css-1p2w8fz-MuiButtonBase-root")
    public WebElement btnHeaderNotificationButton;

    /* Icon (nút) tài khoản ở đầu trang. */
    @FindBy(css = ".MuiBadge-root>div")
    public WebElement btnHeaderUserButton;

    /* Ảnh logo ở chân trang. */
    @FindBy(css = "a.tooltip")
    public WebElement imgFooterLogo;

    /* Khung danh sách truyện ở chân trang. */
    @FindBy(css = "section.main-footer")
    public WebElement pnlFooter;

    /**
     * Hàm lấy element dựa theo text của element đó.
     * @param text Text của element.
     * @return Element chứa text.
     */
    public WebElement getElementByText(String text) {
        /* Xpath của element cần tìm mà có chứa text. */
        String txtAllElementsThatHaveATextXpath = "//*[contains(text(),'%s')]";
        return actionKeyword.findElementCustom(By.cssSelector(String.format(txtAllElementsThatHaveATextXpath, text)));
    }

    public WebElement getGoToAdminPageButton() {
        String btnGoToAdminPage = "//*[contains(text(),'Đến trang Admin')]";
        return actionKeyword.findElementCustom(By.xpath(btnGoToAdminPage));
    }

    /**
     * Hàm lấy một cột danh sách truyện ở chân trang theo số thứ tự cột.
     * @param columnNumber Số thứ tự của cột, từ 1 đến 4.
     * @return Một cột danh sách truyện ở chân trang.
     */
    public WebElement getFooterEbookColumn(int columnNumber) {
        /* Css selector của cột cần lấy. */
        String pnlFooterEbookColumnCssSelector = ".col:nth-child(%s)";
        return pnlFooter.findElement(By.cssSelector(String.format(pnlFooterEbookColumnCssSelector, columnNumber)));
    }

    /**
     * Hàm lấy tên của một cột ở chân trang theo số thứ tự cột.
     * @param columNumber Số thứ tự của cột, từ 1 đến 4.
     * @return Tiêu đề của cột (danh sách truyện).
     */
    public WebElement getTitleFooterEbookColumn(int columNumber) {
        /* Xpath con của tiêu đề bên trong cột danh sách truyện. */
        String txtTitleFooterEbookColumnXpath = "/h3";
        return getFooterEbookColumn(columNumber).findElement(By.xpath(txtTitleFooterEbookColumnXpath));
    }

    /**
     * Hàm lấy hình ảnh của một item (truyện) trong một cột ở chân trang theo thứ tự cột và thứ tự của item đó.
     * @param columnNumber Số thứ tự của cột, từ 1 đến 3.
     * @param itemNumber Số thứ tự của item (truyện), từ 1 đến 3.
     * @return Element hình ảnh của truyện.
     */
    public WebElement getImageOfAItemInFooterEbookColumn(int columnNumber, int itemNumber) {
        /* Css selector con của hình ảnh một item bên trong cột danh sách truyện. */
        String imgImageOfAItemInFooterEbookColumnCssSelector = "li:nth-child(%s)>a";
        return getFooterEbookColumn(columnNumber)
                .findElement(By.xpath(
                        String.format(imgImageOfAItemInFooterEbookColumnCssSelector, itemNumber)
                ));
    }

    /**
     * Hàm lấy tiêu đề của một item (truyện) trong một cột ở chân trang theo thứ tự cột và thứ tự của item đó.
     * @param columnNumber Số thứ tự của cột, từ 1 đến 3.
     * @param itemNumber Số thứ tự của item (truyện), từ 1 đến 3.
     * @return Element tiêu đề của truyện.
     */
    public WebElement getTitleOfAItemInFooterEbookColumn(int columnNumber, int itemNumber) {
        /* Css selector con của tiêu đề một item bên trong cột danh sách truyện. */
        String txtTitleOfAItemInFooterEbookColumnCssSelector = "li:nth-child(%s) h3";
        return getFooterEbookColumn(columnNumber)
                .findElement(By.xpath(
                        String.format(txtTitleOfAItemInFooterEbookColumnCssSelector, itemNumber)
                ));
    }

    /**
     * Hàm lấy text ngày ra mắt của một item (truyện) trong một cột ở chân trang theo thứ tự cột và thứ tự của item đó.
     * @param columnNumber Số thứ tự của cột, từ 1 đến 3.
     * @param itemNumber Số thứ tự của item (truyện), từ 1 đến 3.
     * @return Ngày ra mắt của truyện ở dạng text.
     */
    public String getLaunchDateTextOfAItemInFooterEbookColumn(int columnNumber, int itemNumber) {
        /* Css selector con ngày ra mắt của một item bên trong cột danh sách truyện. */
        String txtLaunchDateOfAItemInFooterEbookColumnCssSelector = "li:nth-child(%s) h4";
        String fullLaunchDateText = getFooterEbookColumn(columnNumber)
                .findElement(By.xpath(
                        String.format(txtLaunchDateOfAItemInFooterEbookColumnCssSelector, itemNumber)
                )).getText();
        return fullLaunchDateText.substring(14);
    }

    /**
     * Hàm lấy link "Xem ngay" của một item (truyện) trong một cột ở chân trang theo thứ tự cột và thứ tự của item đó.
     * @param columnNumber  Số thứ tự của cột, từ 1 đến 3.
     * @param itemNumber Số thứ tự của item (truyện), từ 1 đến 3.
     * @return Element link xem ngay của truyện.
     */
    public WebElement getWatchNowLinkOfAItemInFooterEbookColumn(int columnNumber, int itemNumber) {
        /* Css selector con link "Xem ngay" của một item bên trong cột danh sách truyện. */
        String txtWatchNowLinkOfAItemInFooterEbookColumnCssSelector = "li:nth-child(%s) a.more-btn";
        return getFooterEbookColumn(columnNumber)
                .findElement(By.xpath(
                        String.format(txtWatchNowLinkOfAItemInFooterEbookColumnCssSelector, itemNumber)
                ));
    }

    /**
     * Hàm lấy element hình ảnh của item duy nhất trong cột truyện thứ tư ở phần chân trang.
     * @return Element hình ảnh trong cột truyện thứ tư.
     */
    public WebElement getImageOfFourthFooterEbookColumn() {
        return getFooterEbookColumn(4).findElement(By.cssSelector("img"));
    }

    /**
     * Hàm lấy text copy right ở phần chân trang.
     * @return Chuỗi copy right dạng text.
     */
    public String getCopyRightText() {
        /* Css selector của đoạn text copy right ở chân trang. */
        String txtCopyRightCssSelector = "section.copyrights p";
        return actionKeyword.findElementCustom(By.cssSelector(txtCopyRightCssSelector)).getText();
    }

    /**
     * Hàm nhập từ khóa vào khung tìm kiếm ở đầu trang.
     * @param keyWord Từ khóa cần tìm.
     */
    public void enterKeyWordInHeaderKeyWordEditText(String keyWord) {
        actionKeyword.setText(edtHeaderKeyWord, keyWord);
    }

    /**
     * Hàm nhấn vào icon tìm kiếm trong khung tìm kiếm ở đầu trang.
     */
    public void clickOnSearchIconHeader() {
        actionKeyword.click(imgHeaderSearchIcon);
    }

    /**
     * Hàm tìm kiếm theo từ khóa bằng khung tìm kiếm ở đầu trang.
     * @param keyWord Từ khóa cần tìm.
     */
    public void searchWithHeaderSearchBar(String keyWord) {
        enterKeyWordInHeaderKeyWordEditText(keyWord);
        clickOnSearchIconHeader();
    }

    /**
     * Hàm nhấn vào logo ở đầu trang.
     * @return Trang chủ.
     */
    public HomePage clickOnHeaderLogoImage() {
        actionKeyword.click(imgHeaderLogo);
        return new HomePage(this.driver);
    }

    /**
     * Hàm nhấn vào nút (icon) ở đầu trang.
     */
    public void clickOnHeaderMenuButton() {
        actionKeyword.click(btnHeaderMenuButton);
    }

    /**
     * Hàm nhấn vào nút (icon) thông báo ở đầu trang.
     */
    public void clickOnHeaderNotificationButton() {
        actionKeyword.click(btnHeaderNotificationButton);
    }

    /**
     * Hàm nhấn vào nút (icon) tài khoản ở đầu trang.
     */
    public void clickOnHeaderUserButton() {
        actionKeyword.click(btnHeaderUserButton);
    }

    public void clickOnGoToAdminPageButton() {
        actionKeyword.click(getGoToAdminPageButton());
    }

    /**
     * Hàm nhấn vào ảnh logo ở chân trang.
     */
    public HomePage clickOnFooterLogoImage() {
        actionKeyword.click(imgFooterLogo);
        return new HomePage(this.driver);
    }

    /**
     * Hàm nhấn vào hình ảnh của một item (truyện) trong một cột (danh sách) truyện ở phần chân trang.
     * @param columnNumber Số thứ tự của cột, từ 1 đến 3.
     * @param itemNumber Số thứ tự của item (truyện), từ 1 đến 3.
     * @return Trang chi tiết truyện.
     */
    public DetailPage clickOnImageOfAItemInFooterEbookColumn(int columnNumber, int itemNumber) {
        actionKeyword.click(getImageOfAItemInFooterEbookColumn(columnNumber, itemNumber));
        return new DetailPage(this.driver);
    }

    /**
     * Hàm nhấn vào tiêu đề của một item (truyện) trong một cột (danh sách) truyện ở phần chân trang.
     * @param columnNumber Số thứ tự của cột, từ 1 đến 3.
     * @param itemNumber Số thứ tự của item (truyện), từ 1 đến 3.
     * @return Trang chi tiết truyện.
     */
    public DetailPage clickOnTitleOfAItemInFooterEbookColumn(int columnNumber, int itemNumber) {
        actionKeyword.click(getTitleOfAItemInFooterEbookColumn(columnNumber, itemNumber));
        return new DetailPage(this.driver);
    }

    /**
     * Hàm nhấn vào link "Xem ngay" của một item (truyện) trong một cột (danh sách) truyện ở phần chân trang.
     * @param columnNumber Số thứ tự của cột, từ 1 đến 3.
     * @param itemNumber Số thứ tự của item (truyện), từ 1 đến 3.
     * @return Trang chapter.
     */
    public ChapterPage clickWatchNowLinkOfAItemInFooterEbookColumn(int columnNumber, int itemNumber) {
        actionKeyword.click(getWatchNowLinkOfAItemInFooterEbookColumn(columnNumber, itemNumber));
        return new ChapterPage(this.driver);
    }

    public boolean logoutButtonIsDisplay() {
        try {
            return driver.findElement(By.xpath("//*[contains(text(),'Đăng xuất')]")).isDisplayed();
        } catch (NoSuchElementException exception) {
            return false;
        }
    }

    public boolean goToAdminPageIsDisplay() {
        try {
            return driver.findElement(By.xpath("//*[contains(text(),'Đến trang Admin')]")).isDisplayed();
        } catch (NoSuchElementException exception) {
            return false;
        }
    }
}