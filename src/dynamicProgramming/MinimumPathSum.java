package dynamicProgramming;

public class MinimumPathSum {
	
	 public static void main(String[] args) {
		 MinimumPathSum mps = new MinimumPathSum();
		 int[][] grid = {{1,3,2,4},
				         {2,1,3,2},
				         {5,4,2,3},
				         {4,1,1,2}};
		 int result=mps.minPathSum(grid);
		 System.out.println("Min Path Sum : "+result);
	}
	
	 public int minPathSum(int[][] grid) {
         int m=grid.length;
         int n=grid[0].length;
        int[][] dp=new int[m][n];
       
        int sum=0;
       for(int i=0;i<m;i++){
             sum=sum+grid[i][0];
             dp[i][0]=sum;
       }
       sum=0;
       for(int i=0;i<n;i++){
             sum=sum+grid[0][i];
             dp[0][i]=sum;
       }
        if(n>0 && m==1){
             return dp[0][n-1];
        }
        if(m>0 && n==1){
             return dp[m-1][0];
        }
        
        for(int i=1;i<m;i++){
             for(int j=1;j<n;j++){
                  dp[i][j]=Math.min(dp[i-1][j],dp[i][j-1]) + grid[i][j];
             }
        }
        
        return dp[m-1][n-1];
    }
   
}
