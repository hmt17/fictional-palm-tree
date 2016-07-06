package deliverable4;

import java.util.*;

public class laboonifyFunction {
	
	public static final int NUM_ARRAYS = 100;
	public static final int MAX_INDECES = 100;
	public static final int MAX_VALUES = 100;
	
	public static void main(String[] args)	{
		List<int[]> x = randomArrays();
		List<int[]> copies = replicate(x);
		laboonify(copies);
		//print(x, copies);
	}
	//create list of arrays 
	public static List<int[]> randomArrays()
	{
		Random r = new Random();
		int len = 0, val = 0, arrs = 0;
		int[] arr;
		List<int[]> arrOriginal = new ArrayList<>();
		arrs = r.nextInt(100)+100;
		System.out.print(arrs);
		for(int a = 0; a < NUM_ARRAYS; a++)
		{
			do{
				len = r.nextInt(MAX_INDECES + 1);
			}while(len < 1);
				arr = new int[len];
				
				for(int b = 0; b < arr.length; b++)
				{
					do{
						val = r.nextInt(MAX_VALUES+1);
					}while (val < 1);
					arr[b] = val;
				}
				arrOriginal.add(arr);
		}
		return arrOriginal;
	}
	//make a copy of set of arrays so that 
	//original can be compared to new
	public static List<int[]> replicate(List<int[]> arrOriginal)
	{
		List<int[]> c = new ArrayList<>();
		
		for(int[] arr: arrOriginal)
		{
			c.add(Arrays.copyOf(arr, arr.length + 1));
		}
		return c;
	}
	//reads in each array and squares value and adds sum to end of array
	public static void laboonify(List<int[]> x)	{
		
		for(int[] arr: x)
		{
			int temp = 0;
			int newtemp = 0;
			int totaltemp = 0;
			for(int a = 0; a < arr.length; a++)	{
				temp = arr[a];
				newtemp = temp * temp;
				arr[a] = newtemp;
				totaltemp += newtemp;
			}
			arr[arr.length - 1] = totaltemp;
		}	
	}
	//print to show before and after laboonify()
	public static void print(List<int[]> x, List<int[]> copies)
	{
		System.out.println("ORIGINALS");
		for (int[] a : x) {
			
			for (int i : a) {
				System.out.print(" " + i + " ");
			}
			System.out.println();
		}
		System.out.println("LABOONIFIED");
		for (int[] a : copies) {
			for (int i : a) {
				System.out.print(" " + i + " ");
			}
			System.out.println();
		}
	}
}
