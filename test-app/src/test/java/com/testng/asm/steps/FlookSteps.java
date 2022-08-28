package com.testng.asm.steps;

import com.testng.asm.pages.*;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import io.cucumber.java.After;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

public class FlookSteps extends BaseSteps {
    BaseActivity baseActivity;
    BookcaseActivity bookcaseActivity;
    ChaptersActivity chaptersActivity;
    CoinActivity coinActivity;
    EbookActivity ebookActivity;
    FilterActivity filterActivity;
    GenresActivity genresActivity;
    HomeActivity homeActivity;
    LoginActivity loginActivity;
    MeActivity meActivity;
    PayActivity payActivity;
    RankingActivity rankingActivity;
    ReadingActivity readingActivity;
    SearchActivity searchActivity;
    UserInfoActivity userInfoActivity;

    @Given("I open Flook application")
    public void iOpenFlookApplication() throws MalformedURLException {
        String filePath = "src/app/flook.apk";
        File file = new File(filePath);

        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability(MobileCapabilityType.APP, file.getAbsolutePath());
        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "Pixel3B");
        capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
        capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, "Android 9.0");
        capabilities.setCapability("autoGrantPermissions", true);

        driver = new AndroidDriver<>(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
        homeActivity = new HomeActivity(driver);
        baseActivity = new BaseActivity(driver);
    }

    @Then("I will see the bottom bar showing all the tabs")
    public void iWillSeeTheBottomBarShowingAllTheTabs() {
        Assert.assertTrue(homeActivity.homeTabIsDisplayed());
        Assert.assertTrue(homeActivity.bookcaseTabIsDisplayed());
        Assert.assertTrue(homeActivity.forumTabIsDisplayed());
        Assert.assertTrue(homeActivity.notificationTabIsDisplayed());
        Assert.assertTrue(homeActivity.meTabIsDisplayed());
    }

    @After
    public void endTest() {
        driver.quit();
    }

    @When("I click on the {string} tab")
    public void iClickOnTheTab(String bottomTabName) {
        baseActivity.clickOnBottomTabByName(bottomTabName);
    }

    @Then("I will see the app navigate to the {string} screen")
    public void iWillSeeTheAppNavigateToTheBookcaseScreen(String screenName) {
        Assert.assertTrue(baseActivity.verifyATabIsDisplayedByText(screenName));
    }

    @When("I click on search box")
    public void iClickOnSearchBox() {
        homeActivity.clickOnSearchView();
    }

    @Then("I will see the system navigate to the search page")
    public void iWillSeeTheSystemNavigateToTheSearchPage() {
        Assert.assertTrue(baseActivity.verifyAViewIsDisplayedByText("You can search by book title, author, keywords etc..."));
    }

    @When("I click on ranking button")
    public void iClickOnRankingButton() {
        homeActivity.clickOnRankingButton();
        rankingActivity = new RankingActivity(driver);
    }

    @Then("I will see the system navigate to the ranking page")
    public void iWillSeeTheSystemNavigateToTheRankingPage() {
        Assert.assertTrue(rankingActivity.verifyIsOnRankingPage());
    }
}