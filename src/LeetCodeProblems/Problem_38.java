package LeetCodeProblems;

/* Count and Say */
public class Problem_38 {
  
  public static void main(String[] args) {
		String result=countAndSay(4);
		System.out.println("Result is:"+result);
	}
  
  
  public static String countAndSay(int n) {
		int step = 1;
		String result="";
		Stack<Character> stack = new Stack<Character>();
		
        if(n==1) {
        	return "1";
        }
		
		String say = "1";
		while (step < n) {
			Character prev = '*';
			int count = 1;
			result = "";
			char[] name = say.toCharArray();

			for (int i = 0; i < name.length; i++) {
				if (i == 0) {
					stack.push(name[i]);
					prev = name[i];
				} else {
					if (prev == name[i]) {
						count++;
					} else {
						result = result + count + stack.pop();
						stack.push(name[i]);
						prev = name[i];
						count = 1;
					}
				}
			}
			result = result + count + stack.pop();
			//System.out.println("step "+step+":->" + result);
			say=result;
			step++;
		}
		return result;
	}
}
