public class Problem_82_RemoveDuplicateFromSortedLinkedList {

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
		ListNode head=new ListNode(1);
		headB.next=new ListNode(5);
		headB.next.next=new ListNode(5);
		headB.next.next.next=new ListNode(9);
		headB.next.next.next.next=new ListNode(19);
		headB.next.next.next.next.next=new ListNode(19);
		headB.next.next.next.next.next.next=new ListNode(20);
		headB.next.next.next.next.next.next.next=new ListNode(20);
			
		ListNode li=deleteDuplicates(head);
		System.out.println(li);
	}
	 public static ListNode deleteDuplicates(ListNode head) {
		  if(head==null) {
			  return null;
		  }
		  if(head.next==null) {
			  return head;
		  }
		  ListNode curr1=head;
		  ListNode curr2=null;
		  ListNode newHead=null;
		  ListNode newListCurr=null;
		  
		  while(curr1.next!=null) {
			   curr2=curr1; 
			  while(curr2.val==curr2.next.val) {
				  curr2=curr2.next;
				  if(curr2.next==null) {
					  break;
				  }
			  }
			  if(curr1==curr2) {
				  if(newHead==null) {
					  newHead=new ListNode(curr1.val);
					  newListCurr=newHead;
				  }else {
					  newListCurr.next=new ListNode(curr1.val);
					  newListCurr=newListCurr.next;
				  }
				  curr1=curr1.next;
			  }else {
				  curr1=curr2.next;
				  if(curr1==null) {
					  break;
				  }
			  }
			  if(curr1.next==null) {
				  if(newHead==null) {
					  newHead=new ListNode(curr1.val);
					  newListCurr=newHead;
				  }else {
					  newListCurr.next=new ListNode(curr1.val);
				  }
			  }
		  }
	    return newHead;
	 }
}
