import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import org.junit.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pageobject.MainPage;

import java.util.concurrent.TimeUnit;

public class ConstructorTest {
    private MainPage mainPage;

    @Rule
    public DriverRule driverRule = new DriverRule();

    @Test
    @DisplayName("Переход к разделу Булки")
    @Description("Проверка того, выбрана ли кнопка, путем получения текста")
    public void menuBunIsActiveByClick() {
        WebDriver driver = driverRule.getDriver();
        mainPage = new MainPage(driver);
        mainPage.openMainPage();
        mainPage.clickFillingsButton();
        mainPage.clickBunsButton();
        Assert.assertEquals("Булки", mainPage.getTextFromSelectedMenu());
    }

    @Test
    @DisplayName("Переход к разделу Соусы")
    @Description("Проверка того, выбрана ли кнопка, путем получения текста")
    public void menuSaucesIsActiveByClick() {
        WebDriver driver = driverRule.getDriver();
        mainPage = new MainPage(driver);
        mainPage.openMainPage();
        mainPage.clickFillingsButton();
        mainPage.clickSaucesButton();
        Assert.assertEquals("Соусы", mainPage.getTextFromSelectedMenu());
    }

    @Test
    @DisplayName("Переход к раздел Начинки")
    @Description("Проверка того, выбрана ли кнопка, путем получения текста")
    public void menuFillingIsActiveByClick() {
        WebDriver driver = driverRule.getDriver();
        mainPage = new MainPage(driver);
        mainPage.openMainPage();
        mainPage.clickSaucesButton();
        mainPage.clickFillingsButton();
        Assert.assertEquals("Начинки", mainPage.getTextFromSelectedMenu());
    }

}