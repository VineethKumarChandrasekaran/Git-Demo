package com.vt.crm.objectreporsitory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {

@FindBy(linkText="Organizations")
private WebElement organisationLink;

@FindBy(linkText="Contacts")
private WebElement contactsLink;

@FindBy(linkText="More")
private WebElement moreLink;

@FindBy(linkText="Campaigns")
private WebElement campaignsLink;

public HomePage(WebDriver driver) {
	PageFactory.initElements(driver, this);
}

public WebElement getOrganisationLink() {
	return organisationLink;
}

public WebElement getContactsLink() {
	return contactsLink;
}

public WebElement getMoreLink() {
	return moreLink;
}

public WebElement getCampaignsLink() {
	return campaignsLink;
}
  

public void campaign(WebDriver driver)
{
	Actions act=new Actions(driver);
	act.moveToElement(moreLink);
	campaignsLink.click();
	
}



}
