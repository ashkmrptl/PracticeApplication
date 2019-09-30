package com.akp.codility;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

public class CityCapitalAndDistance {
	private static List<Integer> pathSizeList = new ArrayList<>();

	public static void main(String[] args) {

		int[] array = { 9, 1, 4, 9, 0, 4, 8, 9, 0, 1 };

		int capitalIndex = 0;

		Graph graph = new Graph(array.length);

		for (int i = 0; i < array.length; i++) {
			if (array[i] == i) {
				capitalIndex = i;
				continue;
			}
			graph.addEdge(graph, i, array[i]);
		}

		for (int i = 0; i < array.length; i++) {
			if (array[i] == i) {
				continue;
			}
			graph.printAllPaths(capitalIndex, array[i]);
		}

		System.out.println(pathSizeList);
	}

	static class Graph {
		private int noOfVertices;
		private LinkedList<Integer>[] adjListArray;

		public Graph(int noOfVertices) {
			this.noOfVertices = noOfVertices;
			adjListArray = new LinkedList[noOfVertices];

			// Creating list for all vertices
			for (int i = 0; i < noOfVertices; i++) {
				adjListArray[i] = new LinkedList<>();
			}
		}

		void addEdge(Graph graph, int source, int destination) {
			// Adding an edge from src to dest
			graph.adjListArray[source].add(destination);

			// Since graph is undirected, adding an edge from dest to src
			graph.adjListArray[destination].add(source);
		}

		public void printAllPaths(int s, int d) {
			boolean[] isVisited = new boolean[noOfVertices];
			ArrayList<Integer> pathList = new ArrayList<>();

			// add source to path[]
			// pathList.add(s);

			// Call recursive utility
			printAllPathsUtil(s, d, isVisited, pathList);
		}

		private void printAllPathsUtil(Integer u, Integer d, boolean[] isVisited, List<Integer> localPathList) {

			// Mark the current node
			isVisited[u] = true;

			if (u.equals(d)) {
				System.out.println(localPathList);
				pathSizeList.add(localPathList.size());
				// if match found then no need to traverse more till depth
				isVisited[u] = false;
				return;
			}

			for (Integer i : adjListArray[u]) {
				if (!isVisited[i]) {
					localPathList.add(i);
					printAllPathsUtil(i, d, isVisited, localPathList);

					localPathList.remove(i);
				}
			}

			isVisited[u] = false;
		}

		/*
		 * Printing BFS traversal of graph
		 */
		void bfs(int start) {
			Queue<Integer> queue = new LinkedList<Integer>();
			Set<Integer> visited = new HashSet<>();

			// Marking current/start node as visited
			visited.add(start);
			queue.add(start);

			while (!queue.isEmpty()) {
				// Dequeue the node and print it
				start = queue.poll();
				System.out.print(start + " ");

				// Getting all adjacent vertices of the dequeued vertex, if the adjacent vertex
				// has not been visited mark it visited and enqueue it
				for (Integer n : adjListArray[start]) {
					if (!visited.contains(n)) {
						queue.add(n);
						visited.add(n);
					}
				}
			}
		}

		void printGraph(Graph graph) {
			for (int v = 0; v < graph.noOfVertices; v++) {
				System.out.print("Paths of node : " + v);

				for (int i : graph.adjListArray[v]) {
					System.out.print(" -> " + i);
				}
				System.out.println("");
			}
		}
	}
}
