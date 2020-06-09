import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class FileUploading {

	public static void main(String[] args) throws IOException, InterruptedException {
		// TODO Auto-generated method stub
		
		String downloadFilepath=System.getProperty("user.dir");
		System.setProperty("webdriver.chrome.driver", "C:\\selenium\\chromedriver.exe");
		 HashMap<String, Object> chromePrefs = new HashMap<String, Object>();
		    chromePrefs.put("profile.default_content_settings.popups", 0);
		    chromePrefs.put("download.default_directory", downloadFilepath);
		   
		ChromeOptions options=new ChromeOptions();
		 options.setExperimentalOption("prefs", chromePrefs);
		WebDriver web = new ChromeDriver(options);
		web.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		web.get("https://www.ilovepdf.com/word_to_pdf");
		web.findElement(By.id("pickfiles")).click();
		Thread.sleep(5000);
		Runtime.getRuntime().exec("C:\\Users\\chinni\\Desktop\\fileuploading.exe");
		//Thread.sleep(5000);
		WebDriverWait wait=new WebDriverWait(web,15);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("processTask")));
		web.findElement(By.id("processTask")).click();
		WebDriverWait wait1=new WebDriverWait(web,10);
		wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("pickfiles")));
		web.findElement(By.id("pickfiles")).click();
		Thread.sleep(7000);
		File file=new File(downloadFilepath+"/gautham final paper.pdf");
		if(file.exists()) {
			System.out.println("file is present");
			if(file.delete()) {
				System.out.println("file is deleted");
			}
		}
		
	}

}
