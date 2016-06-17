package binarySearchTree;

import java.util.ArrayList;
import java.util.List;

public class BST {

	private Node root;

	public BST(Node root) {
		this.root = root;
	}

	public void insert(Node node) {

		Node currNode = root;
		boolean found = false;

		while (!found) {

			if (currNode.value > node.value) {

				if (currNode.leftNode != null) {
					currNode = currNode.leftNode;
				} else {
					currNode.leftNode = node;
					found = true;
				}
			} else {

				if (currNode.rightNode != null) {
					currNode = currNode.rightNode;
				} else {
					currNode.rightNode = node;
					found = true;
				}
			}
		}
	}

	public Node search(int value) {

		Node currNode = root;

		if (value == root.value) {
			return root;
		}

		while (currNode != null) {

			if (currNode.value == value) {
				return currNode;
			} else if (currNode.value > value) {
				currNode = currNode.leftNode;
			} else if (currNode.value < value) {
				currNode = currNode.rightNode;
			}
		}

		return null;
	}

	public Node searchParentOf(int value) {

		Node currNode = root;

		if (value == root.value) {
			return root;
		}

		while (currNode.leftNode != null || currNode.rightNode != null) {

			if (currNode.leftNode != null && currNode.leftNode.value == value
					|| currNode.rightNode != null && currNode.rightNode.value == value) {
				return currNode;
			} else if (currNode.value > value) {
				currNode = currNode.leftNode;
			} else if (currNode.value < value) {
				currNode = currNode.rightNode;
			}
		}

		return null;
	}

	public Node searchNextBigger(Node root) {

		Node currNode = root;

		if (root.rightNode == null) {
			return null;

		} else {
			currNode = currNode.rightNode;

			while (currNode.leftNode != null) {
				currNode = currNode.leftNode;
			}

			return currNode;
		}
	}

	public void printTree() {

		List<Node> nodes = new ArrayList<>();
		List<Node> tempNodes = new ArrayList<>();
		nodes.add(root);

		while (nodes.size() != 0) {

			for (Node node : nodes) {
				if (node != null) {
					System.out.print(node.value + " ");
					tempNodes.add(node.leftNode);
					tempNodes.add(node.rightNode);
				} else {
					System.out.print(" ");
				}
			}
			nodes = new ArrayList<>(tempNodes);
			tempNodes = new ArrayList<>();

			System.out.println();

		}

	}

	public void remove(Node node) {

		Node parent = searchParentOf(node.value);

		if (node.leftNode == null && node.rightNode == null) {

			if (parent.leftNode != null && parent.leftNode.value == node.value) {
				parent.leftNode = null;
			} else {
				parent.rightNode = null;
			}

		} else if (node.leftNode != null && node.rightNode != null) {
			
			Node exchangeNode = searchNextBigger(node);
			Node parentOfExchange = searchParentOf(exchangeNode.value);
			
			if(node.leftNode.value != exchangeNode.value) {
				exchangeNode.leftNode = node.leftNode;
			}
			
			if(node.rightNode.value != exchangeNode.value) {
				exchangeNode.rightNode = node.rightNode;
			}
			
			
			if(parentOfExchange.leftNode != null && parentOfExchange.leftNode.value == exchangeNode.value) {
				parentOfExchange.leftNode = null; 
			} else {
				parentOfExchange.rightNode = null;
			}
			
			if(parent.leftNode != null && parent.leftNode.value == node.value) {
				parent.leftNode = exchangeNode;
			} else {
				parent.rightNode = exchangeNode;
			}
			

		} else if (node.leftNode != null || node.rightNode != null) {

			if (parent.leftNode != null && parent.leftNode.value == node.value && node.leftNode != null) {
				parent.leftNode = node.leftNode;

			} else if (parent.leftNode != null && parent.leftNode.value == node.value && node.rightNode != null) {
				parent.leftNode = node.rightNode;

			} else if (parent.rightNode != null && parent.rightNode.value == node.value && node.leftNode != null) {
				parent.rightNode = node.leftNode;

			} else if (parent.rightNode != null && parent.rightNode.value == node.value && node.rightNode != null) {
				parent.rightNode = node.rightNode;
			}

		}

	}

}
