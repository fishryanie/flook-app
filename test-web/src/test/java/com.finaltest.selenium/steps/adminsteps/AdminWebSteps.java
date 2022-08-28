package com.finaltest.selenium.steps.adminsteps;

import com.finaltest.selenium.configuration.Configuration;
import com.finaltest.selenium.driver.DriverFactory;
import com.finaltest.selenium.keyword.ActionKeyword;
import com.finaltest.selenium.pages.adminpages.AdminBasePage;
import com.finaltest.selenium.pages.adminpages.admincomponents.TableHeaderAndFooter;
import com.finaltest.selenium.pages.adminpages.auth.RolesPage;
import com.finaltest.selenium.pages.adminpages.auth.UsersPage;
import com.finaltest.selenium.pages.adminpages.books.AuthorsPage;
import com.finaltest.selenium.pages.adminpages.books.EbooksPage;
import com.finaltest.selenium.pages.adminpages.books.GenresPage;
import com.finaltest.selenium.pages.adminpages.dashboard.DashBoardPage;
import com.finaltest.selenium.pages.adminpages.reviews.CommentsPage;
import com.finaltest.selenium.pages.adminpages.reviews.ReviewsPage;
import com.finaltest.selenium.pages.flookpages.ChapterPage;
import com.finaltest.selenium.pages.flookpages.HomePage;
import com.finaltest.selenium.steps.BaseSteps;
import io.cucumber.java.After;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.testng.Assert;

import java.util.concurrent.TimeUnit;

public class AdminWebSteps extends BaseSteps {
    DashBoardPage dashBoardPage;
    HomePage homePage;
    UsersPage usersPage;
    RolesPage rolesPage;
    TableHeaderAndFooter tableHeaderAndFooter;
    EbooksPage ebooksPage;
    AdminBasePage adminBasePage;
    AuthorsPage authorsPage;
    GenresPage genresPage;
    ChapterPage chapterPage;
    ReviewsPage reviewsPage;
    CommentsPage commentsPage;

    @Given("I open the user website")
    public void iOpenTheUserWebsite() throws Exception {
        WebDriverManager.chromedriver().setup();
        Configuration config = new Configuration("src/test/resources/flook.properties");
        driver = DriverFactory.getDriver(config.getProperty("browser"));
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        actionKeyword = new ActionKeyword(driver);
        actionKeyword.checkUrl(config.getProperty("url"));
        tableHeaderAndFooter = new TableHeaderAndFooter(this.driver);
        adminBasePage = new AdminBasePage(this.driver);
    }

    @When("I login with the username {string} and the password {string}")
    public void iLoginWithTheUsernameAndThePassword(String username, String password) throws InterruptedException {
        homePage = new HomePage(this.driver);
        homePage.menu.clickOnMainMenuJoinUsTab();
        homePage.menu.enterUsernameInTheUsernameEditText(username);
        homePage.menu.enterPasswordInThePasswordEditText(password);
        homePage.menu.getElementFromJoinUsBox("Gửi").click();
        Thread.sleep(2000);
    }

    @And("I navigate to admin page")
    public void iNavigateToAdminPage() {
        driver.navigate().to("http://localhost:3000/admin/");
        dashBoardPage = new DashBoardPage(this.driver);
    }

    @And("I click on the logo in the admin page")
    public void iClickOnTheLogoInTheAdminPage() {
        homePage = dashBoardPage.clickOnHeaderLogo();
    }

    @Then("I will see the system take me back to the user page")
    public void iWillSeeTheSystemTakeMeBackToTheUserPage() throws InterruptedException {
        Assert.assertTrue(homePage.menu.changePassLoginButtonIsDisplay());
    }

    @After(value="@AdminWeb")
    public void clean() {
        driver.quit();
    }

    @And("I click on the menu button")
    public void iClickOnTheMenuButton() {
        dashBoardPage.clickOnMenuButton();
    }

    @Then("I will see the display status of the menu as {string}")
    public void iWillSeeTheDisplayStatusOfTheMenuAs(String status) throws InterruptedException {
        Boolean.compare(Boolean.parseBoolean(status), dashBoardPage.leftMenuIsDisplay());
        Thread.sleep(1000);
    }

    @And("I enter the key word {string} in the search box")
    public void iEnterTheKeyWordInTheSearchBox(String keyWord) {
        dashBoardPage.enterKeyWordInSearchEditText(keyWord);
    }

    @Then("I will see results that match the key word {string}")
    public void iWillSeeResultsThatMatchTheKeyWord(String keyWord) throws InterruptedException {
        Assert.assertTrue(dashBoardPage.dataContainKeywordIsDisplay(keyWord));
    }

    @And("I click on the notification button in the admin page")
    public void iClickOnTheNotificationButtonInTheAdminPage() {
        dashBoardPage.clickOnNotificationButton();
    }

    @Then("I will see the message {string}")
    public void iWillSeeTheMessage(String message) throws InterruptedException {
        Assert.assertTrue(adminBasePage.messageIsDisplay(message));
    }

    @And("I click on the account setting button in the admin page")
    public void iClickOnTheAccountSettingButtonInTheAdminPage() {
        dashBoardPage.clickOnUserSettingButton();
    }

    @Then("I will see all elements in user setting box are display")
    public void iWillSeeAllElementsInUserSettingBoxAreDisplay() throws InterruptedException {
        Assert.assertTrue(dashBoardPage.allElementsInUserSettingBoxAreDisplay());
    }

    @And("I click on the account setting button in account box")
    public void iClickOnTheAccountSettingButtonInAccountBox() {
        dashBoardPage.clickOnAccountSettingButtonOnAccountSettingBox();
    }

    @And("I click on the log out button in account box")
    public void iClickOnTheLogOutButtonInAccountBox() {
        dashBoardPage.clickOnLogoutButtonOnAccountSettingBox();
    }

    @And("I will see the system log out")
    public void iWillSeeTheSystemLogOut() throws InterruptedException {
        Assert.assertTrue(homePage.menu.isLogOut());
    }

    @And("I click user tab in left menu")
    public void iClickUserTabInLeftMenu() {
        usersPage = adminBasePage.clickOnUserTabInLeftMenu();
    }

    @Then("I will see the system navigate to {string} page")
    public void iWillSeeTheSystemNavigateToPage(String pageName) throws InterruptedException {
        Assert.assertTrue(tableHeaderAndFooter.verifyIsOnAPageByPageName(pageName));
    }

