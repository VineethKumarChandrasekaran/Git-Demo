package com.vt.crm.objectreporsitory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrganizationInformationPage {

@FindBy(className="dvHeaderText")
private WebElement headerMsg;

@FindBy(xpath="//td[@id='mouseArea_Organization Name']")
private WebElement organisationname;

public OrganizationInformationPage(WebDriver driver) {
	PageFactory.initElements(driver, this);
} 

public WebElement getHeaderMsg() {
	return headerMsg;
}

public WebElement getOrganisationname() {
	return organisationname;
}






}
   