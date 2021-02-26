package utils.lesson4.staticFactoryMethod;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

public class MozillaDriverManager extends DriverManager {
    DesiredCapabilities capabilities;
    private String downloadFilepathMozilla = "F:\\IT\\Mentorship\\src\\test\\java\\downloadsMozilla";


    @Override
    protected WebDriver createDriver() {
        FirefoxProfile profile = new FirefoxProfile();
        profile.setPreference("browser.download.folderList", 2);
        profile.setPreference("browser.download.manager.showWhenStarting", false);
        profile.setPreference("browser.download.dir", downloadFilepathMozilla);
        profile.setPreference("browser.helperApps.neverAsk.openFile", "image/jpeg");
        profile.setPreference("browser.helperApps.neverAsk.saveToDisk", "image/jpeg");

        profile.setPreference("browser.helperApps.alwaysAsk.force", false);
        profile.setPreference("browser.download.manager.useWindow", false);
        profile.setPreference("browser.download.manager.focusWhenStarting", false);
        profile.setPreference("browser.download.manager.alertOnEXEOpen", false);
        profile.setPreference("browser.download.manager.showAlertOnComplete", false);
        profile.setPreference("browser.download.manager.closeWhenDone", true);

        capabilities = DesiredCapabilities.firefox();
        capabilities.setCapability(FirefoxDriver.PROFILE, profile);
        capabilities.setCapability(CapabilityType.ELEMENT_SCROLL_BEHAVIOR, 1);
        //capabilities.setCapability("marionette", true);

        WebDriverManager.firefoxdriver().setup();
        driver = new FirefoxDriver(capabilities);

        //Maximize Window
        driver.manage().window().maximize();
        DriverManager.createdDrivers.add(driver);
        return driver;
    }
}

