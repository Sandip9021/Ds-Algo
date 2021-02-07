package LeetCodeProblems;

//Leetcode 11
public class ContainerWithMostWater {
     public static void main(String[] args) {
		   int[] height= {1,8,6,2,5,4,8,3,7};
		   int result=maxAreaBruteForce(height);
		   System.out.println("Max area : "+result);
	 }
     
     public static int maxArea(int[] height) {
         int left=0;
         int right=height.length-1;
         int max=Integer.MIN_VALUE;
        while(left<right){
            int min=Math.min(height[left],height[right]);
            System.out.print(min*(right-left)+"  ");
            max=Math.max(max,min*(right-left));
            if(height[left]<=height[right]){
                 left++;
            }else{
                right--;
            }
        }
        return max;
    }
     
     public static int maxAreaBruteForce(int[] height) {
    	   int max=Integer.MIN_VALUE;
    	   
    	   for(int i=0;i<height.length;i++) {
    		   for(int j=i+1;j<height.length;j++) {
    			   int min=Math.min(height[i],height[j]);
    			   max=Math.max(max,min*(j-i));
        	   }
    	   }
        return max;
    }
}
