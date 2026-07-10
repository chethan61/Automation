package chethan.TestComoponents;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import chethan.LandingPageObjects.LandingPageObjects;
import tools.jackson.core.type.TypeReference;
import tools.jackson.databind.ObjectMapper;

public class BaseTest {
	public WebDriver driver;
	public LandingPageObjects lpo;
	public WebDriver initDriver() throws IOException {
		Properties props =new Properties();
		FileInputStream fi = new FileInputStream(System.getProperty("user.dir")+"\\src\\main\\java\\chethan\\resources\\Global.properties");
		props.load(fi);
		String browser=System.getProperty("browser")!=null?System.getProperty("browser"): props.getProperty("browser");
		System.out.println(browser);
		if(browser.contains("chrome")) {
			ChromeOptions opt = new ChromeOptions();
			if(browser.contains("headless")){
				opt.addArguments("headless");
			}
			
		 driver = new ChromeDriver(opt);
		 driver.manage().window().setSize(new Dimension(1440,900));
		}else if(browser.equalsIgnoreCase("firefox")) {
			driver = new FirefoxDriver();
		}else if(browser.equalsIgnoreCase("edge")) {
			driver=new EdgeDriver();
		}

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		return driver;
	}
	@BeforeMethod(alwaysRun=true)
	public LandingPageObjects launchApp() throws IOException {
		driver=initDriver();
		 lpo = new LandingPageObjects(driver);
		lpo.goTo("https://rahulshettyacademy.com/client/");
		driver.manage().window().maximize();
		return lpo;
	}
	@AfterMethod(alwaysRun=true)
	public void terminate() throws IOException {
		driver.quit();
	}
	
	public List<HashMap<String, String>> getJsonData() throws IOException {
		String jsonContent=FileUtils.readFileToString(new File(System.getProperty("user.dir")+"\\src\\main\\java\\chethan\\data\\data.json"),StandardCharsets.UTF_8);
		ObjectMapper om = new ObjectMapper();
		List<HashMap<String,String>> data=om.readValue(jsonContent, new TypeReference<List<HashMap<String,String>>>(){});
		return data;
	}
	public String getScreenShot(String getTestName,WebDriver driver) throws IOException {
		File src=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(src, new File(System.getProperty("user.dir")+"\\src\\test\\"+getTestName+".PNG"));
		return (System.getProperty("user.dir")+"\\src\\test\\"+getTestName+".PNG");
	}

}
