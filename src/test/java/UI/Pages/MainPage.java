package UI.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import java.util.List;

import static UI.Pages.BaseTest.driver;

public class MainPage {
    private WebDriverWait wait;

    @FindBy(xpath = "//div[contains(@class,'Card_containerNew')]")
    private WebElement createNoteButton;

    @FindBy(xpath = "//div[contains(@id,'note-modal-title')]")
    private WebElement noteModalTitle;

    @FindBy(xpath = "//div[contains(@id,'note-modal-content')]")
    private WebElement noteModalContent;

    @FindBy(id = "palette-btn-new_empty")
    private WebElement noteModalChangeColor;

    @FindBy(xpath = "//div[contains(@id,'#fdcfe8')]")
    private WebElement noteModalColor;

    @FindBy(id = "note-modal-save-btn-new_empty")
    private WebElement noteModalOkButton;

    @FindBy(xpath = "//*[contains(@id,'note-container')][last()]//p")
    private WebElement lastTitle;

    @FindBy(xpath = "//div[contains(@id,'note-container')]")
    private WebElement noteContainer;

    @FindBy(xpath = "//*[contains(@id,'note-container')][last()]")
    private WebElement lastNoteContainer;

    @FindBy(xpath = "//*[contains(@id,'note-container')][last()]//div[contains(@class,'Card_body')]")
    private WebElement lastContent;

    @FindBy(xpath = "//div[contains(text(), 'Укажите название или текст заметки')]")
    private WebElement emptyNoteText;

    public MainPage(WebDriver driver) {
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        PageFactory.initElements(driver, this);

    }

    public void clickNewNoteButton() throws InterruptedException {
        Thread.sleep(2000);
        wait.until(ExpectedConditions.visibilityOf(createNoteButton)).click();
    }

    public void fillNoteTitle(String noteTitleText) {
        wait.until(ExpectedConditions.visibilityOf(noteModalTitle)).sendKeys(noteTitleText);
    }

    public void fillNoteContent(String noteContentText) {
        wait.until(ExpectedConditions.visibilityOf(noteModalContent)).sendKeys(noteContentText);
    }

    public void clickNoteModalChangeColor() {
        wait.until(ExpectedConditions.elementToBeClickable(noteModalChangeColor)).click();
    }

    public void refreshPage() {
        driver.navigate().refresh();
    }

    public void clickNoteModalColor() {
        wait.until(ExpectedConditions.elementToBeClickable( noteModalColor)).click();
    }

    public void clickNoteModalOkButton() {
        wait.until(ExpectedConditions.elementToBeClickable(noteModalOkButton)).click();
    }

    public String getNoteColor() {
        String colorNote = driver.findElement(By.xpath("//div[contains(@id,'note-container')][last()]")).getCssValue("background-color");
        return colorNote;
    }
    public String getTextNote() {
        return lastTitle.getText();
    }

    public String getTextContent() {
        return lastContent.getText();
    }

    public void emptyNoteTextIsDisplayed() {
        try {
            emptyNoteText.isDisplayed();
            System.out.println("Пустая заметка не может быть создана");
        } catch (NoSuchElementException e) {
            System.out.println("Что-то пошло не так");
        }
    }

        private int countNote(){
            List<WebElement> notes = driver.findElements(By.xpath("//div[contains(@id,'note-container')]"));
            return notes.size();
        }

    public void deleteNote() {
        int i = countNote();
        while (i!=0) {
            //Удаление заметки
            driver.findElement(By.xpath("//img[contains(@id, 'note-delete-btn')]")).click();
            driver.findElement(By.xpath("//*[@class='btn btn-primary']")).click();
            i = countNote();
        }
    }

    public String getLastNoteContainerText() {
        return lastNoteContainer.getAttribute("id").substring(15);
    }

    public void editLastNote(String newNoteTitleText, String newNoteContentText) {
        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("note-edit-btn-" + getLastNoteContainerText()))).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("note-modal-title-" + getLastNoteContainerText()))).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("note-modal-title-" + getLastNoteContainerText()))).clear();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("note-modal-title-" + getLastNoteContainerText()))).sendKeys(newNoteTitleText);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("note-modal-content-" + getLastNoteContainerText()))).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("note-modal-content-" + getLastNoteContainerText()))).clear();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("note-modal-content-" + getLastNoteContainerText()))).sendKeys(newNoteContentText);
        wait.until(ExpectedConditions.elementToBeClickable(By.id("note-modal-save-btn-"+ getLastNoteContainerText()))).click();
    }
    }




