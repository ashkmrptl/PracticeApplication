package com.akp.sklillenza.test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class CourseAndDependent {
	int vertex;
	LinkedList<Integer> list[];
	List<Integer> noPrintList = new ArrayList<>();

	public CourseAndDependent(int vertex) {
		this.vertex = vertex;
		list = new LinkedList[vertex];
		for (int i = 0; i < vertex; i++) {
			list[i] = new LinkedList<>();
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int noOfCourses = Integer.parseInt(br.readLine());
		int noOfPaths = Integer.parseInt(br.readLine());
		CourseAndDependent cad = new CourseAndDependent(noOfCourses);

		while (noOfPaths-- > 0) {
			String[] arr = br.readLine().split(", ");
			int x = Integer.parseInt(arr[0]);
			int y = Integer.parseInt(arr[1]);

			cad.noPrintList.add(y);

			cad.addEdge(x, y);
		}
		
		cad.printGraph();

		br.close();
	}

	private void addEdge(int source, int destination) {
		list[source].addFirst(destination);
	}

	public void printGraph() {
		for (int i = 0; i < vertex; i++) {
			if (!noPrintList.contains(i)) {
				if (list[i].size() > 0) {
					System.out.print("Vertex " + i + " is connected to: ");
					for (int j = 0; j < list[i].size(); j++) {
						System.out.print(list[i].get(j) + " ");
					}
					System.out.println();
				}
			}
		}
	}
}
