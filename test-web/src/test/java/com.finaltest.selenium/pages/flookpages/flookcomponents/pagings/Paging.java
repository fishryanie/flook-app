package com.finaltest.selenium.pages.flookpages.flookcomponents.pagings;

import com.finaltest.selenium.pages.flookpages.flookcomponents.BaseComponent;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class Paging extends BaseComponent {
    public Paging(WebDriver driver) {
        super(driver);
    }

    /* Nút chuyển đến phân trang đầu tiên. */
    @FindBy(css = ".MuiPagination-ul>li:first-child>button")
    public List<WebElement> btnGoToFirstButtonList;

    /* Nút chuyển đến phân trang cuối cùng. */
    @FindBy(css = ".MuiPagination-ul>li:last-child>button")
    public List<WebElement> btnGoToLastButtonList;

    /* Nút chuyển đến phân trang trước. */
    @FindBy(css = ".MuiPagination-ul>li:first-child+li>button")
    public List<WebElement> btnPreviousButtonList;

    /* Nút chuyển đến phân trang sau. */
    @FindBy(css = "//*[contains(@class, 'MuiPagination-ul')]/li[last()]/preceding-sibling::li[1]")
    public List<WebElement> btnNextButtonList;

    /**
     * Hàm click vào nút chuyển đến trang đầu tiên trong danh sách phân trang.
     * @param position Vị trí của danh sách phân trang trong trang web.
     */
    public void clickOnGoToFirstButton(int position) {
        actionKeyword.click(btnGoToFirstButtonList.get(position));
    }

    /**
     * Hàm click vào nút chuyển đến trang cuối cùng trong danh sách phân trang.
     * @param position Vị trí của danh sách phân trang trong trang web.
     */
    public void clickOnGoToLastButton(int position) {
        actionKeyword.click(btnGoToLastButtonList.get(position));
    }

    /**
     * Hàm click vào nút chuyển đến trang trước trong danh sách phân trang.
     * @param position Vị trí của danh sách phân trang trong trang web.
     */
    public void clickOnPreviousButton(int position) {
        actionKeyword.click(btnPreviousButtonList.get(position));
    }

    /**
     * Hàm click vào nút chuyển đến trang sau trong danh sách phân trang.
     * @param position Vị trí của danh sách phân trang trong trang web.
     */
    public void clickOnNextButton(int position) {
        actionKeyword.click(btnNextButtonList.get(position));
    }
}
