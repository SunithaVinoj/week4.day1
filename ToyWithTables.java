package week4.day1;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import org.openqa.selenium.By;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ToyWithTables {
	
	

		public static void main(String[] args) {
		
			int colCount=0,perInt=0,index=0;
			//Set<String> perSet=new TreeSet<String>();
			List<String> perSet=new ArrayList<String>();
				//download the driver and setup the path
			WebDriverManager.chromedriver().setup();
			ChromeDriver driver = new ChromeDriver();
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
			driver.get("http://www.leafground.com/pages/table.html");



			WebElement elmntTable =driver.findElement(By.xpath("//div[@id='contentblock']//table//tbody"));
			
			

			List<WebElement> rows = elmntTable.findElements(By.xpath("//tr"));
			
			
			System.out.println("Row count: "+ rows.size());

			for(int i=1;i<rows.size();i++)
			{
				List<WebElement> cols = rows.get(i).findElements(By.tagName("td"));	
				
				colCount=cols.size();
												
				for(int j=0;j<colCount;j++)
				{
				//	System.out.println(cols.get(j).getText() + " ");
					String text = cols.get(j).getText(); 
					
					if(text.contains("Learn to interact with Elements"))
					{
						System.out.println("Progress Value of " +"'" + text + "'"+cols.get(j+1).getText());
					}
					
					//Collections.sort(cols);
				/*	if(per.contains("%"))
					{
					   per=per.replace('%', ' ');
					   perInt=(int)per;
					   
					}  
					
					System.out.println(per);
				
					perSet.add(per);	
					Collections.sort(perSet);
					System.out.println(perSet);*/
					
					String per=cols.get(1).getText();
					if(per.equals("20%"))
					{
						//driver.findElement(By.xpath("(//input[@name='vital'])[5]")).click();
					//	System.out.println(cols.get(2).isSelected());
						if (!cols.get(2).isSelected())
						{
							cols.get(2).click();
						}
						
						//index=rowcount;
					}
				}
				
				
				
			}
			
			System.out.println("Column count: "+ colCount);
			
			
				
			
			for(String value:perSet)
			{
				System.out.println("Percentage values are: " +value);
			}
			
			}

			 	}
			


		





