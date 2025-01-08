package tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.github.bonigarcia.wdm.managers.ChromeDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import pages.LoginPage;

public class BaseTest {

    WebDriver driver;
    LoginPage loginPage;
    @BeforeClass
    public void setUp() {
        String browser = System.getProperty("browser");
        if(browser.equals("Firefox")) {
            WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver();
        }
        else {
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
        }
        
        PageFactory.initElements(driver, this);
        goToLogin();
    }

    @BeforeMethod
    public void goToLogin() {
        driver.get("https://www.saucedemo.com/");
        loginPage = new LoginPage(driver);
    }

    private ChromeOptions getChromeOptions() {
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("disable-infobars");
        return chromeOptions;
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }
}
