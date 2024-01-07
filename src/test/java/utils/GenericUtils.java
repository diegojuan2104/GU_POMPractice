package utils;

import org.openqa.selenium.WebDriver;

public class GenericUtils {

  WebDriver driver;

  public GenericUtils(WebDriver webDriver){
    this.driver = webDriver;
  }
  public void tearDown() {
    driver.quit();
  }
}
