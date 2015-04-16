package edu.bsu.cs224.campus.tour;

import static org.junit.Assert.assertTrue;

import java.io.File;
import java.io.FileNotFoundException;

import org.junit.Before;
import org.junit.Test;

public class MatrixBuilderTester {

	private Matrix testData;

	@Before
	public void setup() {
		testData = Matrix.createWithSize(6);
		testData.setDistanceBetween(0, 0, Matrix.NULL);
		testData.setDistanceBetween(0, 1, 2);
		testData.setDistanceBetween(0, 2, 6);
		testData.setDistanceBetween(0, 3, Matrix.NULL);
		testData.setDistanceBetween(0, 4, 1);
		testData.setDistanceBetween(0, 5, Matrix.NULL);
		testData.setDistanceBetween(1, 1, Matrix.NULL);
		testData.setDistanceBetween(1, 2, 5);
		testData.setDistanceBetween(1, 3, 7);
		testData.setDistanceBetween(1, 4, Matrix.NULL);
		testData.setDistanceBetween(1, 5, Matrix.NULL);
		testData.setDistanceBetween(2, 2, Matrix.NULL);
		testData.setDistanceBetween(2, 3, 2);
		testData.setDistanceBetween(2, 4, 8);
		testData.setDistanceBetween(2, 5, Matrix.NULL);
		testData.setDistanceBetween(3, 3, Matrix.NULL);
		testData.setDistanceBetween(3, 4, Matrix.NULL);
		testData.setDistanceBetween(3, 5, 4);
		testData.setDistanceBetween(4, 4, Matrix.NULL);
		testData.setDistanceBetween(4, 5, 3);
		testData.setDistanceBetween(5, 5, Matrix.NULL);
	}

	@Test
	public void test() throws FileNotFoundException {
		Matrix matrix = Matrix.buildFromFile(new File("assets/test_data"));
		assertTrue(matrix.equals(testData));
	}

}
