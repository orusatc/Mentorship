package tests.lesson2.SeleniumGrid;

import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class SeleniumGridTest {
    static WebDriver driver;
    static String nodeUrl = "http://192.168.88.241:5555/wd/hub";


    public static void main(String[] args) {
        //System.setProperty("webdriver.chrome.driver", "F:\\IT\\Mentorship\\src\\test\\java\\drivers\\chrome_89_0_4389_23\\chromedriver.exe");
        System.setProperty("webdriver.chrome.driver", "F:\\IT\\Mentorship\\src\\test\\java\\drivers\\chrome_88_0_4324_96\\chromedriver.exe");
        DesiredCapabilities capabilities = DesiredCapabilities.chrome();
        capabilities.setBrowserName("chrome");
        capabilities.setPlatform(Platform.WIN10);
        capabilities.setVersion("88.0.4324.96");

        try {
            driver = new RemoteWebDriver(new URL(nodeUrl), capabilities);
            driver.manage().deleteAllCookies();
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
            driver.manage().timeouts().pageLoadTimeout(45, TimeUnit.SECONDS);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        driver.get("https://www.google.com.ua/?hl=ua");
    }

}
