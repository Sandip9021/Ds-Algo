package Array;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class FirstRepeatingNumber {
	
	public static void main(String[] args) {	
		int[] arr = {1,3,2,6,2,8,8,2,11,3,6,22};
		//int[] arr = {1,2,3,4};
		FirstRepeatingNumber frn=new FirstRepeatingNumber();
		System.out.println("First repeating num Sol 1 :"+frn.findFirstRepeatingNumSol1(arr));
		System.out.println("First repeating num Sol 2:"+frn.findFirstRepeatingNumSol2(arr));
	}
	
	public int findFirstRepeatingNumSol1(int[] arr){
		Map<Integer,Integer> map=new HashMap<>();
		for(int i=0;i<arr.length;i++) {
			  if(map.containsKey(arr[i])) {
				  if(map.get(arr[i])==0) {
					  return arr[0];
				  }
				  if(map.get(arr[i])>=0) {
					  map.put(arr[i],-map.get(arr[i]));
				  }
			  }else {
				  map.put(arr[i], i);
			  }
		}
		if(arr.length==map.size()) {
			return -1;
		}
		int max=Integer.MIN_VALUE;
		for(Map.Entry<Integer, Integer> entry : map.entrySet()) {
			  if(entry.getValue() <0 && entry.getValue() > max) {
				   max=entry.getValue();
			  }
		}
		return arr[-max];
	}
	
	
    public int findFirstRepeatingNumSol2(int[] arr){
    	Set<Integer> set= new HashSet<>();
    	int rptNum=-1;
    	for(int i=arr.length-1;i>=0;i--) {
    		 if(set.contains(arr[i])) {
    			  rptNum=arr[i];
    		 }else {
    			 set.add(arr[i]);
    		 }
    	}
    	
    	return rptNum;
	}

}
