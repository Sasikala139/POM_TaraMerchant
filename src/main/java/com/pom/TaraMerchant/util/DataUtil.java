package com.pom.TaraMerchant.util;

import java.util.Hashtable;

import org.testng.SkipException;

public class DataUtil {

	//true-Y
	//false -N
	public static boolean isExecutable(Xls_Reader xls, String testName){
		int rows = xls.getRowCount("TestCases");
		for(int rNum=2;rNum<=rows;rNum++){
			String tcid = xls.getCellData("TestCases", "TCID", rNum);
			if(tcid.equals(testName)){
				String runMode=xls.getCellData("TestCases", "Runmode", rNum);
				if(runMode.equals("N"))
					return false;
				else
					return true;
			}
		}
		return false;//default
	}
	
	public static Object[][] getData(String testCaseName, Xls_Reader xls){
		String sheetName="Data";
		int testStartRowNum=1;
		while(!xls.getCellData(sheetName, 0, testStartRowNum).equals(testCaseName)){
			testStartRowNum++;
		}
		int colStartRowNum=testStartRowNum+1;
		int dataStartRowNum=testStartRowNum+2;
		
		// calculate rows of data
		int rows=0;
		while(!xls.getCellData(sheetName, 0, dataStartRowNum+rows).equals("")){
			rows++;
		}
		
		//calculate total cols
		int cols=0;
		while(!xls.getCellData(sheetName, cols, colStartRowNum).equals("")){
			cols++;
		}
		Object[][] data = new Object[rows][1];
		//read the data
		int dataRow=0;
		Hashtable<String,String> table=null;
		for(int rNum=dataStartRowNum;rNum<dataStartRowNum+rows;rNum++){
			table = new Hashtable<String,String>();
			for(int cNum=0;cNum<cols;cNum++){
				String key=xls.getCellData(sheetName,cNum,colStartRowNum);
				String value= xls.getCellData(sheetName, cNum, rNum);
				table.put(key, value);
				// 0,0 0,1 0,2
				//1,0 1,1
			}
			data[dataRow][0] =table;
			dataRow++;
		}
		return data;
		
	}
}
