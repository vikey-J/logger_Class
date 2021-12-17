package com.runner_Class;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import com.pom.Adress_Page;
import com.pom.Cart_page;
import com.pom.HomePage;
import com.base_Class.Base_Class;
import com.pom.New_Acc;
import com.pom.Payment_Page;
import com.pom.Shiping_Page;
import com.pom.Singin_Page;
import com.pom.Summary;
import com.pomanager.Page_Object_Manager;

public class Test_Runner extends Base_Class {
	public static WebDriver driver=getBrowser("chrome");
	public static Page_Object_Manager pom=new Page_Object_Manager(driver);
    public static Logger log=Logger.getLogger(Test_Runner.class);
	public static void main(String[] args) throws Throwable {
    	PropertyConfigurator.configure("log4j.properties");
    	log.info("Browser Launched");
		url("http://automationpractice.com/index.php");
		log.info("Url launched");
		click(pom.getInstanceHp().getDresses());
        implicitWait(30, TimeUnit.SECONDS);
        log.info("Dresses clicked");
        click(pom.getInstanceHp().getCasual_Dresses());
		implicitWait(30, TimeUnit.SECONDS);
		 log.info("Cassual_Dresses clicked");
		// move the mouse to instock
		moveToElement(driver, pom.getInstanceCp().getInstock());
		click(pom.getInstanceCp().getAddcart());
		implicitWait(30, TimeUnit.SECONDS);
		click(pom.getInstanceCp().getCheckout1());
		 log.info("Add to cart Checkout");
		// 1.summary
		javaScriptExecutor();
		implicitWait(30, TimeUnit.SECONDS);
		// click the + button for 6 times
        click(pom.getInstanceSum().getPlusclick1());
        click(pom.getInstanceSum().getPlusclick2());
        click(pom.getInstanceSum().getPlusclick3());
        click(pom.getInstanceSum().getPlusclick4());
        click(pom.getInstanceSum().getPlusclick5());
        click(pom.getInstanceSum().getPlusclick6());
        implicitWait(30, TimeUnit.SECONDS);
		click(pom.getInstanceSum().getCheckout2());
		 log.info("Product purchased");
		// 2.Signin
        implicitWait(30, TimeUnit.SECONDS);
        String email = ParticularData("C:\\Users\\my pc\\Documents\\TestCase_For_project1.xlsx", 2, 5);
		sendkeys(pom.getInstanceSingin().getEmail(), email);
		click(pom.getInstanceSingin().getCreate_Acc());
		implicitWait(30, TimeUnit.SECONDS);
		 log.info("Create account view successfully");
		//create an account page
		click(pom.getInstanceNp().getMr());
		String fname = ParticularData("C:\\Users\\my pc\\Documents\\TestCase_For_project1.xlsx",5,5);
		sendkeys(pom.getInstanceNp().getFirstname(), fname);
		
		String lname = ParticularData("C:\\Users\\my pc\\Documents\\TestCase_For_project1.xlsx",6,5);
		sendkeys(pom.getInstanceNp().getLastname(),lname);
		
		String password = ParticularData("C:\\Users\\my pc\\Documents\\TestCase_For_project1.xlsx",8,5);
		sendkeys(pom.getInstanceNp().getPassword(),password);
		
		String afn = ParticularData("C:\\Users\\my pc\\Documents\\TestCase_For_project1.xlsx",12,5);
		sendkeys(pom.getInstanceNp().getAdress_Fn(),afn);
		
		String aln = ParticularData("C:\\Users\\my pc\\Documents\\TestCase_For_project1.xlsx",13,5);
		sendkeys(pom.getInstanceNp().getAdress_Ln(),aln);
		
		String company = ParticularData("C:\\Users\\my pc\\Documents\\TestCase_For_project1.xlsx",14,5);
		sendkeys(pom.getInstanceNp().getAdress_Company(),company);
		
		String cAddress = ParticularData("C:\\Users\\my pc\\Documents\\TestCase_For_project1.xlsx",15,5);
		sendkeys(pom.getInstanceNp().getAddress(),cAddress);
		
		String city = ParticularData("C:\\Users\\my pc\\Documents\\TestCase_For_project1.xlsx",16,5);
		sendkeys(pom.getInstanceNp().getCity(),city);
		
		String state = ParticularData("C:\\Users\\my pc\\Documents\\TestCase_For_project1.xlsx",17,5);
		dropdownSelectByValue(pom.getInstanceNp().getState(),state);
		
		String zip = ParticularData("C:\\Users\\my pc\\Documents\\TestCase_For_project1.xlsx",18,5);
		sendkeys(pom.getInstanceNp().getPost(),zip);
		
		String phn = ParticularData("C:\\Users\\my pc\\Documents\\TestCase_For_project1.xlsx",19,5);
		sendkeys(pom.getInstanceNp().getPhoneno(),phn);
		click(pom.getInstanceNp().getRegister());
		implicitWait(30, TimeUnit.SECONDS);
		 log.info("new account create successfully");
		//3.address
		implicitWait(30, TimeUnit.SECONDS);
        click(pom.getInstanceAp().getCheckout3());
        log.info("Address checked");
		// 4.Shipping
        implicitWait(30, TimeUnit.SECONDS);
		click(pom.getInstanceSp().getAgree());
		click(pom.getInstanceSp().getCheckout4());
		 log.info("Shipping Checkout");
		// 5.Payment
		implicitWait(30, TimeUnit.SECONDS);
		click(pom.getInstancePp().getBank());
		click(pom.getInstancePp().getConfirm());
		javaScriptExecutor();
		 log.info("Payment pay Successfully");
		driver.close();
		log.info("Browser close successfully");

	}
}



