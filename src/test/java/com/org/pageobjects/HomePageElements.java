package com.org.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static com.org.base.TestBase.driver;

public class HomePageElements {

	private WebElement searchBox;
	private WebElement searchButton;
	private WebElement openMenuButton;
	private WebElement closeMenuButton;
	
	
	public WebElement getCloseMenuButton() {
		closeMenuButton=driver.findElement(By.xpath("//*[@id=\"hmenu-canvas-background\"]/div"));
		return closeMenuButton;
	}
	public WebElement getopenMenuButton() {
		
		openMenuButton = driver.findElement(By.xpath("//a[@id='nav-hamburger-menu']"));	
		return openMenuButton;
	}
	public WebElement getSearchBox() {
	
		searchBox = driver.findElement(By.xpath("/html/body/div[1]/header/div/div[1]/div[3]/div/form/div[3]/div[1]/input"));
		return searchBox;
	}
	public WebElement getSearchButton() {
	
		searchButton=driver.findElement(By.xpath("//*[@id=\"nav-search\"]/form/div[2]/div/input"));
		return searchButton;
	}
}
