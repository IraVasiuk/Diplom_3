import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import pageobject.LoginPage;
import pageobject.MainPage;
import pageobject.PasswordPage;
import pageobject.RegistrationPage;

public class EntranceTest extends Autostart {

    @Rule
    public DriverRule driverRule = new DriverRule();

    @Test
    @DisplayName("Вход по кнопке «Войти в аккаунт» на главной")
    @Description("Подтверждение входа с помощью кнопки входа на главной странице с последующей авторизацией")
    public void loginThroughSignInButton() {
        WebDriver driver = driverRule.getDriver();
        MainPage mainPage = new MainPage(driver);
        mainPage.openMainPage();
        mainPage.clickLogin();
        LoginPage loginPage = new LoginPage(driver);
        loginPage.authorizationFromLoginPage(user);
        loginPage.clickRegisterButtonLoginPage();
        Assert.assertTrue(mainPage.isMainPageOpen());
    }

    @Test
    @DisplayName("Вход через кнопку «Личный кабинет»")
    @Description("Верификация входа с помощью кнопки Личный кабинет на главной странице с последующей авторизацией")
    public void loginThroughPersonalAccountButton() {
        WebDriver driver = driverRule.getDriver();
        MainPage mainPage = new MainPage(driver);
        mainPage.openMainPage();
        mainPage.clickAccountButton();
        LoginPage loginPage = new LoginPage(driver);
        loginPage.authorizationFromLoginPage(user);
        loginPage.clickRegisterButtonLoginPage();
        Assert.assertTrue(mainPage.isMainPageOpen());
    }

    @Test
    @DisplayName("Вход через кнопку в форме регистрации")
    @Description("Подтверждение входа в систему в регистрационной форме с последующей авторизацией")
    public void loginThroughTheButtonInTheRegistrationForm() {
        WebDriver driver = driverRule.getDriver();
        RegistrationPage registrationPage = new RegistrationPage(driver);
        registrationPage.open();
        registrationPage.registerUser(user);
        registrationPage.clickSignButton();
        LoginPage loginPage = new LoginPage(driver);
        loginPage.authorizationFromLoginPage(user);
        loginPage.clickRegisterButtonLoginPage();
        MainPage mainPage = new MainPage(driver);
        Assert.assertTrue(mainPage.isMainPageOpen());
    }

    @Test
    @DisplayName("Вход через кнопку в форме восстановления пароля")
    @Description("Подтверждение логина в форме восстановления пароля с последующей авторизацией")
    public void loginFromRecoveryPage() {
        WebDriver driver = driverRule.getDriver();
        PasswordPage passPage = new PasswordPage(driver);
        passPage.openRecoveryPage();
        passPage.clickEnterButtonOnRecoveryPage();
        LoginPage loginPage = new LoginPage(driver);
        loginPage.authorizationFromLoginPage(user);
        loginPage.clickRegisterButtonLoginPage();
        MainPage mainPage = new MainPage(driver);
        Assert.assertTrue(mainPage.isMainPageOpen());
    }
}