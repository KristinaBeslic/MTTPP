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

public class AddToCart {
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
  public void testAddToCart() throws Exception {
    driver.get("https://demo.opencart.com/index.php?route=common/home");
    driver.findElement(By.xpath("//*[@id=\"top-links\"]/ul/li[2]/a")).click();
    Thread.sleep(2000);
    driver.findElement(By.xpath("//*[@id=\"top-links\"]/ul/li[2]/ul/li[2]/a")).click();
    Thread.sleep(2000);
    driver.get("https://demo.opencart.com/index.php?route=account/login");
    driver.findElement(By.id("input-email")).click();
    driver.findElement(By.id("input-email")).clear();
    driver.findElement(By.id("input-email")).sendKeys("martin123@gmail.com");
    driver.findElement(By.id("input-password")).clear();
    driver.findElement(By.id("input-password")).sendKeys("martin123");
    Thread.sleep(2000);
    driver.findElement(By.xpath("//input[@value='Login']")).click();
    driver.get("https://demo.opencart.com/index.php?route=account/account");
    driver.findElement(By.linkText("Desktops")).click();
    driver.findElement(By.linkText("Mac (1)")).click();
    driver.get("https://demo.opencart.com/index.php?route=product/category&path=20_27");
    driver.findElement(By.xpath("//*[@id=\"menu\"]/div[2]/ul/li[3]/a")).click();
    driver.findElement(By.xpath("//*[@id=\"menu\"]/div[2]/ul/li[3]/div/div/ul/li[2]/a")).click();
    driver.get("https://demo.opencart.com/index.php?route=product/category&path=25_28");
    driver.findElement(By.linkText("Samsung SyncMaster 941BW")).click();
    driver.get("https://demo.opencart.com/index.php?route=product/product&path=25_28&product_id=33");
    driver.findElement(By.id("button-cart")).click();
    driver.findElement(By.xpath("//div[@id='cart']/button")).click();
    driver.findElement(By.xpath("//div[@id='cart']/ul/li[2]/div/p/a/strong")).click();
    Thread.sleep(5000);
    driver.get("https://demo.opencart.com/index.php?route=checkout/cart");
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
