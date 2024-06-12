package pageobject;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import static constants.Urls.RECOVERY_PASSWORD;

public class PasswordPage {

    private final By enterButtonOnRecoverPage = By.xpath(".//a[text()='Войти']");
    private final WebDriver driver;

    public PasswordPage(WebDriver driver) {
        this.driver = driver;
    }

    @Step("Открыть страницу Восстановление пароля")
    public void openRecoveryPage() {
        driver.get(RECOVERY_PASSWORD);
    }

    @Step("Нажать на кнопку Войти на странице восстановления пароля")
    public void clickEnterButtonOnRecoveryPage() {
        driver.findElement(enterButtonOnRecoverPage).click();
    }
}