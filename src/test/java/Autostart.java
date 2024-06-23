import data.*;
import io.restassured.response.ValidatableResponse;
import org.junit.After;
import org.junit.Before;
import static constants.Data.*;

public class Autostart {
    public UserSteps userSteps;
    public String accessToken;
    public User user;

    @Before
    public void setUp() {
        user = new User(RANDOM_EMAIL, RANDOM_PASSWORD, RANDOM_NAME);
        userSteps = new UserSteps();
        ValidatableResponse validatableResponse = userSteps.createUser(user);
        accessToken = userSteps.getAccessToken(validatableResponse);
    }

    @After
    public void close() {
        userSteps.deletingUsersAfterTests(accessToken);
    }
}