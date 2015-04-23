package edu.bsu.cs224.campus.tour;

import java.util.Scanner;

public class Graph {

	private int[][] matrix;

	public static Graph blankWithNodeCount(int nodeCount) {
		return new Graph(nodeCount);
	}

	private Graph(int nodeCount) {
		matrix = new int[nodeCount][nodeCount];
	}

	public static Graph createFrom(String matrix) {
		return new Graph(matrix);
	}

	private Graph(String matrix) {
		Scanner lineScanner = new Scanner(matrix);
		int x = 0;
		int y = 0;
		while (lineScanner.hasNextLine()) {
			Scanner intScanner = new Scanner(lineScanner.nextLine());
			while (intScanner.hasNextInt()) {
				put(intScanner.nextInt(), x, y);
				x++;
			}
			intScanner.close();
			x = 0;
			y++;
		}
		lineScanner.close();
	}

	public void put(int distance, int x, int y) {
		matrix[x][y] = distance;
	}

	public int get(int x, int y) {
		return matrix[x][y];
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		for (int y = 0; y < matrix.length; y++) {
			for (int x = 0; x < matrix.length; x++) {
				builder.append(matrix[x][y])//
						.append(" ");
			}
			builder.append("\n");
		}
		return builder.toString();
	}
}
