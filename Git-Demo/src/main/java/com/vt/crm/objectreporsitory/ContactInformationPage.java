package com.vt.crm.objectreporsitory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactInformationPage {

	@FindBy(xpath = "//span[@class='dvHeaderText']")
	private WebElement headerMsg;

	@FindBy(id = "dtlview_Support Start Date")
	private WebElement date;

	@FindBy(id = "mouseArea_Organization Name")
	private WebElement orgname;

	public ContactInformationPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public WebElement getHeaderMsg() {
		return headerMsg;
	}

	public WebElement getDate() {
		return date;
	}

	public WebElement getOrgname() {
		return orgname;
	}
	
	

}
