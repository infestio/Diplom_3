import api.client.User;
import api.client.UserClient;
import io.qameta.allure.Description;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import pageobject.page.LoginPage;
import pageobject.page.MainPage;
import pageobject.page.ProfilePage;

import java.time.Duration;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class PersonalAccountPositiveTest extends BaseTest {

    private UserClient userClient;
    private User user;
    private String accessToken;

    @Before
    public void setUp() {
        userClient = new UserClient();
        user = new User("infestberserk@yandex.ru", "Qwerty1234", "Вася");
        accessToken = userClient.create(user).extract().path("accessToken");
    }

    @Test
    @Description("Checking the click-through to the Personal Account")
    public void goToPersonalAccountTest() {
        MainPage mainPage = new MainPage(driver);
        mainPage.waitPageLoading();
        mainPage.clickLoginButtonOnMainPage();

        LoginPage loginPage = new LoginPage(driver);
        loginPage.fillLoginForm(user.getEmail(), user.getPassword());

        mainPage.clickPersonalAccountButtonOnMainPage();

        ProfilePage profilePage = new ProfilePage(driver);
        String result = profilePage.getUrlOnProfilePage();
        assertEquals("https://stellarburgers.nomoreparties.site/account/profile", result);

    }

    @Test
    @Description("Checking the transition by clicking on the Constructor on the profile page")
    public void clickConstructorAndMoveMainPageTest() {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        MainPage mainPage = new MainPage(driver);
        mainPage.clickLoginButtonOnMainPage();
        LoginPage loginPage = new LoginPage(driver);
        loginPage.fillLoginForm(user.getEmail(), user.getPassword());
        mainPage.clickPersonalAccountButtonOnMainPage();

        ProfilePage profilePage = new ProfilePage(driver);
        profilePage.clickConstructorButton();
        boolean result = mainPage.isPlaceOrderButtonDisplayed();
        assertTrue(result);
    }

    @Test
    @Description("Checking the transition by clicking on the Logo on the profile page")
    public void clickLogoOnProfilePageAndMoveTest() {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        MainPage mainPage = new MainPage(driver);
        mainPage.clickLoginButtonOnMainPage();
        LoginPage loginPage = new LoginPage(driver);
        loginPage.fillLoginForm(user.getEmail(), user.getPassword());
        mainPage.clickPersonalAccountButtonOnMainPage();

        ProfilePage profilePage = new ProfilePage(driver);
        profilePage.clickLogoButton();
        boolean result = mainPage.isPlaceOrderButtonDisplayed();
        assertTrue(result);
    }

    @Test
    @Description("Checking if you are logged out when you click the Log Out button on your profile page")
    public void logoutFromAccountTest() {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        MainPage mainPage = new MainPage(driver);
        mainPage.clickLoginButtonOnMainPage();
        LoginPage loginPage = new LoginPage(driver);
        loginPage.fillLoginForm(user.getEmail(), user.getPassword());
        mainPage.clickPersonalAccountButtonOnMainPage();

        ProfilePage profilePage = new ProfilePage(driver);
        profilePage.clickExitButton();
        boolean result = loginPage.isTextOnLoginPageDisplayed();
        assertTrue(result);
    }

    @After
    public void cleanUp() {
        userClient.delete(accessToken);
    }

}
