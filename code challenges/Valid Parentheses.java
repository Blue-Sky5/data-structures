import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        stack storage = new stack(20);
        char[] open = {'<','{','(','['};
        Scanner input = new Scanner(System.in);
        int index = 0;
        int step = input.nextInt();
        String in;
        char temp;
        boolean result ;
        //.....................................................

        for (int i = 0 ; i < step ; i++){
            result = true;
            in = input.next();
            storage.empty_stack();
            if(in.length()==0 || in.length() % 2 !=0){
                result = false;
            }
            else {
                for (int j = 0; j < in.length(); j++) {
                    if (contains(open, in.charAt(j))) {
                        storage.push(in.charAt(j));
                    }
                    else if (storage.is_empty()) {
                        result = false;
                    }
                    else {
                        temp = storage.pop();
                        switch (in.charAt(j)) {
                            case ')':
                                if(temp != '('){
                                    result = false;
                                }
                                break;
                            case '}':
                                if(temp != '{'){
                                    result = false;
                                }
                                break;
                            case ']' :
                                if(temp != '['){
                                    result = false;
                                }
                                break;
                            case '>':
                                if(temp != '<'){
                                    result = false;
                                }
                                break;
                            default:
                                System.out.println("!!!!");
                                break;
                        }
                        if (!result){
                            break;
                        }
                    }
                }
            }
            if (result){
                System.out.println("YES");
            }
            else {
                System.out.println("NO");
            }
        }


    }
    public static boolean contains(char[]a , char b){
        for (char d: a){
            if (d == b) {
                return true;
            }
        }
        return false;
    } // o(n)
}

class stack {
    private char[] stack;
    private int length;
    private int end = 0;

    public stack(int length){
        this.length = length;
        this.stack = new char[this.length] ;
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
        this.stack = new char[this.length];
    }
    public void push(char a){
        if(is_full()){
            System.out.println("Overflow");
        }
        else {
            stack[end] = a;
            end+=1;
        }

    }
    public char pop(){
        if (is_empty()){
            return '!';
        }
        else {
            end-=1;
            return stack[end];
        }

    }
}