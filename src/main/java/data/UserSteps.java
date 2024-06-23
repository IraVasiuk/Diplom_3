package data;

import constants.Urls;
import data.CustomerSteps;
import data.User;
import io.qameta.allure.Step;
import io.restassured.response.ValidatableResponse;
import static io.restassured.RestAssured.given;

public class UserSteps extends CustomerSteps {

    @Step("Создать пользователя")
    public ValidatableResponse createUser(User user) {
        return given()
                .spec(getSpec())
                .body(user)
                .when()
                .post(Urls.REGISTER)
                .then();

    }

    @Step("Удалить пользователя")
    public void deleteUser(String accessToken) {
        given()
                .header("authorization", accessToken)
                .spec(getSpec())
                .when()
                .delete(Urls.USER);
    }

    @Step("Вход пользователя в систему")
    public ValidatableResponse login(CustomerSteps customerSteps) {
        return
                given()
                        .spec(getSpec())
                        .body(customerSteps)
                        .when()
                        .post(Urls.LOGIN)
                        .then();

    }

    @Step("Получение токена доступа")
    public String getAccessToken(ValidatableResponse validatableResponse) {
        return validatableResponse.extract().path("accessToken");
    }

    @Step("Удаление пользователя после тестирования")
    public void deletingUsersAfterTests(String accessToken) {
        if (accessToken != null) {
            deleteUser(accessToken);
        } else {
            given().spec(getSpec())
                    .when()
                    .delete(Urls.USER);
        }
    }
}