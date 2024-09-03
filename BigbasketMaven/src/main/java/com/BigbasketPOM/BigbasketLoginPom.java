package com.BigbasketPOM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.BigBasketBase.BibasketBaseClass;

public class BigbasketLoginPom extends BibasketBaseClass implements LoginInterface{

	private WebDriver logindriver;
	
	public BigbasketLoginPom(WebDriver driver) {  
	
		logindriver = driver;
		PageFactory.initElements(driver, this);
	
	}
	

	@FindBy(xpath = loginBtnXpath)
	private WebElement loginBtn;
	
	@FindBy(id = phoneNumberBtnId )
	private WebElement phoneNumberBtn ;
	
	@FindBy(xpath = continueBtnXpath)
	private WebElement continueBtn;
	
	@FindBy(xpath = verifyBtnXpath)
	private WebElement verifyBtn ;
	
	public void loginpage() {
		
		clickTheElement(logindriver,loginBtn,10);
	}
	
	public void verifylogin() {
		
		inputvalues(logindriver, phoneNumberBtn, 10, "8939975610");
		clickTheElement(logindriver,continueBtn, 10);
		staticwait(30000);
		clickTheElement(logindriver, verifyBtn, 10);
		
	}
	
	
}
