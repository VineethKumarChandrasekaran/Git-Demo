package com.vt.crm.objectreporsitory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateContactPage {

	@FindBy(name = "lastname")
	private WebElement lastnameTF;

	@FindBy(xpath = "//input[@title='Save [Alt+S]']")
	private WebElement saveBtn;

	@FindBy(name = "support_start_date")
	private WebElement start_date;

	@FindBy(name = "support_end_date")
	private WebElement end_date;

	@FindBy(xpath = "//input[@title='Save [Alt+S]']")
	private WebElement saveButton;

	@FindBy(xpath = "//img[@title='Select']")
	private WebElement orgNameLink;

	public CreateContactPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public WebElement getLastnameTF() {
		return lastnameTF;
	}

	public WebElement getSaveBtn() {
		return saveBtn;
	}

	public WebElement getStart_date() {
		return start_date;
	}

	public WebElement getEnd_date() {
		return end_date;
	}

	public WebElement getSaveButton() {
		return saveButton;
	}

	public WebElement getOrgNameLink() {
		return orgNameLink;
	}

}
