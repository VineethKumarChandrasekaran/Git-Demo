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

public class CreateContactWithOrganisationTest {
@Test
public void createContact() throws IOException, InterruptedException
{
	WebDriverUtility wu=new WebDriverUtility();
	JavaUtility ju=new JavaUtility();
	ExcelUtility eu=new ExcelUtility();
	FileUtility fu=new FileUtility();
	
	WebDriver driver=new ChromeDriver();
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
	
	String p_id=driver.getWindowHandle();
	ccp.getOrgNameLink().click();
	Thread.sleep(3000);
	wu.switchToWindow(driver, "module=accounts");
	
	driver.findElement(By.linkText("vtiger")).click();
	driver.switchTo().window(p_id);
	
	ccp.getSaveBtn().click();
	
	ContactInformationPage cip=new ContactInformationPage(driver);
	
	String expected_org_name=cip.getOrgname().getText();
	String aname=expected_org_name.trim();
	if(aname.contains("vtiger"))
	{
		System.out.println("Contact is created");
	}
	else
		System.out.println("Contact is not created");
	
	driver.quit();
	
}
}
