package guru99bank.base;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import guru99bank.constants.CommonConstants;
import guru99bank.utilities.ConfigReader;

public class BaseTest {

    public static WebDriver driver;

    @BeforeMethod
    public void setUp() {

        String strBrowser = ConfigReader.getPropertyFromKey("browser");
        String url = ConfigReader.getPropertyFromKey("url");

        System.out.println("'" + strBrowser + "' browser selected for test.");
        System.out.println("Application under test : '" + url + "'.");

        boolean isJenkins = System.getenv("JENKINS_HOME") != null;

        if (strBrowser.equalsIgnoreCase("Chrome")) {

            ChromeOptions options = new ChromeOptions();

            if (isJenkins) {
                System.out.println("Running in Jenkins → Headless Chrome");
                options.addArguments("--headless=new");
                options.addArguments("--no-sandbox");
                options.addArguments("--disable-dev-shm-usage");
                options.addArguments("--window-size=1920,1080");
            }

            driver = new ChromeDriver(options);

        } else if (strBrowser.equalsIgnoreCase("Firefox")) {
            driver = new FirefoxDriver();

        } else if (strBrowser.equalsIgnoreCase("Edge")) {
            driver = new EdgeDriver();

        } else {
            System.out.println("Unsupported browser type. Defaulting to Edge.");
            driver = new EdgeDriver();
        }

        System.out.println("'" + strBrowser + "' browser initialized.");

        driver.manage().timeouts().implicitlyWait(
                Duration.ofSeconds(CommonConstants.getImplicitWaitTime()));
        driver.manage().timeouts().pageLoadTimeout(
                Duration.ofSeconds(CommonConstants.getPageLoadTimeOut()));

        if (!isJenkins) {
            driver.manage().window().maximize();
        }

        driver.get(url);
        System.out.println("Navigated to url '" + url + "'.");
    }

    @AfterMethod
    public void tearDown() {
        if (driver != null) {
            driver.quit();
            System.out.println("All browser instances closed.");
        }
    }
}