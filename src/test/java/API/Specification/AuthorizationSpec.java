package API.Specification;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import java.util.Map;
import static API.Properties.*;
import static io.restassured.RestAssured.given;

public class AuthorizationSpec {
    public static String token;
    public RequestSpecification requestSpec;
    public ResponseSpecification responseSpec;

    public void createRequestSpecificationAuthorization() {
        requestSpec = new RequestSpecBuilder()
                .addHeader("Authorization", "Bearer " + token)
                .setContentType(ContentType.JSON)
                .setBaseUri(BASE_URI)
                .setBasePath(LOGIN_PATH)
                .build();
    }

    public void createResponseSpecificationAuthorization(int status) {
        responseSpec = new ResponseSpecBuilder()
                .expectStatusCode(status)
                .build();
        if (status == 201) {
            System.out.println("Пользователь найден, код состояния ответа HTTP: " + status);
        } else {
            if (status == 403) {
                System.out.println("Пользователь не найден, код состояния ответа HTTP: " + status);
            } else {
                System.out.println("Код состояния ответа HTTP: " + status);
            }
        }
    }

    public String getToken(Map<String, String> paramsLogin) {
        String response = RestAssured.given().log().all()
                .formParams(paramsLogin)
                .get(BASE_URI + LOGIN_PATH)
                .asString();
        try {
            JsonPath jsonPath = JsonPath.from(response);
            token = jsonPath.getString("access_token");
            System.out.println("Токен авторизации получен: " + token);
        } catch (Exception e) {
            System.out.println("Токен авторизации не получен");
            token = null;
        }
        return token;
    }
}
