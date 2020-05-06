package recursion;

public class TowerOfHanoi {
	
	public static void main(String[] args) {
		towerOfHanoi(3,'A','C','B');
	}
	
	public static void towerOfHanoi(int n,char fromTower,char toTower , char auxilaryTower) {
		if(n==1) {
			System.out.println("Move disk "+n+" from "+fromTower+" to "+toTower);
		}else {
		    towerOfHanoi(n-1,fromTower,auxilaryTower,toTower);
		    System.out.println("Move disk "+n+" from "+fromTower+" to "+toTower);
		
		    towerOfHanoi(n-1,auxilaryTower,toTower,fromTower);	
		}
	}

}
