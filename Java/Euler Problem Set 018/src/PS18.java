/*
 * Author: Brandon Bernie
 * 
 * By starting at the top of the triangle below and moving to adjacent numbers
 * on the row below, the maximum total from top to bottom is 23.
 *    3
 *   7 5
 *  2 4 6
 * 8 5 9 3
 * 
 * That is, 3 + 7 + 4 + 9 = 23.
 * Find the maximum total from top to bottom of the triangle below:
 * 
 * [edit]
 * 
 * NOTE: As there are only 16384 routes, it is possible to solve this problem
 * by trying every route. However, Problem 67, is the same challenge with a 
 * triangle containing one-hundred rows; it cannot be solved by brute force, 
 * and requires a clever method! ;o)
 */

public class PS18 {

	public static void main(String[] args) {
		   int[][] triangle =
		   {{75},
		    {95, 64},
		    {17, 47, 82},
		    {18, 35, 87, 10},
		    {20,  4, 82, 47, 65},
		    {19,  1, 23, 75,  3, 34},
		    {88,  2, 77, 73,  7, 63, 67},
		    {99, 65,  4, 28,  6, 16, 70, 92},
		    {41, 41, 26, 56, 83, 40, 80, 70, 33},
		    {41, 48, 72, 33, 47, 32, 37, 16, 94, 29},
		    {53, 71, 44, 65, 25, 43, 91, 52, 97, 51, 14},
		    {70, 11, 33, 28, 77, 73, 17, 78, 39, 68, 17, 57},
		    {91, 71, 52, 38, 17, 14, 91, 43, 58, 50, 27, 29, 48},
		    {63, 66, 04, 68, 89, 53, 67, 30, 73, 16, 69, 87, 40, 31},
		    { 4, 62, 98, 27, 23,  9, 70, 98, 73, 93, 38, 53, 60,  4, 23}};
		   long start, stop;
		   
		   start = System.nanoTime();
		   Node root = build(triangle);
		   System.out.println(maxPath(root));
		   stop = System.nanoTime();
		   System.out.println((stop - start) + " ns");
	}

	/**
	 * Starts from the "bottom" of the int[][] and builds up to the root.
	 * Returns a reference to the root node of the tree.
	 * 
	 * A Breadth-first approach
	 */
	public static Node build(int[][] vals) {
		int lastRow = vals.length - 1;
		Node[] nodes = new Node[vals[lastRow].length];

		for (int i = 0; i < nodes.length; i++) {
			nodes[i] = new Node(vals[lastRow][i], null, null);
		}

		for (int j = lastRow - 1; j >= 0; j--) {
			nodes = buildH(vals[j], nodes);
		}

		return nodes[0];

	}

	private static Node[] buildH(int[] vs, Node[] children) {
		Node[] newChildren = new Node[vs.length];
		for (int i = 0; i < newChildren.length; i++) {
			newChildren[i] = new Node(vs[i], children[i], children[i + 1]);
		}
		return newChildren;
	}

	public static int maxPath(Node n) {
		if (n.isLeaf()) {
			return n.getValue();
		}

		else {
			return n.getValue()
					+ Math.max(maxPath(n.getLeft()), maxPath(n.getRight()));
		}
	}
}

class Node {
	private int value;
	private Node left;
	private Node right;

	Node() {
		this.value = 0;
		this.left = null;
		this.right = null;
	}

	Node(int value) {
		this.value = value;
		this.left = null;
		this.right = null;
	}

	Node(int value, Node left, Node right) {
		this.value = value;
		this.left = left;
		this.right = right;
	}

	Node(Node left, Node right) {
		this.value = 0;
		this.left = left;
		this.right = right;
	}

	public boolean isLeaf() {
		return ((left == null) && (right == null));
	}

	public int getValue() {
		return this.value;
	}

	public Node getLeft() {
		return this.left;
	}

	public Node getRight() {
		return this.right;
	}

}