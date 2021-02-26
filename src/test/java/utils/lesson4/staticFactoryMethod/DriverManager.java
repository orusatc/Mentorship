package utils.lesson4.staticFactoryMethod;


import org.openqa.selenium.WebDriver;

import java.util.HashSet;
import java.util.Set;

public abstract class DriverManager {

    public static Set<WebDriver> createdDrivers = new HashSet<>();

    protected  WebDriver driver;

    protected abstract WebDriver createDriver();
}
