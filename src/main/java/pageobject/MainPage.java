package pageobject;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import static constants.Urls.URL;

public class MainPage {

    private final WebDriver driver;
    private final By currentMenu = By.xpath("//div[contains(@class,'tab_tab__1SPyG tab_tab_type_current__2BEPc')]");
    private final By enterAccountButtonMain = By.xpath(".//button[text()='Войти в аккаунт']");
    private final By profileMainButton = By.xpath(".//p[text()='Личный Кабинет']");

//    private final By makeOrderButton = By.xpath(".//button[text()='Оформить заказ']");  прописан путь иначе, тк падают тесты
    private final By makeOrderButton = By.cssSelector("[class*=button_button__33qZ0]");

    private final By bunsButton = By.xpath(".//span[contains(text(),'Булки')]");
    private final By saucesButton = By.xpath(".//span[contains(text(),'Соусы')]");
    private final By fillingButton = By.xpath(".//span[contains(text(),'Начинки')]");
    private final By setBurgerIndicator = By.xpath(".//*[text()='Соберите бургер']");

    public MainPage(WebDriver driver) {

        this.driver = driver;
    }

    @Step("Открыть главную страницу")
    public void openMainPage() {
        driver.get(URL);
    }

    @Step("Тапнуть на Войти а аккаунт")
    public void clickLogin() {
        driver.findElement(enterAccountButtonMain).click();
    }

    @Step("Проверка отображается ли текст Соберите бургер на главной странице")
    public boolean isBurgerInscriptionDisplayed() {
        return driver.findElement(setBurgerIndicator).isDisplayed();
    }

    @Step("Проверка отображается ли кнопка Оформить заказ на главной странице")
    public boolean isMainPageOpen() {
        return driver.findElement(makeOrderButton).isDisplayed();
    }

    @Step("Нажать на кнопку Личный кабинет")
    public void clickAccountButton() {
        driver.findElement(profileMainButton).click();
    }

    @Step("Нажать на кнопку Булки")
    public void clickBunsButton() {
        driver.findElement(bunsButton).click();
    }

    @Step("Нажать на кнопку Соусы")
    public void clickSaucesButton() {
        driver.findElement(saucesButton).click();
    }

    @Step("Нажать на кнопку Начинки")
    public void clickFillingsButton() {
        driver.findElement(fillingButton).click();
    }

    @Step("Проверка текста текущего меню")
    public String getTextFromSelectedMenu() {
        return driver.findElement(currentMenu).getText();
    }


}