package util;

import java.util.Hashtable;

import content1.pages.Constants;

public class DataUtil {
	
	public Object[][] getData(String testName, Xls_Reader xls){
		//String testName="LoginTest";
		String sheetName="TestCases";
		//Xls_Reader xls = new Xls_Reader(System.getProperty("user.dir")+"//Data.xlsx");
		int testStartRowNum=1;
		while(!xls.getCellData(sheetName, 0, testStartRowNum).equalsIgnoreCase(testName)) {
			
			testStartRowNum++;
		}
	//	System.out.println("Row num for test "+ testStartRowNum);
		int colRowNum = testStartRowNum+1;	
		
		// total cols , rows
		int totalCols=0;
	
		while(!xls.getCellData(sheetName, totalCols, colRowNum).equals("")) {
			totalCols++;
		}
	//	System.out.println("Total Cols "+ totalCols);
		
		int dataStartRowNum= colRowNum+1;
		int totalRows=0;
		while(!xls.getCellData(sheetName, 0, dataStartRowNum+totalRows).equals("")) {
			totalRows++;
		}
		//System.out.println("Total Rows "+ totalRows);
		Object testData[][] = new Object[totalRows][1];
		// extract data for the test
		Hashtable<String,String> table=null;
		int i=0;
		for(int rNum=dataStartRowNum;rNum<dataStartRowNum+totalRows;rNum++) {
			table = new Hashtable<String,String>();
			for(int cNum=0;cNum<totalCols;cNum++) {
				String data = xls.getCellData(sheetName, cNum, rNum);
				String key = xls.getCellData(sheetName, cNum, colRowNum);
				//System.out.print(key+"-"+data+" --- ");
				table.put(key, data);
			}
			// table will be ready
			testData[i][0]=table;
			i++;
			
		}
		
		return testData;
	}
	// true - Y
	// false - N
	public  boolean isRunnable(String testName, Xls_Reader xls) {
		//Xls_Reader xls = new Xls_Reader(System.getProperty("user.dir")+"//Data.xlsx");
		//String testName="LoginTest";
		String sheetName=Constants.TEST_STATUS_SHEET;
		int rows = xls.getRowCount(sheetName);
		for(int rNum=2;rNum<=rows;rNum++) {
			String testCaseName = xls.getCellData(sheetName, Constants.TCID, rNum);
			if(testName.equalsIgnoreCase(testCaseName)) {
				String runmode = xls.getCellData(sheetName, Constants.RUNMODE, rNum);
				if(runmode.equals("Y"))
					return true;
				else
					return false;
			}
		}
		return false;
		
	}

}
