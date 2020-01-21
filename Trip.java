package pages;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

public class Trip

{
public static void main(String args[]) throws Exception
{
System.setProperty("webdriver.gecko.driver", "E:\\geckodriver.exe");
  WebDriver driver=new FirefoxDriver();
  driver.get("https://www.tripadvisor.in/");
  driver.manage().window().maximize();
  driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
  driver.findElement(By.xpath("//span[@class='brand-global-nav-action-search-Search__label--3PRUD']")).click();
  Thread.sleep(3000);

  driver.findElement(By.xpath("//input[@id='mainSearch']")).sendKeys("Club Mahindra");
  driver.findElement(By.xpath("//div[@id='SEARCH_BUTTON_CONTENT']")).click();
 
  Thread.sleep(3000);
 driver.findElement(By.xpath("//span[contains(.,'Club Mahindra Madikeri, Coorg')]")).click();
 Set<String> s= driver.getWindowHandles();
     Iterator<String> it = s.iterator();
     String w1=it.next();
     String w2 = it.next();
    driver.switchTo().window(w2);
     WebElement w = driver.findElement(By.xpath("//a[contains(.,'Write a review')]"));
     JavascriptExecutor js = (JavascriptExecutor) driver;
    js.executeScript("arguments[0].scrollIntoView();", w);
     String w3 = it.next();
     driver.switchTo().window(w3);
     Actions act = new Actions(driver);
     act.moveToElement(driver.findElement(By.xpath("//span[contains(@id,'bubble_rating')]"))).build().perform();
     act.click();
     
   
}


}

