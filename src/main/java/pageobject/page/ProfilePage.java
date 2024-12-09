package pageobject.page;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class ProfilePage extends BasePage {

    //кнопка/ссылка Конструктор в шапке страницы Личный кабинет
    private final By constructorButtonOnProfilePage = By.xpath(".//p[text()='Конструктор']");
    //логотип в шапке страницы Личный кабинет
    private final By logoButtonOnProfilePage = By.xpath(".//div[@class='AppHeader_header__logo__2D0X2']/a[@href='/']");
    //кнопка Выход на странице Личный кабинет
    private final By exitButtonOnProfilePage = By.xpath(".//button[text()='Выход']");
    //локатор элемента со страницы Личный кабинет
    private final By elementOnProfilePage = By.xpath(".//a[@href='/account/profile']");

    public ProfilePage(WebDriver driver) {
        super(driver);
    }

    @Step("Click on the Constructor button on the profile page")
    public void clickConstructorButton() {
        driver.findElement(constructorButtonOnProfilePage).click();
    }

    @Step("Click on the logo on the profile page")
    public void clickLogoButton() {
        driver.findElement(logoButtonOnProfilePage).click();
    }

    @Step("Click on the logout button on the profile page")
    public void clickExitButton() {
        driver.findElement(exitButtonOnProfilePage).click();
    }

    @Step("Getting the correct profile page url")
    public String getUrlOnProfilePage() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(elementOnProfilePage));
        return driver.getCurrentUrl();
    }
}
