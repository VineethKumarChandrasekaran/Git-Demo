package contacts;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import com.vt.crm.generic.fileUtility.ExcelUtility;
import com.vt.crm.generic.fileUtility.FileUtility;
import com.vt.crm.generic.webdriverutility.JavaUtility;
import com.vt.crm.generic.webdriverutility.WebDriverUtility;
import com.vt.crm.objectreporsitory.ContactInformationPage;
import com.vt.crm.objectreporsitory.ContactsPage;
import com.vt.crm.objectreporsitory.CreateContactPage;
import com.vt.crm.objectreporsitory.HomePage;
import com.vt.crm.objectreporsitory.LoginPage;

public class CreateContactWithSupportDateTest {
@Test
public void createContact() throws IOException
{
	WebDriver driver;
	WebDriverUtility wu=new WebDriverUtility();
	FileUtility fu=new FileUtility();
	JavaUtility ju=new JavaUtility();
	ExcelUtility eu=new ExcelUtility();
	
	
	String browsername = fu.getDataFromPropertyFile("browser");
	if(browsername.equals("chrome"))
	{
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		wu.waitForPageToLoad(driver);
		driver.get(fu.getDataFromPropertyFile("url"));
		
		LoginPage lp=new LoginPage(driver);
		lp.login(fu.getDataFromPropertyFile("username"), fu.getDataFromPropertyFile("password"));
		
		HomePage hp=new HomePage(driver);
		hp.getContactsLink().click();
		
		ContactsPage cp=new ContactsPage(driver);
		cp.getCreateContactLink().click();
		
		CreateContactPage ccp=new CreateContactPage(driver);
		ccp.getLastnameTF().sendKeys(eu.getDataFromExcelFile("Sheet2", 1, 0));
		
		ccp.getStart_date().sendKeys(ju.getSystemDateYYYYDDMM());
		ccp.getEnd_date().clear();
		String edate = ju.getrequiredDateYYYDDMM(30);
		ccp.getEnd_date().sendKeys(edate);
		ccp.getSaveButton().click();
		
		ContactInformationPage cip=new ContactInformationPage(driver);
		String start_date =cip.getDate() .getText();
		if(start_date.contains(edate))
			System.out.println("Contact is created");
		else
			System.out.println("Contact is not created");
		
		
		
	}
}
}
