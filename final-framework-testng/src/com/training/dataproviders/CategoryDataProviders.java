
package com.training.dataproviders;

import java.util.List;

import org.testng.annotations.DataProvider;

import com.training.bean.CategoryBean;
import com.training.bean.LoginBean;
import com.training.dao.ELearningDAO;
import com.training.dao.retailCategoryDAO;
import com.training.readexcel.ApachePOIExcelRead;
import com.training.readexcel.ReadExcel;

public class CategoryDataProviders {

	@DataProvider(name = "db-inputs")
	public Object[][] getDBData() {

		List<LoginBean> list = new ELearningDAO().getLogins();

		Object[][] result = new Object[list.size()][];
		int count = 0;
		for (LoginBean temp : list) {
			Object[]  obj = new Object[12]; 
			obj[0] = temp.getFIRSTNAME();
			obj[1] = temp.getLASTNAME();
			obj[2] = temp.getEMAIL();
			obj[3] = temp.getTELEPHONE();
			obj[4] = temp.getADDRESS1();
			obj[5] = temp.getADDRESS2();
			obj[6] = temp.getCITY();
			obj[7] = temp.getPOSTCODE();
			obj[8] = temp.getCOUNTRY();
			obj[9] = temp.getSTATE();
			obj[10] = temp.getPASSWORD();
			obj[11] = temp.getCONFIRMPASSWORD();
			
			result[count ++] = obj; 
		}

		return result;
		
	}
		@DataProvider(name = "db-inputs1")
		public Object[][] getDBData1() {

			List<CategoryBean> list = new retailCategoryDAO().getLogins();

			Object[][] result = new Object[list.size()][];
			int count = 0;
			for (CategoryBean temp : list) {
				Object[]  obj = new Object[4]; 
				obj[0] = temp.getCATEGORYNAME();
				obj[1] = temp.getCATEGORYDESC();
				obj[2] = temp.getMETATAGTITLE();
				obj[3] = temp.getMETATAGDESC();
				
				result[count ++] = obj; 
			}

			return result;
	}
	/*
	 * @DataProvider(name = "excel-inputs") public Object[][] getExcelData(){ String
	 * fileName ="C:\\Users\\SUSMITAMONDAL\\Desktop\\TestDataComplex.xlsx"; return
	 * new ApachePOIExcelRead().getExcelContent(fileName); }
	 */

	@DataProvider(name = "excel-inputs")
	public Object[][] getExcelData() {
		String fileName = "C:\\Users\\SUSMITAMONDAL\\Desktop\\TestDataComplex.xlsx";
		String sheetName = "Sheet1";
		return new ApachePOIExcelRead().getExcelContent(fileName, sheetName);
	}

	@DataProvider(name = "excel-inputs1")
	public Object[][] getExcelData1() {
		String fileName = "C:\\Users\\SUSMITAMONDAL\\Desktop\\TestDataComplex.xlsx";
		String sheetName = "Sheet2";
		return new ApachePOIExcelRead().getExcelContent(fileName, sheetName);
	}

	@DataProvider(name = "xls-inputs")
	public Object[][] getXLSData() {
		// ensure you will have the title as first line in the file
		return new ReadExcel().getExcelData("C:/Users/Naveen/Desktop/Testing.xls", "Sheet1");
	}
}
