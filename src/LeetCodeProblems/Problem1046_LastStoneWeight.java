package LeetCodeProblems;

import java.util.Comparator;
import java.util.PriorityQueue;

public class Problem1046_LastStoneWeight {

	public static void main(String[] args) {
		int stones[] = {6,9,3,111};  
		int result = lastStoneWeight(stones);
		System.out.println("Last Stone:" + result);
	}

	public static int lastStoneWeight(int[] stones) {
		int len = stones.length;
		PriorityQueue<Integer> maxHeap = new PriorityQueue<Integer>(len, new Comparator<Integer>() {
			@Override
			public int compare(Integer a, Integer b) {
				return b - a;
			}
		});

		for (int i = 0; i < stones.length; i++) {
			maxHeap.add(stones[i]);
		}

		while (maxHeap.size() > 1) {
			int y = maxHeap.poll();
			int x = maxHeap.poll();
			if(x==y) {
				continue;
			}else {
				maxHeap.add(y-x);
			}		
		}
		if(maxHeap.size()==1) {
			return maxHeap.peek();
		}else {
			return 0;
		}		
	}

}