    @Then("I will see the system redirect me to the {string} page")
    public void iWillSeeTheSystemRedirectMeToThePage(String pageName) throws InterruptedException {
        Assert.assertTrue(tableHeaderAndFooter.verifyIsOnAPageByPageName2(pageName));
    }

    @And("I click roles tab in left menu")
    public void iClickRolesTabInLeftMenu() {
        rolesPage = adminBasePage.clickOnRolesTabInLeftMenu();
    }

    @And("I click ebooks tab in left menu")
    public void iClickEbooksTabInLeftMenu() {
        ebooksPage = adminBasePage.clickOnEbooksTabInLeftMenu();
    }

    @And("I click authors tab in left menu")
    public void iClickAuthorsTabInLeftMenu() {
        authorsPage = adminBasePage.clickOnAuthorsTabInLeftMenu();
    }

    @And("I click genres tab in left menu")
    public void iClickGenresTabInLeftMenu() {
        genresPage = adminBasePage.clickOnGenresTabInLeftMenu();
    }

    @And("I click chapters tab in left menu")
    public void iClickChaptersTabInLeftMenu() {
        chapterPage = adminBasePage.clickOnChaptersTabInLeftMenu();
    }

    @And("I click reviews tab in left menu")
    public void iClickReviewsTabInLeftMenu() {
        reviewsPage = adminBasePage.clickOnReviewsTabInLeftMenu();
    }

    @And("I click comments tab in left menu")
    public void iClickCommentsTabInLeftMenu() {
        commentsPage = adminBasePage.clickOnCommentsTabInLeftMenu();
    }

    @And("I click dashboard tab in left menu")
    public void iClickDashboardTabInLeftMenu() {
        dashBoardPage = adminBasePage.clickOnDashboardTabInLeftMenu();
    }

    @And("I navigate to user management page")
    public void iNavigateToUserManagementPage() {
        driver.navigate().to("http://localhost:3000/admin/table/auth");
        usersPage = new UsersPage(this.driver);
    }

    @Then("I will be navigated to Dashboard page")
    public void iWillBeNavigatedToDashboardPage() {
        Assert.assertTrue(tableHeaderAndFooter.verifyIsOnDashboardPage());
    }

    @And("I navigate to roles management page")
    public void iNavigateToRolesManagementPage() {
        driver.navigate().to("http://localhost:3000/admin/table/role");
        rolesPage = new RolesPage(this.driver);
    }

    @And("I navigate to ebooks management page")
    public void iNavigateToEbooksManagementPage() {
        driver.navigate().to("http://localhost:3000/admin/table/books/ebooks");
        ebooksPage = new EbooksPage(this.driver);
    }

    @And("I navigate to authors management page")
    public void iNavigateToAuthorsManagementPage() {
        driver.navigate().to("http://localhost:3000/admin/table/books/authors");
        authorsPage = new AuthorsPage(this.driver);
    }

    @And("I navigate to genres management page")
    public void iNavigateToGenresManagementPage() {
        driver.navigate().to("http://localhost:3000/admin/table/books/genres");
        genresPage = new GenresPage(this.driver);
    }

    @And("I navigate to chapters management page")
    public void iNavigateToChaptersManagementPage() {
        driver.navigate().to("http://localhost:3000/admin/table/books/chapters");
        chapterPage = new ChapterPage(this.driver);
    }

    @And("I navigate to reviews management page")
    public void iNavigateToReviewsManagementPage() {
        driver.navigate().to("http://localhost:3000/admin/table/reviews/review");
        reviewsPage = new ReviewsPage(this.driver);
    }

    @And("I navigate to comments management page")
    public void iNavigateToCommentsManagementPage() {
        driver.navigate().to("http://localhost:3000/admin/table/reviews/comment");
        commentsPage = new CommentsPage(this.driver);
    }

    @And("I click on the column button in table header")
    public void iClickOnTheColumnButtonInTableHeader() {
        adminBasePage.clickOnMenuButton();
        tableHeaderAndFooter.clickOnColumnButton();
    }

    @Then("I will see the column box appear with search edit text")
    public void iWillSeeTheColumnBoxAppearWithSearchEditText() {
        Assert.assertTrue(tableHeaderAndFooter.verifyColumnBoxSearchEditTextIsDisplay());
    }

    @And("I will see all user column checkboxes are displayed")
    public void iWillSeeAllUserColumnCheckboxesAreDisplayed() {
        Assert.assertTrue(usersPage.verifyAllColumnCheckboxesInColumnBoxAreDisplay());
    }

    @And("I will see all role column checkboxes are displayed")
    public void iWillSeeAllRoleColumnCheckboxesAreDisplayed() {
        Assert.assertTrue(rolesPage.verifyAllColumnCheckboxesInColumnBoxAreDisplay());
    }

    @And("I will see all ebook column checkboxes are displayed")
    public void iWillSeeAllEbookColumnCheckboxesAreDisplayed() {
        Assert.assertTrue(ebooksPage.verifyAllColumnCheckboxesInColumnBoxAreDisplay());
    }

    @And("I will see all author column checkboxes are displayed")
    public void iWillSeeAllAuthorColumnCheckboxesAreDisplayed() {
        Assert.assertTrue(authorsPage.verifyAllColumnCheckboxesInColumnBoxAreDisplay());
    }

    @And("I will see all genre column checkboxes are displayed")
    public void iWillSeeAllGenreColumnCheckboxesAreDisplayed() {
        Assert.assertTrue(genresPage.verifyAllColumnCheckboxesInColumnBoxAreDisplay());
    }

    @And("I will see all chapter column checkboxes are displayed")
    public void iWillSeeAllChapterColumnCheckboxesAreDisplayed() {
        Assert.assertTrue(chapterPage.verifyAllColumnCheckboxesInColumnBoxAreDisplay());
    }

    @And("I will see all review column checkboxes are displayed")
    public void iWillSeeAllReviewColumnCheckboxesAreDisplayed() {
        Assert.assertTrue(reviewsPage.verifyAllColumnCheckboxesInColumnBoxAreDisplay());
    }

    @And("I will see all comment column checkboxes are displayed")
    public void iWillSeeAllCommentColumnCheckboxesAreDisplayed() {
        Assert.assertTrue(commentsPage.verifyAllColumnCheckboxesInColumnBoxAreDisplay());
    }

