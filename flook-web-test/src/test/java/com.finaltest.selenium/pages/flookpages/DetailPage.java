package com.finaltest.selenium.pages.flookpages;

import com.finaltest.selenium.pages.flookpages.flookcomponents.forms.AddCommentForm;
import com.finaltest.selenium.pages.flookpages.flookcomponents.pagings.Paging;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.List;

public class DetailPage extends BasePage {
    public Paging paging;
    public AddCommentForm addCommentForm;

    public DetailPage(WebDriver driver) {
        super(driver);
    }

    /* Tiêu đề của truyện */
    @FindBy(css = "header.header__detail__content>h1")
    public WebElement txtEbookTitleElement;

    /* Trạng thái của truyện */
    @FindBy(css = "header.header__detail__content>p>span>span")
    public WebElement txtEbookStatusElement;

    /* Số lượng chapter của truyện, hiển thị trong khung bên phải ở đầu trang. */
    @FindBy(css = "div.fakebox__chapers__container>h4:first-child>span")
    public WebElement txtNumberOfChapterElementFromRightPanel;

    /* Số lượt theo dõi của truyện, hiển thị trong khung bên phải ở đầu trang. */
    @FindBy(css = "div.fakebox__chapers__container>h4:nth-child(2)>span")
    public WebElement txtNumberOfSubscribeElement;

    /* Số lượt xem của truyện, hiển thị trong khung bên phải ở đầu trang. */
    @FindBy(css = "div.fakebox__chapers__container>h4:last-child>span")
    public WebElement txtNumberOfViewElement;

    /* Thông tin mô tả của truyện. */
    @FindBy(css = "//*[text()='THE STORY LINE']/following-sibling::p")
    public WebElement txtDescriptionElement;

    /* Nút like truyện. */
    @FindBy(css = "//*[text()='Add To Fevorite']")
    public WebElement btnLike;

    /* Nút theo dõi truyện. */
    @FindBy(css = "//*[text()='Watch Later']")
    public WebElement btnSubscribe;

    /* Nút download toàn bộ các chapter. */
    @FindBy(css = "//*[text()='Watched']")
    public WebElement btnDownLoad;

    /* Ảnh bìa của truyện. */
    @FindBy(css = "a.poster img")
    public WebElement imgBookCoverElement;

    /* Tiêu đề của truyện trong khung thông tin. */
    @FindBy(css = "div.information li:nth-child(1) span")
    public WebElement txtEbookTitleElementInTheInfoFrame;

    /* Danh sách element tên tác giả. */
    @FindBy(css = "div.information li:nth-child(2) span")
    public List<WebElement> lstAuthorNameElementList;

    /* Danh sách element thể loại. */
    @FindBy(css = "div.information li:nth-child(3) span")
    public List<WebElement> lstGenreElementList;

    /* Độ tuổi yêu cầu. */
    @FindBy(css = "div.information li:nth-child(4) span")
    public WebElement txtAllowedAgeElement;

    /* Xếp hạng của truyện. */
    @FindBy(css = "div.information li:nth-child(5) span")
    public WebElement txtRankElement;

    /* Số lượng chapter trong khung thông tin. */
    @FindBy(css = "div.information li:nth-child(6) span")
    public WebElement txtNumberOfChapterElementInTheInfoFrame;

    /* Danh sách element tên chapter. */
    @FindBy(css = ".chapter__item h3")
    public List<WebElement> lstChapterNumberElement;

    /**
     * Hàm lấy điểm đánh giá trung bình của truyện.
     * @return Điểm đánh giá trung bình.
     */
    public int getRatingOfTheEbook() {
        String imgRatingStar = "div.rating__star>.active";
        List<WebElement> activeStarList = actionKeyword.findElementsCustom(
                By.cssSelector(imgRatingStar)
        );
        return activeStarList.size();
    }

    /**
     * Hàm lấy danh sách tên tác giả của truyện.
     * @return Danh sách tên tác giả dạng text.
     */
    public List<String> getAuthorNameList() {
        List<String> authorNameList = new ArrayList<>();
        String authorName;
        for (WebElement element: lstAuthorNameElementList) {
            authorName = element.getText().replace(", ", "");
            authorNameList.add(authorName);
        }
        return authorNameList;
    }

    /**
     * Hàm lấy danh sách thể loại của truyện.
     * @return Danh sách thể loại dạng text.
     */
    public List<String> getGenreList() {
        List<String> genreList = new ArrayList<>();
        String genre;
        for (WebElement element: lstGenreElementList) {
            genre = element.getText().replace(", ", "");
            genreList.add(genre);
        }
        return genreList;
    }

