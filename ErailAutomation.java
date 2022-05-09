package week4.day1;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ErailAutomation {
	
public static void main(String[] args) {
		
	
	//download the driver and setup the path
WebDriverManager.chromedriver().setup();
ChromeDriver driver = new ChromeDriver();
driver.manage().window().maximize();
driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
driver.get("https://erail.in/");

WebElement elementUsername = driver.findElement(By.id("txtStationFrom"));
elementUsername.clear();
// Entering some input in the text box
elementUsername.sendKeys("MDU",Keys.TAB);

WebElement findElement = driver.findElement(By.id("txtStationTo"));
findElement.clear();
findElement.sendKeys("TPJ",Keys.TAB);

driver.findElement(By.id("chkSelectDateOnly")).click();

WebElement elmntTable = driver.findElement(By.xpath("//table[@class='DataTable TrainList TrainListHeader']"));

List<WebElement> rows = elmntTable.findElements(By.tagName("tr"));

for(int i=1;i<rows.size();i++)
{
	List<WebElement> cols = rows.get(i).findElements(By.tagName("td"));
	for(int j=0;j<=1;j++)
	{
		System.out.println(cols.get(j).getText() + " ");
	}
}





 	}
}
