package edu.bsu.cs224.campus.tour;

public class GraphSolver {

	private Graph graph;

	public static GraphSolver createFor(Graph graph) {
		return new GraphSolver(graph);
	}

	private GraphSolver(Graph graph) {
		this.graph = graph;
	}

	public Path solveFromNode(int node) {
		return null;
	}

}
