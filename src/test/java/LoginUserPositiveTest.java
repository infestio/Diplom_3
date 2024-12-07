import api.client.User;
import api.client.UserClient;
import io.qameta.allure.Description;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import pageobject.page.ForgotPasswordPage;
import pageobject.page.LoginPage;
import pageobject.page.MainPage;
import pageobject.page.RegisterPage;

import java.time.Duration;

import static org.junit.Assert.assertTrue;

public class LoginUserPositiveTest extends BaseTest {

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
    @Description("Checking your account login using the Login button on the main page")
    public void loginByButtonLoginOnMainPageTest() {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        MainPage mainPage = new MainPage(driver);
        mainPage.clickLoginButtonOnMainPage();

        LoginPage loginPage = new LoginPage(driver);
        loginPage.fillLoginForm(user.getEmail(), user.getPassword());

        boolean result = mainPage.isPlaceOrderButtonDisplayed();
        assertTrue(result);
    }

    @Test
    @Description("Checking the login to your account using the Login button via the Personal Account button")
    public void loginByButtonPersonalAccountTest() {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        MainPage mainPage = new MainPage(driver);
        mainPage.clickPersonalAccountButtonOnMainPage();

        LoginPage loginPage = new LoginPage(driver);
        loginPage.fillLoginForm(user.getEmail(), user.getPassword());

        boolean result = mainPage.isPlaceOrderButtonDisplayed();
        assertTrue(result);
    }

    @Test
    @Description("Checking account login via button in user registration form")
    public void loginByButtonRegisterFormTest() {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        MainPage mainPage = new MainPage(driver);
        mainPage.clickLoginButtonOnMainPage();

        LoginPage loginPage = new LoginPage(driver);
        loginPage.clickRegisterLink();

        RegisterPage registerPage = new RegisterPage(driver);
        registerPage.clickLoginLinkOnRegisterPage();

        loginPage.fillLoginForm(user.getEmail(), user.getPassword());

        boolean result = mainPage.isPlaceOrderButtonDisplayed();
        assertTrue(result);
    }

    @Test
    @Description("Checking your account login via the button in the password recovery form")
    public void loginByButtonForgotPasswordTest() {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        MainPage mainPage = new MainPage(driver);
        mainPage.clickLoginButtonOnMainPage();

        LoginPage loginPage = new LoginPage(driver);
        loginPage.clickForgotPasswordLink();

        ForgotPasswordPage forgotPasswordPage = new ForgotPasswordPage(driver);
        forgotPasswordPage.clickLoginLinkOnForgotPasswordPage();

        loginPage.fillLoginForm(user.getEmail(), user.getPassword());

        boolean result = mainPage.isPlaceOrderButtonDisplayed();
        assertTrue(result);
    }


    @After
    public void cleanUp() {
        userClient.delete(accessToken);
    }

}