    @And("I will see hide all and show all button are displayed")
    public void iWillSeeHideAllAndShowAllButtonAreDisplayed() {
        Assert.assertTrue(tableHeaderAndFooter.verifyColumnBoxHideAndShowAllButtonIsDisplay());
    }

    @And("I enter keyword {string} in the column box search box")
    public void iEnterKeywordInTheColumnBoxSearchBox(String keyWord) {
        tableHeaderAndFooter.enterColumnTitleInShowHideColumnSearchBoxEditText(keyWord);
    }

    @Then("I will see all column checkboxes that match the keyword {string}")
    public void iWillSeeAllColumnCheckboxesThatMatchTheKeyword(String keyWord) {
        Assert.assertTrue(tableHeaderAndFooter.verifyAllResultsInColumnBoxMatchTheKeyWord(keyWord));
    }

    @And("I click hide all button")
    public void iClickHideAllButton() {
        tableHeaderAndFooter.clickOnHideAllButton();
    }

    @Then("I will see all checkboxes unchecked")
    public void iWillSeeAllCheckboxesUnchecked() {
        Assert.assertTrue(tableHeaderAndFooter.verifyAllCheckboxesInColumnBoxUnchecked());
    }

    @And("I will see all columns hidden")
    public void iWillSeeAllColumnsHidden() throws InterruptedException {
        Assert.assertTrue(tableHeaderAndFooter.verifyAllColumnsAreNotDisplay());
    }

    @And("I click show all button")
    public void iClickShowAllButton() {
        tableHeaderAndFooter.clickOnShowAllButton();
    }

    @Then("I will see all checkboxes checked")
    public void iWillSeeAllCheckboxesChecked() {
        Assert.assertTrue(tableHeaderAndFooter.verifyAllCheckboxesInColumnBoxChecked());
    }

    @And("I will see all user columns displayed")
    public void iWillSeeAllUserColumnsDisplayed() throws InterruptedException {
        Assert.assertTrue(tableHeaderAndFooter.verifyAllColumnsAreDisplay(10));
    }

    @And("I will see all role columns displayed")
    public void iWillSeeAllRoleColumnsDisplayed() throws InterruptedException {
        Assert.assertTrue(tableHeaderAndFooter.verifyAllColumnsAreDisplay(5));
    }

    @And("I will see all ebook columns displayed")
    public void iWillSeeAllEbookColumnsDisplayed() throws InterruptedException {
        Assert.assertTrue(tableHeaderAndFooter.verifyAllColumnsAreDisplay(12));
    }

    @And("I will see all author columns displayed")
    public void iWillSeeAllAuthorColumnsDisplayed() throws InterruptedException {
        Assert.assertTrue(tableHeaderAndFooter.verifyAllColumnsAreDisplay(6));
    }

    @And("I will see all genre columns displayed")
    public void iWillSeeAllGenreColumnsDisplayed() throws InterruptedException {
        Assert.assertTrue(tableHeaderAndFooter.verifyAllColumnsAreDisplay(4));
    }

    @And("I will see all chapter columns displayed")
    public void iWillSeeAllChapterColumnsDisplayed() throws InterruptedException {
        Assert.assertTrue(tableHeaderAndFooter.verifyAllColumnsAreDisplay(8));
    }

    @And("I will see all review columns displayed")
    public void iWillSeeAllReviewColumnsDisplayed() throws InterruptedException {
        Assert.assertTrue(tableHeaderAndFooter.verifyAllColumnsAreDisplay(7));
    }

    @And("I will see all comment columns displayed")
    public void iWillSeeAllCommentColumnsDisplayed() throws InterruptedException {
        Assert.assertTrue(tableHeaderAndFooter.verifyAllColumnsAreDisplay(5));
    }

    @And("I click on {string} checkbox button")
    public void iClickOnCheckboxButton(String columnName) {
        adminBasePage.clickOnCheckboxInColumnBoxByColumnName(columnName);
    }

    @Then("I will see column {string} hidden")
    public void iWillSeeColumnHidden(String columnName) throws InterruptedException {
        Assert.assertFalse(adminBasePage.verifyColumnIsDisplayByText(columnName));
    }

    @Then("I will see column {string} show")
    public void iWillSeeColumnShow(String columnName) throws InterruptedException {
        Assert.assertTrue(adminBasePage.verifyColumnIsDisplayByText(columnName));
    }

    @And("I click on the filter button in table header")
    public void iClickOnTheFilterButtonInTableHeader() {
        tableHeaderAndFooter.clickOnFiltersButton();
    }

    @Then("I will see the filters box appear with close icon")
    public void iWillSeeTheFiltersBoxAppearWithCloseIcon() throws InterruptedException {
        Assert.assertTrue(tableHeaderAndFooter.closeButtonInFiltersBoxIsDisplay());
    }

    @And("I will see column dropdown list with full options")
    public void iWillSeeColumnDropdownListWithFullOptions() throws InterruptedException {
        Assert.assertTrue(tableHeaderAndFooter.verifyFirstColumnInFiltersBoxIsDisplay());
        JavascriptExecutor executor = (JavascriptExecutor)driver;
        executor.executeScript("document.body.style.zoom = '0.5'");
        Assert.assertTrue(tableHeaderAndFooter.verifyFirstColumnInFiltersBoxHaveFullOptions());
        executor.executeScript("document.body.style.zoom = '1.0'");
    }

    @And("I will see operator dropdown list with full options")
    public void iWillSeeOperatorDropdownListWithFullOptions() throws InterruptedException {
        Thread.sleep(500);
        Assert.assertTrue(tableHeaderAndFooter.verifySecondColumnInFiltersBoxIsDisplay());
        Assert.assertTrue(tableHeaderAndFooter.verifySecondColumnInFiltersBoxHaveFullOptions());
    }

    @And("I will see filter value edit text")
    public void iWillSeeFilterValueEditText() {
        Assert.assertTrue(tableHeaderAndFooter.verifyLastColumnInFiltersBoxIsDisplay());
    }

    @And("I select the column {string} in column dropdown list")
    public void iSelectTheColumnInColumnDropdownList(String columnTitle) {
        tableHeaderAndFooter.selectColumnInFilterBox(columnTitle);
    }

