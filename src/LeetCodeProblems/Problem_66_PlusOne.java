package LeetCodeProblems;

public class Problem_66_PlusOne {
	
	public static void main(String[] args) {
		int[] a= {0,2,9};
		int b[]=plusOne(a);
		
		for(int i: b) {
			System.out.print(i+"  ");
		}
	}
	
	public static int[] plusOne(int[] digits) {
		  if(digits==null) {
			  return null;
		  }
		  
		  int len = digits.length;
		 
		  boolean all9=true;
		  for(int i: digits) {
			  if(i!=9) {
				  all9=false;
			  }
		  }
		  
		  if(all9) {
			  int result[]=new int[len+1];
			  for(int i=0;i<result.length;i++) {
				  if(i==0) {
					  result[i]=1;
				  }else {
					  result[i]=0;
				  }
				 
			  }
			  return result;
		  }
		  int remain=0;
		  int plus=1;
		  for(int j=len-1;j>=0;j--) {
			  plus=plus+remain+digits[j];
			  if(plus>9) {
				  digits[j]=0;
				  remain=1;
			  }else {
				  digits[j]=plus;
				  remain=0;
				  break;
			  }
			  plus=0;
		  }
		  
		  return digits;
	}

}
