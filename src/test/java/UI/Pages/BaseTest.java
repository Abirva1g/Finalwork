package UI.Pages;

import UI.DB.DB;
import io.qameta.allure.Attachment;
import org.junit.jupiter.api.*;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.concurrent.TimeUnit;

public class BaseTest {
    public static AuthorizationPage authorizationPage;
    public static RegistrationPage registrationPage;
    public static MainPage mainPage;
    public static DB db;
    public static WebDriver driver;

    @BeforeAll
    public static void setup() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        authorizationPage = new AuthorizationPage(driver);
        mainPage = new MainPage(driver);
        registrationPage = new RegistrationPage(driver);
    }

    @AfterAll
    public static void tearDown() {
        driver.quit();
    }
    @Attachment(value = "Screenshot", type = "image/png")
    public byte[] takeScreenshot(WebDriver driver) {
        return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
    }
}

