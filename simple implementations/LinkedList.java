package list;

public class LinkedList implements list{
    public Node root = null;
    //.............................
    @Override
    public void insert(int data, int index) {
        Node focus = null;
        if(this.root == null){
            if(index != 0){
                System.out.println("IndexOutOfBounds");
                throw new IndexOutOfBoundsException();
            }
            else{
                this.root = new Node();
                this.root.setData(data);
            }
        }
        else{
            int tail = this.Core_path();
            if(index < 0 || index>tail+1){
                System.out.println("IndexOutOfBounds");
                throw new IndexOutOfBoundsException();
            }
            else{
                Node temp = new Node();
                if(index == 0){
                    temp = this.root;
                    this.root = new Node();
                    this.root.setData(data);
                    this.root.setChild(temp);
                }
                else {
                    focus = root;
                    int tempr = 0;
                    while (true){
                        if (index == tempr+1){
                            temp = focus.getChild();
                            Node temp_2 = new Node();
                            temp_2.setChild(temp);
                            temp_2.setData(data);
                            focus.setChild(temp_2);
                            break;
                        }
                        else {
                            focus = focus.getChild();
                            tempr+=1;
                        }
                    }
                }
            }
        }
    }
    public int Core_path(){
        Node focus = this.root;
        int tail = 0;
        while (true){
            if(focus.getChild() == null){
                return tail;
            }
            else {
                focus=focus.getChild();
                tail+=1;
            }
        }
    }
    //...........................
    public void print_list(){
        if(root == null){
            System.out.println("null");
        }
        else {
            Node focus = root;
            while (true){
                System.out.println(focus.getData()+"-->");
                if (focus.getChild() == null){
                    break;
                }
                else{
                    focus = focus.getChild();
                }
            }
        }
    }
    //...........................
    @Override
    public void replace(int data, int index) {
        int temp = this.Core_path();
        if(index > temp || index < 0){
            System.out.println("IndexOutOfBounds");
            throw new IndexOutOfBoundsException();
        }
        else{
            Node focus = root;
            temp = 0;
            while (true){
                if(index == temp){
                    focus.setData(data);
                    break;
                }
                else {
                    focus=focus.getChild();
                    temp+=1;
                }
            }
        }
    }
    @Override
    public void delete(int index) {
        int temp = this.Core_path();
        if(index< 0 || index > temp){
            System.out.println("IndexOutOfBounds");
            throw new IndexOutOfBoundsException();
        }
        else {
            if(index == 0){
                this.root = root.getChild();
            }
            else{
                temp = 0;
                Node focus = this.root;
                Node temp2 = null;
                while (true){
                    if (index-1 == temp){
                        temp2 = focus;
                        focus = focus.getChild();
                        temp2.setChild(focus.getChild());
                        break;
                    }
                    else {
                        temp+=1;
                        focus = focus.getChild();
                    }
                }
            }
        }
    }
    @Override
    public int getData(int index) {
        int temp = this.Core_path();
        if(index > temp || index < 0){
            System.out.println("IndexOutOfBounds");
            throw new IndexOutOfBoundsException();
        }
        else{
            Node focus = root;
            temp = 0;
            while (true){
                if(index == temp){
                    return focus.getData();
                }
                else {
                    focus=focus.getChild();
                    temp+=1;
                }
            }
        }
    }
}
