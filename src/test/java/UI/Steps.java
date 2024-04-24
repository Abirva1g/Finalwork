package UI;

import io.qameta.allure.Step;

import static UI.Pages.BaseTest.authorizationPage;
import static UI.Pages.BaseTest.mainPage;

public class Steps {

    @Step("Пользователь вводит логин {login} и пароль {password} и нажимает кнопку Войти")
    public static void fillAuthorizationForm(String login, String password) {
        authorizationPage.fillInLogin(login);
        authorizationPage.fillInPassword(password);
        authorizationPage.clickLoginButton();
    }

    @Step("Пользователь создает заметку с Заголовком {title} и Описанием {content}")
    public static void createNote(String title, String content) {
        mainPage.clickNewNoteButton();
        mainPage.fillNoteTitle(title);
        mainPage.fillNoteContent(content);
        mainPage.clickNoteModalChangeColor();
        mainPage.clickNoteModalColor();
        mainPage.clickNoteModalOkButton();
    }


}

