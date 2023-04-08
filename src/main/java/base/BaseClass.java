package base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
	
	public static WebDriver driver;
	public static Properties prop;
	
	String path = System.getProperty("user.dir");
	
	public BaseClass() throws IOException {
		prop = new Properties();
		FileInputStream fis = new FileInputStream(path+"\\src\\main\\java\\config\\config.properties");
		prop.load(fis);
	}
	
	public void initialiazation() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get(prop.getProperty("url"));
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}

}
