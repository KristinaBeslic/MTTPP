package com.example.MTTPP;

import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;
import org.testng.annotations.*;
import static org.testng.Assert.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import java.io.File;
import org.apache.commons.io.FileUtils;

public class Register {
  private WebDriver driver;
  private String baseUrl;
  private boolean acceptNextAlert = true;
  private StringBuffer verificationErrors = new StringBuffer();
  private JavascriptExecutor js;

  @BeforeClass(alwaysRun = true)
  public void setUp() throws Exception {
    System.setProperty("webdriver.chrome.driver", "C://drivers/chromedriver.exe");
    driver = new ChromeDriver();
    baseUrl = "https://www.google.com/";
    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    js = (JavascriptExecutor) driver;
  }

  @Test
  public void testRegister() throws Exception {
    driver.get("https://demo.opencart.com/");
    driver.findElement(By.xpath("//*[@id=\"top-links\"]/ul/li[2]/a")).click();
    driver.findElement(By.linkText("Register")).click();
    driver.findElement(By.id("input-firstname")).click();
    driver.findElement(By.id("input-firstname")).clear();
    driver.findElement(By.id("input-firstname")).sendKeys("Mimi");
    driver.findElement(By.id("input-lastname")).click();
    driver.findElement(By.id("input-lastname")).clear();
    driver.findElement(By.id("input-lastname")).sendKeys("Mimi");
    driver.findElement(By.id("input-email")).click();
    driver.findElement(By.id("input-email")).clear();
    driver.findElement(By.id("input-email")).sendKeys("mimimimi@gmail.com");
    driver.findElement(By.id("input-telephone")).click();
    driver.findElement(By.id("input-telephone")).clear();
    driver.findElement(By.id("input-telephone")).sendKeys("1234567");
    driver.findElement(By.id("input-password")).click();
    driver.findElement(By.id("input-password")).clear();
    driver.findElement(By.id("input-password")).sendKeys("mimi123");
    driver.findElement(By.id("input-confirm")).click();
    driver.findElement(By.id("input-confirm")).clear();
    driver.findElement(By.id("input-confirm")).sendKeys("mimi123");
    driver.findElement(By.name("agree")).click();
    driver.findElement(By.xpath("//input[@value='Continue']")).click();
    driver.findElement(By.linkText("Continue")).click();
  }

  @AfterClass(alwaysRun = true)
  public void tearDown() throws Exception {
    driver.quit();
    String verificationErrorString = verificationErrors.toString();
    if (!"".equals(verificationErrorString)) {
      fail(verificationErrorString);
    }
  }

  private boolean isElementPresent(By by) {
    try {
      driver.findElement(by);
      return true;
    } catch (NoSuchElementException e) {
      return false;
    }
  }

  private boolean isAlertPresent() {
    try {
      driver.switchTo().alert();
      return true;
    } catch (NoAlertPresentException e) {
      return false;
    }
  }

  private String closeAlertAndGetItsText() {
    try {
      Alert alert = driver.switchTo().alert();
      String alertText = alert.getText();
      if (acceptNextAlert) {
        alert.accept();
      } else {
        alert.dismiss();
      }
      return alertText;
    } finally {
      acceptNextAlert = true;
    }
  }
}
