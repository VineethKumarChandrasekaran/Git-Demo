package organisation;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import com.vt.crm.generic.fileUtility.ExcelUtility;
import com.vt.crm.generic.fileUtility.FileUtility;
import com.vt.crm.generic.webdriverutility.JavaUtility;
import com.vt.crm.generic.webdriverutility.WebDriverUtility;
import com.vt.crm.objectreporsitory.CreateOrganisationPage;
import com.vt.crm.objectreporsitory.HomePage;
import com.vt.crm.objectreporsitory.LoginPage;
import com.vt.crm.objectreporsitory.OrganisationsPage;
import com.vt.crm.objectreporsitory.OrganizationInformationPage;

public class CreateOrganisationWithContactTest {
@Test
public void createOrgWithContact() throws IOException
{
	WebDriverUtility wu=new WebDriverUtility();
	FileUtility fu=new FileUtility();
	ExcelUtility eu=new ExcelUtility();
	JavaUtility ju=new JavaUtility();
	
	String url = fu.getDataFromPropertyFile("url");
	String org_name = eu.getDataFromExcelFile("Sheet1", 5, 1)+ju.generateRandomNum();
	
	WebDriver driver=new ChromeDriver();
	wu.waitForPageToLoad(driver);
	driver.manage().window().maximize();
	driver.get(url);
	LoginPage lp=new LoginPage(driver);
	lp.login(fu.getDataFromPropertyFile("username"), fu.getDataFromPropertyFile("password"));
	
	
	HomePage hp=new HomePage(driver);
	hp.getOrganisationLink().click();
	
	OrganisationsPage op=new OrganisationsPage(driver);
	op.getCreateOrgLink().click();
	
	CreateOrganisationPage cop=new CreateOrganisationPage(driver);
	
	cop.getOrgNameTF().sendKeys(org_name);
	cop.getPhoneTF().sendKeys(eu.getDataFromExcelFile("Sheet1", 5, 4));
	cop.getSaveBtn().click();
	
	OrganizationInformationPage oip=new OrganizationInformationPage(driver);
	String header=oip.getHeaderMsg().getText();
	if(header.contains(org_name))
	{
		System.out.println("Organisation is created");
	}
	else
	{
		System.out.println("Organisation is not created");
	}
	
	String orgname = oip.getOrganisationname().getText();
	String neworgname = orgname.trim();
	
	if(neworgname.equals(org_name))
	{
		System.out.println("PASS");
	}
	else
		System.out.println("FAIL");
	
	driver.quit();
}
}
