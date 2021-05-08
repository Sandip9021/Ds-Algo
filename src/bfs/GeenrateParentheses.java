package dfsBackTracking;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class GeenrateParentheses {
	private List<String> result = new ArrayList<>();
    private int max;
	
	static class Bracket{
		int open;
		int close;
		String value;
		
		public Bracket(int open, int close, String value) {
			this.open = open;
			this.close = close;
			this.value = value;
		}
				
	}
    
	
	public static void main(String[] args) {
		GeenrateParentheses gp=new GeenrateParentheses();
		List<String> li=gp.generateParenthesis(3);
		for(String s : li) {
			  System.out.println(s);
		}
	}
  
	    public List<String> generateParenthesis(int n) {
	        max = n;
	        bfs();
	        return result;
	    }
	    
	    public void bfs() {
	    	Queue<Bracket> queue = new LinkedList<>();
	    	queue.add(new Bracket(1,0,"("));
	    	
	    	while(!queue.isEmpty()) {
	    		Bracket b=queue.poll();
	    		if(b.value.length()==max*2) {
	    			result.add(b.value);
	    		}else {
	    			if(isValid('(',b.open,b.close)) {
	    				queue.add(new Bracket(b.open+1,b.close,b.value+"("));
	    			}
	    			if(isValid(')',b.open,b.close)) {
	    			    queue.add(new Bracket(b.open,b.close+1,b.value+")"));
	    			}
	    		}
	    	}
	    }
	    
	    private boolean isValid(char c, int open, int close) {
	        if (open == max && c == '(') return false;
	        if (close == max && c == ')') return false;
	        if (open == close && c == ')') return false;
	        return true;        
	    }

}
