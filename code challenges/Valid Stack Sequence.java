import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        // O(n)
        Scanner input = new Scanner(System.in);
        int length = input.nextInt();
        int[] in = new int[length];
        int[] pattern = new int[length];
        int index_in = 0;
        int index_pattern = 0;
        stack storage = new stack(length);
        //................................
        for (int i = 0 ; i < length ; i++){
            in[i] = input.nextInt();
        }
        for (int i = 0 ; i < length ; i++){
            pattern[i] = input.nextInt();
        }
        //.................................
        while(index_in <= length){
            if(!storage.is_empty() && storage.peek() == pattern[index_pattern]){
                index_pattern+=1;
                storage.pop();
            }
            else if(index_in<length){
                storage.push(in[index_in]);
                index_in+=1;
            }
            else {
                index_in+=1;
            }
        }
        if (index_pattern == length){
            System.out.println("yes");
        }
        else {
            System.out.println("no");
        }
    }
}

class stack {
    private int[] stack;
    private int length;
    private int end = 0;

    public stack(int length){
        this.length = length;
        this.stack = new int[this.length] ;
    }
    public boolean is_full(){
        if(this.stack.length == this.end){
            return true;
        }
        else return false;
    }
    public boolean is_empty(){
        if(this.end == 0){
            return true;
        }
        else return false;
    }
    public void empty_stack(){
        this.stack = new int[this.length];
    }
    public void push(int a){
        if(is_full()){
            System.out.println("Overflow");
        }
        else {
            stack[end] = a;
            end+=1;
        }

    }
    public int pop(){
        if (is_empty()){
            return '!';
        }
        else {
            end-=1;
            return stack[end];
        }

    }
    public int peek(){      //any better solution ?
        int temp = pop();
        push(temp);
        return temp;
    }
}