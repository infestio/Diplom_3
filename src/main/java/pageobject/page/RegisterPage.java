package pageobject.page;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RegisterPage extends BasePage {

    //поле Имя в форме регистрации пользователя
    private final By nameFieldOnRegisterPage = By.xpath(".//fieldset[1]//input[@name='name']");
    //поле Email в форме регистрации пользователя
    private final By emailFieldOnRegisterPage = By.xpath(".//fieldset[2]//input[@name='name']");
    //поле Пароль в форме регистрации пользователя
    private final By passwordFieldOnRegisterPage = By.xpath(".//input[@type='password']");
    //кнопка Зарегистрироваться на странице регистрации
    private final By registerButtonOnRegisterPage = By.xpath(".//button[text()='Зарегистрироваться']");
    //локатор отображения ошибки при неудачной регистрации
    private final By registerErrorOnRegisterPage = By.xpath(".//div[@class='input pr-6 pl-6 input_type_password input_size_default input_status_error']");
    //ссылка на страницу Входа в аккаунт со страницы регистрации
    private final By loginLinkOnRegisterPage = By.xpath(".//a[@href='/login']");


    public RegisterPage(WebDriver driver) {
        super(driver);
    }

    @Step("Fill in the Name field in the registration form")
    public void fillNameFieldFormRegistration(String name) {
        driver.findElement(nameFieldOnRegisterPage).sendKeys(name);
    }

    @Step("Fill in the Email field in the registration form")
    public void fillEmailFieldFormRegistration(String email) {
        driver.findElement(emailFieldOnRegisterPage).sendKeys(email);
    }

    @Step("Fill in the Password field in the registration form")
    public void fillPasswordFieldFormRegistration(String password) {
        driver.findElement(passwordFieldOnRegisterPage).sendKeys(password);
    }

    @Step("Click on the Register button on the registration page")
    public void clickRegistrationButton() {
        driver.findElement(registerButtonOnRegisterPage).click();
    }

    @Step("Filling out the entire registration form and registering the user")
    public void fillFormRegistration(String name, String email, String password) {
        fillNameFieldFormRegistration(name);
        fillEmailFieldFormRegistration(email);
        fillPasswordFieldFormRegistration(password);
        clickRegistrationButton();
    }

    @Step("Displaying registration error")
    public boolean isRegisterErrorDisplayed() {
       return driver.findElement(registerErrorOnRegisterPage).isDisplayed();
    }

    @Step("Click on the Login link on the registration page")
    public void clickLoginLinkOnRegisterPage() {
        driver.findElement(loginLinkOnRegisterPage).click();
    }



}
