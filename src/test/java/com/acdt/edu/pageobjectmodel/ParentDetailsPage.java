package com.acdt.edu.pageobjectmodel;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import com.acdt.edu.util.SeleniumUtil;

public class ParentDetailsPage {
	private static final Logger LOGGER = LogManager.getLogger(ParentDetailsPage.class);
	public static final String PARENT_DETAILS_TITLE_XPATH = "//h3[text()='Particulars of Parent/Guardian/Sponsor']";
	public static final String TITLE_XPATH = "//span[text()='Select title']";
	public static final String SEARCH_XPATH = "(//input[@placeholder='Search'])[index]";
	public static final String SELECT_LABEL_XPATH = "//label[text()='selectText']";
	public static final String SURNAME_NAME = "surname";
	public static final String FIRSTNAME_NAME = "firstName";
	public static final String MIDDLENAME_NAME = "middleName";
	public static final String PARENT_RADIO_BUTTON_XPATH = "//label[input[@name='exampleRadiosInline1']]";
	public static final String GUARDIAN_RADIO_BUTTON_XPATH = "//label[input[@name='exampleRadiosInline2']]";
	public static final String SPONSOR_RADIO_BUTTON_XPATH = "//label[input[@name='exampleRadiosInline2']]";
	public static final String COMPANY_NAME = "company";
	public static final String OCCUPATION_NAME = "occupation";
	public static final String ADDRESS1_NAME = "address1";
	public static final String ADDRESS2_NAME = "address2";
	public static final String COUNTRY_XPATH = "//div[label[text()='Country']]//div[@class='c-btn']";
	public static final String CITY_NAME = "city";
	public static final String STATE_NAME = "state";
	public static final String MOBILE_NAME = "mobileno";
	public static final String TELEPHONE_NAME = "telephone";
	public static final String EMAIL_NAME = "email";
	public static final String POSTALCODE_NAME = "postalcode";
	public static final String NEXT_BUTTON_XPATH = "//a[text()='Next']";
	public static final String ERROR_MESSAGE_XPATH = "//div[@class='section form-content']/div[3]";

	public static void validateParentDetailsTitle() {
		LOGGER.info("Inside validateParentDetailsTitle Method");
		SeleniumUtil.validateWebElementVisible(By.xpath(PARENT_DETAILS_TITLE_XPATH), SeleniumUtil.waitWebElementSync);
	}

	public static void parentDetailFilling(String title, String firstName, String middleName, String surname,
			String relationship, String company, String occupation, String address1, String address2, String country,
			String city, String state, String mobile, String telephone, String email, String postalCode)
			throws Throwable {

		if (!("".equals(title))) {
			Thread.sleep(1000);
			SeleniumUtil.getWebElement(By.xpath(TITLE_XPATH)).click();
			Thread.sleep(1000);
			SeleniumUtil.getWebElement(By.xpath(SEARCH_XPATH.replace("index", "1"))).sendKeys(title);
			Thread.sleep(1000);
			SeleniumUtil.getWebElement(By.xpath(SELECT_LABEL_XPATH.replace("selectText", title))).click();
		

		}
		if (!("".equals(firstName))) {
			SeleniumUtil.getWebElement(By.name(FIRSTNAME_NAME)).clear();
			SeleniumUtil.getWebElement(By.name(FIRSTNAME_NAME)).sendKeys(firstName);
		}
		if (!("".equals(middleName))) {
			SeleniumUtil.getWebElement(By.name(MIDDLENAME_NAME)).sendKeys(middleName);
		}
		if (!("".equals(surname))) {
			SeleniumUtil.getWebElement(By.name(SURNAME_NAME)).clear();
			SeleniumUtil.getWebElement(By.name(SURNAME_NAME)).sendKeys(surname);
		}

		if (!("".equals(relationship))) {
			if ("parent".equalsIgnoreCase(relationship)) {
				SeleniumUtil.scrollToWebElement(By.xpath(PARENT_RADIO_BUTTON_XPATH));
				SeleniumUtil.getWebElement(By.xpath(PARENT_RADIO_BUTTON_XPATH)).click();
			} else if ("guardian".equalsIgnoreCase(relationship)) {
				SeleniumUtil.scrollToWebElement(By.xpath(GUARDIAN_RADIO_BUTTON_XPATH));
				SeleniumUtil.getWebElement(By.xpath(GUARDIAN_RADIO_BUTTON_XPATH)).click();
			} else if ("sponsor".equalsIgnoreCase(relationship)) {
				SeleniumUtil.scrollToWebElement(By.xpath(PARENT_RADIO_BUTTON_XPATH));
				SeleniumUtil.getWebElement(By.xpath(GUARDIAN_RADIO_BUTTON_XPATH)).click();
			}

		}

		if (!("".equals(company))) {

			SeleniumUtil.getWebElement(By.name(COMPANY_NAME)).sendKeys(company);
		}

		if (!("".equals(occupation))) {
			SeleniumUtil.getWebElement(By.name(OCCUPATION_NAME)).sendKeys(occupation);
			
		}
		
		if (!("".equals(address1))) {
			SeleniumUtil.getWebElement(By.name(ADDRESS1_NAME)).sendKeys(address1);
		}
		
		if (!("".equals(address2))) {
			SeleniumUtil.getWebElement(By.name(ADDRESS2_NAME)).sendKeys(address2);
		}
		
		if(!("".equals(country))){
			SeleniumUtil.getWebElement(By.xpath(COUNTRY_XPATH)).click();
			SeleniumUtil.getWebElement(By.xpath(SEARCH_XPATH.replace("index", "2"))).sendKeys(country);
			SeleniumUtil.getWebElement(By.xpath(SELECT_LABEL_XPATH.replace("selectText", country))).click();
				
		}
		if (!("".equals(city))) {
			SeleniumUtil.getWebElement(By.name(CITY_NAME)).sendKeys(city);
		}
		if (!("".equals(state))) {
			SeleniumUtil.getWebElement(By.name(STATE_NAME)).sendKeys(state);
		}
		if (!("".equals(mobile))) {
			SeleniumUtil.getWebElement(By.name(MOBILE_NAME)).sendKeys(mobile);
		}
		if (!("".equals(telephone))) {
			SeleniumUtil.getWebElement(By.name(TELEPHONE_NAME)).sendKeys(telephone);
		}
		if (!("".equals(email))) {
			SeleniumUtil.getWebElement(By.name(EMAIL_NAME)).sendKeys(email);
		}
		if (!("".equals(postalCode))) {
			SeleniumUtil.getWebElement(By.name(POSTALCODE_NAME)).sendKeys(postalCode);
		}

	}

	public static void clickNextButton() {
		SeleniumUtil.getWebElement(By.xpath(NEXT_BUTTON_XPATH)).click();
	}

	public static String getErrorMessage() {
		SeleniumUtil.wait(2000);
		return SeleniumUtil.getWebElement(By.xpath(ERROR_MESSAGE_XPATH)).getText().trim();

	}

}
