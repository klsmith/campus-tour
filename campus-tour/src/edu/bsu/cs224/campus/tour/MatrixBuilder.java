package edu.bsu.cs224.campus.tour;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class MatrixBuilder {
	private Scanner data;

	public static MatrixBuilder createForFile(File file) throws FileNotFoundException {
		return new MatrixBuilder(file);
	}

	private MatrixBuilder(File file) throws FileNotFoundException {
		data = new Scanner(new FileInputStream(file));
		data.useDelimiter(";");
	}

	public Matrix build() {
		Matrix matrix = Matrix.createWithSize(getSize());
		while (data.hasNextLine()) {
			String current = data.nextLine();
			int pointA = getPointAFor(current);
			int pointB = getPointBFor(current);
			int distance = getDistanceFor(current);
			matrix.setDistanceBetween(pointA, pointB, distance);
		}
		return matrix;
	}

	private int getPointAFor(String current) {
		String number = current.substring(current.indexOf('[') + 1,
				current.indexOf(',')).trim();
		return Integer.valueOf(number);
	}

	private int getPointBFor(String current) {
		String number = current.substring(current.indexOf(',') + 1,
				current.indexOf(']')).trim();
		return Integer.valueOf(number);
	}

	private int getDistanceFor(String current) {
		String number = current.substring(current.indexOf('=') + 1,
				current.indexOf(';')).trim();
		if (number.isEmpty()) {
			return Matrix.NULL;
		}
		return Integer.valueOf(number);
	}

	private int getSize() {
		String line = data.nextLine();
		String number = line
				.substring(line.indexOf(":") + 1, line.indexOf(";")).trim();
		if (number.isEmpty()) {
			return Matrix.NULL;
		}
		return Integer.valueOf(number);
	}
}
