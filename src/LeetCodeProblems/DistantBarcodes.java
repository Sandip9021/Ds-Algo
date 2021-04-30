package LeetCodeProblems;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class DistantBarcodes {
	
	public static void main(String[] args) {
		
	}
	
	 public int[] rearrangeBarcodes(int[] barcodes) {
	        int n = barcodes.length;
	        int[] result = new int[n];
	        
	        Map<Integer,Integer> map=new HashMap<>();
	        for(int b : barcodes) {
	        	 map.put(b, map.getOrDefault(b,0)+1);
	        }
	        
	        PriorityQueue<Integer> maxHeap= new PriorityQueue<>((a,b) -> map.get(b) -map.get(a));
	        maxHeap.addAll(map.keySet());
	        
	        int index=0;
	        while(maxHeap.size() > 0) {
	        	int a = maxHeap.poll();
	        	result[index++] = a;
	        	if(maxHeap.size()==0) {
	        		 break;
	        	}
	        	int b = maxHeap.poll();
	        	result[index++] = b;
	        	
	        	modify(map,maxHeap,a);
	        	modify(map,maxHeap,b);
	        }
	        return result;
	 }

	private void modify(Map<Integer, Integer> map, PriorityQueue<Integer> maxHeap, int m) {
		if(map.get(m)==1) {
			 map.remove(m);
		}else {
			map.put(m,map.get(m)-1);
			maxHeap.offer(m);
		}
		
	}

}
