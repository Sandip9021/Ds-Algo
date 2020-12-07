package Array;

public class KadanesAlgo {
	
	public static void main(String[] args) {
		 int arr[]= {-5,-3,-4,0,-21};
		 maximumSubArraySum(arr);	 
	}
	
	public static void maximumSubArraySum(int arr[]) {
		  int maxSumTillNow=arr[0];
		  int maxSumInCurrWindow = 0;
		  
		  int start =0;
		  int end = 0;
		  int shift =0;
		  
		  for(int i=0;i<arr.length;i++) {
			  maxSumInCurrWindow = maxSumInCurrWindow + arr[i];
			  
			  if(maxSumInCurrWindow > maxSumTillNow) {
				  maxSumTillNow = maxSumInCurrWindow;
				  start=shift;
				  end=i;
			  }
			  
			  if(maxSumInCurrWindow <0) {
				  maxSumInCurrWindow = 0;
				  shift = i+1;
			  }
		  }
		  
		  System.out.println("Max Sum : "+maxSumTillNow);
		  System.out.println("Start Index: "+start +" End Index: "+ end);
	}

}
