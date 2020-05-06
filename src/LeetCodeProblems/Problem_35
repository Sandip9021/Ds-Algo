public class Problem_35 {

/* find position of a number */
public static void main(String[] args) {
		int[] arr = { 1,4,6,13};
		int target = 7;
		int index = searchInsert(arr, target);
		 System.out.println("Index of "+target+" is ="+index);
	}

	public static int searchInsert(int[] nums, int target) {
		if (nums.length == 0 || target < nums[0]) {
			return 0;
		}

		if (target > nums[nums.length - 1]) {
			return nums.length;
		}

		for (int i = 0; i < nums.length; i++) {
			if (nums[i] == target) {
				return i;
			} else if (target > nums[i] && target < nums[i + 1]) {
				return i + 1;
			}
		}
		return 0;
	}
  }
