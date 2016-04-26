package com.Pe.Service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.Pe.Dao.testDao;
import com.Pe.selenium.ExecutionEngine;

import Utilities.POI;



@Service
public class testService {

	public testService(){
		super();
	}

	public static String[][] getTestCases(String temp) throws Exception{

		String [][]e = testDao.getTestCasesDao(temp);


		return e;

	}

	public static boolean teststatus(List<String> status) throws Exception{

		boolean aknole=testDao.teststatus(status);
		return aknole;



	
	}
	
	public static List<String> testresults(String browser) throws Exception{
		
	return ExecutionEngine.results(browser);
		
}}


