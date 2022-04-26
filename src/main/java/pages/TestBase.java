package pages;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestBase {

	public static WebDriver driver;
	
	public void initDriver() {
		System.setProperty("webdriver.chrome.driver", ".\\drivers\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://www.techfios.com/billing/?ng=admin/");
		
	}
	
	public void TakeScreenShot(WebDriver driver) throws IOException {
		TakesScreenshot ts = (TakesScreenshot)driver;
		ts.getScreenshotAs(OutputType.FILE);
		File sourcefile = ts.getScreenshotAs(OutputType.FILE);
		String currentdirectory = System.getProperty("user.dir");
		
		SimpleDateFormat formatter = new SimpleDateFormat("MMddyy_HHmmss");
		Date date = new Date();
		String label = formatter.format(date);
		
		FileUtils.copyFile(sourcefile, new File(currentdirectory + "/screenshot/" + label +".png"));
	}
	
}
