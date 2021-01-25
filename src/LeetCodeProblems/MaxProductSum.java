package LeetCodeProblems;

//Leetcode 152
public class MaxProductSum {

	public static void main(String[] args) {
		int nums[] = { 2, 3, -1, 4, 0, -2, 5, 3 };
		int result = maxProduct(nums);
		System.out.println("Result : " + result);
	}

	public static int maxProduct(int[] nums) {

		if (nums.length == 1) {
			return nums[0];
		}
		int maxPositive = nums[0];
		int maxNegetive = nums[0];
		int current = 0;
		int maxProduct = nums[0];
		int choice1;
		int choice2;

		for (int i = 1; i < nums.length; i++) {
			current = nums[i];
			choice1 = maxPositive * current;
			choice2 = maxNegetive * current;

			maxPositive = Math.max(current, Math.max(choice1, choice2));
			maxNegetive = Math.min(current, Math.min(choice1, choice2));
			maxProduct = Math.max(maxProduct, Math.max(maxPositive, maxNegetive));
		}

		return maxProduct;

	}

}
