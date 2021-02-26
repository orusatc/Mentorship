package tests.lesson1.pageObject;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import utils.lesson4.staticFactoryMethod.DriverManager;
import utils.lesson4.staticFactoryMethod.DriverManagerFactory;
import utils.lesson4.staticFactoryMethod.DriverType;


public class BaseTest {

    DriverManager driverManager;
    protected WebDriver driver;
    private String downloadFilepath;
    private String downloadFilepathChrome = "F:\\IT\\Mentorship\\src\\test\\java\\downloadsChrome";
    private String downloadFilepathMozilla = "F:\\IT\\Mentorship\\src\\test\\java\\downloadsMozilla";
    protected DriverType driverType;

    public String getDownloadFilepath(DriverType driverType) {
        switch (driverType) {
            case FIREFOX:
                downloadFilepath = downloadFilepathMozilla;
                break;
            case CHROME:
                downloadFilepath = downloadFilepathChrome;
                break;
            default:
                downloadFilepath = downloadFilepathChrome;
        }
        return downloadFilepath;
    }

    @BeforeTest
    @Parameters({"browserType"})
    public void setup(String br) {
        driverType =  DriverType.valueOf(br.toUpperCase());
        driver = DriverManagerFactory.getManager(driverType);
    }

    public WebDriver getDriver() {
        driver = DriverManagerFactory.getDriver();
        return driver;
    }

    @AfterSuite
    public void teardown() {
        DriverManagerFactory.quitDriver();
    }
}
