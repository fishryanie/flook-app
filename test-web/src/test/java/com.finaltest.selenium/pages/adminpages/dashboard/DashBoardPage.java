package com.finaltest.selenium.pages.adminpages.dashboard;

import com.finaltest.selenium.pages.adminpages.AdminBasePage;
import com.finaltest.selenium.pages.adminpages.admincomponents.TableHeaderAndFooter;
import org.openqa.selenium.WebDriver;

public class DashBoardPage extends AdminBasePage {
    TableHeaderAndFooter tableHeaderAndFooter;
    public DashBoardPage(WebDriver driver) {
        super(driver);
        tableHeaderAndFooter = new TableHeaderAndFooter(this.driver);
    }
}
