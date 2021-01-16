package LeetCodeProblems;


//Leetcode 283
public class MoveZeroes {
	
	public static void main(String[] args) {
		  int nums[]= {0,1,0,3,12};
		  moveZeroes(nums);
	}
	
	 public static void moveZeroes(int[] nums) {
	        int position=0;
	        
	        for(int i=0;i<nums.length;i++) {
	        	  if(nums[i]!=0) {
	        		   nums[position]=nums[i];
	        		   position++;
	        		   nums[i]=0;
	        	  }
	        }
	        
	        for(int i=position;i<nums.length;i++) {
	        	   nums[i]=0;
	        } 
	             
	 }

}
