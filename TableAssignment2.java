package week4.day1;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TableAssignment2 {

	public static void main(String[] args) {
	
				int colcount=0;
			//download the driver and setup the path
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.get("https://html.com/tags/table/");



		WebElement elmntTable = driver.findElement(By.xpath("//div[@class='render']//table//tbody"));
		
		

		List<WebElement> rows = elmntTable.findElements(By.xpath("tr"));
		
		System.out.println("Row count: "+ rows.size());

		for(int i=0;i<rows.size();i++)
		{
			List<WebElement> cols = rows.get(i).findElements(By.tagName("td"));	

			colcount=cols.size();			
		}
		
		
		System.out.println("Column count: "+ colcount);
		}

		 	}
		


	


