package grid;

public class FloodFill {
	
	 int row=0;
	    int col=0;
	    int newC=0;
	    int startingPix=0;
	    
	    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
	           this.row=image.length;
	           this.col=image[0].length;
	           this.newC=newColor;
	           this.startingPix=image[sr][sc];
	        if(this.startingPix==newColor){
	             return image;
	        }
	           
	           return dfs(sr,sc,image);
	        
	    }
	
	
	 public int[][] dfs(int i,int j,int[][] image){
	        
	        if(i<0|| i>=row || j<0 || j>=col || image[i][j]!=this.startingPix){
	              return image;
	        }
	        
	        image[i][j]=this.newC;
	        
	        dfs(i,j-1,image);
	        dfs(i,j+1,image);
	        dfs(i+1,j,image);
	        dfs(i-1,j,image);
	        
	        return image;
	    }

}
