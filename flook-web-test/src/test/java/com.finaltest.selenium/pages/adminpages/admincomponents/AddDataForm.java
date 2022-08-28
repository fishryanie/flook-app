package com.finaltest.selenium.pages.adminpages.admincomponents;

import org.openqa.selenium.*;

import java.util.ArrayList;
import java.util.List;

public class AddDataForm extends BaseComponent{
    public AddDataForm(WebDriver driver) {
        super(driver);
    }

    String edtFieldOfFormXpath = "//label[contains(text(),'%s')]/following-sibling::div/input";

    public WebElement getFieldByLabelText(String labelText) {
        return actionKeyword.findElementCustom(By.xpath(String.format(edtFieldOfFormXpath, labelText)));
    }

    public WebElement getUploadImageButtonInAddDataForm() {
        String btnUploadImageButtonId = "upload_file";
        return actionKeyword.findElementCustom(By.id(btnUploadImageButtonId));
    }

    public String getImageUploadedSrc() {
        String imgImageUploadedCssSelector = "#uploaded_view>img";
        return actionKeyword.findElementCustom(By.cssSelector(imgImageUploadedCssSelector)).getAttribute("src");
    }

    public void enterContentInFieldByLabelText(String labelText, String content) {
        actionKeyword.setText(getFieldByLabelText(labelText), content);
    }

    public void uploadImageInAddDataForm(String imageAbsolutePath) {
        getUploadImageButtonInAddDataForm().sendKeys(imageAbsolutePath);
    }

    public boolean verifyAEditTextIsDisplayByLabelText(String labelText) {
        try {
            return driver.findElement(By.xpath(String.format(edtFieldOfFormXpath, labelText))).isDisplayed();
        } catch (NoSuchElementException exception) {
            return false;
        }
    }

    public boolean verifyAEditTextAndItsValueAreDisplayByLabelTextAndValueText(String labelText, String valueText) {
        try {
            return driver.findElement(By.xpath(String.format(edtFieldOfFormXpath, labelText))).getAttribute("value").contains(valueText);
        } catch (NoSuchElementException exception) {
            return false;
        }
    }

    public boolean verifyARadioButtonIsCheckedByLabelTextAndValueText(String labelText) {
        String rdoFormRadioButtonXpath = "//*[text()='%s']/preceding-sibling::span";
        try {
            return driver.findElement(By.xpath(String.format(rdoFormRadioButtonXpath, labelText))).getAttribute("class").contains("Mui-checked");
        } catch (NoSuchElementException exception) {
            return false;
        }
    }

    public List<String> getDataListOfAComboBoxInUpdateDataFormByLabel(String label) throws InterruptedException {
        Thread.sleep(500);
        List<String> dataListInUpdateDataForm = new ArrayList<>();
        String lstdataListXpath = "//label[text()='%s']/following-sibling::div/div/span[1]";
        List<WebElement> elementList = driver.findElements(By.xpath(String.format(lstdataListXpath, label)));
        for (WebElement element: elementList) {
            dataListInUpdateDataForm.add(element.getText());
        }
        return dataListInUpdateDataForm;
    }
}