    @And("I select the option {string} in operator dropdown list")
    public void iSelectTheOptionInOperatorDropdownList(String operatorOption) {
        tableHeaderAndFooter.selectOperationInFilterBox(operatorOption);
    }

    @And("I enter the key word {string} in value edit text")
    public void iEnterTheKeyWordInValueEditText(String keyWord) {
        tableHeaderAndFooter.enterKeywordInFilterBox(keyWord);
    }
    @Then("I will see a list of users that contain the key word {string}")
    public void iWillSeeAListOfUsersThatContainTheKeyWord(String keyWord) throws InterruptedException {
        Assert.assertTrue(usersPage.verifyAllResultsThatContainTheKeyWorkInFiltersBox(keyWord));
    }
    @Then("I will see a list of roles that contain the key word {string}")
    public void iWillSeeAListOfRolesThatContainTheKeyWord(String keyWord) throws InterruptedException {
        Assert.assertTrue(rolesPage.verifyAllResultsThatContainTheKeyWorkInFiltersBox(keyWord));
    }
    @Then("I will see a list of ebooks that contain the key word {string}")
    public void iWillSeeAListOfEbooksThatContainTheKeyWord(String keyWord) throws InterruptedException {
        Assert.assertTrue(ebooksPage.verifyAllResultsThatContainTheKeyWorkInFiltersBox(keyWord));
    }
    @Then("I will see a list of authors that contain the key word {string}")
    public void iWillSeeAListOfAuthorsThatContainTheKeyWord(String keyWord) throws InterruptedException {
        Assert.assertTrue(authorsPage.verifyAllResultsThatContainTheKeyWorkInFiltersBox(keyWord));
    }
    @Then("I will see a list of genres that contain the key word {string}")
    public void iWillSeeAListOfGenresThatContainTheKeyWord(String keyWord) throws InterruptedException {
        Assert.assertTrue(genresPage.verifyAllResultsThatContainTheKeyWorkInFiltersBox(keyWord));
    }
    @Then("I will see a list of chapters that contain the key word {string}")
    public void iWillSeeAListOfChaptersThatContainTheKeyWord(String keyWord) throws InterruptedException {
        Assert.assertTrue(chapterPage.verifyAllResultsThatContainTheKeyWorkInFiltersBox(keyWord));
    }

    @Then("I'll see a list of reviews where the {string} column contains the keyword {string}")
    public void iLlSeeAListOfReviewsWhereTheColumnContainsTheKeyword(String columTitle, String keyWord) throws InterruptedException {
        Assert.assertTrue(reviewsPage.verifyAllResultsThatContainTheKeyWorkInFiltersBox(columTitle, keyWord));
    }

    @Then("I will see a list of comments that contain the key word {string}")
    public void iWillSeeAListOfCommentsThatContainTheKeyWord(String keyWord) throws InterruptedException {
        Assert.assertTrue(commentsPage.verifyAllResultsThatContainTheKeyWorkInFiltersBox(keyWord));
    }

    @Then("I will see a list of users that equal the key word {string}")
    public void iWillSeeAListOfUsersThatEqualTheKeyWord(String keyWord) throws InterruptedException {
        Assert.assertTrue(usersPage.verifyAllResultsThatEqualTheKeyWorkInFiltersBox(keyWord));
    }

    @Then("I will see a list of roles that equal the key word {string}")
    public void iWillSeeAListOfRolesThatEqualTheKeyWord(String keyWord) throws InterruptedException {
        Assert.assertTrue(rolesPage.verifyAllResultsThatEqualTheKeyWorkInFiltersBox(keyWord));
    }

    @Then("I will see a list of ebooks that equal the key word {string}")
    public void iWillSeeAListOfEbooksThatEqualTheKeyWord(String keyWord) throws InterruptedException {
        Assert.assertTrue(ebooksPage.verifyAllResultsThatEqualTheKeyWorkInFiltersBox(keyWord));
    }

    @Then("I will see a list of authors that equal the key word {string}")
    public void iWillSeeAListOfAuthorsThatEqualTheKeyWord(String keyWord) throws InterruptedException {
        Assert.assertTrue(authorsPage.verifyAllResultsThatEqualTheKeyWorkInFiltersBox(keyWord));
    }

    @Then("I will see a list of genres that equal the key word {string}")
    public void iWillSeeAListOfGenresThatEqualTheKeyWord(String keyWord) throws InterruptedException {
        Assert.assertTrue(genresPage.verifyAllResultsThatEqualTheKeyWorkInFiltersBox(keyWord));
    }

    @Then("I will see a list of chapters that equal the key word {string}")
    public void iWillSeeAListOfChaptersThatEqualTheKeyWord(String keyWord) throws InterruptedException {
        Assert.assertTrue(chapterPage.verifyAllResultsThatEqualTheKeyWorkInFiltersBox(keyWord));
    }

    @Then("I'll see a list of reviews where the {string} column equal the keyword {string}")
    public void iLlSeeAListOfReviewsWhereTheColumnEqualTheKeyword(String columnTitle, String keyWord) throws InterruptedException {
        Assert.assertTrue(reviewsPage.verifyAllResultsThatEqualTheKeyWorkInFiltersBox(columnTitle, keyWord));
    }

    @Then("I will see a list of comments that equal the key word {string}")
    public void iWillSeeAListOfCommentsThatEqualTheKeyWord(String keyWord) throws InterruptedException {
        Assert.assertTrue(commentsPage.verifyAllResultsThatEqualTheKeyWorkInFiltersBox(keyWord));
    }

    @Then("I will see a list of users that star with the key word {string}")
    public void iWillSeeAListOfUsersThatStarWithTheKeyWord(String keyWord) throws InterruptedException {
        Assert.assertTrue(usersPage.verifyAllResultsThatStartWithTheKeyWorkInFiltersBox(keyWord));
    }

    @Then("I will see a list of roles that star with the key word {string}")
    public void iWillSeeAListOfRolesThatStarWithTheKeyWord(String keyWord) throws InterruptedException {
        Assert.assertTrue(rolesPage.verifyAllResultsThatStartWithTheKeyWorkInFiltersBox(keyWord));
    }

    @Then("I will see a list of ebooks that star with the key word {string}")
    public void iWillSeeAListOfEbooksThatStarWithTheKeyWord(String keyWord) throws InterruptedException {
        Assert.assertTrue(ebooksPage.verifyAllResultsThatStartWithTheKeyWorkInFiltersBox(keyWord));
    }

