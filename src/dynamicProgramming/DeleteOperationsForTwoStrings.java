package dynamicProgramming;

public class DeleteOperationsForTwoStrings {
	
     //Solution 1 using Longest Common Subsequence 
	public int minDistance1(String word1, String word2) {
        int commonPart=longestCommonSubsequence(word1,word2);
        return word1.length() +word2.length() - 2 * commonPart  ;
    }
    
     public  int longestCommonSubsequence(String text1, String text2) {
         int n=text1.length() +1;
         int m=text2.length() + 1;
         char[] schar1=text1.toCharArray();
         char[] schar2=text2.toCharArray();

        int dp[][] = new int[n][m];

        for(int i=1; i<n; i++){
            for(int j=1 ;j<m; j++){
                if(schar1[i-1] == schar2[j-1]){
                      dp[i][j]=dp[i-1][j-1]+1 ;
                }else{
                      dp[i][j]=Math.max(dp[i-1][j],dp[i][j-1]);
                }
            }
        }
        
        return dp[n-1][m-1];
    }
	
     
     //Solution 2 using normal DP
	 public int minDistance(String word1, String word2) {
         int n=word1.length() +1;
         int m=word2.length() + 1;
         char[] schar1=word1.toCharArray();
         char[] schar2=word2.toCharArray();

        int dp[][] = new int[n][m];

        for(int i=0; i<n; i++){
            for(int j=0 ;j<m; j++){
                if(i==0){
                    dp[0][j]=j;
                }else if(j==0){
                    dp[i][0]=i;
                }else{
                    if(schar1[i-1] == schar2[j-1]){
                      dp[i][j]=dp[i-1][j-1];
                    }else{
                      dp[i][j]=Math.min(dp[i-1][j],dp[i][j-1])+1;
                    }
                }
            }
        }
        
        return dp[n-1][m-1];
    }

}
