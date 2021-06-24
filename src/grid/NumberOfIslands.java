class NumberOfIslands {
    int n;
    int m;
    char[][] grid;

    public int numIslands(char[][] grid) {
        this.m=grid.length;
        this.n=grid[0].length;
        this.grid=grid;
        int count=0;

        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                char c=grid[i][j];
                if(c=='1'){
                    dfs(i,j);
                    count++;
                }
            }
        }
        return count;
    }

    public void dfs(int i,int j){
        if(i<0 || i>=m || j<0 || j>=n ){
            return ;
        }
        char c=grid[i][j];
        if(c=='0' || c=='2'){
            return ;
        }

        grid[i][j]='2';
         dfs(i-1,j) ;
         dfs(i+1,j) ;
         dfs(i,j-1) ;
         dfs(i,j+1) ;

    }
}
