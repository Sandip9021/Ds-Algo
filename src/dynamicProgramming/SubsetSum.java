package dynamicProgramming;

import java.util.Arrays;

public class SubsetSum {
	
	public static void main(String[] args) {
		SubsetSum ss=new SubsetSum();
		int arr[]= {3,4,2,5};
		boolean possible=ss.isSubsetWithSumPresent(arr,6);
		System.out.println(possible);
	}
	
	 public boolean isSubsetWithSumPresent(int[] arr, int sum){
	        Arrays.sort(arr);
	        int n=arr.length+1;
	        int m=sum+1;
	        boolean[][]  dp=new boolean[n][m];
	        dp[0][0] = true;
	        for(int j=1;j<m;j++){
	               dp[0][j] = false;
	        }

	        for(int i=0;i<n;i++){
	              dp[i][0]=true;
	        }

	        for(int i=1;i<n;i++){
	            for(int j=1;j<m;j++){
	                  if(arr[i-1]>j){
	                       dp[i][j]=dp[i-1][j];
	                  }else{
	                      int diff = j - arr[i-1];
	                      dp[i][j]=dp[i-1][j] || dp[i-1][diff];
	                  }
	            }
	               if(dp[i][m-1]){
	                  return true;
	               }
	        }
	        

	         return dp[n-1][m-1];
	    }

}
