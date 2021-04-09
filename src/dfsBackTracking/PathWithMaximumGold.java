package dfsBackTracking;

public class PathWithMaximumGold {
	 int row;
     int col;
    
      public int getMaximumGold(int[][] grid) {
        int maxSum=0;
        this.row=grid.length;
        this.col= grid[0].length;
         for(int i=0;i<grid.length;i++){
             for(int j=0;j<grid[0].length;j++){
                    if(grid[i][j]>0){
                         int sum=dfs(grid,i,j);
                         maxSum=Math.max(sum,maxSum);
                    }
             }
         }
          return maxSum;
    }

    public int dfs (int[][] grid,int i,int j){
        if(i<0 || i>=row || j<0 || j>=col || grid[i][j]==0) {
            return 0;
        }

        int temp=grid[i][j];
        grid[i][j]=0;

        int upSum=dfs(grid,i-1,j);
        int downSum=dfs(grid,i+1,j);
        int leftSum=dfs(grid,i,j-1);
        int rightSum=dfs(grid,i,j+1);

        grid[i][j]=temp;
        return temp+Math.max(Math.max(Math.max(upSum,downSum),leftSum),rightSum);
    }
}
