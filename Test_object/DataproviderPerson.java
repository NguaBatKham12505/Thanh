package Test_object;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;

public class DataproviderPerson {
	// Datatest khac class test
  @Test(dataProvider = "dp",dataProviderClass = DataProviderclass.class)
  public void f() {
  }
  @BeforeTest
  public void beforeTest() {
  }

  @AfterTest
  public void afterTest() {
  }

}
