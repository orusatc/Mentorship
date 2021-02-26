package utils.lesson4.staticFactoryMethod;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.util.HashMap;

public class ChromeDriverManager extends DriverManager {
    DesiredCapabilities capabilities;
    private String downloadFilepathChrome = "F:\\IT\\Mentorship\\src\\test\\java\\downloadsChrome";

    @Override
    protected WebDriver createDriver() {
        HashMap<String, Object> prefs = new HashMap<String, Object>();
        prefs.put("profile.default_content_settings.popups", 0);
        prefs.put("download.default_directory", downloadFilepathChrome);
        ChromeOptions options = new ChromeOptions();
        options.setExperimentalOption("prefs", prefs);
        capabilities = DesiredCapabilities.chrome();
        capabilities.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
        capabilities.setCapability(ChromeOptions.CAPABILITY, options);

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver(capabilities);
        //Maximize Window
        driver.manage().window().maximize();
        DriverManager.createdDrivers.add(driver);
        return driver;
    }
}