package UI.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class RegistrationPage {
    private WebDriver driver;
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
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
        wait.until(ExpectedConditions.elementToBeClickable(regButton)).click();
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

}