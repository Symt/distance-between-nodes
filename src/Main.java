import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Stack;
import java.util.concurrent.ThreadLocalRandom;

import javax.swing.JFrame;

public class Main extends JFrame {
	BinaryTree tree = new BinaryTree();
	
	public static void main(String[] args) {
		new Main("GUI");
	}

	Main(String title) {
		super(title);
		tree.addNode(6);
		tree.addNode(4);
		tree.addNode(8);
		tree.addNode(3);
		tree.addNode(5);
		tree.addNode(7);
		tree.addNode(9);
		tree.distanceBetween(98, 23);
		setSize(500, 500);
		setLocationRelativeTo(null);
		setVisible(true);
		setBackground(Color.white);
		repaint();
	}

	public static int random(int low, int high) {
		return ThreadLocalRandom.current().nextInt(low, high);
	}

	public void paint(Graphics g) {
		BinaryNode node = tree.root;
		Stack<BinaryNode> nodes = new Stack<BinaryNode>();
		Stack<ArrayList<Integer>> nodePositions = new Stack<ArrayList<Integer>>();
		nodes.push(node);
		ArrayList<Integer> temp = new ArrayList<Integer>();
		temp.add(this.getWidth() / 2 - 20);
		temp.add(35);
		temp.add(this.getWidth() / 2 - 8);
		temp.add(60);
		nodePositions.push(temp);
		g.setColor(Color.black);
		g.drawOval(nodePositions.peek().get(0), nodePositions.peek().get(1), 40, 40);
		g.drawString(Integer.toString(nodes.peek().data), nodePositions.peek().get(2), nodePositions.peek().get(3));
		String direction = "";
		while (!nodes.isEmpty()) {
			temp = new ArrayList<Integer>();
			if (nodes.peek().left != null) {
				direction = "left";
				nodes.push(nodes.peek().left);
				temp.add(nodePositions.peek().get(0) - 40);
				temp.add(nodePositions.peek().get(1) + 40);
				temp.add(nodePositions.peek().get(2) - 40);
				temp.add(nodePositions.peek().get(3) + 40);
				nodePositions.push(temp);
				g.drawOval(nodePositions.peek().get(0), nodePositions.peek().get(1), 40, 40);
				g.drawString(Integer.toString(nodes.peek().data), nodePositions.peek().get(2),
						nodePositions.peek().get(3));
			} else if (nodes.peek().right != null) {
				direction = "right";
				nodes.push(nodes.peek().right);
				temp.add(nodePositions.peek().get(0) + 40);
				temp.add(nodePositions.peek().get(1) + 40);
				temp.add(nodePositions.peek().get(2) + 40);
				temp.add(nodePositions.peek().get(3) + 40);
				nodePositions.push(temp);
				g.drawOval(nodePositions.peek().get(0), nodePositions.peek().get(1), 40, 40);
				g.drawString(Integer.toString(nodes.peek().data), nodePositions.peek().get(2),
						nodePositions.peek().get(3));
			} else {
				if (direction.equals("left")) {
					nodes.pop();
					nodePositions.pop();
					if (!nodes.isEmpty())
						nodes.peek().left = null;
				} else if (direction.equals("right")) {
					nodes.pop();
					nodePositions.pop();
					if (!nodes.isEmpty())
						nodes.peek().right = null;
				}
			}
		}
	}
}