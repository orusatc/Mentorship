package utils.lesson4.staticFactoryMethod;

import org.openqa.selenium.WebDriver;

public class DriverManagerFactory {
    static WebDriver driver;
    public static WebDriver getManager(DriverType type) {
        switch (type) {
            case CHROME:
                //return already driver but not driver manager
                driver = new ChromeDriverManager().createDriver();
                break;
            case FIREFOX:
                driver = new MozillaDriverManager().createDriver();
                break;
            default:
                driver = new ChromeDriverManager().createDriver();
                break;
        }
        return driver;
    }

    public static void quitDriver() {
        for (WebDriver drivers : DriverManager.createdDrivers) {
            drivers.quit();
        }
    }

    public static WebDriver getDriver() {
        if(null == driver){
            getManager(DriverType.CHROME);
        }
        return driver;
    }

}

