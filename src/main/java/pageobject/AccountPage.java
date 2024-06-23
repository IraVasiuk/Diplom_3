package pageobject;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AccountPage {
    private final WebDriver driver;

    private final By logOutButton = By.xpath(".//button[text() = 'Выход']");

    private final By constructorButton = By.xpath(".//p[text()='Конструктор']");

    private final By burgerLogo  = By.xpath(".//div[@class='AppHeader_header__logo__2D0X2']");

    public AccountPage(WebDriver driver) {
        this.driver = driver;
    }

    @Step("Нажать на кнопку Выход")
    public void clickLogOutButton() {
        driver.findElement(logOutButton).click();
    }

    @Step("Нажать на кнопку Конструктор")
    public void clickConstructorButton() {
        driver.findElement(constructorButton).click();
    }

    @Step("Нажать на логотип")
    public void clickOnLogo() {
        driver.findElement(burgerLogo).click();
    }
}