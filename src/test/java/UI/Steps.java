package UI;

import UI.DB.DB;
import io.qameta.allure.Step;
import java.util.Arrays;
import java.util.List;
import static UI.Pages.BaseTest.authorizationPage;
import static UI.Pages.BaseTest.mainPage;
import static UI.Pages.BaseTest.registrationPage;

public class Steps {
    @Step("Пользователь вводит логин {login} и пароль {password} и нажимает кнопку Войти")
    public static void fillAuthorizationForm(String login, String password) {
        authorizationPage.fillInLogin(login);
        authorizationPage.fillInPassword(password);
        authorizationPage.clickLoginButton();
    }

    @Step("Пользователь вводит логин {login} и  и нажимает кнопку Войти")
    public static void fillOnlyLoginAuthorizationForm(String login) {
        authorizationPage.fillInLogin(login);
        authorizationPage.clickLoginButton();
    }

    @Step("Пользователь вводит пароль {password} и нажимает кнопку Войти")
    public static void fillOnlyPasswordAuthorizationForm(String password) {
        authorizationPage.fillInPassword(password);
        authorizationPage.clickLoginButton();
    }

    @Step("Пользователь создает заметку с Заголовком {title} и Описанием {content}")
    public static void createNote(String title, String content) throws InterruptedException {
        mainPage.clickNewNoteButton();
        mainPage.fillNoteTitle(title);
        mainPage.fillNoteContent(content);
        mainPage.clickNoteModalChangeColor();
        mainPage.clickNoteModalColor();
        mainPage.clickNoteModalOkButton();
    }

    @Step("Пользователь пытается создать пустую заметку")
    public static void createEmptyNote() throws InterruptedException {
        mainPage.clickNewNoteButton();
        mainPage.clickNoteModalOkButton();
        mainPage.emptyNoteTextIsDisplayed();
    }

    @Step("Пользователь удаляет все заметки")
    public static void deleteAllNote() {
        mainPage.deleteNote();
    }

    @Step("Пользователь редактирует последнюю заметку")
    public static void editLastNote(String newNoteTitleText, String newNoteContentText) {
        mainPage.refreshPage();
        mainPage.editLastNote(newNoteTitleText, newNoteContentText);
        mainPage.refreshPage();
    }

    @Step("Пользователь получает данные по новой заметке")
    public static List<String> getInfoNote() {
        String titleText = mainPage.getTextNote();
        String contentText = mainPage.getTextContent();
        String colorNote = mainPage.getNoteColor();
        return Arrays.asList(titleText, contentText, colorNote);
    }

    @Step("Пользователь создает заметку через БД")
    public static void createNoteDB(String userLogin, String titleText,String contentText) {
        DB.ConnectDB();
        DB.loginExecuteQuery(userLogin);
        DB.lastPriorityExecuteQuery();
        DB.lastIdExecuteQuery();
        DB.CreateNoteExecuteQuery(titleText,contentText);
        DB.ConnectionCloseExecuteQuery();
    }

    @Step("Пользователь создает нового пользователя через БД")
    public static void CreateNewUserDB(String userName) {
        DB.ConnectDB();
        DB.maxUsersIdExecuteQuery();
        DB.CreateNewUserExecuteQuery(userName);
        DB.ConnectionCloseExecuteQuery();
    }

    @Step("Пользователь нажимает кнопку Зарегистрироваться")
    public static void clickRegButton() {
        registrationPage.clickRegButton();
    }

    @Step("Пользователь вводит логин {login},  пароль {password}, email {email} и нажимает кнопку Создать")
    public static void fillRegistrationForm(String login, String password,String email) {
        registrationPage.fillInLogin(login);
        registrationPage.fillInPassword(password);
        registrationPage.fillInEmail(email);
        registrationPage.clickCreateButton();
    }

    @Step("Пользователь вводит логин {login},  пароль {password} и нажимает кнопку Создать")
    public static void fillRequiredRegistrationForm(String login, String password) {
        registrationPage.fillInLogin(login);
        registrationPage.fillInPassword(password);
        registrationPage.clickCreateButton();
    }

    @Step("Пользователь вводит логин {login} и нажимает кнопку Создать")
    public static void fillOnlyLoginRegistrationForm(String login) {
        registrationPage.fillInLogin(login);
        registrationPage.clickCreateButton();
    }

    @Step("Пользователь вводит пароль {password} и нажимает кнопку Создать")
    public static void fillOnlyPasswordRegistrationForm(String password) {
        registrationPage.fillInPassword(password);
        registrationPage.clickCreateButton();
    }
}

