package Array;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class SubArrayZeroSum {
	
	public static void main(String[] args) {
	    int arr[]={1,3,2,-1,5,4,-8,4,3,6};
	    subArraySumZeroWithIndex(arr);
	    if(subArraySumZero(arr)) {
	    	System.out.println("SubArray sum zero is PRESENT");
	    }else {
	    	System.out.println("SubArray sum zero is NOT PRESENT");
	    }
	}
	
	public static boolean subArraySumZero(int[] arr) {
		 int sum=0;
		 Set<Integer> hs = new HashSet<Integer>();
		 
		 for(int i=0;i<arr.length;i++) {
			  sum=sum+arr[i];
			  if(arr[i]==0 || sum==0 || hs.contains(sum)) {
				  return true;
			  }
			  hs.add(sum);
		 }
		 return false;
		 
	}
	
	public static void subArraySumZeroWithIndex(int[] arr) {
		 Map<Integer,Integer> map = new HashMap<Integer,Integer>();  
		 int sum=0;
		 boolean isSumZero=false;
		 
		 for(int i=0;i<arr.length;i++) {
			 sum=sum+arr[i];
			 if(arr[i]==0 || sum==0 || map.containsKey(sum)) {
				 System.out.println("Sub Array with Sum 0 is present");
				 System.out.println("Start : "+(map.get(sum)+1)+" End : "+i);
				 isSumZero=true;
				 break;
			 }
			 map.put(sum,i);
		 }
		 
		 if(!isSumZero) {
			 System.out.println("There is no sub array with sum 0");
		 }
	}
		
	public static boolean subArraySumZeroBrutForce(int[] arr) {
		int sum=0;
		 for(int i=0;i<arr.length;i++) {
			 for(int j=i;j<arr.length;j++) {
					sum=sum+arr[j];
					 if(arr[j]==0 || sum==0 ) {
						 System.out.println("Start Index="+i+"  End index="+j);
						 return true;
					 }
			 }
			 sum=0;
		 }
		 return false;
	}
	
}
