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
		if (!found) {
			System.out.println(a + ", " + b + ": combo does not exist");
			return;
		}
		found = false;
		pathToB = search(root, b, "");
		if (!found) {
			System.out.println(a + ", " + b + ": combo does not exist");
			return;
		}
		found = false;
		System.out.println(pathToA + " - " + pathToB);
		int min = Math.min(pathToA.length(), pathToB.length()); // could be bad
		for (int i = 0; i < min; i++) {
			if (pathToA.charAt(0) == pathToB.charAt(0)) {
				pathToA = pathToA.substring(1);
				pathToB = pathToB.substring(1);
			} else {
				break;
			}
		}
		int length = pathToA.length() + pathToB.length();
		System.out.println("The distance between " + a + " and " + b + " is " + length);
	}

	boolean found = false;

	private String search(BinaryNode node, int target, String path) {
		if (node != null) {
			if (node.data == target) {
				found = true;
				return path;
			}  else {
				if (node.left != null) {
					path = search(node.left, target, path + "L");
					if (found) {
						return path;
					} else {
						path = path.substring(0, path.length() - 1);
					}
				}
				if (node.right != null) {
					path = search(node.right, target, path + "R");
					if (found) {
						return path;
					} else {
						path = path.substring(0, path.length() - 1);
					}
				}
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