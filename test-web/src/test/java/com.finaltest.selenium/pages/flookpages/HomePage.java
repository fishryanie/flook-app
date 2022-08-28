package com.finaltest.selenium.pages.flookpages;

import com.finaltest.selenium.pages.flookpages.flookcomponents.items.EbookItem;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {
    private EbookItem ebookItem;

    public HomePage(WebDriver driver) {
        super(driver);
        ebookItem = new EbookItem(this.driver);
    }

    /* Bước 1 trong khung hướng dẫn các bước theo dõi bộ truyện yêu thích ở phần thân trang chủ. */
    @FindBy(css = ".ti-user.cta-column")
    public WebElement pnlFirstStep;

    /* Bước 2 trong khung hướng dẫn các bước theo dõi bộ truyện yêu thích ở phần thân trang chủ. */
    @FindBy(css = ".ti-view-module.cta-column")
    public WebElement pnlSecondStep;

    /* Bước 3 trong khung hướng dẫn các bước theo dõi bộ truyện yêu thích ở phần thân trang chủ. */
    @FindBy(css = ".ti-notifications.cta-column")
    public WebElement pnlThirdStep;

    /**
     * Hàm lấy mỗi item trong banner list theo thuộc tính data index.
     * @param dataIndex Một trường trong mỗi item, chỉ vị trí của item trong list.
     * @return Item cần lấy trong banner list.
     */
    public WebElement getBannerItemByDataIndex(String dataIndex) {
        /* Css Selector của từng đối tượng trong banner. %s là vị trí thay thế giá trị của thuộc tính data
         * index của riêng mỗi đối tượng. */
        String pnlBannerItemCssSelector = ".slick-slider.slider [data-index='%s']";
        return actionKeyword.findElementCustom(By.cssSelector(String.format(pnlBannerItemCssSelector, dataIndex)));
    }

    /**
     * Hàm lấy link hình ảnh của mỗi item trong banner list, tìm bằng xpath con bên trong mỗi item.
     * @param dataIndex Một trường trong mỗi item, chỉ vị trí của item trong list.
     * @return Đường link hình ảnh của item.
     */
    public String getBannerItemImageLinkByDataIndex(String dataIndex) {
        /* Xpath con của hình ảnh bên trong mỗi banner item. */
        String imgBannerItemChildImageXpath = "//img";
        return getBannerItemByDataIndex(dataIndex)
                .findElement(By.xpath(imgBannerItemChildImageXpath))
                .getAttribute("src");
    }

    /**
     * Hàm lấy một item (ebook) bên trong một danh sách truyện được gợi ý trong trang chủ.
     * @param ebookListName Tên của cả danh sách truyện, được đặt trong thẻ h2.
     * @param dataIndex Một trường trong mỗi item, chỉ vị trí của item trong list.
     * @return Item cần lấy trong danh sách.
     */
    public WebElement getEbookListItemWithMatchingNameAndDataIndex(String ebookListName, String dataIndex) {
        /* Xpath của mỗi khung truyện trong các danh sách truyện ở phần thân trang chủ.
         * %s đầu tiên là vị trí điền tên của danh sách.
         * %s thứ 2 là vị trí điền giá trị data index của mỗi item. */
        String pnlEbookListItemXpath = "//*[text()='%s']/parent::div/following-sibling::div//div[@data-index='%s']";
        return actionKeyword.findElementCustom(By.xpath(String.format(pnlEbookListItemXpath, ebookListName, dataIndex)));
    }

    /**
     * Hàm lấy link xem thêm của mỗi danh sách truyện được gợi ý trong trang chủ.
     * @param ebookListName Tên của cả danh sách truyện, được đặt trong thẻ h2.
     * @return Element xem thêm của danh sách có tên khớp với ebookListName.
     */
    public WebElement getEbookListSeeMoreLinkWithMatchingListName(String ebookListName) {
        /* Xpath con của thẻ chứa đường link đi đến trang chi tiết của mỗi item trong danh sách truyện. */
        String txtSeeMoreLinkXpath = "//*[text()='%s']/following-sibling::a";
        return actionKeyword.findElementCustom(By.xpath(String.format(txtSeeMoreLinkXpath, ebookListName)));
    }

    /**
     * Hàm lấy thẻ tên tác giả của mỗi item danh sách truyện được gợi ý trong trang chủ.
     * @param ebookListName Tên của cả danh sách truyện, được đặt trong thẻ h2.
     * @param dataIndex Một trường trong mỗi item, chỉ vị trí của item trong list.
     * @return Chuỗi tên các tác giả của truyện.
     */
    public String getEbookListItemAuthor(String ebookListName, String dataIndex) {
        return ebookItem.getEbookListItemAuthor(
                getEbookListItemWithMatchingNameAndDataIndex(ebookListName, dataIndex)
        );
    }

    /**
     * Hàm lấy thẻ tiêu đề của mỗi item danh sách truyện được gợi ý trong trang chủ.
     * @param ebookListName Tên của cả danh sách truyện, được đặt trong thẻ h2.
     * @param dataIndex Một trường trong mỗi item, chỉ vị trí của item trong list.
     * @return Chuỗi tiêu đề của truyện.
     */
    public String getEbookListItemTitle(String ebookListName, String dataIndex) {
        return ebookItem.getEbookListItemTitle(
                getEbookListItemWithMatchingNameAndDataIndex(ebookListName, dataIndex)
        );
    }

    /**
     * Hàm lấy thẻ điểm đánh giá của mỗi item danh sách truyện được gợi ý trong trang chủ.
     * @param ebookListName Tên của cả danh sách truyện, được đặt trong thẻ h2.
     * @param dataIndex Một trường trong mỗi item, chỉ vị trí của item trong list.
     * @return Chuỗi điểm đánh giá của truyện, chỉ bao gồm số điểm, không gồm các hình ảnh ngôi sao.
     */
    public String getEbookListItemRating(String ebookListName, String dataIndex) {
        return ebookItem.getEbookListItemRating(
                getEbookListItemWithMatchingNameAndDataIndex(ebookListName, dataIndex)
        );
    }

    /**
     * Hàm lấy thẻ mô tả của mỗi item danh sách truyện được gợi ý trong trang chủ.
     * @param ebookListName Tên của cả danh sách truyện, được đặt trong thẻ h2.
     * @param dataIndex Một trường trong mỗi item, chỉ vị trí của item trong list.
     * @return Chuỗi mô tả của truyện.
     */
    public String getEbookListItemDescription(String ebookListName, String dataIndex) {
        return ebookItem.getEbookListItemDescription(
                getEbookListItemWithMatchingNameAndDataIndex(ebookListName, dataIndex)
        );
    }

    /**
     * Hàm lấy element dẫn đến trang chi tiết của mỗi item danh sách truyện được gợi ý trong trang chủ.
     * @param ebookListName Tên của cả danh sách truyện, được đặt trong thẻ h2.
     * @param dataIndex Một trường trong mỗi item, chỉ vị trí của item trong list.
     * @return Element đường link của truyện.
     */
    public WebElement getEbookListItemSrc(String ebookListName, String dataIndex) {
        return ebookItem.getEbookListItemSrc(
                getEbookListItemWithMatchingNameAndDataIndex(ebookListName, dataIndex)
        );
    }

    /**
     * Hàm lấy ngày phát hành của mỗi item danh sách truyện được gợi ý trong trang chủ.
     * @param ebookListName Tên của cả danh sách truyện, được đặt trong thẻ h2.
     * @param dataIndex Một trường trong mỗi item, chỉ vị trí của item trong list.
     * @return Chuỗi ngày phát hành của truyện.
     */
    public String getEbookListItemDate(String ebookListName, String dataIndex) {
        return ebookItem.getEbookListItemDate(
                getEbookListItemWithMatchingNameAndDataIndex(ebookListName, dataIndex)
        );
    }

    /**
     * Hàm nhấn vào mỗi item trong banner list.
     * @param dataIndex Một trường trong mỗi item, chỉ vị trí của item trong list.
     */
    public void clickOnBannerItemByDataIndex(String dataIndex) {
        actionKeyword.click(getBannerItemByDataIndex(dataIndex));
    }

    /**
     * Hàm nhấn vào mỗi item trong danh sách truyện.
     * @param ebookListName Tên của cả danh sách truyện, được đặt trong thẻ h2.
     * @param dataIndex Một trường trong mỗi item, chỉ vị trí của item trong list.
     */
    public void clickOnEbookListItemWithMatchingNameAndDataIndex(String ebookListName, String dataIndex) {
        actionKeyword.click(getEbookListItemWithMatchingNameAndDataIndex(ebookListName, dataIndex));
    }

    /**
     * Hàm nhấn vào link xem thêm của mỗi danh sách truyện để chuyển tới trang tìm kiếm.
     * @param ebookListName Tên của cả danh sách truyện, được đặt trong thẻ h2.
     * @return Trang danh sách truyện.
     */
    public ComicPage clickOnEbookListSeeMoreLinkWithMatchingListName(String ebookListName) {
        actionKeyword.click(getEbookListSeeMoreLinkWithMatchingListName(ebookListName));
        return new ComicPage(this.driver);
    }

    /**
     * Hàm nhấn vào link xem thêm của mỗi item trong danh sách truyện, để chuyển đến trang chi tiết của truyện đó.
     * @param ebookListName Tên của cả danh sách truyện, được đặt trong thẻ h2.
     * @param dataIndex Một trường trong mỗi item, chỉ vị trí của item trong list.
     * @return Trang chi tiết truyện.
     */
    public DetailPage clickOnEbookListItemSrc(String ebookListName, String dataIndex) {
        actionKeyword.click(getEbookListItemSrc(ebookListName, dataIndex));
        return new DetailPage(this.driver);
    }

    /**
     * Hàm click vào khung bước 1 trong bảng hướng dẫn các bước theo dõi bộ truyện yêu thích.
     * @return Trang chủ.
     */
    public HomePage clickOnFirstStepPanel() {
        actionKeyword.click(pnlFirstStep);
        return new HomePage(this.driver);
    }

    /**
     * Hàm click vào khung bước 2 trong bảng hướng dẫn các bước theo dõi bộ truyện yêu thích.
     * @return Trang chủ.
     */
    public HomePage clickOnSecondStepPanel() {
        actionKeyword.click(pnlSecondStep);
        return new HomePage(this.driver);
    }

    /**
     * Hàm click vào khung bước 3 trong bảng hướng dẫn các bước theo dõi bộ truyện yêu thích.
     * @return Trang chủ.
     */
    public HomePage clickOnThirdStepPanel() {
        actionKeyword.click(pnlThirdStep);
        return new HomePage(this.driver);
    }
}
