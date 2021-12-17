package com.runner;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import com.base_Class.Base_Class;
import com.manager.POManager;

import pom2.BookHotel;
import pom2.Final;
import pom2.HomePage;
import pom2.SearchHotel;
import pom2.SelectHotel;


public class Runner extends Base_Class{
	public static WebDriver  driver = getBrowser("chrome");
	public static POManager pom=new POManager(driver);
	public static Logger log =Logger.getLogger(Runner.class);
	public static void main(String[] args) throws Throwable  {
		PropertyConfigurator.configure("log4j.properties");
		log.info("browser launched");
		url("https://adactinhotelapp.com/");
		log.info("Url launched");
		//login
		String username = ParticularData("C:\\Users\\my pc\\Documents\\TestCase_for_Project2.xlsx",1,5);
		sendkeys(pom.getHp().getUsername(),username);
		
		String password= ParticularData("C:\\Users\\my pc\\Documents\\TestCase_for_Project2.xlsx",2,5);
		sendkeys(pom.getHp().getPassword(), password);
		click(pom.getHp().getLogin());
		implicitWait(20, TimeUnit.SECONDS);
		log.info("Login successfull");
		// Search Hotel
		implicitWait(30, TimeUnit.SECONDS);
		String location= ParticularData("C:\\Users\\my pc\\Documents\\TestCase_for_Project2.xlsx",4,5);
		dropdownSelectByValue(pom.getS().getLocation(), location);
		
		String hotel= ParticularData("C:\\Users\\my pc\\Documents\\TestCase_for_Project2.xlsx",5,5);
		dropdownSelectByValue(pom.getS().getHotel(), hotel);
		
		String roomType= ParticularData("C:\\Users\\my pc\\Documents\\TestCase_for_Project2.xlsx",6,5);
        dropdownSelectByValue(pom.getS().getRoomtypes(), roomType);
        
        String noOfRooms= ParticularData("C:\\Users\\my pc\\Documents\\TestCase_for_Project2.xlsx",7,5);
		dropdownSelectByValue(pom.getS().getRooms(), noOfRooms);
		
		String cinDate= ParticularData("C:\\Users\\my pc\\Documents\\TestCase_for_Project2.xlsx",8,5);
		sendkeys(pom.getS().getDate1(), cinDate);
		
		String coutDate= ParticularData("C:\\Users\\my pc\\Documents\\TestCase_for_Project2.xlsx",9,5);
		sendkeys(pom.getS().getDate2(), coutDate);
		
		String adult= ParticularData("C:\\Users\\my pc\\Documents\\TestCase_for_Project2.xlsx",10,5);
		dropdownSelectByValue(pom.getS().getAdult(),adult);
		
		String child= ParticularData("C:\\Users\\my pc\\Documents\\TestCase_for_Project2.xlsx",11,5);
		dropdownSelectByValue(pom.getS().getChild(), child);
		click(pom.getS().getSearch());
		implicitWait(20,TimeUnit.SECONDS);
		log.info("Hotel serached successfully");
		// Select hotel
		click(pom.getSh().getAgree());
		click(pom.getSh().getContinue());
		implicitWait(20,TimeUnit.SECONDS);
		log.info("Hotel selected successfully");
		// Book a Hotel
		String fname= ParticularData("C:\\Users\\my pc\\Documents\\TestCase_for_Project2.xlsx",15,5);
		sendkeys(pom.getBh().getFname(), fname);
		
		String lname= ParticularData("C:\\Users\\my pc\\Documents\\TestCase_for_Project2.xlsx",16,5);
		sendkeys(pom.getBh().getLname(),lname);
		
		String address= ParticularData("C:\\Users\\my pc\\Documents\\TestCase_for_Project2.xlsx",17,5);
		sendkeys(pom.getBh().getAdress(),address);
		
		String creditCardNo= ParticularData("C:\\Users\\my pc\\Documents\\TestCase_for_Project2.xlsx",18,5);
		sendkeys(pom.getBh().getCreditCard(),creditCardNo);
		
		String cType= ParticularData("C:\\Users\\my pc\\Documents\\TestCase_for_Project2.xlsx",19,5);
		dropdownSelectByValue(pom.getBh().getCcType(), cType);
		
		String expMonth= ParticularData("C:\\Users\\my pc\\Documents\\TestCase_for_Project2.xlsx",20,5);
		dropdownSelectByValue(pom.getBh().getExpMonth(), expMonth);
		
		String expYear= ParticularData("C:\\Users\\my pc\\Documents\\TestCase_for_Project2.xlsx",21,5);
		dropdownSelectByValue(pom.getBh().getExpYear(), expYear);
		
		String ccvNo= ParticularData("C:\\Users\\my pc\\Documents\\TestCase_for_Project2.xlsx",22,5);
		sendkeys(pom.getBh().getCcv(),ccvNo);
		click(pom.getBh().getBooknow());
		implicitWait(20, TimeUnit.SECONDS);
		log.info("Hotel Booked successfully");
		// Booking Confirmation
		click(pom.getF().getLogout());
		log.info("Logout successfully");
		driver.close();
		log.info("Browser close successfully");
		
	}
}