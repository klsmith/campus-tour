package edu.bsu.cs224.campus.tour;

import java.util.Arrays;

public class Path {

	private int[] path;
	private int cursor;

	public static Path createForNodeCount(int nodeCount) {
		return new Path(nodeCount);
	}

	private Path(int nodeCount) {
		path = new int[nodeCount];
		Arrays.fill(path, -1);
		cursor = 0;
	}

	public void goTo(int node) {
		path[cursor] = node;
		if (!atEnd()) {
			cursor++;
		}
	}

	public boolean atEnd() {
		return cursor == path.length;
	}
}
