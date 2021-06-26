package grid;

public class MaxAreaIsland {
	
	    int row=0;
	    int col=0;
	   
	    
	    public int maxAreaOfIsland(int[][] grid) {
	        this.row=grid.length;
	        this.col=grid[0].length;
	        int max=0;
	        
	        for(int i=0;i< row;i++){
	             for(int j=0;j< col;j++){
	                    if(grid[i][j]==1){
	                        max=Math.max(max,dfs(grid,i,j));
	                    }
	              }
	        }
	        return max;
	        
	    }
	    
	    public int dfs(int[][] grid,int i,int j){
	    	
	        if(i<0 || i>=this.row || j<0 || j>=this.col || grid[i][j]==0){
	            return 0;
	        }
	        
	        if(grid[i][j]==2){
	             return 0;
	        }
	        
	        grid[i][j]=2;
	        
	        return 1 + dfs(grid,i+1,j) + dfs(grid,i-1,j) +  dfs(grid,i,j+1) +  dfs(grid,i,j-1);
	                
	    }
	
}
