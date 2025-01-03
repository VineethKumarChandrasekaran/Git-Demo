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

public class CreateContactTest {
	WebDriverUtility wu = new WebDriverUtility();
	FileUtility fu = new FileUtility();
	ExcelUtility eu = new ExcelUtility();
	JavaUtility ju = new JavaUtility();

	@Test
	public void create() throws IOException {

		
		//Modified Script
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		wu.waitForPageToLoad(driver);
		driver.get(fu.getDataFromPropertyFile("url"));
		String lname = eu.getDataFromExcelFile("Sheet2", 1, 0) + ju.generateRandomNum();

		LoginPage lp = new LoginPage(driver);
		lp.login(fu.getDataFromPropertyFile("username"), fu.getDataFromPropertyFile("password"));

		HomePage hp = new HomePage(driver);
		hp.getContactsLink().click();

		ContactsPage cp = new ContactsPage(driver);
		cp.getCreateContactLink().click();

		CreateContactPage ccp = new CreateContactPage(driver);
		ccp.getLastnameTF().sendKeys(lname);
		ccp.getSaveBtn().click();

		ContactInformationPage cip = new ContactInformationPage(driver);
		String header = cip.getHeaderMsg().getText();
		if (header.contains(lname)) {
			System.out.println("Contact is created");
		} else
			System.out.println("Contact is not created");

		driver.quit();

	}
}
