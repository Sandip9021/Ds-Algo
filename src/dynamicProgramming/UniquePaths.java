package dynamicProgramming;

public class UniquePaths {
	
	public static void main(String[] args) {
		 int noOfPaths=uniquePaths(3,4);
		 System.out.println("No of Paths : "+noOfPaths);
	}
	
	 public static int uniquePaths(int m, int n) {
	        int[] dp=new int[n];
	        
	        for(int i=0;i<m;i++){
	             for(int j=0;j<n;j++){
	                   if(i==0 || j==0){
	                         dp[j]=1;
	                   }else{
	                        dp[j]=dp[j-1]+dp[j];
	                   }
	             }
	        }

	        return dp[n-1];
	        
	    }

}
