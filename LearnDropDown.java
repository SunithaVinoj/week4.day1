package week4.day1;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
//import org.openqa.selenium.WebDriverManager;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.support.ui.Select;

public class LearnDropDown 
{
public static void main(String[] args) {
	
                   	
	
	WebDriverManager.chromedriver().setup();
	ChromeDriver driver = new ChromeDriver();
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	driver.get("http://leaftaps.com/opentaps/control/login");
	
	 WebElement elementUsername = driver.findElement(By.id("username"));
	    // Entering some input in the text box
	    elementUsername.sendKeys("Demosalesmanager");
	    
	    driver.findElement(By.name("PASSWORD")).sendKeys("crmsfa",Keys.ENTER);
	    
	    driver.findElement(By.linkText("CRM/SFA")).click();
	    driver.findElement(By.linkText("Leads")).click();
	
	    driver.findElement(By.linkText("Create Lead")).click();

    WebElement sourceDropdown = driver.findElement(By.id("createLeadForm_dataSourceId"));
    
    Select sel1 = new Select(sourceDropdown);
    
   
    sel1.selectByIndex(1);

    
    WebElement marketingCampaignDropdown = driver.findElement(By.id("createLeadForm_marketingCampaignId"));
    
    Select sel2 = new Select(marketingCampaignDropdown);
    
//    select2.selectByVisibleText("Car and Driver");
    
    sel2.selectByValue("9000");
    
    List<WebElement> options = sel2.getOptions();
    
    sel2.selectByIndex(options.size()-1);
    
    for (WebElement value : options)
    {
        System.out.println(value.getText());
    }
    
    
    WebElement industry = driver.findElement(By.id("createLeadForm_industryEnumId"));
    
    Select sel3 = new Select(industry);
    
    List<WebElement> industryoptions = sel3.getOptions();
    
    for (WebElement indvalue : industryoptions)
    {
        System.out.println(indvalue.getText());
    }
    
    
WebElement ownership = driver.findElement(By.id("createLeadForm_ownershipEnumId"));
    
    Select sel4 = new Select(ownership);
    
    List<WebElement> ownershipoptions = sel4.getOptions();
    
    sel4.selectByIndex(ownershipoptions.size()-1);
    
    
   
    
    
}
}
