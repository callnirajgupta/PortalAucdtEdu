package com.acdt.edu.pageobjectmodel;

import java.util.Date;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.By;

import com.acdt.edu.util.SeleniumUtil;

public class SignupPage {
	private static final Logger LOGGER = LogManager.getLogger(SignupPage.class);
	public static final String SIGNUP_TITLE_XPATH = "//h5[contains(text(),'Welcome to the ACDT Online Admission Portal!')]";
	public static final String FIRSTNAME_NAME="firstName";
	public static final String MIDDLENAME_NAME="middleName";
	public static final String LASTNAME_NAME="lastName";
	public static final String SELECT_LABEL_XPATH="//label[text()='selectText']";
	public static final String SEARCH_LABEL_XPATH="(//input[@placeholder='Search'])[index]";
	public static final String PROGRAMME_TYPE_XPATH="//span[text()='Select programme']";
	public static final String GENDER_XPATH="//span[text()='Select gender']";
	public static final String COUNTRY_OF_RESIDENCE_XPATH="//span[text()='Select country']";
	public static final String COUNTRY_FLAG_DDROPDOWN_CSS="div.iti__selected-flag";
	public static final String COUNTRY_CODE_XPATH="//span[text()='countryCode']";
	public static final String MOBILE_NUMBER_CSS="input[placeholder='Mobile Number ']";
	public static final String EMAIL_NAME="email";
	public static final String PASSWORD_NAME="password";
	public static final String CONFIRM_PASSWORD_NAME="confirmPassword";
	public static final String CAPTCHA_XPATH="//span[@id='recaptcha-anchor']/div[1]";
	public static final String START_APPLICATION_XPATH="//a[text()='Start Application']";
	public static final String ERROR_MESSAGE_XPATH="//p[@class='error-msg']";
	
	public static void validateSignupTitle() {
		LOGGER.info("Inside validateHomePageTitle Method");
		SeleniumUtil.validateWebElementVisible(By.xpath(SIGNUP_TITLE_XPATH), SeleniumUtil.waitWebElementSync);
	}
	
	public static void signup(String firstName,String middleName,String lastName,
			String programme,String gender,String country,String mobile,String email,String password,String confirmPassword,String captcha){
		
		if(!("".equals(firstName))){
			SeleniumUtil.getWebElement(By.name(FIRSTNAME_NAME)).sendKeys(firstName);	
		}
		if(!("".equals(middleName))){
			SeleniumUtil.getWebElement(By.name(MIDDLENAME_NAME)).sendKeys(middleName);	
		}
		if(!("".equals(lastName))){
			SeleniumUtil.getWebElement(By.name(LASTNAME_NAME)).sendKeys(lastName);	
		}
		if(!("".equals(programme))){
			SeleniumUtil.getWebElement(By.xpath(PROGRAMME_TYPE_XPATH)).click();
			SeleniumUtil.getWebElement(By.xpath(SELECT_LABEL_XPATH.replace("selectText", programme))).click();
			
		}
		
		if(!("".equals(gender))){
			SeleniumUtil.getWebElement(By.xpath(GENDER_XPATH)).click();
			SeleniumUtil.getWebElement(By.xpath(SELECT_LABEL_XPATH.replace("selectText", gender))).click();
			
		}
		
		if(!("".equals(country))){
			SeleniumUtil.getWebElement(By.xpath(COUNTRY_OF_RESIDENCE_XPATH)).click();
			SeleniumUtil.getWebElement(By.xpath(SEARCH_LABEL_XPATH.replace("index", "3"))).sendKeys(country);
			SeleniumUtil.getWebElement(By.xpath(SELECT_LABEL_XPATH.replace("selectText", country))).click();
			
		}
		
		if(!("".equals(mobile))){
			SeleniumUtil.scrollToWebElement(By.cssSelector(COUNTRY_FLAG_DDROPDOWN_CSS));
			SeleniumUtil.getWebElement(By.cssSelector(COUNTRY_FLAG_DDROPDOWN_CSS)).click();
			String countryCode=mobile.substring(0, 3);
		
			String CountryCodeXpath=COUNTRY_CODE_XPATH.replace("countryCode", countryCode);
			SeleniumUtil.scrollToWebElement(By.xpath(CountryCodeXpath));
			
			SeleniumUtil.getWebElement(By.xpath(CountryCodeXpath)).click();
			
			SeleniumUtil.getWebElement(By.cssSelector(MOBILE_NUMBER_CSS)).sendKeys(mobile.substring(3,mobile.length()));	
		}
		
		if(!("".equals(email))){
			Date date= new Date();
			String emailAuto="automation"+date.getTime()+"@gmail.com";
			SeleniumUtil.getWebElement(By.name(EMAIL_NAME)).sendKeys(emailAuto);	
		}
		
		if(!("".equals(password))){
			SeleniumUtil.getWebElement(By.name(PASSWORD_NAME)).sendKeys(password);	
		}
		
		if(!("".equals(confirmPassword))){
			SeleniumUtil.getWebElement(By.name(CONFIRM_PASSWORD_NAME)).sendKeys(confirmPassword);	
		}
		if(!("".equals(captcha))){
			SeleniumUtil.getDriver().switchTo().frame(0);
			SeleniumUtil.getWebElement(By.xpath(CAPTCHA_XPATH)).click();
			SeleniumUtil.switchToDefaultContent();
			SeleniumUtil.wait(2000);
		}
		
		
		SeleniumUtil.getWebElement(By.xpath(START_APPLICATION_XPATH)).click();
		
	}

	
	public static void ValidateErrorMessage(String message){
		SeleniumUtil.wait(2000);
		Assert.assertEquals("The signup page error message not matching", message, SeleniumUtil.getWebElement(By.xpath(ERROR_MESSAGE_XPATH)).getText().trim());
	}
	
	public static void selectCountry(String country){
		    SeleniumUtil.validateWebElementVisible(By.xpath(COUNTRY_OF_RESIDENCE_XPATH), SeleniumUtil.waitWebElementSync);
			SeleniumUtil.getWebElement(By.xpath(COUNTRY_OF_RESIDENCE_XPATH)).click();
			SeleniumUtil.getWebElement(By.xpath(SEARCH_LABEL_XPATH.replace("index", "3"))).sendKeys(country);
			String xpathForLabel="//label[text()=\""+country+"\"]";
			//SeleniumUtil.getWebElement(By.xpath(SELECT_LABEL_XPATH.replace("selectText", country))).click();
			SeleniumUtil.getWebElement(By.xpath(xpathForLabel)).click();
		
	}
}
