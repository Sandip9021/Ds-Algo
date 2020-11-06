package Prims;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.PriorityQueue;

public class PrimsAlgo {
	
	private int V;  /* number of vertices*/
	private LinkedList<Node> al[];
	
	public PrimsAlgo(int v) {
		this.V=v;
		al = new LinkedList[V];
		for (int i = 0; i < V; i++) {
			al[i] = new LinkedList<>();
		}
	}
	
	public void addEdge(int from, Node node) {
		al[from].add(node);
	}
	
	public void printMSTPrims (PrimsAlgo graph) {
		int count=0;
		boolean nodeUsed[] = new boolean[this.V];
		PriorityQueue<Node> minHeap = new PriorityQueue<Node>(new Comparator<Node>() {
			@Override
			public int compare(Node o1, Node o2) {
				return o1.getWeight() - o2.getWeight();
			}
		});
		
		nodeUsed[0]=true;
		LinkedList<Node> el =al[0];
		el.forEach(node->{
			if(!nodeUsed[node.getKey()]) {
				 minHeap.add(node);
			}
		});
		
		Node n=null;
		
		while(count != this.V -1) {
			n = minHeap.poll();
			if(nodeUsed[n.getFromKey()] && nodeUsed[n.getKey()]) {
				continue;
			}
			nodeUsed[n.getKey()] =true;
			System.out.println(n.getFromKey() + " to " + n.getKey() + "  : weight -> "+ n.getWeight());
			count++;
			el = al[n.getKey()];
			el.forEach(node->{
				if(!nodeUsed[node.getKey()]) {
					 minHeap.add(node);
				}
			});
		}
	}
	
	public static void adjacencyMatrixToListConverter(int graphAM[][],PrimsAlgo graph) {
		int len = graphAM.length;
		for(int i=0;i<len;i++) {
			for(int j=0;j<len;j++) {
				if(graphAM[i][j]!=0) {
				    graph.addEdge(i,new Node(i,j,graphAM[i][j]));	
				}
			}
		}	
	}
	
	
	public static void main(String[] args) {
		int[][] graphAM = {
	              {0,5,2,0,0,0,0},
	              {5,0,10,0,0,6,0},
	              {2,10,0,15,9,0,0},
	              {0,0,15,0,8,0,0},
	              {0,0,9,8,0,11,5},
	              {0,6,0,0,11,0,0},
	              {0,0,0,0,5,0,0}
            };
		PrimsAlgo  graph= new PrimsAlgo(graphAM.length);
		adjacencyMatrixToListConverter(graphAM,graph);
		graph.printMSTPrims(graph);
	}

}
