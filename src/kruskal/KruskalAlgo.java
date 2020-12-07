package kruskal;

import java.util.ArrayList;
import java.util.Collections;

public class KruskalAlgo {

	private int V; /* number of vertices */
	private int [][] parentRankMatrix;

	public KruskalAlgo(int v) {
		this.V = v;	
		parentRankMatrix = new int[2][this.V];
		for(int i=0;i<this.V;i++) {
			parentRankMatrix[0][i]=-1;
			parentRankMatrix[1][i]=0;
		}
	}

	public void printMSTKruskal(int[][] graphAM) {
		  ArrayList<Edge> edgeList = sortTheEdges(graphAM);
		  int count=0;
		  int mstEdgeCount=0;
		  
		  while(mstEdgeCount !=this.V -1) {
			  Edge n = edgeList.get(count);
			  count++;
			  if(isThisEdgeFormingLoop(n)) {
				  continue;
			  }
			  System.out.println(n.getFrom() + "  to "+n.getTo() + "  : weight =>"+n.getWeight());
			  mstEdgeCount++;
		  }
	}
	
	public boolean isThisEdgeFormingLoop(Edge n) {
		int parent=0 ;int rank =1;
		
		int fromParent=parentRankMatrix[parent][n.getFrom()];
		int toParent=parentRankMatrix[parent][n.getTo()];
		if(fromParent==-1 && toParent==-1) {
			if(parentRankMatrix[rank][n.getTo()] > parentRankMatrix[rank][n.getFrom()]) {
				parentRankMatrix[parent][n.getFrom()]=n.getTo();
			}else if(parentRankMatrix[rank][n.getTo()] < parentRankMatrix[rank][n.getFrom()]) {
				parentRankMatrix[parent][n.getTo()]=n.getFrom();
			}else {
				parentRankMatrix[rank][n.getTo()]++;
				parentRankMatrix[parent][n.getFrom()]=n.getTo();
			}
			return false;
		}else {
			int absFromParent=getAbsoluteParent(n.getFrom());
			int absToParent=getAbsoluteParent(n.getTo());	
			if(absFromParent==absToParent) {
				return true;
			}else {
				if(parentRankMatrix[rank][absFromParent] > parentRankMatrix[rank][absToParent]) {
					parentRankMatrix[parent][absToParent]=absFromParent;
				}else if(parentRankMatrix[rank][absFromParent] < parentRankMatrix[rank][absToParent]){
					parentRankMatrix[parent][absFromParent]=absToParent;
				}else {
					parentRankMatrix[rank][absToParent]++;
					parentRankMatrix[parent][absFromParent]=absToParent;
				}
				return false;
			} 
		}
	}
	
	public int getAbsoluteParent(int source) {
		while(parentRankMatrix[0][source]!=-1) {
			source=parentRankMatrix[0][source];
		}
		return source;
	}
	
	
	public ArrayList<Edge> sortTheEdges(int[][] graphAM){
		ArrayList<Edge> edgeList = new ArrayList<Edge>(); 
		
		int len = graphAM.length;
		for (int i = 1; i < len; i++) {
			for (int j = 0; j < i; j++) {
				if (graphAM[i][j] != 0) {
					edgeList.add(new Edge(i,j, graphAM[i][j]));
				}
			}
		}   
		Collections.sort(edgeList); 
		return edgeList;
	}
	
	

	public static void main(String[] args) {
		int[][] graphAM = { { 0, 5, 2, 0, 0, 0, 0 }, { 5, 0, 10, 0, 0, 6, 0 }, { 2, 10, 0, 15, 9, 0, 0 },
				{ 0, 0, 15, 0, 8, 0, 0 }, { 0, 0, 9, 8, 0, 11, 5 }, { 0, 6, 0, 0, 11, 0, 0 }, { 0, 0, 0, 0, 5, 0, 0 } };
		KruskalAlgo graph = new KruskalAlgo(graphAM.length);
		graph.printMSTKruskal(graphAM);
		
	}

}
