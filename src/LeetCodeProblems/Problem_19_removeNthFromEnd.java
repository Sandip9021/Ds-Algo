public class Problem_19_removeNthFromEnd {
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
			head.next.next.next.next.next=new ListNode(6);
			
			ListNode result=removeNthFromEnd(head,6);
			System.out.println(result);
		}
		
		 public static ListNode removeNthFromEnd(ListNode head, int n) {
			   if(head==null) {
				   return null;
			   }
			   
			   ListNode forwardPointer=head;
			   ListNode backPointer=head;
			   ListNode prevNode=null;
			   
			   for(int i=0;i<n;i++) {
				   forwardPointer=forwardPointer.next;
			   }
			   
			   while(forwardPointer!=null) {
				   forwardPointer=forwardPointer.next;
				   prevNode=backPointer;
				   backPointer=backPointer.next;
			   }
			   
			   if(backPointer==head) {
				   return head.next;
			   }
			   
			   if(backPointer.next==null) {
				   prevNode.next=null;
			   }else {
				   prevNode.next=backPointer.next;
			   }
	
		       return head; 
		 }
}











