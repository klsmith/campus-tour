package edu.bsu.cs224.campus.tour;

import java.util.Scanner;

public class Application {

	public static void main(String[] args) {
		Scanner inputScanner = new Scanner(System.in);
		System.out.println("Campus Tour (Traveling Saleman) Test");
		System.out.print("Enter number of nodes: ");
		String input = inputScanner.nextLine();
		int nodeCount = Integer.valueOf(input);
		System.out.println("Enter matrix below: ");
		StringBuilder matrixBuilder = new StringBuilder();
		for (int y = 0; y < nodeCount; y++) {
			for (int x = 0; x < nodeCount; x++) {
				matrixBuilder.append(inputScanner.nextInt());
			}
			matrixBuilder.append("\n");
		}
		Graph graph = Graph.createFrom(nodeCount, matrixBuilder.toString());
		GraphSolver solver = GraphSolver.createFor(graph);
		Path solution = solver.solveFromNode(0);
		System.out.println(solution);
		inputScanner.close();
	}
}
