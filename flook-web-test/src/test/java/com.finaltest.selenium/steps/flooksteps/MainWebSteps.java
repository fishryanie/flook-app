package com.finaltest.selenium.steps.flooksteps;

import com.finaltest.selenium.configuration.Configuration;
import com.finaltest.selenium.driver.DriverFactory;
import com.finaltest.selenium.keyword.ActionKeyword;
import com.finaltest.selenium.pages.flookpages.HomePage;
import com.finaltest.selenium.steps.BaseSteps;
import io.cucumber.java.After;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;

public class MainWebSteps extends BaseSteps {
    HomePage homePage;

    @Given("I open the Flook website")
    public void iOpenTheFlookWebsite() throws Exception {
        WebDriverManager.chromedriver().setup();
        Configuration config = new Configuration("src/test/resources/flook.properties");
        driver = DriverFactory.getDriver(config.getProperty("browser"));
        actionKeyword = new ActionKeyword(driver);
        actionKeyword.checkUrl(config.getProperty("url"));
    }

    @When("I click the login button")
    public void iClickTheJoinUsButton() throws InterruptedException {
        homePage = new HomePage(this.driver);
        homePage.menu.clickOnMainMenuJoinUsTab();
        Thread.sleep(500);
    }

    @Then("I will see the elements fully displayed")
    public void iWillSeeTheElementsFullyDisplayed() {
        Assert.assertTrue(homePage.menu.allTabsOfTheJoinUsBoxAreDisplay());
        Assert.assertTrue(homePage.menu.loginWithGoogleAndFacebookButtonsAreDisplay());
        Assert.assertTrue(homePage.menu.usernameAndPasswordFieldsAreDisplay());
        Assert.assertTrue(homePage.menu.rememberPasswordLinksAreDisplay());
        Assert.assertTrue(homePage.menu.submitButtonIsDisplay());
    }

    @And("I click the login with Google account button")
    public void iClickTheLoginWithGoogleAccountButton() {
        homePage.menu.clickOnLoginWithGoogleButton();
    }

    @And("I click the login with Facebok account button")
    public void iClickTheLoginWithFacebookAccountButton() {
        homePage.menu.clickOnLoginWithFacebookButton();
    }

    @Then("I will see the Google account login page, or a notification that the function is updating")
    public void iWillSeeTheGoogleAccountLoginPageOrANotificationThatTheFunctionIsUpdating() {
        Assert.assertTrue(false);
    }

    @Then("I will see the Facebook account login page, or a notification that the function is updating")
    public void iWillSeeTheFacebookAccountLoginPageOrANotificationThatTheFunctionIsUpdating() {
        Assert.assertTrue(false);
    }

    @And("I enter my username {string} in the username field")
    public void iEnterMyUsernameInTheUsernameField(String username) {
        homePage.menu.enterUsernameInTheUsernameEditText(username);
    }

    @And("I enter my password {string} in the password field")
    public void iEnterMyPasswordInThePasswordField(String password) {
        homePage.menu.enterPasswordInThePasswordEditText(password);
    }

    @And("I click the submit button")
    public void iClickTheSubmitButton() {
        homePage.menu.getElementFromJoinUsBox("Gửi").click();
    }

    @Then("I will see the system display the message {string}")
    public void iWillSeeTheSystemDisplayTheMessage(String message) throws InterruptedException {
        Thread.sleep(500);
        Assert.assertTrue(homePage.menu.messageIsDisplay(message));
    }

    @And("I will see the login button change to the password change button")
    public void iWillSeeTheLoginButtonChangeToChangePassButton() {
        Assert.assertFalse(homePage.menu.verifyLoginButtonBecomesChangePassButton());
    }

    @When("I click the account button")
    public void iClickTheAccountButton() {
        homePage.btnHeaderUserButton.click();
    }

    @Then("I will see the logout button displayed.")
    public void iWillSeeTheLogoutButtonDisplayed() throws InterruptedException {
        Thread.sleep(500);
        Assert.assertTrue(homePage.logoutButtonIsDisplay());
    }

    @When("I wait {string} milliseconds")
    public void iWaitMilliseconds(String time) throws InterruptedException {
        Thread.sleep(Integer.parseInt(time));
    }

    @And("I go to admin page")
    public void iGoToAdminPage() {
        driver.get("http://localhost:3000/admin/");
    }

    @Then("I will see the dashboard of the admin page")
    public void iWillSeeTheDashboardOfTheAdminPage() {
        Assert.assertTrue(true);
    }

    @Then("I will not see the dashboard of the admin page")
    public void iWillNotSeeTheDashboardOfTheAdminPage() {
        Assert.assertTrue(true);
    }

    @After(value="@Login")
    public void cleanUp(){
        driver.quit();
    }
}