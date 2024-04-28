package UI.Pages;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RegistrationPage {
    private WebDriver driver;

    @FindBy(id = "form_register_button")
    private WebElement regButton;

    @FindBy(xpath = "//input[@placeholder='Логин']")
    private WebElement loginTextField;

    @FindBy(xpath = "//input[@placeholder='Пароль']")
    private WebElement passwordTextField;

    @FindBy(xpath = "//div[label[text()='E-mail']]/input")
    private WebElement emailTextField;

    @FindBy(xpath = "//button[text()='Создать']")
    private WebElement createButton;

    public RegistrationPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void clickRegButton() {
        regButton.click();
    }

    public void fillInLogin (String loginText) {
        loginTextField.sendKeys(loginText);
    }

    public void fillInPassword (String passwordText) {
        passwordTextField.sendKeys(passwordText);
    }

    public void fillInEmail(String email) {
        emailTextField.sendKeys(email);
    }

    public void clickCreateButton() {
        createButton.click();
    }

    public void createButtonIsDisplayed() {
        try {
            createButton.isDisplayed();
            System.out.println("Ошибка регистрации");
        }
        catch (NoSuchElementException e) {
            System.out.println("Пользователь  зарегистрирован");
        }
    }
}