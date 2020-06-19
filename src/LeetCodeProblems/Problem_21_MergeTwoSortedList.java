public class Problem_21_MergeTwoSortedList {

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
		ListNode l1 = new ListNode(2);
		l1.next = new ListNode(5);
		l1.next.next = new ListNode(5);
		
		ListNode l2 = new ListNode(5);
		l2.next = new ListNode(8);
		l2.next.next = new ListNode(9);
		
		ListNode result = mergeTwoLists(l1,l2);
		System.out.println(result);
	}

	public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
		if(l1==null) {
			return l2;
		}
		if(l2==null) {
			return l1;
		}
        ListNode resultHead=new ListNode(0);
        ListNode resultList=null;
        int firstVal=0;
        int secondVal=0;
        boolean firstRun=true;
        
        while(true) {
        	firstVal=l1.val;
        	secondVal=l2.val;
        	if(firstVal==secondVal) {
        		if(firstRun) {
        			resultHead.val=firstVal;
        			resultList=resultHead;
        			resultList=resultList.next=new ListNode(secondVal);
        		}else {
        			resultList.val=firstVal;
        			resultList=resultList.next=new ListNode(secondVal);
        		}
        		l1=l1.next;
        		l2=l2.next;
        	}else if(firstVal<secondVal){
        		if(firstRun) {
        			resultHead.val=firstVal;
        			resultList=resultHead;
        		}else {
        			resultList.val=firstVal;
        		}
        		l1=l1.next;
        	}else {
        		if(firstRun) {
        			resultHead.val=secondVal;
        			resultList=resultHead;
        		}else {
        			resultList.val=secondVal;
        		}
        		l2=l2.next;
        	}
        	firstRun=false;
        	if(l1==null && l2==null) {
        		break;
        	}
        	if(l1==null && l2!=null) {
        		resultList.next=l2;
        		break;
        	}
        	if(l2==null && l1!=null) {
        		resultList.next=l1;
        		break;
        	}
        	resultList=resultList.next=new ListNode(0); 
        }   
        return resultHead;
	}

}
