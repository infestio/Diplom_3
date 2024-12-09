package api.client;

import io.restassured.response.ValidatableResponse;

import static io.restassured.RestAssured.given;

public class UserClient extends RestClient {

    private static final String USER_PATH = "/api/auth/register";
    private static final String LOGIN_PATH = "/api/auth/login";
    private static final String DELETE_PATH = "/api/auth/user";


    public ValidatableResponse create(User user) {
        return  given()
                .log()
                .all()
                .spec(getBaseSpec())
                .body(user)
                .when()
                .post(USER_PATH)
                .then()
                .log()
                .all();
    }


    public ValidatableResponse login(UserCredentials userCredentials) {
        return given()
                .log()
                .all()
                .spec(getBaseSpec())
                .body(userCredentials)
                .when()
                .post(LOGIN_PATH)
                .then()
                .log()
                .all();
    }


    public void delete(String accessToken) {
                given()
                .log()
                .all()
                .spec(getBaseSpec())
                .header("Authorization", accessToken)
                .when()
                .delete(DELETE_PATH)
                .then()
                .log()
                .all();
    }
}
