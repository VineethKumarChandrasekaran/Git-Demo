package organisation;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import java.util.Random;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Reporter;
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

public class CreateOrganisationWithIndustryTest {
	@Test
	public void createOrganisation() throws IOException {

		FileUtility fu=new FileUtility();
		WebDriverUtility wu=new WebDriverUtility();
		JavaUtility ju=new JavaUtility();
		ExcelUtility eu=new ExcelUtility();
		String orgName = eu.getDataFromExcelFile("Sheet1", 3, 1)+ju.generateRandomNum();
		
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		wu.waitForPageToLoad(driver);
		driver.get(fu.getDataFromPropertyFile("url"));
		
		
		LoginPage lp=new LoginPage(driver);
		lp.login(fu.getDataFromPropertyFile("username"), fu.getDataFromPropertyFile("password"));
		
		
		HomePage hp=new HomePage(driver);
		hp.getOrganisationLink().click();
		
		OrganisationsPage op=new OrganisationsPage(driver);
		op.getCreateOrgLink().click();
		
		
		CreateOrganisationPage cop=new CreateOrganisationPage(driver);
		cop.getOrgNameTF().sendKeys(orgName);
		//cop.getIndustryDropdown().sendKeys(eu.getDataFromExcelFile("Sheet1", 3, 2));
		wu.seletDropDownByVisibleText(cop.getIndustryDropdown(),eu.getDataFromExcelFile("Sheet1", 5, 2));
		wu.seletDropDownByValue(cop.getTypeDropdown(),eu.getDataFromExcelFile("Sheet1", 5, 3));
		
		cop.getSaveBtn().click();
		
		
		OrganizationInformationPage oip=new OrganizationInformationPage(driver);
		String headermsg = oip.getHeaderMsg().getText();
		
		// String act_name =
		// driver.findElement(By.xpath("//td[@id='mouseArea_Organization
		// Name']")).getText();

		if (headermsg.contains(orgName)) {
			Reporter.log("Organisation is created", true);
		} else {
			Reporter.log("Organisation is not created", true);
		}
		String act_name = oip.getOrganisationname().getText();
		String a_name = act_name.trim();

		if (orgName.contains(a_name)) {
			System.out.println("PASS");
		} else {
			System.out.println("FAIL");
		}
		

		driver.quit();

	}
}
