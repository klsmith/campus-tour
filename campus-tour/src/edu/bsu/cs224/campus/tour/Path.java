package edu.bsu.cs224.campus.tour;

public class Path {

	// number of nodes is n, beginning point is x[], matrix is c[][], symbol of
	// node is:0,1,2,.....,n-1
	public void findPath(int n, int origin[], int matrix[][]) {

		boolean[] used = new boolean[n]; // record how many nodes have been used
		// initial vector x[], used vector s[]
		for (int i = 0; i < n; i++) {
			origin[i] = -1;
			used[i] = false;
		}

		used[0] = true;
		origin[0] = 0; // begins with 0
		int k = 1; //initial depth is 1, for n nodes and origin is given(k=0), depth is n-1(1 to n-1)
		while (k >= 0) {

			origin[k] = origin[k] + 1; // next nodes
			while (origin[k] < n) {
				// if x[k] is not used and linked with previous node x[k-1]
				if ((!used[origin[k]]) && (matrix[origin[k - 1]][origin[k]] == 1)) 
					break;
				else
					origin[k] = origin[k] + 1; //find next
			}

			if ((origin[k] < n) && (k != n - 1)) { //success, depth+1
				used[origin[k]] = true;
				k = k + 1;
			} else if ((origin[k] < n) && (k == n - 1)
					&& (matrix[origin[k]][origin[0]] == 1)) { // done, and is the last node
				break;
			} else { // search fail, back to previous node and recover
				origin[k] = -1;
				k = k - 1;
				used[origin[k]] = false;
			}

		}
	}
}