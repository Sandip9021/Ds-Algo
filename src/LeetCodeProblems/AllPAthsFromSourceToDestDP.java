package graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

class AllPAthsFromSourceToDestDP {
    private int target;
    private int[][] graph;
    private HashMap<Integer, List<List<Integer>>> nodePathMap;
    
    public static void main(String[] args) {
    	AllPAthsFromSourceToDestDP apst=new AllPAthsFromSourceToDestDP();
		int[][] graph = {{4,3,1},{3,2,4},{3},{4},{}};
		List<List<Integer>> result=apst.allPathsSourceTarget(graph);
		System.out.println("-----------Result-------------");
		System.out.println(result);
	}

    protected List<List<Integer>> allPathsToTarget(int currNode) {
        if (nodePathMap.containsKey(currNode)) {
            return nodePathMap.get(currNode);
        }

        List<List<Integer>> results = new ArrayList<>();
        
        if (currNode == this.target) {
            ArrayList<Integer> path = new ArrayList<>();
            path.add(target);
            results.add(path);
            return results;
        }

        for (int nextNode : this.graph[currNode]) {
            for (List<Integer> path : allPathsToTarget(nextNode)) {
                ArrayList<Integer> newPath = new ArrayList<>();
                newPath.add(currNode);
                newPath.addAll(path);
                results.add(newPath);
            }
        }
        nodePathMap.put(currNode, results);
        return results;
    }

    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {

        this.target = graph.length - 1;
        this.graph = graph;
        this.nodePathMap = new HashMap<>();

        return this.allPathsToTarget(0);
    }
}