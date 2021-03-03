package graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//Leetcode 797
public class AllPathsFromSourceToTarget {

	List<List<Integer>> result = new ArrayList<List<Integer>>();

	public static void main(String[] args) {
		AllPathsFromSourceToTarget apst = new AllPathsFromSourceToTarget();
		int[][] graph = { { 4, 3, 1 }, { 3, 2, 4 }, { 3 }, { 4 }, {} };
		List<List<Integer>> result = apst.allPathsSourceTarget(graph);
		System.out.println("--------------Result-------------");
		System.out.println(result);
	}

	public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
		int source = 0;
		int dest = graph.length - 1;
		boolean[] isVisited = new boolean[graph.length];
		List<Integer> pathlist = new ArrayList<>();
		pathlist.add(source);
		dfsUtil(source, dest, isVisited, pathlist, graph);
		return result;
	}

	public void dfsUtil(int source, int dest, boolean[] isVisited, List<Integer> currentPath, int[][] graph) {

		if (source == dest) {
			result.add(new ArrayList<Integer>(currentPath));
			return;
		}

		isVisited[source] = true;

		for (Integer node : graph[source]) {
			if (!isVisited[node]) {
				currentPath.add(node);
				dfsUtil(node, dest, isVisited, currentPath, graph);
				currentPath.remove(node);
			}
		}
		isVisited[source] = false;
	}

}
