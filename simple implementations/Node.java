package list;

public class Node {
    private int data;
    private Node child = null;
    public int getData() {
        return data;
    }
    public void setData(int data) {
        this.data = data;
    }
    public Node getChild() {
        return child;
    }
    public void setChild(Node child) {
        this.child = child;
    }
    //....................................
}
