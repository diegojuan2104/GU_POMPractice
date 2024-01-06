package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
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
        System.setProperty("webdriver.chrome.driver", "resources/chromedriver.exe");
        driver = new ChromeDriver(getChromeOptions());
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
