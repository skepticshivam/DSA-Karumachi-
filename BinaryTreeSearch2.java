import java.util.LinkedList;
import java.util.Queue;

public class BinaryTreeSearch2 {
	public static boolean isPresent(Node root, int x) {
		if (root != null) {
			Queue<Node> q = new LinkedList<>();
			
			q.add(root);
			while (!q.isEmpty()) {
				Node n = q.poll();
			
				if (n.data == x) {
					return true;
				}
				
				if (n.left != null) {
					q.add(n.left);
				}
				if (n.right != null) {
					q.add(n.right);
				}
			}
			
			return false;
		}
		
		return false;
	}

	public static void main(String[] args) {
		Node root = new Node(1);
		root.left = new Node(2);
		root.right = new Node(3);
		root.left.left = new Node(4);
		root.left.right = new Node(5);

		System.out.println("Does 4 exist in the tree: " + isPresent(root, 4));
		System.out.println("Does 7 exist in the tree: " + isPresent(root, 7));

	}
}

class Node {
	int data;
	Node left;
	Node right;

	public Node(int data) {
		this.data = data;
	}
}