    @Then("I will see a list of authors that star with the key word {string}")
    public void iWillSeeAListOfAuthorsThatStarWithTheKeyWord(String keyWord) throws InterruptedException {
        Assert.assertTrue(authorsPage.verifyAllResultsThatStartWithTheKeyWorkInFiltersBox(keyWord));
    }

    @Then("I will see a list of genres that star with the key word {string}")
    public void iWillSeeAListOfGenresThatStarWithTheKeyWord(String keyWord) throws InterruptedException {
        Assert.assertTrue(genresPage.verifyAllResultsThatStartWithTheKeyWorkInFiltersBox(keyWord));
    }

    @Then("I will see a list of chapters that star with the key word {string}")
    public void iWillSeeAListOfChaptersThatStarWithTheKeyWord(String keyWord) throws InterruptedException {
        Assert.assertTrue(chapterPage.verifyAllResultsThatStartWithTheKeyWorkInFiltersBox(keyWord));
    }

    @Then("I'll see a list of reviews where the {string} column star with the keyword {string}")
    public void iLlSeeAListOfReviewsWhereTheColumnStarWithTheKeyword(String columnTitle, String keyWord) throws InterruptedException {
        Assert.assertTrue(reviewsPage.verifyAllResultsThatStartWithTheKeyWorkInFiltersBox(columnTitle, keyWord));
    }

    @Then("I will see a list of comments that star with the key word {string}")
    public void iWillSeeAListOfCommentsThatStarWithTheKeyWord(String keyWord) throws InterruptedException {
        Assert.assertTrue(commentsPage.verifyAllResultsThatStartWithTheKeyWorkInFiltersBox(keyWord));
    }

    @Then("I will see a list of users that end with the key word {string}")
    public void iWillSeeAListOfUsersThatEndWithTheKeyWord(String keyWord) throws InterruptedException {
        Assert.assertTrue(usersPage.verifyAllResultsThatEndWithTheKeyWorkInFiltersBox(keyWord));
    }

    @Then("I will see a list of roles that end with the key word {string}")
    public void iWillSeeAListOfRolesThatEndWithTheKeyWord(String keyWord) throws InterruptedException {
        Assert.assertTrue(rolesPage.verifyAllResultsThatEndWithTheKeyWorkInFiltersBox(keyWord));
    }

    @Then("I will see a list of ebooks that end with the key word {string}")
    public void iWillSeeAListOfEbooksThatEndWithTheKeyWord(String keyWord) throws InterruptedException {
        Assert.assertTrue(ebooksPage.verifyAllResultsThatEndWithTheKeyWorkInFiltersBox(keyWord));
    }

    @Then("I will see a list of authors that end with the key word {string}")
    public void iWillSeeAListOfAuthorsThatEndWithTheKeyWord(String keyWord) throws InterruptedException {
        Assert.assertTrue(authorsPage.verifyAllResultsThatEndWithTheKeyWorkInFiltersBox(keyWord));
    }

    @Then("I will see a list of genres that end with the key word {string}")
    public void iWillSeeAListOfGenresThatEndWithTheKeyWord(String keyWord) throws InterruptedException {
        Assert.assertTrue(genresPage.verifyAllResultsThatEndWithTheKeyWorkInFiltersBox(keyWord));
    }

    @Then("I will see a list of chapters that end with the key word {string}")
    public void iWillSeeAListOfChaptersThatEndWithTheKeyWord(String keyWord) throws InterruptedException {
        Assert.assertTrue(chapterPage.verifyAllResultsThatEndWithTheKeyWorkInFiltersBox(keyWord));
    }

    @Then("I'll see a list of reviews where the {string} column end with the keyword {string}")
    public void iLlSeeAListOfReviewsWhereTheColumnEndWithTheKeyword(String columnTitle, String keyWord) throws InterruptedException {
        Assert.assertTrue(reviewsPage.verifyAllResultsThatEndWithTheKeyWorkInFiltersBox(columnTitle, keyWord));
    }

    @Then("I will see a list of comments that end with the key word {string}")
    public void iWillSeeAListOfCommentsThatEndWithTheKeyWord(String keyWord) throws InterruptedException {
        Assert.assertTrue(commentsPage.verifyAllResultsThatEndWithTheKeyWorkInFiltersBox(keyWord));
    }

    @Then("I will see a list of users that is empty")
    public void iWillSeeAListOfUsersThatIsEmpty() throws InterruptedException {
        Assert.assertTrue(usersPage.verifyAllResultsThatIsEmpty());
    }

    @Then("I will see a list of roles that is empty")
    public void iWillSeeAListOfRolesThatIsEmpty() throws InterruptedException {
        Assert.assertTrue(rolesPage.verifyAllResultsThatIsEmpty());
    }

    @Then("I will see a list of ebooks that is empty")
    public void iWillSeeAListOfEbooksThatIsEmpty() throws InterruptedException {
        Assert.assertTrue(ebooksPage.verifyAllResultsThatIsEmpty());
    }

    @Then("I will see a list of authors that is empty")
    public void iWillSeeAListOfAuthorsThatIsEmpty() throws InterruptedException {
        Assert.assertTrue(authorsPage.verifyAllResultsThatIsEmpty());
    }

    @Then("I will see a list of genres that is empty")
    public void iWillSeeAListOfGenresThatIsEmpty() throws InterruptedException {
        Assert.assertTrue(genresPage.verifyAllResultsThatIsEmpty());
    }

    @Then("I will see a list of chapters that is empty")
    public void iWillSeeAListOfChaptersThatIsEmpty() throws InterruptedException {
        Assert.assertTrue(chapterPage.verifyAllResultsThatIsEmpty());
    }

    @Then("I will see a list of reviews that is empty")
    public void iWillSeeAListOfReviewsThatIsEmpty() throws InterruptedException {
        Assert.assertTrue(reviewsPage.verifyAllResultsThatIsEmpty());
    }

    @Then("I will see a list of comments that is empty")
    public void iWillSeeAListOfCommentsThatIsEmpty() throws InterruptedException {
        Assert.assertTrue(commentsPage.verifyAllResultsThatIsEmpty());
    }

