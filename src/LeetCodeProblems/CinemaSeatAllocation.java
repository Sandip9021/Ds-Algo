package LeetCodeProblems;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class CinemaSeatAllocation {

	public static void main(String[] args) {
		int n = 4;
		//int reservedSeats[][] = { { 1, 2 }, { 1, 3 }, { 1, 8 }, { 2, 6 }, { 3, 1 }, { 3, 10 } };
		 //int reservedSeats[][] = { {2,1},{1,8},{2,6}};
		 int reservedSeats[][] = { {4,3},{1,4},{4,6},{1,7}};
		int result = maxNumberOfFamilies(n, reservedSeats);
		System.out.println("Result=" + result);
	}
	
	public static int maxNumberOfFamilies(int n, int[][] reservedSeats) {
		int count = 0;
		Boolean[] seats;
		Map<Integer,Boolean[]> map=new HashMap<>();
		
			for (int i = 0; i < reservedSeats.length; i++) {
				    int row=reservedSeats[i][0];
				    int s=reservedSeats[i][1];
				    if(s==1 || s==10) {
						  continue;
					}
				
				   if (map.containsKey(row)) {
					     seats=map.get(row);
				   }else {
					    seats=new Boolean[3];
					    seats[0]=true;
					    seats[1]=true;
					    seats[2]=true;
				   }
					
					if(s==2 || s==3) {
						seats[0]=false;
					}else if(s==8 || s==9) {
						seats[2]=false;
					}else if(s==4 || s==5) {
						seats[0]=false;
						seats[1]=false;
					}else if(s==6 || s==7) {
						seats[1]=false;
						seats[2]=false;
					}
					  map.put(row, seats);
			}
			
			for (Map.Entry<Integer,Boolean[]> entry : map.entrySet()) {  
				     Boolean[] seatsAvlble=entry.getValue();
				     if((seatsAvlble[0] && seatsAvlble[1] && seatsAvlble[2]) || seatsAvlble[0] && seatsAvlble[2]) {
				    	   count+=2;
				     }else if((seatsAvlble[0] && seatsAvlble[2]) || seatsAvlble[0] || seatsAvlble[1]) {
				    	 count++;
				     }else if((seatsAvlble[1] && seatsAvlble[2]) || seatsAvlble[1] || seatsAvlble[2]) {
				    	 count++;
				     }
			}
			
			count=count + (n-map.size()) *2;

		return count;
	}
	
	public static int maxNumberOfFamiliesBruteForce(int n, int[][] reservedSeats) {
		Set<Integer> set = new HashSet<>();
		int count = 0;
		for (int i = 1; i <= n; i++) {
			set.clear();
			for (int j = 0; j < reservedSeats.length; j++) {
				if (reservedSeats[j][0] == i) {
					set.add(reservedSeats[j][1]);
				}
			}
			if (set.size() == 0) {
				count = count + 2;
				continue;
			}

			if (!set.contains(2) && !set.contains(3) && !set.contains(4) && !set.contains(5) && !set.contains(6)
					&& !set.contains(7) && !set.contains(8) && !set.contains(9)) {
				count = count + 2;
				continue;
			}

			if (!set.contains(2) && !set.contains(3) && !set.contains(4) && !set.contains(5)) {
				count++;
				continue;
			}
			if (!set.contains(4) && !set.contains(5) && !set.contains(6) && !set.contains(7)) {
				count++;
				continue;
			}
			if (!set.contains(6) && !set.contains(7) && !set.contains(8) && !set.contains(9)) {
				count++;
				continue;
			}

		}
		return count;
	}

}
