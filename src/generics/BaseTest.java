package generics;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.CommandExecutor;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.*;
import org.testng.annotations.Listeners;

@Listeners(FWListener.class)
public class BaseTest implements IAutoConst
{
	public WebDriver driver;
	@BeforeSuite(alwaysRun=true)
	public void setDriverPath()
	{
		System.setProperty(CHROME_KEY, CHROME_VALUE);
		System.setProperty(GECKO_KEY, GECKO_VALUE);
	}

	@Parameters({"node", "browser"})
	@BeforeMethod(alwaysRun=true)
	public void openApp(String node,String browser) throws MalformedURLException
	{
		URL whichSystem = new URL(node);
		DesiredCapabilities whichBrowser = new DesiredCapabilities();
		whichBrowser.setBrowserName(browser);
		
		driver = new RemoteWebDriver(whichSystem,whichBrowser);
		
		String ito = UtilityLib.getPropertyValue(CONFIG_PATH, "ITO");
		String appURL = UtilityLib.getPropertyValue(CONFIG_PATH, "URL");
		long waitTime = Long.parseLong(ito);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(waitTime, TimeUnit.SECONDS);		
		driver.get(appURL);
	}

	@AfterMethod(alwaysRun=true)
	public void closeApp()
	{
		driver.close();
	}
}
