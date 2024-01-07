package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.PageFactory;

public class TestBase {
  public WebDriver driver;

  public WebDriver WebDriverManager(){

    ChromeOptions chromeOptions = new ChromeOptions();
    chromeOptions.addArguments("disable-infobars");
    driver = new ChromeDriver(chromeOptions);
    System.setProperty("webdriver.chrome.driver", "resources/chromedriver.exe");
    PageFactory.initElements(driver, this);
    driver.get("https://www.saucedemo.com/");


    return driver;
  }
}
