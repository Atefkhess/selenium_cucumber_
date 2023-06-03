package com.e2eTest.automation.utils;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;

import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Setup {

    private static ThreadLocal<WebDriver> driver = new ThreadLocal<>();
    private static final Logger LOGGER = LogManager.getLogger(Setup.class.getName());

    /**
     * This method is used to open the browser. This method is called before the
     * invocation of each test method in the given class. In this method, we need to
     * pass the browser name, which will invoke the respective driver.
     *
     * @throws MalformedURLException the malformed URL exception
     * @Before Methods annotated with @Before will execute before every scenario.
     */
    @Before // Hooks Of Cucumber
    
    public void setWebDriver(Scenario scenario) {
        LOGGER.error("scenario :" + scenario.getName() + "-started");
        String browser = System.getProperty("browser");
        if (browser == null) {
            browser = "chrome";
        }
        switch (browser) {
            case "chrome":
                ChromeOptions chromeOptions = new ChromeOptions();
                WebDriverManager.chromedriver().setup();
                driver.set(new ChromeDriver(chromeOptions));
                driver.get().manage().window().maximize();
                break;
            case "firefox":
                System.setProperty("webdriver.gecko.driver", "src/test/resource/drivers/win/geckodriver.exe");
                FirefoxProfile profile = new FirefoxProfile();
                profile.setPreference("browser.download.folderList", 1);
                profile.setPreference("browser.download.manager.showWhenStarting", false);
                profile.setPreference("browser.download.manager.focusWhenStarting", false);
                profile.setPreference("browser.download.useDownloadDir", true);
                profile.setPreference("browser.helperApps.alwaysAsk.force", false);
                profile.setPreference("browser.download.manager.alertOnEXEOpen", false);
                profile.setPreference("browser.download.manager.closeWhenDone", true);
                profile.setPreference("browser.download.manager.showAlertOnComplete", false);
                profile.setPreference("browser.download.manager.useWindow", false);
                FirefoxOptions firefoxOptions = new FirefoxOptions();
                firefoxOptions.setCapability("platform", Platform.WIN10);
                firefoxOptions.setProfile(profile);
                driver.set(new FirefoxDriver(firefoxOptions));
                driver.get().manage().window().maximize();
                break;
            default:
                throw new IllegalArgumentException("Browser \"" + browser + "\" is not supported.");
        }
    }

    /* Getter */
    public static WebDriver getDriver() {
        return driver.get();
    }

    public static Logger getLogger() {
        return LOGGER;
    }
}
