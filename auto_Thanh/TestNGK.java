package auto_Thanh;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;

public class TestNGK {
  @Test
  public void f() {
	  System.out.println("test"+"\n");
  }
  @BeforeMethod
  public void beforeMethod() {
	  System.out.println("beforeMethod"+"\n");
  }

  @AfterMethod
  public void afterMethod() {
	  System.out.println("afterMethod"+"\n");
  }

  @BeforeClass
  public void beforeClass() {
	  System.out.println("beforeClass"+"\n");
  }

  @AfterClass
  public void afterClass() {
	  System.out.println("afterClass"+"\n");
  }

  @BeforeTest
  public void beforeTest() {
	  System.out.println("beforeTest"+"\n");
  }

  @AfterTest
  public void afterTest() {
	  System.out.println("afterTest"+"\n");
  }

}
