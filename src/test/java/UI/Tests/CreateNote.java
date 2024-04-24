package UI.Tests;

import UI.Pages.BaseTest;
import UI.Steps;
import org.junit.jupiter.api.Test;

import static io.qameta.allure.Allure.step;

public class CreateNote extends BaseTest {
    Steps steps = new Steps();

    @Test
    public void start() {
        step("Шаг 1. Открытие страницы авторизации", () -> {
            authorizationPage.goToAuthorizationPage();
        });

        step("Шаг 2. Авторизация в приложении", () -> {
            Steps.fillAuthorizationForm("ASSEROV", "Qwerty$4");
        });

        step("Шаг 3. Создание новой заметки ", () -> {
            Steps.createNote("Итог", "Тестовая");
        });
        this.takeScreenshot(driver);
    }
}
