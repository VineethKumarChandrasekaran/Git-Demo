package com.vt.crm.objectreporsitory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

@FindBy(name="user_name")
private WebElement username;

@FindBy(name="user_password")
private WebElement password;

@FindBy(id="submitButton")
private WebElement loginBtn;


public LoginPage(WebDriver driver) {
	PageFactory.initElements(driver, this);
}


public WebElement getUsername() {
	return username;
}


public WebElement getPassword() {
	return password;
}


public WebElement getLoginBtn() {
	return loginBtn;
}

public void login(String un, String pwd)
{
	username.sendKeys(un);
	password.sendKeys(pwd);
	loginBtn.click();
}

}
