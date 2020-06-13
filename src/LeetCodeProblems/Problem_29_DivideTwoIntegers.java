package LeetCodeProblems;

public class Problem_29_DivideTwoIntegers {

	public static void main(String[] args) {
         int result=divide(-30,-1);
         System.out.println(result);
	}

	public static int divide(int dividend, int divisor) {
		
		if(dividend==Integer.MIN_VALUE) {
			if(divisor==1) {
				return Integer.MIN_VALUE;
			}
			if(divisor==-1) {
				return Integer.MAX_VALUE;
			}
		}
		
		if(dividend==Integer.MAX_VALUE) {
			if(divisor==1) {
				return Integer.MAX_VALUE;
			}
			if(divisor==-1) {
				return -Integer.MAX_VALUE;
			}
		}
		
         if(divisor==1) {
			 return dividend; 
		  }
         
         if(divisor==-1) {
			 return -dividend; 
		  }
		
		boolean isNegetive=false;
		
		if(dividend >=0 && divisor >=0) {
			isNegetive=false;
		}else if(dividend >=0 && divisor <0) {
			isNegetive=true;
			divisor= -divisor;
		}else if(dividend <0 && divisor >=0) {
			isNegetive=true;
			dividend= -dividend;
		}else {
			isNegetive=false;
			divisor= -divisor;
			dividend= -dividend;
		}
		
		
		
		int remaining=dividend;
		int count=0;
		while(remaining-divisor>=0) {
			remaining=remaining-divisor;
			count++;
		}
				
		if(isNegetive) {
			return -count;
		}
        return count;
	}

}
