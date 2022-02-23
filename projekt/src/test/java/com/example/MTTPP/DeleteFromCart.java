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

public class DeleteFromCart {
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
  public void testDeleteFromCart() throws Exception {
    driver.get("https://demo.opencart.com/index.php?route=common/home");
    driver.findElement(By.xpath("//*[@id=\"top-links\"]/ul/li[2]/a")).click();
    driver.findElement(By.linkText("Login")).click();
    driver.get("https://demo.opencart.com/index.php?route=account/login");
    driver.findElement(By.id("input-email")).click();
    driver.findElement(By.id("input-email")).clear();
    driver.findElement(By.id("input-email")).sendKeys("martin123@gmail.com");
    driver.findElement(By.id("input-password")).clear();
    driver.findElement(By.id("input-password")).sendKeys("martin123");
    driver.findElement(By.xpath("//input[@value='Login']")).click();
    driver.get("https://demo.opencart.com/index.php?route=checkout/cart");
    driver.findElement(By.xpath("//div[@id='content']/form/div/table/tbody/tr/td[4]/div/span/button[2]")).click();
    Thread.sleep(2000);
    driver.findElement(By.xpath("//div[@id='content']/form/div/table/tbody/tr")).click();
    //driver.findElement(By.name("quantity[845248]")).clear();
    Thread.sleep(2000);
    driver.findElement(By.xpath("//*[@id=\"content\"]/form/div/table/tbody/tr/td[4]/div/input")).clear();
    //driver.findElement(By.name("quantity[845248]")).sendKeys("1");
    Thread.sleep(2000);
    driver.findElement(By.xpath("//*[@id=\"content\"]/form/div/table/tbody/tr/td[4]/div/input")).sendKeys("1");
    Thread.sleep(2000);
    driver.findElement(By.xpath("//button[@type='submit']")).click();
    Thread.sleep(4000);
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
