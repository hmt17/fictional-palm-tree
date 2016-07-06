package deliverable4;

//import static org.junit.Assert.*;

import org.junit.*;
import org.junit.Assert;
import java.util.*;


public class laboonifyTests {
	
	List<int[]> arrays;
	List<int[]> copy;
	
	@Before
	public void setUp() {
		arrays = laboonifyFunction.randomArrays();
		copy = laboonifyFunction.replicate(arrays);
		laboonifyFunction.laboonify(copy);
	}
	
	/*
	 * We must check that each of the arrays have 
	 * at most 100 indeces, of values between 1 and 100,
	 * and that they're are at least 100 arrays in the list
	 */
	@Test
	public void testSize()
	{
		
		for(int[] a: arrays)
		{
			for(int i = 0; i < a.length; i++)
			{
				if(a[i]<0 || a[i] > 100)
				{
					Assert.fail();
				}
				if(i > 100)
				{
					Assert.fail();
				}
			}
		}
		
		Assert.assertTrue(arrays.size() >= 100);

	}
	
	/*
	 * We must check that each of the indeces have the  
	 * are squared from the original value
	 */
	@Test
	public void testSquared()
	{
		for(int t = 0; t < copy.size(); t++){	
			
			int x[] = copy.get(t);
			int a[] = arrays.get(t);
		
			for(int i = 0; i < a.length; i++)
			{
				if(a[i]==0) { break;}

				double expected = (double)(a[i]*a[i]);
				double actual = (double) x[i];
				Assert.assertEquals(expected, actual, .1);
			}				
		}
	}
	
	/*
	 * We must check that each of the squared indeces 
	 * add up to the last index's value
	 */
	@Test
	public void testSum()
	{
		for(int t = 0; t < copy.size(); t++){	
			
			int x[] = copy.get(t);
			int total = 0;
			for(int i = 0; i < x.length-1; i++)
			{
				int temp = x[i];
				total += temp;
				double expected = (double) total;
				double actual = (double) x[x.length - 1];
				if(i == (x.length - 2)){
					Assert.assertEquals(expected, actual, .1);
				}
			}				
		}
		
	}

}
