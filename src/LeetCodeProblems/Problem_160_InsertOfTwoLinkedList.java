public class Problem_160_InsertOfTwoLinkedList {

	public static class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
			next = null;
		}

		@Override
		public String toString() {
			return "ListNode [val=" + val + ", next=" + next + "]";
		}
		
	}
	
	public static void main(String[] args) {
		ListNode merge=new ListNode(101);
		
		ListNode headA=new ListNode(4);
		headA.next=new ListNode(1);
		headA.next.next=new ListNode(2);
		headA.next.next.next=new ListNode(4);
		headA.next.next.next.next=merge;
		
		ListNode headB=new ListNode(5);
		headB.next=new ListNode(0);
		headB.next.next=new ListNode(1);
		headB.next.next.next=new ListNode(9);
		headB.next.next.next.next=new ListNode(19);
		headB.next.next.next.next.next=new ListNode(21);
		
		ListNode li=getIntersectionNode(headA,headB);
		System.out.println(li==null? "null" : li.val);  
	}

	public static ListNode getIntersectionNode(ListNode headA, ListNode headB) {
		
		if(headA==null || headB==null) {
			return null;
		}
		
		int lenA=1,lenB=1;
		ListNode currA=headA;
		ListNode currB=headB;
		
		while(currA.next!=null) {
			currA=currA.next;
			lenA++;
		}
		
		while(currB.next!=null) {
			currB=currB.next;
			lenB++;
		}
		
		if(currA!=currB) {
			return null;
		}
		
		currA=headA;
		currB=headB;
		
		if(lenA>lenB) {
			for(int i=0;i<lenA-lenB;i++) {
				currA=currA.next;
			}
		}else {
			for(int i=0;i<lenB-lenA;i++) {
				currB=currB.next;
			}
		}
		
		while(currA!=currB) {
			currA=currA.next;
			currB=currB.next;
		}
	
		return currA;
	}
}
