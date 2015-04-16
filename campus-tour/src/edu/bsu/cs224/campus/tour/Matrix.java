package edu.bsu.cs224.campus.tour;

public class Matrix {

	public static final int NULL = -1;

	private int[][] matrix;

	public static Matrix createWithSize(int size) {
		return new Matrix(size);
	}

	private Matrix(int size) {
		matrix = new int[size][size];
	}

	public void setDistanceBetween(int pointA, int pointB, int distance) {
		matrix[pointA][pointB] = distance;
	}

	public int getDistanceBetween(int pointA, int pointB)
			throws NoDistanceException {
		int result = matrix[pointA][pointB];
		if (result == NULL) {
			throw new NoDistanceException();
		}
		return result;
	}

	public int size() {
		return matrix.length;
	}

	public static class NoDistanceException extends Exception {
		private static final long serialVersionUID = 5936439758540709300L;
	}
}
