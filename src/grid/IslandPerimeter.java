package grid;

public class IslandPerimeter {
	  int count=0;
	    int row=0;
	    int col=0;
	    
	    public int islandPerimeter(int[][] grid) {
	        this.row=grid.length;
	        this.col=grid[0].length;

	        for(int i=0;i<row;i++){
	            for(int j=0;j<col;j++){
	                   if(grid[i][j]==1){
	                       dfs(i,j,grid);
	                       break;
	                   }
	            }
	        }

	        return this.count;
	    }

	    public void dfs(int i,int j,int[][] grid){
	        if(i<0 || i>=row || j<0 || j>=col || grid[i][j]==0){
	             count++;
	             return;
	        }
	        if(grid[i][j]==3){
	            return;
	        }
	        grid[i][j]=3;
	        dfs(i,j-1,grid);
	        dfs(i,j+1,grid);
	        dfs(i-1,j,grid);
	        dfs(i+1,j,grid);
	    }
	

}
