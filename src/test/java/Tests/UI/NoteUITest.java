package Tests.UI;

import UI.Pages.BaseTest;
import UI.Steps;
import org.junit.jupiter.api.*;
import java.util.List;
import static io.qameta.allure.Allure.step;

public class NoteUITest extends BaseTest {
    Steps steps = new Steps();

    @BeforeEach
    public void authorization() {
        step("Шаг 1. Открытие страницы авторизации", () -> {
            authorizationPage.goToAuthorizationPage();
        });
        step("Шаг 2. Авторизация в приложении", () -> {
            Steps.fillAuthorizationForm("ASSEROV", "Qwerty$4");
        });
    }

    @Test
    @DisplayName("Заметки.Создание новой заметки")
    public void createNoteTest()  {
        step("Шаг 1. Создание новой заметки", () -> {
            Steps.createNote("Итог", "Тестовая");
        });
        step("Шаг 2. Проверки новой заметки", () -> {
            List<String> infoNote = Steps.getInfoNote();
            String titleText = infoNote.get(0);
            String contentText = infoNote.get(1);
            String colorNote = infoNote.get(2);
            Assertions.assertEquals("Итог", titleText, "Неверный заголовок заметки");
            Assertions.assertEquals("Тестовая", contentText, "Неверное описание заметки");
            Assertions.assertEquals("rgba(253, 207, 232, 1)", colorNote, "Неверное описание заметки");
        });
    }

        @Test
        @DisplayName("Заметки.Создание новой заметки через БД")
        public void createNoteDBTest()  {
        step("Шаг 1. Создание новой заметки через БД", () -> {
            Steps.createNoteDB("ASSEROV", "ИТОГ", "БД");
        });
        step("Шаг 2. Проверки новой заметки, созданной в БД", () -> {
            driver.navigate().refresh();
            List<String> infoNote = Steps.getInfoNote();
            String titleText = infoNote.get(0);
            String contentText = infoNote.get(1);
            String colorNote = infoNote.get(2);
            Assertions.assertEquals("ИТОГ", titleText, "Неверный заголовок заметки");
            Assertions.assertEquals("БД", contentText, "Неверное описание заметки");
            Assertions.assertEquals("rgba(253, 207, 232, 1)", colorNote, "Неверное описание заметки");
        });
    }

    @Test
    @DisplayName("Заметки.Создание новой заметки через БД")
    public void negativeCreateEmptyNoteTest()  {
        step("Шаг 1. Попытка создания пустой заметки", () -> {
            Steps.createEmptyNote();
        });
    }

    @Test
    @DisplayName("Заметки.Создание новой заметки")
    public void createAndEditNoteTest()  {
        step("Шаг 1. Создание новой заметки", () -> {
            Steps.createNote("Итог", "Тестовая");
        });
        step("Шаг 2. Проверки новой заметки", () -> {
            List<String> infoNote = Steps.getInfoNote();
            String titleText = infoNote.get(0);
            String contentText = infoNote.get(1);
            String colorNote = infoNote.get(2);
            Assertions.assertEquals("Итог", titleText, "Неверный заголовок заметки");
            Assertions.assertEquals("Тестовая", contentText, "Неверное описание заметки");
            Assertions.assertEquals("rgba(253, 207, 232, 1)", colorNote, "Неверное описание заметки");
        });
        step("Шаг 3. Создание новой заметки", () -> {
            Steps.editLastNote("Новая", "Заметка");
        });
        step("Шаг 4. Проверки редактированной заметки", () -> {
            List<String> infoNote = Steps.getInfoNote();
            String titleText = infoNote.get(0);
            String contentText = infoNote.get(1);
            String colorNote = infoNote.get(2);
            Assertions.assertEquals("Новая", titleText, "Неверный заголовок заметки");
            Assertions.assertEquals("Заметка", contentText, "Неверное описание заметки");
            Assertions.assertEquals("rgba(253, 207, 232, 1)", colorNote, "Неверное описание заметки");
        });

    }

    @Test
    @DisplayName("Заметки.Удаление всех заметок")
    public void deleteAllNoteTest()  {
        step("Шаг 1. Удаление заметок", () -> {
            Steps.deleteAllNote();
        });
    }

    @AfterEach
    public void screenShot() {
        this.takeScreenshot(driver);
    }
}