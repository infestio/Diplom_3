import api.client.UserClient;
import api.client.UserCredentials;
import io.qameta.allure.Description;
import org.junit.After;
import org.junit.Test;
import pageobject.page.LoginPage;
import pageobject.page.MainPage;
import pageobject.page.RegisterPage;

import static org.junit.Assert.assertEquals;



public class RegistrationUserTest extends BaseTest {

     String name = "Вася";
     String email = "infestberserk@yandex.ru";
     String password = "Qwerty1234";

    @Test
    @Description("Checking successful registration, after which you are redirected to the account login page")
    public void registrationUserPositiveTest() {
        MainPage mainPage = new MainPage(driver);
        mainPage.waitPageLoading();
        mainPage.clickLoginButtonOnMainPage();

        LoginPage loginPage = new LoginPage(driver);
        loginPage.clickRegisterLink();

        RegisterPage registerPage = new RegisterPage(driver);
        registerPage.fillFormRegistration(name, email, password);

        String result = loginPage.getUrlOnLoginPage();
        assertEquals("https://stellarburgers.nomoreparties.site/login", result);
    }

    @After
    public void cleanUp() {
        UserClient userClient = new UserClient();
        UserCredentials userCredentials = new UserCredentials(email, password);
        String accessToken = userClient.login(userCredentials).extract().path("accessToken");
        userClient.delete(accessToken);
    }

}
