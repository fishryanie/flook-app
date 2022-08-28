package com.finaltest.selenium.pages.flookpages;

import com.finaltest.selenium.pages.flookpages.flookcomponents.items.EbookItem;
import com.finaltest.selenium.pages.flookpages.flookcomponents.pagings.Paging;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ComicPage extends BasePage {
    public EbookItem ebookItem;
    public Paging paging;

    public ComicPage(WebDriver driver) {
        super(driver);
        ebookItem = new EbookItem(this.driver);
    }

    /* Icon (nút) hiển thị truyện theo dạng danh sách (list). */
    @FindBy(css = "[role='group']>button:first-child")
    public WebElement btnSortByList;

    /* Icon (nút) hiển thị truyện theo dạng lưới (grid). */
    @FindBy(css = "[role='group']>button:last-child")
    public WebElement btnSortByGrid;

    /* Khung điền từ khóa tìm kiếm truyện. */
    @FindBy(id = "search")
    public WebElement edtSearch;

    /* Khung chọn các tác giả để hiển thị danh sách truyện của các tác giả đó. */
    @FindBy(id = "authors")
    public WebElement edtSelectAuthors;

    /* Khung chọn các tác giả để hiển thị danh sách truyện của các tác giả đó. */
    @FindBy(id = "genres")
    public WebElement edtSelectGenres;

    /* Khung chọn các tác giả để hiển thị danh sách truyện của các tác giả đó. */
    @FindBy(id = "allowedAge")
    public WebElement edtSelectAllowedAges;

    /* Khung chọn số lượng chapter để hiển thị danh sách truyện phù hợp. */
    @FindBy(id = "chapters")
    public WebElement edtSelectNumberOfChapters;

    /* Khung chọn trạng thái để hiển thị danh sách truyện phù hợp. */
    @FindBy(id = "status")
    public WebElement edtSelectStates;

    /* Icon của nút tìm kiếm truyện dựa trên các điều kiện đã chọn. */
    @FindBy(css = ".fa-solid.fa-magnifying-glass")
    public WebElement btnIconOfSearchButton;

    /* Icon của nút xóa toàn bộ các điều kiện đã chọn. */
    @FindBy(css = ".fa-solid.fa-arrow-rotate-left")
    public WebElement btnIconOfResetButton;

    /* Khung danh sách truyện. */
    @FindBy(css = "ul.alphabet-sorting+form+div>div>div")
    public WebElement lstEbookList;

    /**
     * Hàm lấy một item (truyện) trong danh sách truyện.
     * @param itemNumber Vị trí của truyện trong danh sách, từ 1 đến 12.
     * @return Element truyện.
     */
    public WebElement getItemFromEbookListWithPositionNumber(int itemNumber) {
        /* Css selector của item cần lấy. */
        String pnlEbookListItemCssSelector = "ul.alphabet-sorting+form+div>div>div>div:nth-child(%s) section.card-image";
        return pnlFooter.findElement(By.cssSelector(String.format(pnlEbookListItemCssSelector, itemNumber)));
    }

    /**
     * Hàm lấy thẻ tên tác giả của mỗi item danh sách truyện được gợi ý trong trang chủ.
     * @param itemNumber Vị trí của item trong danh sách truyện, từ 1 đến 12.
     * @return Chuỗi tên các tác giả của truyện.
     */
    public String getEbookListItemAuthor(int itemNumber) {
        return ebookItem.getEbookListItemAuthor(
                getItemFromEbookListWithPositionNumber(itemNumber)
        );
    }

    /**
     * Hàm lấy thẻ tiêu đề của mỗi item danh sách truyện được gợi ý trong trang chủ.
     * @param itemNumber Vị trí của item trong danh sách truyện, từ 1 đến 12.
     * @return Chuỗi tiêu đề của truyện.
     */
    public String getEbookListItemTitle(int itemNumber) {
        return ebookItem.getEbookListItemTitle(
                getItemFromEbookListWithPositionNumber(itemNumber)
        );
    }

    /**
     * Hàm lấy thẻ điểm đánh giá của mỗi item danh sách truyện được gợi ý trong trang chủ.
     * @param itemNumber Vị trí của item trong danh sách truyện, từ 1 đến 12.
     * @return Chuỗi điểm đánh giá của truyện, chỉ bao gồm số điểm, không gồm các hình ảnh ngôi sao.
     */
    public String getEbookListItemRating(int itemNumber) {
        return ebookItem.getEbookListItemRating(
                getItemFromEbookListWithPositionNumber(itemNumber)
        );
    }

    /**
     * Hàm lấy thẻ mô tả của mỗi item danh sách truyện được gợi ý trong trang chủ.
     * @param itemNumber Vị trí của item trong danh sách truyện, từ 1 đến 12.
     * @return Chuỗi mô tả của truyện.
     */
    public String getEbookListItemDescription(int itemNumber) {
        return ebookItem.getEbookListItemDescription(
                getItemFromEbookListWithPositionNumber(itemNumber)
        );
    }

    /**
     * Hàm lấy element dẫn đến trang chi tiết của mỗi item danh sách truyện được gợi ý trong trang chủ.
     * @param itemNumber Vị trí của item trong danh sách truyện, từ 1 đến 12.
     * @return Element đường link của truyện.
     */
    public WebElement getEbookListItemSrc(int itemNumber) {
        return ebookItem.getEbookListItemSrc(
                getItemFromEbookListWithPositionNumber(itemNumber)
        );
    }

    /**
     * Hàm lấy ngày phát hành của mỗi item danh sách truyện được gợi ý trong trang chủ.
     * @param itemNumber Vị trí của item trong danh sách truyện, từ 1 đến 12.
     * @return Chuỗi ngày phát hành của truyện.
     */
    public String getEbookListItemDate(int itemNumber) {
        return ebookItem.getEbookListItemDate(
                getItemFromEbookListWithPositionNumber(itemNumber)
        );
    }

    /**
     * Hàm nhấn vào một ký tự alphabet trên bảng lựa chọn.
     * @param alphabetOptionText Ký tự alphabet cần nhấn, từ A đến Z, ALL hoặc #.
     * @return Trang danh sách truyện.
     */
    public ComicPage clickOnAlphabetOption(String alphabetOptionText) {
        actionKeyword.click(getElementByText(alphabetOptionText));
        return new ComicPage(this.driver);
    }

    /**
     * Hàm nhấn nút sắp xếp danh sách truyện theo thứ tự từ A đến Z.
     * @return Trang danh sách truyện.
     */
    public ComicPage clickOnSortByAZOption() {
        actionKeyword.click(getElementByText("SORT BY A-Z"));
        return new ComicPage(this.driver);
    }

    /**
     * Hàm nhấn nút sắp xếp truyện theo điểm đánh giá trung bình.
     * @return Trang danh sách truyện.
     */
    public ComicPage clickOnSortByRatingOption() {
        actionKeyword.click(getElementByText("SORT BY RATING"));
        return new ComicPage(this.driver);
    }

    /**
     * Hàm nhấn nút sắp xếp truyện theo ngày ra mắt.
     * @return Trang danh sách truyện.
     */
    public ComicPage clickOnSortByNewestMangaOption() {
        actionKeyword.click(getElementByText("SORT BY NEWEST MANGA"));
        return new ComicPage(this.driver);
    }

    /**
     * Hàm nhấn nút sắp xếp truyện theo tổng số lượt xem.
     * @return Trang danh sách truyện.
     */
    public ComicPage clickOnSortByViewOption() {
        actionKeyword.click(getElementByText("SORT BY VIEW"));
        return new ComicPage(this.driver);
    }

    /**
     * Hàm nhấn nút tìm kiếm nâng cao.
     * @return Trang danh sách truyện.
     */
    public ComicPage clickOnAdvancedSearchButton() {
        actionKeyword.click(getElementByText("ADVANCED SEARCH"));
        return new ComicPage(this.driver);
    }

    /**
     * Hàm nhấn nút sắp xếp danh sách truyện theo dạng list.
     * @return Trang danh sách truyện.
     */
    public ComicPage clickOnSortByListButton() {
        actionKeyword.click(btnSortByList);
        return new ComicPage(this.driver);
    }

    /**
     * Hàm nhấn nút sắp xếp danh sách truyện theo dạng lưới.
     * @return Trang danh sách truyện.
     */
    public ComicPage clickOnSortByGridButton() {
        actionKeyword.click(btnSortByGrid);
        return new ComicPage(this.driver);
    }

    /**
     * Hàm nhập từ khóa vào khung tìm kiếm bằng từ khóa.
     * @param keyWord Từ khóa cần tìm.
     * @return Trang danh sách truyện.
     */
    public ComicPage enterKeywordInTheSearchEditText(String keyWord) {
        actionKeyword.setText(edtSearch, keyWord);
        return new ComicPage(this.driver);
    }

    /**
     * Hàm thêm một tác giả vào khung chọn danh sách tác giả.
     * @param authorName Tên tác giả cần chọn.
     * @return Trang danh sách truyện.
     */
    public ComicPage selectAuthorNameFromTheListOfAuthorsEditText(String authorName) {
        actionKeyword.setText(edtSelectAuthors, authorName);
        edtSelectAuthors.sendKeys(Keys.ENTER);
        return new ComicPage(this.driver);
    }

    /**
     * Hàm thêm thể loại vào khung chọn thể loại.
     * @param genre Thể loại cần chọn.
     * @return Trang danh sách truyện.
     */
    public ComicPage selectGenreFromTheListOfGenresEditText(String genre) {
        actionKeyword.setText(edtSelectGenres, genre);
        edtSelectAuthors.sendKeys(Keys.ENTER);
        return new ComicPage(this.driver);
    }

    /**
     * Hàm thêm độ tuổi yêu cầu vào khung chọn tuổi.
     * @param genre Độ tuổi cần chọn.
     * @return Trang danh sách truyện.
     */
    public ComicPage selectAllowedAgeFromTheListOfAllowedAgesEditText(String genre) {
        actionKeyword.setText(edtSelectAllowedAges, genre);
        edtSelectAuthors.sendKeys(Keys.ENTER);
        return new ComicPage(this.driver);
    }

    /**
     * Hàm thêm số lượng chapter vào khung chọn số chapters.
     * @param numberOfChapters Số lượng chapter cần chọn.
     * @return Trang danh sách truyện.
     */
    public ComicPage selectNumberOfChaptersFromTheListOfChaptersEditText(String numberOfChapters) {
        actionKeyword.setText(edtSelectNumberOfChapters, numberOfChapters);
        edtSelectAuthors.sendKeys(Keys.ENTER);
        return new ComicPage(this.driver);
    }

    /**
     * Hàm thêm trạng thái truyện vào khung chọn trạng thái.
     * @param status Số lượng chapter cần chọn.
     * @return Trang danh sách truyện.
     */
    public ComicPage selectStatusFromTheListOfStatesEditText(String status) {
        actionKeyword.setText(edtSelectStates, status);
        edtSelectAuthors.sendKeys(Keys.ENTER);
        return new ComicPage(this.driver);
    }

    /**
     * Hàm click vào nút reset toàn bộ option đã chọn.
     * @return Trang danh sách truyện.
     */
    public ComicPage clickOnResetButton() {
        actionKeyword.click(btnIconOfResetButton);
        return new ComicPage(this.driver);
    }

    /**
     * Hàm click vào nút tìm kiếm dựa theo những option đã chọn.
     * @return Trang danh sách truyện.
     */
    public ComicPage clickOnSearchButton() {
        actionKeyword.click(btnIconOfSearchButton);
        return new ComicPage(this.driver);
    }

    /**
     * Hàm click vào một item (truyện) trong danh sách.
     * @return Trang danh sách truyện.
     */
    public ComicPage clickOnEbook(int itemNumber) {
        actionKeyword.click(getItemFromEbookListWithPositionNumber(itemNumber));
        return new ComicPage(this.driver);
    }

    /**
     * Hàm click vào nút xem thêm trên một item (truyện) trong danh sách.
     * @return Trang danh sách truyện.
     */
    public ComicPage clickOnReadMoreLinkOfEbook(int itemNumber) {
        actionKeyword.click(getEbookListItemSrc(itemNumber));
        return new ComicPage(this.driver);
    }
}
