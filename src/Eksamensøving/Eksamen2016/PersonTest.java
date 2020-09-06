package Eksamen2016;

import org.junit.Test;
import org.junit.Assert;


public class PersonTest {
	@Test
	   public void testAddChild() {
		      Gender female = Gender.valueOf("female"), male = Gender.valueOf("male");
		      Person mother = new Person("Chris"); mother.setGender(female);
		      Person father1 = new Person("Pat");  father1.setGender(male);
		      Person father2 = new Person("Alex"); father2.setGender(male);
		      Person child = new Person("Jean");
		      mother.addChild(child);
		      Assert.assertEquals(1, mother.getChildCount());
		      Assert.assertTrue(mother.hasChild(child));
		      Assert.assertEquals(mother, child.getMother());
		      mother.addChild(child);
		      Assert.assertEquals(1, mother.getChildCount());
		 
		      father1.addChild(child);
		      Assert.assertTrue(father1.hasChild(child));
		      Assert.assertEquals(father1, child.getFather());
		 
		      father2.addChild(child);
		      Assert.assertFalse(father1.hasChild(child));
		      Assert.assertTrue(father2.hasChild(child));
		      Assert.assertEquals(father2, child.getFather());
		 
		      father2.setGender(female);
		      father2.addChild(child);
		      // ???
		      child.addChild(father2);
		      // ???
		   }
		}

