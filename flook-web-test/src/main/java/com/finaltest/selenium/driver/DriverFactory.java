package com.finaltest.selenium.driver;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

public class DriverFactory {
    public static WebDriver getDriver(String browser){
        switch (browser){
            case "chrome":
                WebDriverManager.chromedriver().setup();
                ChromeOptions chromeOptions = new ChromeOptions();
                chromeOptions.addArguments("start-maximized");
//                chromeOptions.addArguments("--incognito");
                return new ChromeDriver(chromeOptions);
            case "edge":
                WebDriverManager.edgedriver().setup();
                EdgeOptions edgeOptions = new EdgeOptions();
                edgeOptions.setCapability("InPrivate", true);
                EdgeDriver edgeDriver = new EdgeDriver(edgeOptions);
                edgeDriver.manage().window().maximize();
                return edgeDriver;
            case "firefox":
                WebDriverManager.firefoxdriver().setup();
                FirefoxOptions firefoxOptions = new FirefoxOptions();
                firefoxOptions.addArguments("start-maximized");
//                firefoxOptions.setHeadless(true);
                firefoxOptions.addArguments("-headless");
                FirefoxDriver driver = new FirefoxDriver();
                driver.manage().window().maximize();
                return driver;
            default:
                return new ChromeDriver();
        }
    }
}
