package com.Pe.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.Pe.Dao.testDao;
import com.Pe.Service.testService;
import com.Pe.selenium.ExecutionEngine;

import Utilities.Browser;

@Controller
public class BaseController {
	private static String browser="Mozilla";
	private static int counter = 0;
	private static final String VIEW_INDEX = "index";
	private final static org.slf4j.Logger logger = LoggerFactory.getLogger(BaseController.class);
	boolean aknol;
	@Autowired
	testService testservice;

	public testService getTestservice() {
		return testservice;
	}

	public void setTestservice(testService testservice) {
		this.testservice = testservice;
	}
	int k;
	@RequestMapping(value = "/testmodule", method = RequestMethod.POST)
	public ModelAndView Testinput(ServletRequest request, ServletResponse response) throws Exception { 
		ModelAndView modelAndView = new ModelAndView();
		String temp=request.getParameter("module");
		System.out.println("\nfile is \n"+temp);
		String [][]p=testService.getTestCases(temp);
		List<String> test1 = new ArrayList<>();
		k=p.length;
		int l=p[0].length;
		modelAndView.addObject("testcases", p);
		
//		for (int i = 1; i <k ; i++) {
//			for (int j = 0; j <l ; j++) {
//				test1.add(p[i][j]);}
//			test1.add("<br>");
		
//			test1.add(" ");
//		}
//
//		modelAndView.addObject("testcases",test1);
		modelAndView.setViewName("index");

		return modelAndView;


	}
	@RequestMapping(value = "/testdata", method = RequestMethod.GET)
	public ModelAndView Testresult(ServletRequest request, ServletResponse response) throws Exception { 
		ModelAndView modelAndView = new ModelAndView();
		List<String> test2 = new ArrayList<>();
		int o=1;
		for(int l=0;l<k-1;l++){

			
			System.out.println(o);
			String check=request.getParameter(""+o);

			System.out.println(check);
			test2.add(request.getParameter(""+o));
			
			o++;
		}
		aknol=testService.teststatus(test2);
		if(aknol==true)
		{
			modelAndView.addObject("message", "Test cases submitted please wait for result");
			
			HttpServletRequest servlReq = (HttpServletRequest) request;
			

			String burl = servlReq.getRequestURL().toString();
			burl = burl.replaceAll("testdata", "testrun");
			System.out.println(burl);
			String bb = "redirect:/testrun";
			browser=request.getParameter("browser");
			modelAndView.addObject("redirectURL", burl);

		}
		modelAndView.setViewName("Testresults");
		return modelAndView;

	}
	@RequestMapping(value = "/testrun", method = RequestMethod.GET)
	public ModelAndView Testrun(ServletRequest request, ServletResponse response) throws Exception { 
		ModelAndView modelAndView = new ModelAndView();

			
		long teststarttime=System.currentTimeMillis();
		
		List testresults= new ArrayList();
		testresults=testService.testresults(browser);
		long endtime=System.currentTimeMillis();
		long testtime=endtime-teststarttime;
		int p = 0,q=0,r=0;
		modelAndView.addObject("testresults",testresults);
		Iterator<String> Iterator = testresults.iterator();
		if(Iterator.hasNext()){
			String a =Iterator.next();
			
			if(a.equals("pass")){
				p++;
			}
			if(a.equals("fail")){
				q++;
			}
			if(a.contains("test")){
				r++;
			}
		}
		
		
		modelAndView.addObject("nooftests", testresults.size());
		modelAndView.addObject("testspasses", p);
		modelAndView.addObject("testsfailed", q);
		modelAndView.addObject("testsnotrun", r);
		try{Browser.quit();
		modelAndView.addObject("test", "Time taken for test is "+testtime/1000+"  seconds");}
		catch(Exception e){
			modelAndView.addObject("test", "Selected browser not installed");
		}
		modelAndView.setViewName("Testresults");
		
		return modelAndView;

	}


}