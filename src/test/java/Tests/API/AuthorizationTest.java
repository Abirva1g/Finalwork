package Tests.API;

import API.Specification.AuthorizationSpec;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.HashMap;
import java.util.Map;

@DisplayName(value = "Авторизация")
public class AuthorizationTest {
    AuthorizationSpec authorizationSpec = new AuthorizationSpec();

    @Test
    @DisplayName("Авторизация.Существующий пользователь")
    public void positiveAuthorizationTest() {
        Map<String, String> paramsLogin = new HashMap<>();
        paramsLogin.put("username", "ASSEROV");
        paramsLogin.put("password", "Qwerty$4");
        authorizationSpec.getToken(paramsLogin);
        authorizationSpec.createRequestSpecificationAuthorization();
        authorizationSpec.createResponseSpecificationAuthorization(201);
    }

    @Test
    @DisplayName("Авторизация.Несуществующий пользователь")
    public void negativeAuthorizationTest() {
        Map<String, String> paramsLogin = new HashMap<>();
        paramsLogin.put("username", "PILULKIN");
        paramsLogin.put("password", "PILPAS");
        authorizationSpec.getToken(paramsLogin);
        authorizationSpec.createRequestSpecificationAuthorization();
        authorizationSpec.createResponseSpecificationAuthorization(403);
    }

    @Test
    @DisplayName("Авторизация. Только логин существующего клиента")
    public void onlyLoginAuthorizationTest() {
        Map<String, String> paramsLogin = new HashMap<>();
        paramsLogin.put("username", "ASSEROV");
        authorizationSpec.getToken(paramsLogin);
        authorizationSpec.createRequestSpecificationAuthorization();
        authorizationSpec.createResponseSpecificationAuthorization(403);
    }

    @Test
    @DisplayName("Авторизация. Только c паролем существующего клиента")
    public void onlyPasswordAuthorizationTest() {
        Map<String, String> paramsLogin = new HashMap<>();
        paramsLogin.put("password", "Qwerty$4");
        authorizationSpec.getToken(paramsLogin);
        authorizationSpec.createRequestSpecificationAuthorization();
        authorizationSpec.createResponseSpecificationAuthorization(403);
    }
}
