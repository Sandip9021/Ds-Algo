package LeetCodeProblems;

import java.util.PriorityQueue;

public class Problem1046_LastStoneWeight {

	public static void main(String[] args) {
		int stones[] = {6,9,3,111};  
		int result = lastStoneWeight(stones);
		System.out.println("Last Stone:" + result);
	}

	public static int lastStoneWeight(int[] stones) {
		PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b)-> b - a);

		for (int stone : stones) {
			maxHeap.add(stone);
		}

		while (maxHeap.size() > 1) {
			int y = maxHeap.poll();
			int x = maxHeap.poll();
			if(y!= x) {
				maxHeap.add(y-x);
			}		
		}
		if(maxHeap.size() == 1) {
			return maxHeap.peek();
		}else {
			return 0;
		}		
	}

}
