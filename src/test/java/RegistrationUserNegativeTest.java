import io.qameta.allure.Description;
import org.junit.Test;
import pageobject.page.LoginPage;
import pageobject.page.MainPage;
import pageobject.page.RegisterPage;

import static org.junit.Assert.assertTrue;

public class RegistrationUserNegativeTest extends BaseTest {

    String name = "Вася";
    String email = "infestberserk@yandex.ru";
    String password = "12345";

    @Test
    @Description("Checking for registration error when entering an incorrect password")
    public void registrationUserNegativeTest() {
        MainPage mainPage = new MainPage(driver);
        mainPage.waitPageLoading();
        mainPage.clickLoginButtonOnMainPage();

        LoginPage loginPage = new LoginPage(driver);
        loginPage.clickRegisterLink();

        RegisterPage registerPage = new RegisterPage(driver);
        registerPage.fillFormRegistration(name, email, password);

        boolean result = registerPage.isRegisterErrorDisplayed();
        assertTrue(result);

    }
}
