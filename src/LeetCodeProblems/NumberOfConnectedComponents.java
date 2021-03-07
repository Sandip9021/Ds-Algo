package LeetCodeProblems;

public class NumberOfConnectedComponents {
	
	    int group;
	    int[] parent;
	    int[] rank;
	    
	    public static void main(String[] args) {
	    	NumberOfConnectedComponents noc=new NumberOfConnectedComponents();
	    	int[][] edges = {{0,1},{1,2},{3,4}};
	    	int count=noc.countComponents(5, edges);
	    	System.out.println("Result :"+count);
		}
	    
	    public int countComponents(int n, int[][] edges) {
	        // union find
	        parent = new int[n];
	        rank = new int[n];
	        group = n;
	        
	        for (int i = 0; i < n; i++) {
	        	  parent[i] = i; 
	        }
	        
	        for (int[] e : edges) {
	            union(e[0], e[1]);  
	        }
	        
	        return group;
	    }
	    
	    private void union(int i, int j) {
	        int pi = find(i);
	        int pj = find(j);
	        
	        if (pi == pj) {
	        	return ;
	        }
	        
	        if (rank[pi] > rank[pj]) {
	        	parent[pj] = pi;
	        }
	        else if (rank[pi] < rank[pj]) {
	        	parent[pi] = pj;
	        }
	        else {
	            parent[pj] = pi;
	            rank[pi]++;
	        }
	       	group--;
	    }
	    
	    private int find(int i) {
	        while (parent[i] != i) {
	            i = parent[i];
	        } 
	        return i;
	    }

}
