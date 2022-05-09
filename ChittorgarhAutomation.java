package week4.day1;

import java.time.Duration;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ChittorgarhAutomation {

	public static void main(String[] args) {
		
		int count=0;
		WebDriverManager.chromedriver().setup();
		ChromeDriver chromdriver = new ChromeDriver();
		chromdriver.get("https://www.chittorgarh.com/");
		chromdriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		chromdriver.manage().window().maximize();
		
		chromdriver.findElement(By.xpath("//a[@id='navbtn_stockmarket']")).click();
		
		chromdriver.findElement(By.linkText("NSE Bulk Deals")).click();
		List<WebElement> findElements = chromdriver.findElements(By.xpath("//table[contains(@class,'table table-bordered')]//tbody//tr"));
		 
		int rowCount = findElements.size();     
	//	System.out.println(rowCount); 
		List<String> arrayList = new ArrayList<String>();
		//List<String> duplicateList = new ArrayList<String>();
		Set<String> duplicateList = new HashSet<String>();
		for (int i = 1; i <=rowCount; i++) 
		{         
			String text = chromdriver.findElement(By.xpath("//table[contains(@class,'table table-bordered')]//tbody//tr["+i+"]//td[3]")).getText();
			//System.out.println(text);
			arrayList.add(text);
			
		}
		
		for(int j=0;j<rowCount;j++)
		{
			for (int k=j+1;k<rowCount;k++)
			{
				if (arrayList.get(j).equals(arrayList.get(k)))
				{
					arrayList.set(k,"");	
//					duplicateList.set(j, arrayList.get(j));
					duplicateList.add(arrayList.get(j));
					count=1;
				}
			}
			

			if(!arrayList.get(j).isEmpty())
			{
				System.out.println(arrayList.get(j));	
						
			}
			
				}
		
	
		if (count>0) 
		{
			System.out.println("--------------------------------------" );
			System.out.println("Yes the following Security Names are Duplicate " );
			System.out.println("--------------------------------------" );
			
			for(String value:duplicateList)
			{
				System.out.println(value);
			}
	
		}
		else
		{
			System.out.println("No there are Duplicate Security Names" );
			}
		
		
		
		
}	

	}


//for(int l=0;l<duplicateList.size()-1;l++)
//{
//	System.out.println(duplicateList.get(l));
//}
//

