import data.User;
import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import pageobject.LoginPage;
import pageobject.MainPage;
import pageobject.AccountPage;
import static constants.Data.*;

public class SwitchTest {
    private User user;

    @Rule
    public DriverRule driverRule = new DriverRule();

    @Test
    @DisplayName("Проверяем переход, нажав на кнопку Личный кабинет")
    @Description("Убеждаемся, что попадаем на страницу авторизации, где отображается надпись Войти")
    public void checkClickOnPersonalAccButton() {
        WebDriver driver = driverRule.getDriver();
        MainPage mainPage = new MainPage(driver);
        mainPage.openMainPage();
        mainPage.clickAccountButton();
        LoginPage loginPage = new LoginPage(driver);
        Assert.assertTrue(loginPage.isLoginIndicatorDisplayed());
    }

    @Test
    @DisplayName("Переход из личного кабинета в Конструктор")
    @Description("Проверка перехода из личного кабинета на главную страницу, нажатием кнопки Конструктор")
    public void switchFromProfileByClickDesignerButton() {
        user = new User(RANDOM_EMAIL, RANDOM_PASSWORD, RANDOM_NAME);
        WebDriver driver = driverRule.getDriver();
        MainPage mainPage = new MainPage(driver);
        mainPage.openMainPage();
        mainPage.clickAccountButton();
        LoginPage loginPage = new LoginPage(driver);
        loginPage.authorizationFromLoginPage(user);
        loginPage.clickRegisterButtonLoginPage();
        AccountPage accountPage = new AccountPage(driver);
        accountPage.clickConstructorButton();
        Assert.assertTrue(mainPage.isBurgerInscriptionDisplayed());
    }

    @Test
    @DisplayName("Переход из личного кабинета в конструктор через логотип")
    @Description("Проверьте переход из личного кабинета на главную страницу, нажав на логотип")
    public void switchFromProfileByClickLogoBurger() {
        user = new User(RANDOM_EMAIL, RANDOM_PASSWORD, RANDOM_NAME);
        WebDriver driver = driverRule.getDriver();
        MainPage mainPage = new MainPage(driver);
        mainPage.openMainPage();
        mainPage.clickAccountButton();
        LoginPage loginPage = new LoginPage(driver);
        loginPage.authorizationFromLoginPage(user);
        loginPage.clickRegisterButtonLoginPage();
        AccountPage accountPage = new AccountPage(driver);
        accountPage.clickOnLogo();
        Assert.assertTrue(mainPage.isBurgerInscriptionDisplayed());
    }

}