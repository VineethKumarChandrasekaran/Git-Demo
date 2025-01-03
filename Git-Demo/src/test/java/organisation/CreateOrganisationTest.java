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
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Reporter;
import org.testng.annotations.Test;

import com.vt.crm.generic.fileUtility.ExcelUtility;
import com.vt.crm.generic.fileUtility.FileUtility;
import com.vt.crm.objectreporsitory.CreateOrganisationPage;
import com.vt.crm.objectreporsitory.HomePage;
import com.vt.crm.objectreporsitory.LoginPage;
import com.vt.crm.objectreporsitory.OrganisationsPage;
import com.vt.crm.objectreporsitory.OrganizationInformationPage;

public class CreateOrganisationTest {
	@Test
	public void createOrganisation() throws IOException {

		Random random = new Random();
		int value = random.nextInt();

		FileUtility fu=new FileUtility();
		String url = fu.getDataFromPropertyFile("url");
		String username=fu.getDataFromPropertyFile("username");
		String password = fu.getDataFromPropertyFile("password");
		
		ExcelUtility eu=new ExcelUtility();
		String name = eu.getDataFromExcelFile("Sheet1", 1, 1);
		String orgName = name+value;

		
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get(url);
		
		LoginPage lp=new LoginPage(driver);
		lp.login(username, password);
		
		
		HomePage hp=new HomePage(driver);
		hp.getOrganisationLink().click();
		
		
		OrganisationsPage op=new OrganisationsPage(driver);
		op.getCreateOrgLink().click();
		
		CreateOrganisationPage cop=new CreateOrganisationPage(driver);
		cop.createOrg(orgName);
		
		
		OrganizationInformationPage oip=new OrganizationInformationPage(driver);
		String headername = oip.getHeaderMsg().getText();
		// String act_name =
		// driver.findElement(By.xpath("//td[@id='mouseArea_Organization
		// Name']")).getText();

		if (headername.contains(orgName)) {
			Reporter.log("Organisation is created", true);
		} else {
			Reporter.log("Organisation is not created", true);
		}
		
		String oname = oip.getOrganisationname().getText();
		String a_name = oname.trim();

		if (orgName.contains(a_name)) {
			System.out.println("PASS");
		} else {
			System.out.println("FAIL");
		}
		

		driver.quit();

	}
}
