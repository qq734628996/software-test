package com.tju.lab.lab2;
import org.junit.Test;
import org.junit.Before;
import org.junit.After;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.core.IsNot.not;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Alert;
import org.openqa.selenium.Keys;
import java.util.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.io.*;


public class Lab2 {
	public static void main(String args[]) {
		String driverPath = System.getProperty("user.dir") + "\\src\\resources\\driver\\geckodriver.exe";
		System.setProperty("webdriver.gecko.driver", driverPath);
		WebDriver driver = new FirefoxDriver();

		driver.get("http://103.120.226.190/selenium-demo/git-repo");

		String testListPath = System.getProperty("user.dir") + "\\src\\resources\\Selenium+Lab2020.csv";
		try {
			FileReader fileReader = new FileReader(testListPath);
			BufferedReader bufferedReader = new BufferedReader(fileReader);
			String line;
			while ((line = bufferedReader.readLine()) != null) {
				String context[] = line.split(",");
				WebElement userNumber = driver.findElement(By.name("user_number"));
				WebElement password = driver.findElement(By.name("password"));
				WebElement submit = driver.findElement(By.cssSelector(".btn"));
				userNumber.clear();
				userNumber.sendKeys(context[0]);
				password.clear();
				password.sendKeys(context[1]);
				submit.click();
				String result = driver.findElement(By.cssSelector(".mb-2:nth-child(6) > code")).getText();
				assert(result == context[1]);
			}
			bufferedReader.close();
			fileReader.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	    driver.close();
	}
}
