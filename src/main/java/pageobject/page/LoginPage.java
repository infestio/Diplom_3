package pageobject.page;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class LoginPage extends BasePage {

    //ссылка на страницу регистрации со страницы входа в аккаунт
    private final By registerLinkOnLoginPage = By.xpath(".//a[@href='/register']");
    //локатор текста Вход на странице входа в аккаунт
    private final By textOnLoginPage = By.xpath(".//h2[text()='Вход']");
    //поле Email в форме авторизации пользователя
    private final By emailFieldOnLoginPage = By.xpath(".//input[@name='name']");
    //поле Пароль в форме авторизации пользователя
    private final By passwordFieldOnLoginPage = By.xpath(".//input[@name='Пароль']");
    //кнопка Войти в аккаунт на странице входа в аккаунт
    private final By loginButtonOnLoginPage = By.xpath(".//button[text()='Войти']");
    //ссылка Восстановить пароль на странице входа в аккаунт
    private final By forgotPasswordLinkOnLoginPage = By.xpath(".//a[@href='/forgot-password']");

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    @Step("Click on the Register link on the account login page")
    public void clickRegisterLink() {
        driver.findElement(registerLinkOnLoginPage).click();
    }

    @Step("Getting the correct login page URL")
    public String getUrlOnLoginPage() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(textOnLoginPage));
       return driver.getCurrentUrl();
    }

    @Step("Filling in the Email field in the authorization form")
    public void fillEmailFieldOnLoginPage(String email) {
        driver.findElement(emailFieldOnLoginPage).sendKeys(email);
    }

    @Step("Filling in the Password field in the authorization form")
    public void fillPasswordFieldOnLoginPage(String password) {
        driver.findElement(passwordFieldOnLoginPage).sendKeys(password);
    }

    @Step("Click on the Login to Account button on the login page")
    public void clickLoginButtonOnLoginPage() {
        driver.findElement(loginButtonOnLoginPage).click();
    }

    @Step("Filling out the authorization form and logging into your account")
    public void fillLoginForm(String email, String password) {
        fillEmailFieldOnLoginPage(email);
        fillPasswordFieldOnLoginPage(password);
        clickLoginButtonOnLoginPage();
    }

    @Step("Click on the link Recover password")
    public void clickForgotPasswordLink() {
        driver.findElement(forgotPasswordLinkOnLoginPage).click();
    }

    @Step("Displaying the text Login on the account login page")
    public boolean isTextOnLoginPageDisplayed() {
        return driver.findElement(textOnLoginPage).isDisplayed();
    }
}
