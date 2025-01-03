package com.vt.crm.objectreporsitory;

import java.awt.print.PageFormat;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrganisationsPage {

	
@FindBy(xpath="//img[@title='Create Organization...']")
private WebElement createOrgLink;

public OrganisationsPage(WebDriver driver) {
	PageFactory.initElements(driver, this);
}

public WebElement getCreateOrgLink() {
	return createOrgLink;
}




}
