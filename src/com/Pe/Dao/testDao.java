package com.Pe.Dao;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.Pe.selenium.reflector;

import Utilities.Constant;
import Utilities.POI;



public class testDao {
	
	static String File_TestData=null;
	static String ElementPath = null;
	
	static String ElementType;
	
	public static String ElementType(String Element) throws Exception{
		int i=0;
		POI.setExcelFile(Constant.Path_TestElements,Constant.File_TestElements );

		
		for(i=0;!POI.getCellData(i, 0).isEmpty();){

			System.out.println("value is "+POI.getCellData(i, 0)+"\n");
			i++;
		}

		
		for(int RowNum=0;RowNum<i;RowNum++)
		{
			String ExcelElement=POI.getCellData(RowNum, 0);
			
		if(Element.equals(ExcelElement)){
			ElementType=POI.getCellData(RowNum, 1);
		}

			}
		return ElementType;
	}
	public static String ElementPath(String Element) throws Exception{
		int i=0;
		POI.setExcelFile(Constant.Path_TestElements,Constant.File_TestElements );

		List<String> testresultsview,results = new ArrayList();
		for(i=0;!POI.getCellData(i, 0).isEmpty();){

			System.out.println("value is "+POI.getCellData(i, 0)+"\n");
			i++;
		}

		
		
		for(int RowNum=0;RowNum<i;RowNum++)
		{
			String ExcelElement=POI.getCellData(RowNum, 0);
			
		if(Element.equals(ExcelElement)){
			ElementPath=POI.getCellData(RowNum, 2);
		}

			}
		return ElementPath;
	}
	public static  String[][] getTestCasesDao(String a) throws Exception{

		//testDao t = new testDao();
		File_TestData=a;
		String d[] = new String[0];
		d=cellcount(Constant.Path_TestData,File_TestData);

		POI.setExcelFile(Constant.Path_TestData,File_TestData );
		int row=Integer.parseInt(d[1]);
		int coloumn=Integer.parseInt(d[0]);
		String [][]a1 = new String[row+1][coloumn+1];
		for (int i = 1; i <= row; i++) {
			for (int j = 0; j <= coloumn; j++) {
				System.out.println("this"+POI.getCellData(i, j)+"value");
				a1[i][j] = POI.getCellData(i, j);
			}
		}
		return a1;




	}
	public static String[] cellcount(String a,String b) throws Exception{
		POI.setExcelFile(a,b);
		String c[] = new String[2];

		int i=0,j=0;


		for(i=0;!POI.getCellData(1, i).isEmpty();){
			System.out.println("value is "+POI.getCellData(0, i)+"\n");
			i++;
		}
		for(j=0;!POI.getCellData(j, 0).isEmpty();){
			System.out.println("value is "+POI.getCellData(j, 0)+"\n");
			j++;
		}
		i--;
		j--;
		c[0]=""+i;
		c[1]=""+j;



		return c;

	}
	public static boolean teststatus(List<String> status) throws Exception{

		Iterator itr = status.iterator();
		int row=1;
		while(itr.hasNext()) {
			String element = (String) itr.next();


			POI.setExcelFile(Constant.Path_TestData,File_TestData );
			POI.setCellData(element, row, 4);
			row++;

		}
		return true;


	}

	public static List<String> insertTestResults(List<String> testresults) throws Exception{
		int i=0;
		POI.setExcelFile(Constant.Path_TestData,File_TestData );

		List<String> testresultsview,results = new ArrayList();
		for(i=0;!POI.getCellData(i, 0).isEmpty();){

			System.out.println("value is "+POI.getCellData(i, 0)+"\n");
			i++;
		}

		Iterator<String> Iterator = testresults.iterator();
		for(int RowNum=1;RowNum<i&&Iterator.hasNext();RowNum++)
		{
			String teststatus=POI.getCellData(RowNum, 4);
		

				String a=Iterator.next();
				System.out.println(a);
				POI.setExcelFile(Constant.Path_TestData,File_TestData );
				POI.setCellData(a, RowNum, 5);
				String poi=testpoi();
				System.out.println(poi);
			results.add(POI.getCellData(RowNum, 0)+"            "+POI.getCellData(RowNum, 5));
			
		}
		return results;	
	}
	public static List<String> getResults() throws Exception{
		List<String> results = new ArrayList();
		for(int l=1;l<getColumlegnth();l++){

			results.add(POI.getCellData(l, 5));
		}
		return results;

	}
	public static int getColumlegnth() throws Exception{
		int i=0;
		POI.setExcelFile(Constant.Path_TestData,File_TestData );


		for(i=0;!POI.getCellData(i, 0).isEmpty();){

			System.out.println("value is "+POI.getCellData(i, 0)+"\n");
			i++;
		}
		return i ;	
	}
	public static List<String> checkTestSTatus() throws Exception{
		int i=0;
		POI.setExcelFile(Constant.Path_TestData,File_TestData );

		List<String> testresults = new ArrayList();
		for(i=0;!POI.getCellData(i, 0).isEmpty();){

			System.out.println("value is "+POI.getCellData(i, 0)+"\n");
			i++;
		}
		for(int RowNum=1;RowNum<=i;RowNum++){
			String teststatus=POI.getCellData(RowNum, 4);
			System.out.println(teststatus);
			if(teststatus.equals("Y")){
				String a=POI.getCellData(RowNum, 2);
				System.out.println(a);


				testresults.add(a);

			}
			if(teststatus.equals("N"))
			{
				testresults.add("test case not run");
			}

		}


		return testresults;	
	}
public static String testpoi() throws Exception{
	for(int i=1;i<10;i++)
	{
		POI.setCellData("test", i, 6);
		
	}
	return "POI working";
}	
}

