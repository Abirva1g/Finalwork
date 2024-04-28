package Tests.UI;

import UI.Pages.BaseTest;
import UI.Steps;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static io.qameta.allure.Allure.step;

public class RegistraionUiTest extends BaseTest {
    Steps steps = new Steps();

    @BeforeEach
    public void authorization() {
        step("Шаг 1. Открытие страницы авторизации", () -> {
            authorizationPage.goToAuthorizationPage();
        });
        step("Шаг 2. Нажатие кнопки Зарегистрироваться", () -> {
            Steps.clickRegButton();
        });
    }

    @Test
    @DisplayName("Регистрация. Новый пользователь. Заполнение всех полей.")
    public void positiveRegistrationTest() {
        step("Шаг 1. Заполнение формы регистрации и нажатие кнопки Создать", () -> {
            Steps.fillRegistrationForm("ASSEROVUI","Qwerty$4","uitest@mail.ru");
        });
        step("Шаг 2. Авторизация в приложении", () -> {
            Steps.fillAuthorizationForm("ASSEROVUI", "Qwerty$4");
        });
        step("Шаг 3. Проверка авторизации в приложении", () -> {
            authorizationPage.logoutButtonIsDisplayed();
        });
    }

    @Test
    @DisplayName("Регистрация. Новый пользователь. Заполнение только обязательных полей")
    public void positiveRequiredRegistrationTest() {

        step("Шаг 1. Заполнение формы регистрации и нажатие кнопки Создать", () -> {
            Steps.fillRequiredRegistrationForm("ASSEROVREQ","Qwerty$4");
        });
        step("Шаг 2. Авторизация в приложении", () -> {
            Steps.fillAuthorizationForm("ASSEROVREQ", "Qwerty$4");
        });
        step("Шаг 3. Проверка авторизации в приложении", () -> {
            authorizationPage.logoutButtonIsDisplayed();
        });
    }

    @Test
    @DisplayName("Регистрация. Новый пользователь. Заполнение только логина")
    public void negativeOnlyLoginRegistrationTest() {

        step("Шаг 1. Заполнение формы регистрации и нажатие кнопки Создать", () -> {
            Steps.fillOnlyLoginRegistrationForm("ASSEROVLOG");
        });
        step("Шаг 2. Проверка авторизации в приложении", () -> {
            registrationPage.createButtonIsDisplayed();
        });
    }

    @Test
    @DisplayName("Регистрация. Новый пользователь. Заполнение только пароля")
    public void negativeOnlyPasswordRegistrationTest() {
        step("Шаг 1. Заполнение формы регистрации и нажатие кнопки Создать", () -> {
            Steps.fillOnlyPasswordRegistrationForm ("Qwerty$4");
        });
        step("Шаг 2. Проверка авторизации в приложении", () -> {
            registrationPage.createButtonIsDisplayed();
        });
    }

    @AfterEach
    public void screenShot() {
        this.takeScreenshot(driver);
    }
}
