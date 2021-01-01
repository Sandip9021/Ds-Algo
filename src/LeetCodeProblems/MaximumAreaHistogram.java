package Array;

import java.util.Arrays;
import java.util.Stack;

public class MaximumAreaHistogram {
	public static void main(String[] args) {
		int hist[] = {2,1,5,6,2,3};
		printHistogram(hist);
		System.out.println("\nMaximum area is " + getMaxArea(hist));
	}
	
	static int getMaxArea(int hist[]) {
		Stack<Integer> stack=new Stack<>();
		int n=hist.length;
		if(n==0) {
			return 0;
		}
		if(n==1) {
			return hist[0];
		}
		int left[]=new int[n];
		int right[]=new int[n];
		int max_area=0;
		
		left[0]=0;
		stack.push(0);
		int i=1;
		
		while(i<n) {
			  while(!stack.isEmpty() && hist[i] <= hist[stack.peek()]) {
				  stack.pop();
			  }
			  left[i] = stack.isEmpty() ? 0 : stack.peek() +1;
			  stack.push(i++);
		}
		
		stack.clear();
		
		i = n-1;
		right[i]=i;
		stack.push(i--);
		
		while(i>=0) {
			 while(!stack.isEmpty() && hist[i] <= hist[stack.peek()]) {
				  stack.pop();
			  }
			 right[i] = stack.isEmpty() ? n-1 : stack.peek() -1;
			 stack.push(i--);
		}
		int area=0;
		for(int z=0;z<n;z++) {
			  area=(right[z]-left[z] +1) * hist[z];
			  if(area > max_area) {
				  max_area=area;
			  }
		}
		
		return max_area;
	}
	
	public static void printHistogram(int arr[]) {
		int max = Arrays.stream(arr).max().getAsInt();

		for (int j = max - 1; j >= 0; j--) {
			for (int i = 0; i < arr.length; i++) {
				if (arr[i] <= j) {
					System.out.print("   ");
				} else {
					System.out.print("###");
				}
				System.out.print(" ");
			}
			System.out.println();
		}
		for (int i = 0; i < arr.length; i++) {
			System.out.print("----");
		}
		System.out.println();
		for (int i = 0; i < arr.length; i++) {
			System.out.print(" " + arr[i] + "  ");
		}
	}

	

}
