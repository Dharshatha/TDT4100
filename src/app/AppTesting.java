package app;

import org.junit.Before;
import org.junit.Assert;
import org.junit.Test;

public class AppTesting{
	private BMIUtregning bmi;
	private Person p;
	private IbsToKg ibstokg;
	
	@Before
	public void setUp() throws Exception{
		System.out.println("System is setting up.");
		this.bmi = new BMIUtregning();
		this.p = new Person();
		this.ibstokg = new IbsToKg();
	}
	
	
	
	@SuppressWarnings("deprecation")
	@Test
	public void TestClass() {
		BMIUtregning hei = new BMIUtregning();
		hei.utregning(124, 65);
		Assert.assertEquals(13, hei.getBmi());
	}
	

}
