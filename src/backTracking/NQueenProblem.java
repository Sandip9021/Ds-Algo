package backTracking;

public class NQueenProblem {
	
	class Position{
		public int row;
		public int col;
		
		public Position(int row,int col) {
			this.row=row;
			this.col=col;
		}
	}
	
	public static void main(String[] args) {
		int n=4;  // 4 X 4 matrix
		NQueenProblem nq=new NQueenProblem();
		Position[] po=nq.solveNQueenOneSolution(n);
		
		//nq.printIndexes(po);
		nq.printChessBoardView(po, n);	
	}
		
	public Position[] solveNQueenOneSolution(int n) {
		if(n<4) {
			System.out.println("Solution not possible for less than 4 row");
			return new Position[0];
		}
		Position[] nQSol=new Position[n];
		boolean solutionFound = hasSolution(n,0,nQSol);//no of columns,first row,result solution array
		if(solutionFound) {
			return nQSol;
		}else {
			return new Position[0];
		}
		
	}
	
	private boolean hasSolution(int n,int row,Position[] nQSol) {
		if(n==row) {
			return true;
		}
		
		for(int col=0;col<n;col++) {
			boolean foundSafe= true;
			for(int queen=0;queen<row;queen++) {
				if(nQSol[queen].col==col || nQSol[queen].row==row || 
					(nQSol[queen].col-nQSol[queen].row)==(col-row)	||
						 (nQSol[queen].col+nQSol[queen].row)==(col+row)) {
					foundSafe= false;
					break;
				}
			}
			
			if(foundSafe) {
				nQSol[row]=new Position(row,col);
				if(hasSolution(n,row+1,nQSol)) {
					return true;
				}
			}
		}
			
		return false;
	}
	
	public void printIndexes(Position[] po) {
		for(Position p: po) {
			System.out.println("["+p.row+" , "+p.col+"]");
		}
	}
	
	public void printChessBoardView(Position[] po,int n) {
		for(Position p: po) {
			for(int i=0;i<n;i++) {
				if(i==p.col) {
					System.out.print("| Q ");
				}else {
					System.out.print("|   ");
				}
				if(i==n-1) {
					System.out.print("|");
				}
			}
			System.out.println();
			for(int j=0;j<=n*4;j++) {
			   System.out.print("-");
			}
			System.out.println();
		}
	}

}
