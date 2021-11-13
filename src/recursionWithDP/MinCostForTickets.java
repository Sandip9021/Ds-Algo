class MinCostForTickets {
    
    public int mincostTickets(int[] days, int[] costs) {
       int[] dp = new int[days.length];
       int ans = dfs(days,costs,0,dp);
        return ans;
    }
    
    public static int dfs(int[] days, int[] costs,int index,int[] dp){
        if(index>=days.length){
             return 0;
        }
        
        if(dp[index]>0){
            return dp[index];
        }
        
        
        //opt 1
        int op1 = costs[0] + dfs(days,costs,index+1,dp);
        
        
        //opt2
        int k=index;
        while(k<days.length && days[k] < days[index]+7){
             k++;
        }
        
        int op2 = costs[1] + dfs(days,costs,k,dp);
        
        //opt3
        k=index;
        while(k<days.length && days[k]< days[index]+30){
            k++;
        }
        
        int op3 = costs[2]+ dfs(days,costs,k,dp);
        
        int min = Math.min(op1,Math.min(op2,op3));
        dp[index] = min;
        return min;
    }
    
    
}