    @Then("I will see a list of users that is not empty")
    public void iWillSeeAListOfUsersThatIsNotEmpty() throws InterruptedException {
        Assert.assertTrue(usersPage.verifyAllResultsThatIsNotEmpty());
    }

    @Then("I will see a list of roles that is not empty")
    public void iWillSeeAListOfRolesThatIsNotEmpty() throws InterruptedException {
        Assert.assertTrue(rolesPage.verifyAllResultsThatIsNotEmpty());
    }

    @Then("I will see a list of ebooks that is not empty")
    public void iWillSeeAListOfEbooksThatIsNotEmpty() throws InterruptedException {
        Assert.assertTrue(ebooksPage.verifyAllResultsThatIsNotEmpty());
    }

    @Then("I will see a list of authors that is not empty")
    public void iWillSeeAListOfAuthorsThatIsNotEmpty() throws InterruptedException {
        Assert.assertTrue(authorsPage.verifyAllResultsThatIsNotEmpty());
    }

    @Then("I will see a list of genres that is not empty")
    public void iWillSeeAListOfGenresThatIsNotEmpty() throws InterruptedException {
        Assert.assertTrue(genresPage.verifyAllResultsThatIsNotEmpty());
    }

    @Then("I will see a list of chapters that is not empty")
    public void iWillSeeAListOfChaptersThatIsNotEmpty() throws InterruptedException {
        Assert.assertTrue(chapterPage.verifyAllResultsThatIsNotEmpty());
    }

    @Then("I will see a list of reviews with the column {string} not empty")
    public void iWillSeeAListOfReviewsWithTheColumnNotEmpty(String columnTitle) throws InterruptedException {
        Assert.assertTrue(reviewsPage.verifyAllResultsThatIsNotEmpty(columnTitle));
    }

    @Then("I will see a list of comments that is not empty")
    public void iWillSeeAListOfCommentsThatIsNotEmpty() throws InterruptedException {
        Assert.assertTrue(commentsPage.verifyAllResultsThatIsNotEmpty());
    }

    @Then("I will see value input box is hidden")
    public void iWillSeeValueInputBoxIsHidden() throws InterruptedException {
        Assert.assertFalse(tableHeaderAndFooter.verifyLastColumnInFilterBoxIsDisplay());
    }

    @And("I click close button in filters box")
    public void iClickCloseButtonInFiltersBox() throws InterruptedException {
        Thread.sleep(500);
        tableHeaderAndFooter.clickCloseButtonInFilterBox();
    }

    @Then("I will see the value of the column dropdown list as {string}")
    public void iWillSeeTheValueOfTheColumnDropdownListAs(String value) throws InterruptedException {
        Thread.sleep(500);
        Assert.assertEquals(value, tableHeaderAndFooter.getValueOfFirstColumnInFilterBox());
    }

    @And("I will see the value of the operator dropdown list as {string}")
    public void iWillSeeTheValueOfTheOperatorDropdownListAs(String value) {
        Assert.assertEquals(value, tableHeaderAndFooter.getValueOfSecondColumnInFilterBox());
    }

    @Then("I will see value edit text is empty")
    public void iWillSeeValueEditTextIsEmpty() {
        Assert.assertTrue(tableHeaderAndFooter.getValueOfLastColumnInFilterBox().isEmpty());
    }

    @And("I click on the density button in table header")
    public void iClickOnTheDensityButtonInTableHeader() {
        tableHeaderAndFooter.clickOnDensityButton();

    }

    @Then("I will see the display options fully displayed")
    public void iWillSeeTheDisplayOptionsFullyDisplayed() {
        Assert.assertTrue(tableHeaderAndFooter.verifyTheFirstDisplayOptionIsDisplay());
        Assert.assertTrue(tableHeaderAndFooter.verifyTheSecondDisplayOptionIsDisplay());
        Assert.assertTrue(tableHeaderAndFooter.verifyTheThirdDisplayOptionIsDisplay());
    }

    @And("I choose {string} mode")
    public void iChooseMode(String mode) {
        actionKeyword.clickOnElementByText(mode);
    }

    @Then("I will see the data displayed in {string} mode")
    public void iWillSeeTheDataDisplayedInMode(String mode) {
        Assert.assertEquals(mode, tableHeaderAndFooter.checkDisplayModeOfList());
    }

    @And("I click on the more options button in table header")
    public void iClickOnTheMoreOptionsButtonInTableHeader() {
        tableHeaderAndFooter.clickOnTableHeaderMoreOptionsIcon();
    }

    @Then("I will see the data options fully displayed")
    public void iWillSeeTheDataOptionsFullyDisplayed() throws InterruptedException {
        Thread.sleep(500);
        Assert.assertTrue(tableHeaderAndFooter.verifyTheFirstOptionInMoreOptionsIconIsDisplay());
        Assert.assertTrue(tableHeaderAndFooter.verifyTheSecondOptionInMoreOptionsIconIsDisplay());
        Assert.assertTrue(tableHeaderAndFooter.verifyTheThirdOptionInMoreOptionsIconIsDisplay());
    }

    @And("I click on add data button")
    public void iClickOnAddDataButton() {
        tableHeaderAndFooter.clickOnAddDataButton();
    }

    @Then("I will see a form to add a user with the information in the first group")
    public void iWillSeeAFormToAddAUserWithTheInformationInTheFirstGroup() throws InterruptedException {
        Assert.assertTrue(usersPage.verifyAllEditTextOfFirstGroupInAddDataFormAreDisplay());
    }

    @Then("I will see a form to add a chapter with the information in the first group")
    public void iWillSeeAFormToAddAChapterWithTheInformationInTheFirstGroup() throws InterruptedException {
        Assert.assertTrue(chapterPage.verifyAllEditTextOfFirstGroupInAddDataFormAreDisplay());
    }

    @Then("I will see a form to add a author with the information in the first group")
    public void iWillSeeAFormToAddAAuthorWithTheInformationInTheFirstGroup() throws InterruptedException {
        Assert.assertTrue(authorsPage.verifyAllEditTextOfFirstGroupInAddDataFormAreDisplay());
    }

    @Then("I will see a form to add a ebook with the information in the first group")
    public void iWillSeeAFormToAddAEbookWithTheInformationInTheFirstGroup() throws InterruptedException {
        Assert.assertTrue(ebooksPage.verifyAllEditTextOfFirstGroupInAddDataFormAreDisplay());
    }

