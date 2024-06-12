import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import pageobject.LoginPage;
import pageobject.MainPage;
import pageobject.AccountPage;

public class LogoutTest extends Autostart {

    @Rule
    public DriverRule driverRule = new DriverRule();

    @Test
    @DisplayName("Проверка выхода по кнопке «Выйти» в личном кабинете")
    @Description("Проверка, что после выхода из профиля отображается страница авторизации - Вход")
    public void logoutSuccess() {
        WebDriver driver = driverRule.getDriver();
        MainPage mainPage = new MainPage(driver);
        mainPage.openMainPage();
        mainPage.clickLogin();
        LoginPage loginPage = new LoginPage(driver);
        loginPage.authorizationFromLoginPage(user);
        loginPage.clickRegisterButtonLoginPage();
        mainPage.clickAccountButton();
        AccountPage accountPage = new AccountPage(driver);
        accountPage.clickLogOutButton();
        Assert.assertTrue(loginPage.isLoginIndicatorDisplayed());
    }

}