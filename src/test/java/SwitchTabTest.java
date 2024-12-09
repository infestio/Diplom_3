import io.qameta.allure.Description;
import org.junit.Test;
import pageobject.page.MainPage;

import java.time.Duration;

import static org.junit.Assert.assertTrue;

public class SwitchTabTest extends BaseTest {

    @Test
    @Description("Checking that the transition to the Sauces section occurs correctly when switching tabs")
    public void switchSaucesTabTest() {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        MainPage mainPage = new MainPage(driver);
        mainPage.clickOfSaucesTab();
        boolean result = mainPage.extractAttributeValueOfElementSaucesTab().contains("tab_tab_type_current__2BEPc");
        assertTrue(result);
    }

    @Test
    @Description("Checking that the transition to the Topping section occurs correctly when switching tabs")
    public void switchToppingsTabTest() {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        MainPage mainPage = new MainPage(driver);
        mainPage.clickToppingTab();
        boolean result = mainPage.extractAttributeValueOfElementToppingTab().contains("tab_tab_type_current__2BEPc");
        assertTrue(result);
    }

    @Test
    @Description("Checking that the transition to the Bun section occurs correctly when switching tabs")
    public void switchBunTabTest() {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        MainPage mainPage = new MainPage(driver);
        mainPage.clickOfSaucesTab();
        mainPage.clickToppingTab();
        mainPage.clickOfBunTab();
        boolean result = mainPage.extractAttributeValueOfElementBunTab().contains("tab_tab_type_current__2BEPc");
        assertTrue(result);
    }
}
