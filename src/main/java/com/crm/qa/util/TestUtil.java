package com.crm.qa.util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import org.apache.poi.ss.usermodel.WorkbookFactory;

import com.crm.qa.base.TestBase;

public class TestUtil extends TestBase{

	public void switchToFrame() {
		driver.switchTo().frame("mainpanel");
	}
	
	
	}

