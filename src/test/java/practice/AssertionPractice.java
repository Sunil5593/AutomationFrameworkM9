package practice;

import org.testng.Assert;
import org.testng.annotations.Test;

public class AssertionPractice 
{

@Test
public void Sample()
{
String s = "sample";
System.out.println("Step1");
System.out.println("Step2");

Assert.assertEquals(1, 1);

//Assert.assertTrue(s.contains("S"));
//Assert.assertNotEquals(1, 1);

System.out.println("Step3");
System.out.println("Step4");
}
}

