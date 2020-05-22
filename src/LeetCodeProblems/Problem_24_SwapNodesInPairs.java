package LeetCodeProblems;

public class Problem_24_SwapNodesInPairs {

	 static class ListNode {
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
		public String toString() {
			return "ListNode [val=" + val + ", next=" + next + "]";
		}
	}

	public static void main(String[] args) {
		ListNode head=new ListNode(1);
		head.next=new ListNode(2);
		head.next.next=new ListNode(3);
		head.next.next.next=new ListNode(4);
		head.next.next.next.next=new ListNode(5);
		//head.next.next.next.next.next=new ListNode(6);
		
		ListNode result=swapPairs(null);
		System.out.println(result);
	}

	public static ListNode swapPairs(ListNode head) {
		if(head==null || head.next==null) {
			return head;
		}
		
		ListNode newHead=null;
		ListNode left=null;
		ListNode right=null;
		ListNode lastNode=null;
	
		newHead=head.next;
		lastNode=head;
		boolean firstSwap=false;
		
	   while(head!=null) {	
		left=head;
		if(left.next==null) {
			lastNode.next=left;
			break;
		}
		right=left.next;
		//swap
		head=right.next==null?null:right.next;
		right.next=left;
		left.next=null;
		if(firstSwap) {
			lastNode.next=right;
			lastNode=right.next;
		}
		firstSwap=true;
	   }	
        return newHead;
	}
}
