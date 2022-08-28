package com.finaltest.selenium.pages.flookpages.flookcomponents.forms;

import com.finaltest.selenium.pages.flookpages.flookcomponents.BaseComponent;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AddCommentForm extends BaseComponent {
    public AddCommentForm(WebDriver driver) {
        super(driver);
    }

    /* Khung nhập nội dung bình luận. */
    @FindBy(css = "form>textarea")
    public WebElement txaComment;

    /* Nút gửi nội dung bình luận. */
    @FindBy(css = "form>input[type='submit']")
    public WebElement btnAddComment;

    /**
     * Hàm lấy avatar của người bình luận dựa theo vị trí của bình luận đó trên phân trang.
     * @param position Vị trí của bình luận trên phân trang.
     * @return Element ảnh đại diện của người bình luận.
     */
    public WebElement getAvatarOfCommenter(int position) {
        String imgAvatarOfCommenterCssSelector = ".comment-block:nth-child(%s) img";
        return actionKeyword.findElementCustom(By.cssSelector(String.format(imgAvatarOfCommenterCssSelector, position)));
    }

    /**
     * Hàm lấy tên của người bình luận dựa theo vị trí của bình luận đó trên phân trang.
     * @param position Vị trí của bình luận trên phân trang.
     * @return Element tên của người bình luận.
     */
    public WebElement getNameOfCommenter(int position) {
        String txtNameOfCommenterCssSelector = "//*[@class='comment-block'][%s]//h3/text()";
        return actionKeyword.findElementCustom(By.cssSelector(String.format(txtNameOfCommenterCssSelector, position)));
    }

    /**
     * Hàm lấy thời gian bình luận dựa theo vị trí của bình luận đó trên phân trang.
     * @param position Vị trí của bình luận trên phân trang.
     * @return Element thời gian bình luận.
     */
    public WebElement getCommentTime(int position) {
        String txtCommentTimeCssSelector = "//*[@class='comment-block'][%s]//h3/span";
        return actionKeyword.findElementCustom(By.cssSelector(String.format(txtCommentTimeCssSelector, position)));
    }

    /**
     * Hàm lấy nội dung bình luận dựa theo vị trí của bình luận đó trên phân trang.
     * @param position Vị trí của bình luận trên phân trang.
     * @return Element nội dung bình luận.
     */
    public WebElement getCommentContent(int position) {
        String txtCommentContentCssSelector = "//*[@class='comment-block'][1]/p";
        return actionKeyword.findElementCustom(By.cssSelector(String.format(txtCommentContentCssSelector, position)));
    }

    /**
     * Hàm nhập nội dung bình luận vào khung.
     * @param content Nội dung bình luận.
     */
    public void enterContentInCommentEditText(String content) {
        actionKeyword.setText(txaComment, content);
    }

    /**
     * Hàm nhấn vào nút gửi bình luận.
     */
    public void clickOnAddCommentButton() {
        actionKeyword.click(btnAddComment);
    }
}
