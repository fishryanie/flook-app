package com.finaltest.selenium.data;

import com.finaltest.selenium.helpers.ExcelHelper;
import com.finaltest.selenium.helpers.JsonHelper;
import org.testng.annotations.DataProvider;

public class WebData {
    @DataProvider
    public static Object[][] getOrderJsonData(){
        return JsonHelper.readOrderListFromJsonFile("src/test/resources/cucumber_web.json");
    }

    @DataProvider
    public static Object[][] getOrderExcelData(){
        return ExcelHelper.readOrderListFromExcelFile("src/test/resources/cucumber_web.xlsx");
    }
}