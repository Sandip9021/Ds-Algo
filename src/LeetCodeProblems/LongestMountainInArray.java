package LeetCodeProblems;

//Leetcode 845
public class LongestMountainInArray {
	public static void main(String[] args) {
		int arr[] = { 1, 4, 3, 0, 5, 1, 6, 7, 9, 4, 3, 2, 1 };
		// int arr[] = { 0,2,0,2,1,2,3,4,4,1};
		// int arr[] = { 0,2,3,3,2,1,0};
		int result = longestMountain(arr);
		System.out.println("Longest Mountain length=" + result);
	}

	public static int longestMountain(int[] arr) {
		int n = arr.length;
		int max = 0;
		int start = 0;
		int end = 0;

		while (start < n) {
			end = start;
			if (end + 1 < n && arr[end] < arr[end + 1]) {
				while (end + 1 < n && arr[end] < arr[end + 1]) {
					end++;
				}
				if (end + 1 < n && arr[end] > arr[end + 1]) {
					while (end + 1 < n && arr[end] > arr[end + 1]) {
						end++;
					}
					max = Math.max(max, end - start + 1);
				}
			}
			start = Math.max(end, start + 1);
		}
		return max;
	}

}
