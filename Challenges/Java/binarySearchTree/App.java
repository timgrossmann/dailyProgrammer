package binarySearchTree;

public class App {
	
	public static void main(String[] args) {
		
		Node root = new Node(5);
		
		BST tree = new BST(root);
		
		tree.insert(new Node(3));
		tree.insert(new Node(9));
		tree.insert(new Node(1));
		tree.insert(new Node(4));
		tree.insert(new Node(10));
		tree.insert(new Node(7));
		tree.insert(new Node(8));
		tree.insert(new Node(6));
		tree.insert(new Node(2));
		tree.insert(new Node(14));
		tree.insert(new Node(12));
		tree.insert(new Node(13));
		
		
		tree.printTree();
		
		System.out.println();
		
		tree.remove(tree.search(7));
		
		tree.printTree();
		
	}

}
