package LeetCodeProblems;

public class MaximumSubArrSumWithOneDeletion {
	
	public static void main(String[] args) {
		int arr[]= {1,-3,2,4,5,-2};
		int result=maximumSum(arr);
		System.out.println("Result : "+result);
	}
	
	 public static int maximumSum(int[] arr) {
		 int len = arr.length;
	        int preNotDeleted = arr[0];
	        int preWithDeleted = 0;
	        int max = arr[0];
	        
	        for(int i=1; i<len; i++){
	        	preWithDeleted = Math.max(preNotDeleted, preWithDeleted+arr[i]);
	        	preNotDeleted = Math.max(preNotDeleted+arr[i], arr[i]);
	            int current = Math.max(preWithDeleted, preNotDeleted);
	            max = Math.max(max, current);
	        }
	        return max;
   }

}
