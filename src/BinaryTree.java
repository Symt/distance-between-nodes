public class BinaryTree {
	BinaryNode root;
	int length = 0;

	public BinaryTree() {
		root = null;
	}
	
	public void addNode(int data) {
		root = addNode(root, data);
	}

	private BinaryNode addNode(BinaryNode node, int data) {
		if (node == null) {
			length++;
			return new BinaryNode(data);
		}
		if (data < node.data) {
			node.left = addNode(node.left, data);
		} else if (data > node.data) {
			node.right = addNode(node.right, data);
		}
		return node;
	}

	public void distanceBetween(int a, int b) {
		String pathToA = "", pathToB = "";
		pathToA = search(root, a, "");
		found = false;
		pathToB = search(root, b, "");
		found = false;
		int min = Math.min(pathToA.length(), pathToB.length()); // could be bad
		for (int i = 0; i < min; i++) {
			if (pathToA.charAt(0) == pathToB.charAt(0)) { // bad
				pathToA = pathToA.substring(1);			  // bad
				pathToB = pathToB.substring(1);		      // bad
			} else {
				break;
			}
		}
		int length = pathToA.length() + pathToB.length();
		length = (pathToA.length() == 0 || pathToB.length() == 0) ? length : length + 1; // bad
		System.out.println("The distance between " + a + " and " + b + " is " + length);
	}

	boolean found = false;

	private String search(BinaryNode node, int search, String path) { // Definitely bad
		System.out.println(path);
		if (node != null) {
			if (node.data == search) {
				found = true;
				return path;
			}
			path = search(node.left, search, path + "L");
			if (found == true) {
				return path;
			} else if (path.length() > 1) {
				path = path.substring(0, path.length() - 1);
			}
			path = search(node.right, search, path + "R");
			if (found == true) {
				return path;
			} else if (path.length() > 1) {
				path = path.substring(0, path.length() - 1);
			}
		}
		return path;
	}

}

class BinaryNode {
	int data;
	BinaryNode left;
	BinaryNode right;

	public BinaryNode(int data) {
		this.data = data;
	}

	public BinaryNode(BinaryNode copy) {
		left = copy.left;
		right = copy.right;
		data = copy.data;
	}
}