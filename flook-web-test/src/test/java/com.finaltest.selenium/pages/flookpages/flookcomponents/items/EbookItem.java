package com.finaltest.selenium.pages.flookpages.flookcomponents.items;

import com.finaltest.selenium.pages.flookpages.flookcomponents.BaseComponent;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class EbookItem extends BaseComponent {
    public EbookItem(WebDriver driver) {
        super(driver);
    }

    /**
     * Hàm lấy thẻ tên tác giả của từ một item đã lấy được trong danh sách truyện.
     * @return Chuỗi tên các tác giả của truyện.
     */
    public String getEbookListItemAuthor(WebElement element) {
        /* Xpath con của thẻ chứa tên tác giả của mỗi item trong danh sách truyện. */
        String txtEbookListItemAuthorXpath = "//*[@class='card-author']/span";
        return element.findElement(By.xpath(txtEbookListItemAuthorXpath)).getText();
    }

    /**
     * Hàm lấy thẻ tiêu đề của một item đã lấy được trong danh sách truyện.
     * @return Chuỗi tiêu đề của truyện.
     */
    public String getEbookListItemTitle(WebElement element) {
        /* Xpath con của thẻ chứa tiêu đề của mỗi item trong danh sách truyện. */
        String txtEbookListItemTitleXpath = "//*[@class='card-title']";
        return element.findElement(By.xpath(txtEbookListItemTitleXpath)).getText();
    }

    /**
     * Hàm lấy thẻ điểm đánh giá của một item đã lấy được trong danh sách truyện.
     * @return Chuỗi điểm đánh giá của truyện, chỉ bao gồm số điểm, không gồm các hình ảnh ngôi sao.
     */
    public String getEbookListItemRating(WebElement element) {
        /* Xpath con của thẻ chứa điểm đánh giá của mỗi item trong danh sách truyện. */
        String txtEbookListItemRatingXpath = "//*[@class='card-rating']";
        String rating = element.findElement(By.xpath(txtEbookListItemRatingXpath)).getText();
        String[] words = rating.split(" ");
        return words[words.length - 1];
    }

    /**
     * Hàm lấy thẻ mô tả của một item đã lấy được trong danh sách truyện.
     * @return Chuỗi mô tả của truyện.
     */
    public String getEbookListItemDescription(WebElement element) {
        /* Xpath con của thẻ chứa mô tả của mỗi item trong danh sách truyện. */
        String txtEbookListItemDescriptionXpath = "//*[@class='card-description']";
        return element.findElement(By.xpath(txtEbookListItemDescriptionXpath)).getText();
    }

    /**
     * Hàm lấy element dẫn đến trang chi tiết của một item đã lấy được trong danh sách truyện.
     * @return Element đường link của truyện.
     */
    public WebElement getEbookListItemSrc(WebElement element) {
        /* Xpath con của thẻ chứa ngày phát hành của mỗi item trong danh sách truyện. */
        String txtEbookListItemSrcXpath = "//*[@class='link']";
        return element.findElement(By.xpath(txtEbookListItemSrcXpath));
    }

    /**
     * Hàm lấy ngày phát hành của một item đã lấy được trong danh sách truyện.
     * @return Chuỗi ngày phát hành của truyện.
     */
    public String getEbookListItemDate(WebElement element) {
        /* Xpath con của thẻ chứa ngày phát hành của mỗi item trong danh sách truyện. */
        String txtEbookListItemDateXpath = "//*[@class='card-day']";
        return element.findElement(By.xpath(txtEbookListItemDateXpath)).getText();
    }
}
