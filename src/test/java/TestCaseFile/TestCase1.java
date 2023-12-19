package TestCaseFile;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import PageObjectfile.LogOutClass;
import PageObjectfile.LoginWebElement;
import UtilitiesFile.DataDrivenTesting;

public class TestCase1 extends BaseClass {
	
	@Test(dataProvider = "DataPro")
	public void loginPage(String user, String pass) {
		driver.get(url);
		Log1.info("url open");
		LoginWebElement l1=new LoginWebElement(driver);
		l1.user_name("student");
		Log1.info("Enter the username");
		l1.user_pass("Password123");
		Log1.info("Enter the password");
		l1.user_sub();
		Log1.info("click the submit button");	
	}
@DataProvider(name="DataPro")
	public String[][] searchData() throws Exception{
	
		String filename = "C:\\Users\\tanma\\Desktop\\ReportSheet.xlsx";
	    int r= DataDrivenTesting.getRowCount(filename, "Sheet1");
	    int c = DataDrivenTesting.getCellCount(filename,"Sheet1");
	    String s1[][] = new String[r-1][c]; // 2,2
	    for(int i=1;i<r;i++) {
	    	for(int j = 0;j<c;j++) {
	    		s1[i-1][j]=DataDrivenTesting.getCellValue(filename, "Sheet1",i,j);
	    	}
	    }
	    
	return s1;	
	}
@Test
void logOutpage() {
	LogOutClass lg = new LogOutClass(driver);
	lg.user_logout();
}
}
