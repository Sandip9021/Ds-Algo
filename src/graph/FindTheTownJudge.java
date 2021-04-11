package graph;

public class FindTheTownJudge {
	
	 public int findJudge(int N, int[][] trust) {
	        int[] degree=new int[N];
	        
	        for(int i=0;i<trust.length;i++){
	        	degree[trust[i][1]-1]++;
	        	degree[trust[i][0]-1]--;
	        }
	        
	        for(int i=0;i<N;i++){
	             if(degree[i]==N-1){
	                  return i+1;
	             }
	        }
	        
	        return -1;
	    }

}
