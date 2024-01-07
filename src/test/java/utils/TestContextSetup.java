package utils;

import org.openqa.selenium.WebDriver;
import pages.PageObjectManager;

public class TestContextSetup {

  public PageObjectManager pageObjectManager;
  public GenericUtils genericUtils;
  public TestBase testBase;
  WebDriver driver;

  public TestContextSetup() {
    testBase = new TestBase();
    this.driver = testBase.WebDriverManager();
    pageObjectManager = new PageObjectManager(driver);
    genericUtils = new GenericUtils(driver);
  }
}
