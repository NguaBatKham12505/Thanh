package Test_object;

import org.testng.annotations.Test;

import org.testng.annotations.DataProvider;

public class Dataprovider {
  @Test(dataProvider = "dp",dataProviderClass = DataProvideMethod.class)
  public void f(Integer n, String s) {
	System.out.println("data la: ");
  }

  @DataProvider
  public Object[][] dp() {
    return new Object[][] {
      new Object[] { 1, "a" },
      new Object[] { 2, "b" },
    };
  }
}
