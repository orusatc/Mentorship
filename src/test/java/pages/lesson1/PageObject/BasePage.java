package pages.lesson1.PageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.util.concurrent.TimeUnit;

public class BasePage {
    public WebDriver driver;
    public WebDriverWait wait;

    //Constructor
    public BasePage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
        // It depends on Internet speed ))
        wait = new WebDriverWait(driver, 60);
        //to handle geckodriver Page loading
        driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
    }

    void waitForLoad(WebDriver driver) {
        new WebDriverWait(driver, 10).until((ExpectedCondition<Boolean>) wd ->
                ((JavascriptExecutor) wd).executeScript("return document.readyState").equals("complete"));
    }

    //Wait Wrapper Method
    public void waitVisibility(WebElement element) {
        wait.until(ExpectedConditions.visibilityOfAllElements(element));
    }

    //Wait Wrapper Method
    public void waitForElementToBeClickable(WebElement element) {
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    //Wait Wrapper Method
    public void waitVisibilityBy(By element) {
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(element));
    }

    //Click Method
    public void click(WebElement element) {
        waitVisibility(element);
        element.click();
    }

    //Write Text
    public void writeText(WebElement element, String text) {
        waitVisibility(element);
        element.sendKeys(text);
    }

    public void writeTextToFrame(WebElement frameElement, WebElement element, String text) {
        driver.switchTo().frame(frameElement);
        waitVisibility(element);
        element.sendKeys(text);
        driver.switchTo().defaultContent();
    }

    //Read Text
    public String readText(WebElement element) {
        waitVisibility(element);
        return element.getText();
    }

    //Assert
    public void assertEquals(WebElement element, String expectedText, String assertionMessage) {
        waitVisibility(element);
        Assert.assertEquals(readText(element), expectedText, assertionMessage);
    }

    public void assertTrue(WebElement element, Boolean condition, String assertionMessage) {
        waitVisibility(element);
        Assert.assertTrue(condition, assertionMessage);
    }

    public void assertTrue(boolean actualValue, String assertionMessage) {
        Assert.assertTrue(actualValue, assertionMessage);
    }

    public WebElement getDynamicElement(String text, WebElement parentElement) {
        By selectorBy = By.xpath("//a[contains(text(), '" + text + "')]");
        waitVisibilityBy(selectorBy);
        WebElement dynamic = parentElement.findElement(selectorBy);
        return dynamic;
    }
}