    @Then("I will see a form to add a role with all the fields")
    public void iWillSeeAFormToAddARoleWithAllTheFields() throws InterruptedException {
        Assert.assertTrue(rolesPage.verifyAllEditTextOfAddDataFormAreDisplay());
    }

    @Then("I will see a form to add a genre with all the fields")
    public void iWillSeeAFormToAddAGenreWithAllTheFields() throws InterruptedException {
        Assert.assertTrue(genresPage.verifyAllEditTextOfAddDataFormAreDisplay());
    }

    @And("I click on continue button")
    public void iClickOnContinueButton() {
        actionKeyword.clickOnElementByText("Tiếp tục");
    }

    @Then("I will see a form to add a user with the information in the second group")
    public void iWillSeeAFormToAddAUserWithTheInformationInTheSecondGroup() throws InterruptedException {
        Assert.assertTrue(usersPage.verifyAllRadioButtonOfSecondGroupInAddDataFormAreDisplay());
    }

    @Then("I will see a form to add a chapter with the information in the second group")
    public void iWillSeeAFormToAddAChapterWithTheInformationInTheSecondGroup() throws InterruptedException {
        Assert.assertTrue(chapterPage.verifyAllRadioButtonOfSecondGroupInAddDataFormAreDisplay());
    }

    @Then("I will see a form to add a author with the information in the second group")
    public void iWillSeeAFormToAddAAuthorWithTheInformationInTheSecondGroup() throws InterruptedException {
        Assert.assertTrue(authorsPage.verifyAllElementOfSecondGroupInAddDataFormAreDisplay());
    }

    @Then("I will see a form to add a ebook with the information in the second group")
    public void iWillSeeAFormToAddAEbookWithTheInformationInTheSecondGroup() throws InterruptedException {
        Assert.assertTrue(ebooksPage.verifyAllRadioButtonOfSecondGroupInAddDataFormAreDisplay());
    }

    @Then("I will see a form to add a user with the information in the third group")
    public void iWillSeeAFormToAddAUserWithTheInformationInTheThirdGroup() throws InterruptedException {
        Assert.assertTrue(usersPage.verifyAllElementOfThirdGroupInAddDataFormAreDisplay());
    }

    @Then("I will see a form to add a chapter with the information in the third group")
    public void iWillSeeAFormToAddAChapterWithTheInformationInTheThirdGroup() throws InterruptedException {
        Assert.assertTrue(chapterPage.verifyAllElementOfThirdGroupInAddDataFormAreDisplay());
    }

    @Then("I will see a form to add a ebook with the information in the third group")
    public void iWillSeeAFormToAddAEbookWithTheInformationInTheThirdGroup() throws InterruptedException {
        Assert.assertTrue(ebooksPage.verifyAllElementOfThirdGroupInAddDataFormAreDisplay());
    }

    @Then("I will see a form to add a user with the information in the fourth group")
    public void iWillSeeAFormToAddAUserWithTheInformationInTheFourthGroup() throws InterruptedException {
        Assert.assertTrue(usersPage.verifyAllElementOfLastGroupInAddDataFormAreDisplay());
    }

    @And("I click on back button")
    public void iClickOnBackButton() {
        actionKeyword.clickOnButtonByText("Trở về");
    }

    @And("I enter display name {string}, phone number {string}, username {string}, email {string} and password {string}")
    public void iEnterDisplayNamePhoneNumberUsernameEmailAndPassword(String displayName, String phoneNumber, String userName, String email, String passWord) {
        usersPage.enterInformationInFirstGroup(displayName, phoneNumber, userName, email, passWord);
    }

    @And("I enter author name {string}")
    public void iEnterAuthorName(String authorName) {
        authorsPage.enterInformationInFirstGroup(authorName);
    }

    @And("I enter name {string}, status {string} and description {string}")
    public void iEnterNameStatusAndDescription(String name, String status, String description) {
        ebooksPage.enterInformationInFirstGroup(name, status, description);
    }

    @And("I enter role name {string} and description {string}")
    public void iEnterRoleNameAndDescription(String roleName, String description) {
        rolesPage.enterInformationInAddDataForm(roleName, description);
    }

    @And("I enter genre name {string}")
    public void iEnterGenreName(String genreName) {
        genresPage.enterInformationInAddDataForm(genreName);
    }

    @And("I enter chapter name {string} and status {string}")
    public void iEnterChapterNameAndStatus(String chapterName, String status) {
        chapterPage.enterInformationInFirstGroup(chapterName, status);
    }

    @And("I select is active {string}")
    public void iSelectIsActive(String isActive) throws InterruptedException {
        actionKeyword.clickOnElementByFullText(isActive);
        Thread.sleep(500);
    }

    @And("I select role {string}")
    public void iSelectRole(String role) {
        usersPage.addRolesInAddUserForm(role);
    }

    @And("I select license {string}")
    public void iSelectLicense(String license) {
        authorsPage.addLicenseInAddAuthorForm(license);
    }

    @And("I select authors {string} and genres {string}")
    public void iSelectAuthorsAndGenres(String authors, String genres) {
        ebooksPage.addAuthorsInAddEbookForm(authors);
        ebooksPage.addGenresInAddEbookForm(genres);
    }

    @And("I select ebook {string}")
    public void iSelectEbook(String ebook) {
        chapterPage.addEbookInAddChapterForm(ebook);
    }

    @And("I select image")
    public void iSelectImage() throws InterruptedException {
        adminBasePage.uploadImageInAddDataForm("C:\\Workspaces\\Working\\Flook\\flook-web-test\\src\\images\\avatar.png");
    }

    @And("I click on submit button")
    public void iClickOnSubmitButton() throws InterruptedException {
        actionKeyword.clickOnElementByText("Gửi");
        Thread.sleep(2000);
    }

    @Then("I will see the user that I created with the email {string}")
    public void iWillSeeTheUserThatICreatedWithTheEmail(String email) throws InterruptedException {
        Assert.assertTrue(usersPage.verifyThatTheUserHasBeenCreated(email));
    }

    @Then("I will see the author that I created with the author name {string}")
    public void iWillSeeTheAuthorThatICreatedWithTheAuthorName(String authorName) throws InterruptedException {
        Assert.assertTrue(authorsPage.verifyThatTheAuthorHasBeenCreated(authorName));
    }

