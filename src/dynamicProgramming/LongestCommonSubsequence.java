package dynamicProgramming;

public class LongestCommonSubsequence {
	
	public static void main(String[] args) {
		LongestCommonSubsequence lcs=new LongestCommonSubsequence();
		int result=lcs.longestCommonSubsequence("acdfer", "acdmfar");
		System.out.println("Longest common subsequence : "+result);
	}

	
	  public int longestCommonSubsequence(String text1, String text2) {
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
	        
	       /*This method is used to print the sequence*/
	        getSequence(dp,schar1,schar2);
	        
	        return dp[n-1][m-1];
	    }
	  
	  public void getSequence(int dp[][],char[] schar1,char[] schar2) {
		  int n=schar1.length +1;
	      int m=schar2.length + 1;
	      int i=n-1;
	      int j=m-1;
	      String word="";
	     
	       while(i>=1 && j>=1) {
	            	 if(schar1[i-1] == schar2[j-1]){
	                      word=schar1[i-1]+word;
	                      i=i-1;
	                      j=j-1;
	                }else{
	                     if(dp[i-1][j]>dp[i][j-1]) {
	                    	  i=i-1;
	                     }else {
	                    	  j=j-1;
	                     }
	                }
	      }
	       
	       System.out.println("Word : "+word);
	  }
}
