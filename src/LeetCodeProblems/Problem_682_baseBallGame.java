package LeetCodeProblems;

import java.util.Stack;

public class Problem_682_baseBallGame {
	
	public static void main(String[] args) {
		 String ops[] = {Integer.MAX_VALUE+"" , Integer.MAX_VALUE+"" , "+"};
		 System.out.println(calPoints(ops));
	}
	
	public static int calPoints(String[] ops) {
		Stack<Integer> result=new Stack<Integer>();
		int i=0;
		while(i<ops.length) {
			switch(ops[i]) {
			  case "C":
			     result.pop();
			    break;
			  case "D":
			     result.push(result.peek() *2);
			    break;
			  case "+":
				int a=result.pop();
				int b=result.peek();
				 result.push(a);
				 result.push(a+b);
				break;
			  default:
				  result.push(Integer.parseInt(ops[i]));
			}
			i++;
		}
		
		int j=0; int sum=0;
		while(j<result.size()) {
			sum=sum+ result.get(j);
			j++;
		}
		
		return sum;     
	}

}
