package Array;

public class KadansAlgo2DMatrix {
	int L=0;
	int R=0;
	int currentSum=0;
	int maxSum=0;
	int maxLeft=0;
	int maxRight=0;
	int maxUp=0;
	int maxDown=0;
	
	public static void main(String[] args) {		
		int arr[][]= {
				{1,1,-3,-4,5},
				{0,7,3,4,1},
				{2,-2,-3,4,-5},
				{-3,4,1,0,3}
		};
		
		KadansAlgo2DMatrix kd2d= new KadansAlgo2DMatrix();
		kd2d.maxSum2Dmatrix(arr);
				
	}
	
	public void maxSum2Dmatrix(int[][] arr) {
		int tempArr[]=new int[arr.length];
		
		while(L < arr[0].length) {
			emptyTempArr(tempArr);
			R=L;
			while(R < arr[0].length) {
				for(int i=0;i<arr.length ; i++) {
					tempArr[i] = tempArr[i] + arr[i][R];
				}
				maximumSubArraySum(tempArr);
				R++;
			}
			L++;
		}
		
		System.out.println("Max Sum : "+this.maxSum);
		System.out.println("Left : "+this.maxLeft);
		System.out.println("Right : "+this.maxRight);
		System.out.println("Top : "+this.maxUp);
		System.out.println("Down : "+this.maxDown);
	}
	
	public void emptyTempArr(int tempArr[]) {
		 for(int i=0;i<tempArr.length;i++) {
			  tempArr[i]=0;
		 }
	}
	
	public  void maximumSubArraySum(int arr[]) {
		  int maxSumTillNow=arr[0];
		  int maxSumInCurrWindow = 0;
		  
		  int start =0;
		  int end = 0;
		  int shift =0;
		  
		  for(int i=0;i<arr.length;i++) {
			  maxSumInCurrWindow = maxSumInCurrWindow + arr[i];
			  
			  if(maxSumInCurrWindow > maxSumTillNow) {
				  maxSumTillNow = maxSumInCurrWindow;
				  start=shift;
				  end=i;
			  }
			  
			  if(maxSumInCurrWindow <0) {
				  maxSumInCurrWindow = 0;
				  shift = i+1;
			  }
		  }
		  
		  this.currentSum = maxSumTillNow;
		  if(this.currentSum > this.maxSum) {
			  this.maxSum = this.currentSum;
			  this.maxUp = start;
			  this.maxDown=end;
			  this.maxLeft=L;
			  this.maxRight=R;
		  }
		  
	}
	
	
}
