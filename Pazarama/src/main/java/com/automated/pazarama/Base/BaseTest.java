package com.automated.pazarama.Base;

import com.automated.pazarama.Listener.Listener;
import com.automated.pazarama.Utilities.ConfigReader;
import com.automated.pazarama.Utilities.StepInit;

import org.apache.log4j.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.*;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.*;
import org.testng.annotations.*;
import org.testng.asserts.SoftAssert;



@Listeners({Listener.class})
public abstract class BaseTest {
    private static final Logger LOGGER = LogManager.getLogger(BaseTest.class);
    private static SoftAssert softAssert = new SoftAssert();
    private static WebDriver driver;

    public static WebDriver getDriver() {
        return driver;
    }

    public static WebDriver setDriver(String browser) {

        if (driver == null) {
            browser = browser == null ? ConfigReader.getProperty("browser") : browser;

            switch (browser) {
                case "chrome":
                    ChromeOptions options = new ChromeOptions();
                    options.addArguments("--start-maximized");
                    options.addArguments("--ignore-certificate-errors");
                    options.addArguments("--allow-insecure-localhost");
                    options.addArguments("--acceptInsecureCerts");
                    options.addArguments("--remote-allow-origins=*");
                    options.addArguments("--disable-notifications");
                    options.addArguments("--incognito");

                    driver = new ChromeDriver(options);
                    break;

                case "firefox":
                    FirefoxOptions firefoxOptions = new FirefoxOptions();
                    driver = new FirefoxDriver(firefoxOptions);
                    break;

                case "edge":
                    driver = new EdgeDriver();
                    break;

                default:
                    driver = new ChromeDriver();
            }
        }
        return driver;
    }

    @BeforeClass
    @Parameters(value = {"browser"})
    public void setupTest(@Optional String browser) {
        driver = setDriver(browser);
        driver.manage().window().maximize();
        LOGGER.info("Window size: " + driver.manage().window().getSize());
        StepInit.init();
    }

    @AfterClass
    public synchronized void tearDown() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
        softAssert.assertAll();
    }
}
