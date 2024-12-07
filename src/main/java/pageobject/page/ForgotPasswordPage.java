package pageobject.page;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ForgotPasswordPage extends BasePage {

    //ссылка на страницу входа в аккаунт
    private final By loginLinkOnForgotPasswordPage = By.xpath(".//a[text()='Войти']");

    public ForgotPasswordPage(WebDriver driver) {
        super(driver);
    }

    @Step("Click on the link to the Login page from the Forgot your password page")
    public void clickLoginLinkOnForgotPasswordPage() {
        driver.findElement(loginLinkOnForgotPasswordPage).click();
    }
}