    @Then("I will see the ebook that I created with the name {string}")
    public void iWillSeeTheEbookThatICreatedWithTheName(String name) throws InterruptedException {
        Assert.assertTrue(ebooksPage.verifyThatTheEbookHasBeenCreated(name));
    }

    @Then("I will see the role that I created with the name {string}")
    public void iWillSeeTheRoleThatICreatedWithTheName(String name) throws InterruptedException {
        Assert.assertTrue(rolesPage.verifyThatTheRoleHasBeenCreated(name));
    }

    @Then("I will see the genre that I created with the name {string}")
    public void iWillSeeTheGenreThatICreatedWithTheName(String name) throws InterruptedException {
        Assert.assertTrue(genresPage.verifyThatTheGenreHasBeenCreated(name));
    }

    @Then("I will see the chapter that I created with the chapter name {string}")
    public void iWillSeeTheChapterThatICreatedWithTheChapterName(String chapterName) throws InterruptedException {
        Assert.assertTrue(chapterPage.verifyThatTheChapterHasBeenCreated(chapterName));
    }

    @And("I click on the active button of the user that have the email {string}")
    public void iClickOnTheActiveButtonOfTheUserThatHaveTheEmail(String email) {
        usersPage.clickOnUserActiveButtonByEmail(email);
    }

    @And("I log out of my account")
    public void iLogOutOfMyAccount() throws InterruptedException {
        driver.navigate().to("http://localhost:3000/");
        homePage = new HomePage(this.driver);
        Thread.sleep(500);
        homePage.clickOnHeaderUserButton();
        actionKeyword.clickOnElementByText("Đăng xuất");
        Thread.sleep(2000);
    }

    @And("I click on the update button of the user {string}")
    public void iClickOnTheUpdateButtonOfTheUser(String email) {
        usersPage.clickOnUpdateUserButtonByEmail(email);
    }

    @Then("I will see display name {string}, phone number {string}, username {string} and email {string}")
    public void iWillSeeDisplayNamePhoneNumberUsernameAndEmail(String displayName, String phoneNumber, String username, String email) throws InterruptedException {
        Assert.assertTrue(usersPage.verifyAllInformationOfFirstGroupInUpdateDataFormAreDisplay(displayName, phoneNumber, username, email));
    }

    @Then("I will see the activation status {string}")
    public void iWillSeeTheActivationStatus(String activeStatus) throws InterruptedException {
        Assert.assertTrue(usersPage.verifyAllInformationOfSecondGroupInUpdateDataFormAreDisplay(activeStatus));
    }

    @Then("I will see the roles {string}")
    public void iWillSeeTheRoles(String roles) throws InterruptedException {
        Assert.assertTrue(usersPage.verifyAllInformationOfThirdGroupInUpdateDataFormAreDisplay(roles));
    }

    @Then("I will see the avatar with the link {string}")
    public void iWillSeeTheAvatarWithTheLink(String avatarLink) {
        Assert.assertTrue(usersPage.verifyThatTheAvatarIsCorrectByLink(avatarLink));
    }

    @And("I click on the update button of the role {string}")
    public void iClickOnTheUpdateButtonOfTheRole(String roleName) {
        rolesPage.clickOnUpdateRoleButtonByRoleName(roleName);
    }

    @Then("I will see the role name {string} and the description {string}")
    public void iWillSeeTheRoleNameAndTheDescription(String roleName, String description) throws InterruptedException {
        Assert.assertTrue(rolesPage.verifyAllInformationOfUpdateDataFormAreDisplay(roleName, description));
    }

    @And("I click on the update button of the ebook {string}")
    public void iClickOnTheUpdateButtonOfTheEbook(String ebookTitle) {
        ebooksPage.clickOnUpdateUserButtonByEmail(ebookTitle);
    }

    @Then("I will see ebook tilte {string}, status {string} and description {string}")
    public void iWillSeeEbookTilteStatusAndDescription(String ebookTitle, String status, String description) throws InterruptedException {
        Assert.assertTrue(ebooksPage.verifyAllInformationOfFirstGroupInUpdateDataFormAreDisplay(ebookTitle, status, description));
    }

    @Then("I will see the authors {string} and the genres {string}")
    public void iWillSeeTheAuthorsAndTheGenres(String authors, String genres) throws InterruptedException {
        Assert.assertTrue(ebooksPage.verifyAllAuthorsInUpdateDataFormAreDisplay(authors));
        Assert.assertTrue(ebooksPage.verifyAllGenresInUpdateDataFormAreDisplay(genres));
    }

    @Then("I will see the book cover with the link {string}")
    public void iWillSeeTheBookCoverWithTheLink(String bookCoverLink) {
        Assert.assertTrue(ebooksPage.verifyThatTheBookCoverIsCorrectByLink(bookCoverLink));
    }

    @And("I click on the update button of the author {string}")
    public void iClickOnTheUpdateButtonOfTheAuthor(String authorName) {
        authorsPage.clickOnUpdateAuthorButtonByAuthorName(authorName);
    }

    @Then("I will see author name {string}")
    public void iWillSeeAuthorName(String authorName) throws InterruptedException {
        Assert.assertTrue(authorsPage.verifyAllInformationOfFirstGroupInUpdateDataFormAreDisplay(authorName));
    }

    @Then("I will see the licenses {string}")
    public void iWillSeeTheLicenses(String licenses) throws InterruptedException {
        Assert.assertTrue(authorsPage.verifyAllInformationOfSecondGroupInUpdateDataFormAreDisplay(licenses));
    }

    @Then("I will see the author avatar with the link {string}")
    public void iWillSeeTheAuthorAvatarWithTheLink(String avatarLink) {
        Assert.assertTrue(authorsPage.verifyThatTheAvatarIsCorrectByLink(avatarLink));
    }

    @And("I click on the update button of the genre {string}")
    public void iClickOnTheUpdateButtonOfTheGenre(String genreName) {
        genresPage.actions.sendKeys(Keys.ESCAPE).build().perform();
        genresPage.clickOnUpdateGenreButtonByGenreName(genreName);
    }

    @Then("I will see genre name {string}")
    public void iWillSeeGenreName(String genreName) throws InterruptedException {
        Assert.assertTrue(genresPage.verifyAllInformationInUpdateDataFormAreDisplay(genreName));
    }
}