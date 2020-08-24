package Test_object;


import java.lang.reflect.Method;

import org.testng.annotations.DataProvider;

public class DataProviderclass {
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
}
