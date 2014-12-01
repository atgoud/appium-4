package com.yhpl.apptest;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.HasTouchScreen;
import org.openqa.selenium.interactions.TouchScreen;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteTouchScreen;
import org.openqa.selenium.remote.RemoteWebDriver;

import io.selendroid.SelendroidCapabilities;
import io.selendroid.SelendroidDriver;

import java.io.File;
import java.net.URL;
import java.util.List;

public class AndroidTest {
	private WebDriver driver;

	@Before
	public void setUp() throws Exception {
		// set up appium
		File classpathRoot = new File(System.getProperty("user.dir"));
		File appDir = new File(classpathRoot, "apps/app");
		File app = new File(appDir, "EnterpriseApp.apk");
		// DesiredCapabilities capabilities = new DesiredCapabilities();
		// capabilities.setCapability("device", "Android");
		// capabilities.setCapability(CapabilityType.BROWSER_NAME, "");
		// capabilities.setCapability(CapabilityType.VERSION, "4.4.2");
		// capabilities.setCapability(CapabilityType.PLATFORM, "WINDOWS");
		// capabilities.setCapability("platformName", "Android");
		// capabilities.setCapability("deviceName", "CB5A1P3DHW");
		//
		// capabilities.setCapability("app", app.getAbsolutePath());
		// capabilities.setCapability("app-package", "com.founder.eapp");
		// capabilities.setCapability("app-activity",
		// "com.founder.eapp.ui.activity.LoginActivity");
		// driver = new SwipeableWebDriver(
		// new URL("http://127.0.0.1:4723/wd/hub"), capabilities);

		// SelendroidCapabilities capa = new SelendroidCapabilities(
		// "io.selendroid.testapp:0.8.0");
		// capa.setPlatformVersion(DeviceTargetPlatform.ANDROID18);
		// capa.setEmulator(true);

		SelendroidCapabilities capa = new SelendroidCapabilities(
				"EnterpriseApp.apk");

		capa.setCapability("browserName", "");
		capa.setCapability("deviceName", "Android Emulator");
		// capabilities.setCapability("automationName", "Selendroid");
		capa.setCapability("platformVersion", "4.1");
		capa.setCapability("platformName", "Android");
		capa.setCapability("app", app.getAbsolutePath());
		capa.setCapability("appPackage", "com.founder.eapp");
		capa.setCapability("appActivity",
				"com.founder.eapp.ui.activity.LoginActivity");
		// capa.setCapability(SelendroidCapabilities., value)
		driver = new SelendroidDriver(capa);
		
	}

	@After
	public void tearDown() throws Exception {
		driver.quit();
	}

	@Test
	public void addContact() {
		WebElement el = driver.findElement(By.id("titlebar_right"));
		el.click();
		// List<WebElement> textFieldsList = driver.findElements(By
		// .tagName("textfield"));
		// textFieldsList.get(0).sendKeys("Some Name");
		// textFieldsList.get(2).sendKeys("Some@example.com");
		// driver.findElement(By.name("Save")).click();
	}

	public class SwipeableWebDriver extends RemoteWebDriver implements
			HasTouchScreen {
		private RemoteTouchScreen touch;

		public SwipeableWebDriver(URL remoteAddress,
				Capabilities desiredCapabilities) {
			super(remoteAddress, desiredCapabilities);
			touch = new RemoteTouchScreen(getExecuteMethod());
		}

		public TouchScreen getTouch() {
			return touch;
		}
	}
}