import java.util.Random;

public class Main {
    public static void main(String[] args){
        Random he_he_he = new Random();
        BinarySearchTree Sample = new BinarySearchTree();
        int[] a_series = new int[10]; // this series contains numbers that are going to be stored inside the tree
        for (int i = 0 ; i < a_series.length; i++){
            a_series[i] = he_he_he.nextInt(30);
            Sample.insert(a_series[i]);
            System.out.println("our "+(i+1)+" th number is: "+a_series[i]);
        }
        System.out.println("Now for the search series:\n\n");
        int[] b_series = new int[5]; //this series will contain the random numbers for our tree search
        for (int i = 0 ; i < b_series.length; i++){
            b_series[i] = he_he_he.nextInt(30);
            System.out.println("our "+(i+1)+" th number is: "+a_series[i]);
            System.out.println("and the search result is: "+Sample.search(b_series[i]));
        }

    }
}

class Node{
    private int data;
    private Node left_child;
    private Node right_child;
//....................................
    public Node(int data){
        this.data = data;
        this.left_child = null;
        this.right_child = null;
    }
    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }

    public Node getLeft_child() {
        return left_child;
    }

    public void setLeft_child(Node left_child) {
        this.left_child = left_child;
    }

    public Node getRight_child() {
        return right_child;
    }

    public void setRight_child(Node right_child) {
        this.right_child = right_child;
    }
}
class BinarySearchTree{
    private Node root;
    //..............................
    public void insert(int data){
        Node node = new Node(data);

        Node focus_node = null; //the idea of node selection is from a coding website
        if(root == null){
            root = node;
            //System.out.println("root");
        }
        else{
            focus_node = root;
            //System.out.printf("the focus is "+focus_node.getData());
            while (true){
                if(node.getData() < focus_node.getData()){
                    //System.out.printf("left");
                    if(focus_node.getLeft_child() == null){
                        focus_node.setLeft_child(node);
                        System.out.println("");
                        return;
                    }
                    else {
                        focus_node = focus_node.getLeft_child();
                    }
                }
                else{
                    //System.out.printf("right");
                    if (focus_node.getRight_child() == null){
                        focus_node.setRight_child(node);
                        System.out.println();
                        return;
                    }
                    else {
                        focus_node = focus_node.getRight_child();
                    }
                }
            }
        }
    }
    public boolean search(int data){
        Node focus_node = root;
        if (root == null){
            return false;
        }
        else{
            if (root.getData() == data){
                return true;
            }
            else {
                while(true){
                    if (focus_node.getData() == data){
                        return true;
                    }
                    else {
                        if(data<focus_node.getData()){
                            if (focus_node.getLeft_child() == null){
                                return false;
                            }
                            else {
                                focus_node = focus_node.getLeft_child();
                            }
                        }
                        else {
                            if (focus_node.getRight_child() == null){
                                return false;
                            }
                            else {
                                focus_node = focus_node.getRight_child();
                            }
                        }
                    }
                    }

            }
        }
    }
}