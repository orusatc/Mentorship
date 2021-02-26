package pages.lesson1.PageObject;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.io.File;

public class UkrNetHomePage extends BasePage {

    //*********Constructor*********
    public UkrNetHomePage(WebDriver driver) {
        super(driver);
    }

    //*********Web Elements*********
    @FindBy(css = "button.default")
    WebElement writeLetterButtonElement;
    @FindBy(css = ".sendmsg__form-label-field.auto.cropped.ui-sortable input.input")
    WebElement toElement;
    @FindBy(css = "[name='subject']")
    WebElement titleElement;
    WebElement tinymce;
    WebElement mce_0_ifr;
    @FindBy(className = "send")
    WebElement send;
    @FindBy(className = "sendmsg__ads-ready")
    WebElement sentMailPopUpElement;
    @FindBy(id = "10001")
    WebElement sentFolder;
    @FindBy(css = "td")
    WebElement parentElement;
    @FindBy(id = "0")
    WebElement inboxFolder;
    @FindBy(css = ".attachment.image")
    WebElement attachment;

    //*********Page Methods*********

    /**
     * @param receiver -- persons who gets the mail
     * @param title    -- email's title
     * @param letter   -- email's content
     */
    @Step("Creating and sending email to: {0} with title: {1} and body: {2}")
    public void createLetter(String receiver, String title, String letter) {
        click(writeLetterButtonElement);
        writeText(toElement, receiver);
        writeText(titleElement, title);
        writeTextToFrame(mce_0_ifr, tinymce, letter);
        click(send);
    }

    @Step("Verify sending letter Popup presence")
    public UkrNetHomePage verifySendingLetterPopup() {
        assertTrue(sentMailPopUpElement, !readText(sentMailPopUpElement).isEmpty(), "Pop up about sent message doesn't shown");
        return this;
    }

    /**
     * @param folderName   -- name of folder in which is necessary to check email presence
     * @param emailSubject -- subject of email which need to check
     * @return UkrNetHomePage;
     */

    @Step("Checking presence email by subject: {1} in folder")
    public UkrNetHomePage checkingPresenceEmailInFolder(WebElement folderName, String emailSubject, String message) {
        click(folderName);
        WebElement titleBy = getDynamicElement(emailSubject, parentElement);
        assertTrue(titleBy, readText(titleBy).contains(emailSubject), message);
        return this;
    }

    @Step("Checking presence email in Send folder")
    public UkrNetHomePage checkingPresenceEmailInSentFolder(String emailSubject) {
        return checkingPresenceEmailInFolder(sentFolder, emailSubject, "Email by subject: " + emailSubject + " is absent in folder: Sent");
    }

    @Step("Search email")
    public UkrNetHomePage openEmail(String emailSubject) {
        WebElement titleBy = getDynamicElement(emailSubject, parentElement);
        click(titleBy);
        return this;
    }

    @Step("Download file")
    public UkrNetHomePage downloadFile(String emailSubject, String fileLink) {
        click(inboxFolder);
        openEmail(emailSubject);
        try {
            driver.get(fileLink);
        } catch (org.openqa.selenium.TimeoutException e){
            return this;
        }
        return this;
    }

    @Step("Check file downloading")
    public void checkFileDownloading(String fileDirectory, String fileName) throws InterruptedException {
        Thread.sleep(1000);
        File file = new File(fileDirectory);
        File[] dir_contents = file.listFiles();
        String nameAndDirectory = fileDirectory + "/" + fileName;
        File finalPath = new File(nameAndDirectory);
        boolean isFile =finalPath.exists();
        for(int i =0; i < dir_contents.length; i++){
            if(dir_contents[i].getName().equals(fileName)){
                isFile = true;
            }
        }
        if (isFile) {
            finalPath.delete();
        }
        assertTrue(isFile, "File was not downloaded");
    }
}
