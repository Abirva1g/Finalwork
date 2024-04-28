package Tests.UI;

import UI.Pages.BaseTest;
import UI.Steps;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static io.qameta.allure.Allure.step;

public class AuthorizationUITest extends BaseTest {
    Steps steps = new Steps();

    @Test
    @DisplayName("Авторизация.Существующий пользователь")
    public void positiveAuthorizationTest()  {
        step("Шаг 1. Открытие страницы авторизации", () -> {
            authorizationPage.goToAuthorizationPage();
        });
        step("Шаг 2. Авторизация в приложении", () -> {
            Steps.fillAuthorizationForm("ASSEROV", "Qwerty$4");
        });
        step("Шаг 3. Проверка авторизации в приложении", () -> {
            authorizationPage.logoutButtonIsDisplayed();
        });
    }

    @Test
    @DisplayName("Авторизация.Несуществующего пользователя")
    public void negativeAuthorizationTest()  {
        step("Шаг 1. Открытие страницы авторизации", () -> {
            authorizationPage.goToAuthorizationPage();
        });
        step("Шаг 2. Авторизация в приложении", () -> {
            Steps.fillAuthorizationForm("NEGATIVE", "Qwerty$4");
        });
        step("Шаг 3. Проверка авторизации в приложении", () -> {
            authorizationPage.logoutButtonIsDisplayed();
        });
    }

    @Test
    @DisplayName("Авторизация.Ввод только логина существующего пользователя")
    public void negativeOnlyLoginAuthorizationTest()  {
        step("Шаг 1. Открытие страницы авторизации", () -> {
            authorizationPage.goToAuthorizationPage();
        });
        step("Шаг 2. Авторизация в приложении", () -> {
            Steps.fillOnlyLoginAuthorizationForm("ASSEROV");
        });
        step("Шаг 3. Проверка авторизации в приложении", () -> {
            authorizationPage.logoutButtonIsDisplayed();
        });
    }

    @Test
    @DisplayName("Авторизация.Ввод только логина существующего пользователя")
    public void negativeOnlyPasswordAuthorizationTest()  {
        step("Шаг 1. Открытие страницы авторизации", () -> {
            authorizationPage.goToAuthorizationPage();
        });
        step("Шаг 2. Авторизация в приложении", () -> {
            Steps.fillOnlyPasswordAuthorizationForm("Qwerty$4");
        });
        step("Шаг 3. Проверка авторизации в приложении", () -> {
            authorizationPage.logoutButtonIsDisplayed();
        });
    }

    @Test
    @DisplayName("Авторизация.Создание нового пользователя через бд + авторизация")
    //Необходимо менять UserName и login
    public void createNewUserAuthorizationTest()  {
        step("Шаг 1. Создание новой пользователя через БД", () -> {
            Steps.CreateNewUserDB("ASSEROVAUTO2");
        });
        step("Шаг 2. Открытие страницы авторизации", () -> {
            authorizationPage.goToAuthorizationPage();
        });
        step("Шаг 3. Авторизация в приложении", () -> {
            Steps.fillAuthorizationForm("ASSEROVAUTO2", "Qwerty$4");
        });
        step("Шаг 4. Проверка авторизации в приложении", () -> {
            authorizationPage.logoutButtonIsDisplayed();
        });
    }

    @AfterEach
    public void screenShot() {
        this.takeScreenshot(driver);
    }
}
