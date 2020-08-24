package Test_object;

import org.testng.annotations.Test;
import org.testng.annotations.DataProvider;
import org.testng.annotations.BeforeTest;

import java.lang.reflect.Method;

import org.testng.annotations.AfterTest;

public class DataProvideMethod {
	// dataprovider co name thi truyen name, khong co name truyen dung method
	
	@Test(dataProvider = "dp")
	public void Method1(Integer n, String s) {
		System.out.print("Method1"+s);
	}

	@Test(dataProvider = "dp")
	public void Method2(Integer n, String s) {
		System.out.print("Method2"+s);
	}

	@Test(dataProvider = "dp")
	public void Method3(Integer n, String s) {
		System.out.print("Method3"+s);
	}

	@DataProvider
	public Object[][] dp(Method method) {
		Object[][] data = null;
		if (method.getName().equals("Method1")) {
			data = new Object[][] { 
				new Object[] { 1, "a" }, 
				new Object[] { 1, "a" } 
				};
		}else if(method.getName().equals("Method2")){
			data = new Object[][] { 
				new Object[] { 1, "b" }, 
				new Object[] { 1, "b" } 
				};
		}else if(method.getName().equals("Method3")){
			data = new Object[][] { 
				new Object[] { 1, "c" }, 
				new Object[] { 1, "c" } 
				};
		}
		return data;
	}

	@BeforeTest
	public void beforeTest() {
	}

	@AfterTest
	public void afterTest() {
	}

}
