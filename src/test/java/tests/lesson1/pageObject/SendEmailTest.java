package tests.lesson1.pageObject;

import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.lesson1.PageObject.LoginPage;
import pages.lesson1.PageObject.UkrNetHomePage;
import utils.lesson4.builder.Email;
import utils.lesson4.singleton.CredentialsSingleton;

//@Listeners({TestListener.class})
@Epic("Functional test")
@Feature("Login test")
public class SendEmailTest extends BaseTest {

    UkrNetHomePage ukrNetHomePage;
    CredentialsSingleton credentialsSingleton = CredentialsSingleton.getCredentials();
    String fileForDownloading = "https://mail.ukr.net/attach/get/16097101060358760360/1/owl.jpg";
    Email email = new Email.EmailBuilder().build();

    @BeforeClass
    public void setLogin() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.goToLoginPage();
        ukrNetHomePage = loginPage.loginToUkrNet(CredentialsSingleton.login, CredentialsSingleton.password);
    }

    @Test(description = "Checking login to the email and sending the mail")
    public void checkingLoginToTheEmailAndSendingTheMail() {
        ukrNetHomePage.createLetter(email.getReceiver(), email.getTitle(), email.getEmailBody());
        ukrNetHomePage.verifySendingLetterPopup();
        ukrNetHomePage.checkingPresenceEmailInSentFolder(email.getTitle());
    }

    @Test(description = "files upload download")
    public void checkDownloading() throws InterruptedException {
        ukrNetHomePage.downloadFile("picture", fileForDownloading);
        ukrNetHomePage.checkFileDownloading(getDownloadFilepath(driverType), "owl.jpg");
    }
}
