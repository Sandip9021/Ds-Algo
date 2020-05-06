package recursion;

public class Factorial {
	
	public static void main(String[] args) {
		Factorial fact = new Factorial();
		System.out.println(fact.factorial(5));
		
		System.out.println("*"+fact.printNumber(5));
	}
	
	public long factorial(long number) {
		if(number<=1) {
			return 1;
		}else {
			return number * factorial(number-1);
		}
	}
     // 5 * 4!
	 // 5 * 4 * 3! 
	 // 5 * 4 * 3 * 2!
	 //5 * 4 * 3 * 2 * 1!
	
	public int printNumber(int n) {
		if(n == 0) {
			return 0;
		}else {
			System.out.print(n+"  ");
			return printNumber(n-1);
		}
	}
}
