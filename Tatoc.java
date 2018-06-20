package Automation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

public class Tatoc {

	public static void main(String[] args) {
		   System.setProperty("webdriver.chrome.driver","C:\\Users\\salonitandon\\workspace\\chromedriver.exe");
	       WebDriver driver= new ChromeDriver();
	       driver.get("http://10.0.1.86/tatoc/basic/grid/gate");
	        driver.findElement(By.className("greenbox")).click();
	       driver.switchTo().frame("main");
	       String original = driver.findElement(By.id("answer")).getAttribute("class");
	       boolean condi = true;
	       while(condi)
	       {
	       	//WebElement childElement = driver.findElement(By.id("child"));
	       	driver.switchTo().frame("child");
	       	String newAnswer = driver.findElement(By.id("answer")).getAttribute("class");
	       	driver.switchTo().parentFrame();
	       	if(original.equals(newAnswer))
	       	{
	       		condi = false;
	       	}	
	       	else
	       	{
	       		driver.findElement(By.linkText("Repaint Box 2")).click();
	       	}
	       }
	       driver.findElement(By.linkText("Proceed")).click();
	       WebElement from = driver.findElement(By.id("dragbox"));
	       WebElement to = driver.findElement(By.id("dropbox"));
	       Actions builder = new Actions(driver);	
		Action dragAndDrop = builder.clickAndHold(from).moveToElement(to).release(to).build();
	 	   dragAndDrop.perform();
	 	   driver.findElement(By.linkText("Proceed")).click();
	      
	}

}
