package SaleRecord;


import java.util.Date;

public class BinaryTree {

    private Node root;

    public BinaryTree() {
        this.root = null;
    }

    public void insert(SaleRecord saleRecord) {
        Node newNode = new Node(saleRecord);

        if (this.root == null) {
            this.root = newNode;
        } else {
            insertNode(this.root, newNode);
        }
    }

    private void insertNode(Node currentNode, Node newNode) {
        if (newNode.getData().getDate().compareTo(currentNode.getData().getDate()) < 0) {
            if (currentNode.getLeft() == null) {
                currentNode.setLeft(newNode);
            } else {
                insertNode(currentNode.getLeft(), newNode);
            }
        } else {
            if (currentNode.getRight() == null) {
                currentNode.setRight(newNode);
            } else {
                insertNode(currentNode.getRight(), newNode);
            }
        }

        // Update the children count fields
        updateChildrenCountFields(currentNode);
    }

    private void updateChildrenCountFields(Node node) {
        int leftChildrenCount = node.getLeft() == null ? 0 : node.getLeft().getChildrenCount();
        int rightChildrenCount = node.getRight() == null ? 0 : node.getRight().getChildrenCount();

        node.setChildrenCount(leftChildrenCount + rightChildrenCount + 1);
    }

    public int search(Date date) {
        return searchNode(this.root, date);
    }

    private int searchNode(Node currentNode, Date date) {
        if (currentNode == null) {
            return 0;
        }

        if (date.compareTo(currentNode.getData().getDate()) == 0) {
            return currentNode.getChildrenCount();
        } else if (date.compareTo(currentNode.getData().getDate()) < 0) {
            return searchNode(currentNode.getLeft(), date);
        } else {
            return searchNode(currentNode.getRight(), date);
        }
    }

    public int recursiveSearch(Date date) {
        return recursiveSearchNode(this.root, date);
    }

    private int recursiveSearchNode(Node currentNode, Date date) {
        if (currentNode == null) {
            return 0;
        }

        if (date.compareTo(currentNode.getData().getDate()) == 0) {
            return 1;
        } else if (date.compareTo(currentNode.getData().getDate()) < 0) {
            return recursiveSearchNode(currentNode.getLeft(), date);
        } else {
            return recursiveSearchNode(currentNode.getRight(), date) + currentNode.getChildrenCount();
        }
    }

    public Node getRoot() {
        return root;
    }

    public void setRoot(Node root) {
        this.root = root;
    }

	
}