    /**
     * Hàm lấy đường dẫn ảnh bìa của truyện.
     * @return Đường dẫn ảnh bìa của truyện ở dạng text.
     */
    public String getBookCoverSrc() {
        return imgBookCoverElement.getAttribute("src");
    }

    /**
     * Hàm lấy danh sách chapter theo dạng số (thứ tự chapter).
     * @return Danh sách chapter theo dạng số.
     */
    public List<Integer> getChapterNumberList() {
        List<Integer> chapterNumberList = new ArrayList<>();
        int number;
        for (WebElement element: lstChapterNumberElement) {
            number = Integer.parseInt(element.getText().replace("Chapter ", ""));
            chapterNumberList.add(number);
        }
        return chapterNumberList;
    }

    /**
     * Hàm lấy tiêu đề chapter.
     * @param chapter chapter cần lấy tiêu đề (Ví dụ: Chapter 1).
     * @return Element tiêu đề của chapter.
     */
    public WebElement getTitleOfChapter(String chapter) {
        String txtChapterTitle = "//*[text()='%s']/following-sibling::p";
        return actionKeyword.findElementCustom(By.xpath(String.format(txtChapterTitle, chapter)));
    }

    /**
     * Hàm lấy nút đọc của chapter.
     * @param chapter chapter cần lấy nút đọc (Ví dụ: Chapter 1).
     * @return Nút đọc của chapter.
     */
    public WebElement getReadButtonOfChapter(String chapter) {
        String btnReadButton = "//*[text()='%s']/../parent::div/following-sibling::div/a[@class='btn__read']";
        return actionKeyword.findElementCustom(By.xpath(String.format(btnReadButton, chapter)));
    }

    /**
     * Hàm lấy nút tải về của chapter.
     * @param chapter chapter cần lấy nút tải về (Ví dụ: Chapter 1).
     * @return Nút tải về của chapter.
     */
    public WebElement getDowloadButtonOfChapter(String chapter) {
        String btnDownloadButton = "//*[text()='%s']/../parent::div/following-sibling::div/a[@class='btn__download']";
        return actionKeyword.findElementCustom(By.xpath(String.format(btnDownloadButton, chapter)));
    }

    /**
     * Hàm nhấn nút thích truyện.
     * @return Trang chi tiết truyện.
     */
    public DetailPage clickOnLikeButton() {
        actionKeyword.click(btnLike);
        return new DetailPage(this.driver);
    }

    /**
     * Hàm nhấn nút theo dõi truyện.
     * @return Trang chi tiết truyện.
     */
    public DetailPage clickOnSubscribeButton() {
        actionKeyword.click(btnSubscribe);
        return new DetailPage(this.driver);
    }

    /**
     * Hàm nhấn nút tải về toàn bộ chapter của truyện.
     * @return Trang chi tiết truyện.
     */
    public DetailPage clickOnDownloadButton() {
        actionKeyword.click(btnDownLoad);
        return new DetailPage(this.driver);
    }

    /**
     * Hàm nhấn tên chapter.
     * @param chapterNumber Tên chapter (Ví dụ: Chapter 1).
     * @return Trang chi tiết truyện.
     */
    public DetailPage clickOnChapterNumber(String chapterNumber) {
        actionKeyword.click(getElementByText(chapterNumber));
        return new DetailPage(this.driver);
    }

    /**
     * Hàm nhấn tiêu đề chapter.
     * @param chapter Tên chapter (Ví dụ: Chapter 1).
     * @return Trang chi tiết truyện.
     */
    public DetailPage clickOnChapterTitle(String chapter) {
        actionKeyword.click(getTitleOfChapter(chapter));
        return new DetailPage(this.driver);
    }

    /**
     * Hàm nhấn nút đọc chapter.
     * @param chapter Tên chapter (Ví dụ: Chapter 1).
     * @return Trang chi tiết truyện.
     */
    public DetailPage clickOnReadButtonOfChapter(String chapter) {
        actionKeyword.click(getReadButtonOfChapter(chapter));
        return new DetailPage(this.driver);
    }

    /**
     * Hàm nhấn nút tải về chapter.
     * @param chapter Tên chapter (Ví dụ: Chapter 1).
     * @return Trang chi tiết truyện.
     */
    public DetailPage clickOnDowloadButtonOfChapter(String chapter) {
        actionKeyword.click(getDowloadButtonOfChapter(chapter));
        return new DetailPage(this.driver);
    }
}
