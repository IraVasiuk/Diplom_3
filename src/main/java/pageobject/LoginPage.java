package pageobject;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import static constants.Urls.LOGIN_PAGE;
import data.User;
import java.util.concurrent.TimeUnit;

public class LoginPage {
    private final WebDriver driver;
    private final By loginText = By.xpath(".//*[text()='Вход']");
    private final By registerButton = By.xpath(".//a[(@class = 'Auth_link__1fOlj' and text()= 'Зарегистрироваться')]");

//    private final By signButton = By.xpath(".//button[text()='Войти']"); прописан путь иначе, тк падают тесты
    private final By signButton = By.cssSelector("[class*=button_button__33qZ0]");
    private final By emailField = By.xpath(".//label[text()='Email']/following-sibling::input");
    private final By passwordField = By.xpath(".//*[text()='Пароль']/following-sibling::input");

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    @Step("Открыть страницу входа")
    public void openLoginPage() {
        driver.get(LOGIN_PAGE);
    }

    @Step("Страница авторизации - надпись Вход")
    public boolean isLoginIndicatorDisplayed() {
        return driver.findElement(loginText).isDisplayed();
    }

    @Step("Нажать на кнопку Зарегистрироваться")
    public void clickRegisterButton() {
        driver.findElement(registerButton).click();
    }

    @Step("Ввод электронной почты и пароля")
    public void authorizationFromLoginPage(User user) {
        driver.findElement(emailField).click();
        driver.findElement(emailField).sendKeys(user.getEmail());
        driver.findElement(passwordField).click();
        driver.findElement(passwordField).sendKeys(user.getPassword());
    }

    @Step("Нажать на кнопку Войти")
    public void clickRegisterButtonLoginPage() {
        driver.findElement(signButton).click();
        driver.manage().timeouts().implicitlyWait(20000, TimeUnit.MILLISECONDS);
    }
}