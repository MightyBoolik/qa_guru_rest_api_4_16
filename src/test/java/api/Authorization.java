package api;

import java.util.Map;

import static io.restassured.RestAssured.given;

public class Authorization {

    public Map<String, String> login(String login, String password) {
        return
                given()
                        .contentType("application/x-www-form-urlencoded; charset=UTF-8")
                        .formParam("Email", "bkuchaev@gmail.com")
                        .formParam("Password", "43315231")
                        .when()
                        .post("/login")
                        .then()
                        .statusCode(302)
                        .log().body()
                        .extract().cookies();
    }
}

