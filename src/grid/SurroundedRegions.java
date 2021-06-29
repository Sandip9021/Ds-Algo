class SurroundedRegions {
    int m;
    int n;
    char[][] grid;
    
    public void solve(char[][] board) {
        this.m=board.length;
        this.n=board[0].length;
        this.grid=board;
        
       
         for(int i=0;i<board.length;i++){
             for(int j=0;j<board[0].length;j++){
                 if(i==0 || i==m-1 || j==0 || j==n-1){
                      if(board[i][j]=='O'){
                           dfs(i,j);
                      }
                 }           
             } 
        }
        
        for(int i=0;i<board.length;i++){
             for(int j=0;j<board[0].length;j++){
                   if (board[i][j] == 'P')
                       board[i][j] = 'O';
                   else if (board[i][j] == 'O')
                       board[i][j] = 'X';
             } 
        }
        
    }
    
     public void dfs(int i,int j){
	        if(i<0 || i>=m || j<0 || j>=n ){
	            return ;
	        }
	        char c=grid[i][j];
	        if(c=='X' || c=='P'){
	            return ;
	        }

	        grid[i][j]='P';
	         dfs(i-1,j) ;
	         dfs(i+1,j) ;
	         dfs(i,j-1) ;
	         dfs(i,j+1) ;

	    }
}
