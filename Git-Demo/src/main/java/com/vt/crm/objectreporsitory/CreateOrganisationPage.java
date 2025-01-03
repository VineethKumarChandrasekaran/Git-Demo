package com.vt.crm.objectreporsitory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateOrganisationPage {

@FindBy(name="accountname")
private  WebElement orgNameTF;

@FindBy(name="industry")
private WebElement industryDropdown;

@FindBy(name="accounttype")
private WebElement typeDropdown;

@FindBy(name="phone")
private WebElement phoneTF;

@FindBy(xpath="//input[@title='Save [Alt+S]']")
private WebElement saveBtn;

public CreateOrganisationPage(WebDriver driver) {
	PageFactory.initElements(driver, this);
}

public WebElement getOrgNameTF() {
	return orgNameTF;
}



public WebElement getIndustryDropdown() {
	return industryDropdown;
}

public WebElement getTypeDropdown() {
	return typeDropdown;
}

public WebElement getSaveBtn() {
	return saveBtn;
}


public WebElement getPhoneTF() {
	return phoneTF;
}

public void createOrg(String orgName)
{
	orgNameTF.sendKeys(orgName);
	saveBtn.click();
}



}
