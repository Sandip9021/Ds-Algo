/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class MergeKSortedLists {
   public  ListNode mergeKLists(ListNode[] lists) {
       PriorityQueue<ListNode>  pq= new PriorityQueue<>((l1, l2) -> l1.val - l2.val);
		for(ListNode li : lists) {
			  if(li!=null) {
				  pq.add(li);
			  }
		}
		if(pq.isEmpty()) {
			return null;
		}
		if(pq.size()==1) {
			return pq.poll();
		}
		ListNode minNode=pq.poll();
		ListNode resultList=minNode;
		ListNode resultHeadMain=resultList;
		if(minNode.next!=null) {
			pq.add(minNode.next);
		}
		while(!pq.isEmpty()) {
			ListNode min=pq.poll();
			resultList.next=min;
			resultList=resultList.next;
			if(min.next!=null) {
				pq.add(min.next);
			}
			
		}
		return resultHeadMain;
	}

}
