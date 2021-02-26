package pages.lesson1.PageObject;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {

    //*********Constructor*********
    public LoginPage(WebDriver driver) {
        super(driver);
    }

    //*********Page Variables*********
    String loginURL = "https://accounts.ukr.net/login?lang=ui";

    //*********Web Elements*********
    @FindBy(css = "button.form__submit")
    private WebElement signInButtonElement;
    @FindBy(id = "id-l")
    private WebElement usernameElement;
    @FindAll({
            @FindBy(id = "id-p"),
            @FindBy(id = "some invalid selector")
    })
    private WebElement passwordElement;

    //*********Page Methods*********
    @Step("Open login page")
    public LoginPage goToLoginPage() {
        driver.get(loginURL);
        return this;
    }

    @Step("Login to mail with login: {0}, password: {1} ")
    public UkrNetHomePage loginToUkrNet(String username, String password) {
        //Enter Username(Email)
        writeText(usernameElement, username);
        //Enter Password
        writeText(passwordElement, password);
        //Click Login Button
        return goToUkrNet();
    }

    @Step("Go to UkrNetHomePage")
    public UkrNetHomePage goToUkrNet() {
        click(signInButtonElement);
        return new UkrNetHomePage(driver);
    }
}
