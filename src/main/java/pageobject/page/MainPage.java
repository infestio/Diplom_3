package pageobject.page;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class MainPage extends BasePage {

    public static final String URL = "https://stellarburgers.nomoreparties.site";

    //Кнопка Входа в аккаунт на главной странице
    private final By loginButtonOnMainPage = By.xpath(".//button[text()='Войти в аккаунт']");
    //Кнопка Оформить заказ на главной странице
    private final By placeOrderButtonOnMainPage = By.xpath(".//button[text()='Оформить заказ']");
    //Кнопка Личный кабинет на главной странице
    private final By personalAccountButtonOnMainPage = By.xpath(".//p[text()='Личный Кабинет']");

    //Вкладка с соусами
    private final By saucesTab = By.xpath(".//span[text()='Соусы']/parent::div");
    //Вкладка с начинками
    private final By toppingTab = By.xpath(".//span[text()='Начинки']/parent::div");
    //Вкладка с булками
    private final By bunTab = By.xpath(".//span[text()='Булки']/parent::div");



    public MainPage(WebDriver driver) {
        super(driver);
    }

    @Step("Waiting for the page to load and display the Login button")
    public void waitPageLoading() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(loginButtonOnMainPage));
    }

    @Step("Click on the login button on the main page")
    public void clickLoginButtonOnMainPage() {
        driver.findElement(loginButtonOnMainPage).click();
    }

    @Step("Click on the Personal Account button on the main page")
    public void clickPersonalAccountButtonOnMainPage() {
        driver.findElement(personalAccountButtonOnMainPage).click();
    }

    @Step("Waiting for the Place Order button to be displayed")
    public boolean isPlaceOrderButtonDisplayed() {
        return driver.findElement(placeOrderButtonOnMainPage).isDisplayed();
    }

    @Step("Extracting the value of the attribute of the Buns tab")
    public String extractAttributeValueOfElementBunTab() {
        return driver.findElement(bunTab).getDomAttribute("class");
    }

    @Step("Extracting the value of the Sauces tab attribute")
    public String extractAttributeValueOfElementSaucesTab() {
        return driver.findElement(saucesTab).getDomAttribute("class");
    }

    @Step("Extracting the value of the Toppings tab attribute")
    public String extractAttributeValueOfElementToppingTab() {
        return driver.findElement(toppingTab).getDomAttribute("class");
    }

    @Step("Click on the Buns tab")
    public void clickOfBunTab() {
        driver.findElement(bunTab).click();
    }

    @Step("Click on the Sauces tab")
    public void clickOfSaucesTab() {
        driver.findElement(saucesTab).click();
    }

    @Step("Click on the Toppings tab")
    public void clickToppingTab() {
        driver.findElement(toppingTab).click();
    }

}
