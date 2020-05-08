/*Problem 2 : Add two numbers */
public class Problem_2 {
	// Definition for singly-linked list.
	public static class ListNode {
		int val;
		ListNode next;

		ListNode() {
		}

		ListNode(int val) {
			this.val = val;
		}

		ListNode(int val, ListNode next) {
			this.val = val;
			this.next = next;
		}

		@Override
		public String toString() {
			return "ListNode [val=" + val + ", next=" + next + "]";
		}

	}

	public static void main(String[] args) {
		ListNode l1 = new ListNode(5);
		// l1.next=new ListNode(4);
		// l1.next.next=new ListNode(3);

		 ListNode l2= new ListNode(5);
		//l2.next=new ListNode(6);
		// l2.next.next=new ListNode(4);
		// l2.next.next=new ListNode(9);
	/*	ListNode li = null;
		ListNode l2 = null;
		int[] arr = { 1, 9, 9, 9, 9, 9, 9, 9, 9, 9 };
		for (int i = 0; i < arr.length; i++) {
			if (li == null) {
				li = new ListNode(arr[i]);
				l2 = li;
			} else {
				li.next = new ListNode(arr[i]);
				li = li.next;
			}
		}  */

		System.out.println(addTwoNumbers(l1, l2));
	}

	public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		int num1 = 0, num2 = 0, r = 0, c = 0, sum = 0;
		ListNode li = null;
		ListNode root = null;
		boolean l1Remains = true;
		boolean l2Remains = true;

		while (l1Remains || l2Remains) {
			num1 = l1 == null ? 0 : l1.val;
			num2 = l2 == null ? 0 : l2.val;
			sum = num1 + num2 + c;

			if (sum > 9) {
				r = sum % 10;
				c = 1;
			} else {
				r = sum;
				c = 0;
			}

			/* forming the result list */
			if (li == null) {
				li = new ListNode(r);
				root = li;
			} else {
				li.next = new ListNode(r);
				li = li.next;
			}

			if (l1Remains) {
				if (l1.next == null) {
					l1Remains = false;
					l1 = null;
				} else {
					l1 = l1.next;
				}
			}

			if (l2Remains) {
				if (l2.next == null) {
					l2Remains = false;
					l2 = null;
				} else {
					l2 = l2.next;
				}
			}
		}
		
		if(c==1) {
			li.next = new ListNode(c);
		}
		return root;
	}

}
