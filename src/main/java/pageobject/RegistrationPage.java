package pageobject;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import static constants.Urls.REGISTER_PAGE;
import data.User;

public class RegistrationPage {

    private final WebDriver driver;
    private final By nameField = By.xpath(".//label[text() = 'Имя']/../input[contains(@name, 'name')]");
    private final By emailField = By.xpath(".//label[text() = 'Email']/../input[contains(@name, 'name')]");
    private final By passwordField = By.xpath(".//label[text() = 'Пароль']/../input[contains(@type, 'password')]");
    private final By registerButton = By.xpath("//button[text()='Зарегистрироваться']");
    private final By signButton = By.xpath(".//a[text()='Войти']");
    private final By registerWrongPasswordMessage = By.xpath(".//*[text()='Некорректный пароль']");

    public RegistrationPage(WebDriver driver) {
        this.driver = driver;
    }

    public void open() {
        driver.get(REGISTER_PAGE);
    }

    @Step("Открыть страницу Регистрации")
    public void openRegisterPage() {
        driver.findElement(registerButton).click();
    }

    @Step("Ввести регистрационные данные - электронную почту, пароль и имя")
    public void registerUser(User user) {
        driver.findElement(emailField).click();
        driver.findElement(emailField).sendKeys(user.getEmail());
        driver.findElement(passwordField).click();
        driver.findElement(passwordField).sendKeys(user.getPassword());
        driver.findElement(nameField).click();
        driver.findElement(nameField).sendKeys(user.getName());
    }

    @Step("Получение логического значения при вводе неверного пароля")
    public boolean isWrongPasswordDisplayed() {
        return driver.findElement(registerWrongPasswordMessage).isDisplayed();
    }

    @Step("Нажать на кнопку Войти на странице регистрации")
    public void clickSignButton() {
        driver.findElement(signButton).click();
    }
}