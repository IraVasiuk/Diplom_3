import data.*;
import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import org.junit.*;
import pageobject.LoginPage;
import org.openqa.selenium.WebDriver;
import pageobject.MainPage;
import pageobject.RegistrationPage;
import static constants.Data.*;

public class RegistrationTest {
    private User user;

    @Rule
    public DriverRule driverRule = new DriverRule();

    @Test
    @DisplayName("Проверка правильности пароля при регистрации")
    @Description("Регистрация на странице регистрации с правильным паролем длиной более 5 символов")
    public void registrationOnRegPageSuccess() {
        user = new User(RANDOM_EMAIL, RANDOM_PASSWORD, RANDOM_NAME);
        WebDriver driver = driverRule.getDriver();
        RegistrationPage registrationPage = new RegistrationPage(driver);
        registrationPage.open();
        registrationPage.registerUser(user);
        registrationPage.openRegisterPage();
        LoginPage loginPage = new LoginPage(driver);
        loginPage.authorizationFromLoginPage(user);
        loginPage.clickRegisterButtonLoginPage();
        MainPage mainPage = new MainPage(driver);
        Assert.assertTrue(mainPage.isMainPageOpen());
    }

    @Test
    @DisplayName("Проверка правильности пароля при регистрации")
    @Description("Регистрация на странице входа в систему с правильным паролем длиной более 5 символов")
    public void registrationOnLoginPageSuccess() {
        user = new User(RANDOM_EMAIL, RANDOM_PASSWORD, RANDOM_NAME);
        WebDriver driver = driverRule.getDriver();
        LoginPage loginPage = new LoginPage(driver);
        loginPage.openLoginPage();
        loginPage.clickRegisterButton();
        RegistrationPage registrationPage = new RegistrationPage(driver);
        registrationPage.registerUser(user);
        registrationPage.openRegisterPage();
        loginPage.authorizationFromLoginPage(user);
        loginPage.clickRegisterButtonLoginPage();
        MainPage mainPage = new MainPage(driver);
        Assert.assertTrue(mainPage.isMainPageOpen());
    }

    @Test
    @DisplayName("Проверка правильности пароля при регистрации")
    @Description("Регистрация на главной странице с правильным паролем длиной более 5 символов")
    public void registrationOnMainPageSuccess() {
        user = new User(RANDOM_EMAIL, RANDOM_PASSWORD, RANDOM_NAME);
        WebDriver driver = driverRule.getDriver();
        MainPage mainPage = new MainPage(driver);
        mainPage.openMainPage();
        mainPage.clickLogin();
        LoginPage loginPage = new LoginPage(driver);
        loginPage.clickRegisterButton();
        RegistrationPage registrationPage = new RegistrationPage(driver);
        registrationPage.registerUser(user);
        registrationPage.openRegisterPage();
        loginPage.authorizationFromLoginPage(user);
        loginPage.clickRegisterButtonLoginPage();
        Assert.assertTrue(mainPage.isMainPageOpen());
    }

    @Test
    @DisplayName("Проверка регистрации с неправильным паролем")
    @Description("Проверка регистрации с использованием неверного пароля, состоящего из 4 символов")
    public void checkRegistrationWithWrongPassError() {
        user = new User(RANDOM_EMAIL, RANDOM_PASSWORD_4_CHAR, RANDOM_NAME);
        WebDriver driver = driverRule.getDriver();
        RegistrationPage registrationPage = new RegistrationPage(driver);
        registrationPage.open();
        registrationPage.registerUser(user);
        Assert.assertTrue(registrationPage.isWrongPasswordDisplayed());
    }

}