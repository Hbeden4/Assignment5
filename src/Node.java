import java.util.Date;

public class Node {
    private SaleRecord data;
    private Node left;
    private Node right;
    private int childrenCount;

    public Node(SaleRecord data) {
        this.data = data;
        this.left = null;
        this.right = null;
        this.childrenCount = 1;
    }

    public SaleRecord getData() {
        return data;
    }

    public void setData(SaleRecord data) {
        this.data = data;
    }

    public Node getLeft() {
        return left;
    }

    public void setLeft(Node left) {
        this.left = left;
    }

    public Node getRight() {
        return right;
    }

    public void setRight(Node right) {
        this.right = right;
    }

    public int getChildrenCount() {
        return childrenCount;
    }

    public void setChildrenCount(int childrenCount) {
        this.childrenCount = childrenCount;
    }
}

