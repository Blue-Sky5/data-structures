import java.io.IOException;
import java.util.Scanner;
import java.util.Stack;

public class Main {
    public static long remain = (long) Math.pow(10,9) + 7;
    public static void main(String[] args) throws IOException {
        //String input = "5*2+7*(3)-(2+((3*4))-7)+4*(6-3)";
        Scanner in = new Scanner(System.in);
        String input = in.next();
        long length = input.length();
        String temp = "";
        Stack<Long> operands = new Stack<>();
        Stack<Character> operator = new Stack<>();

        //.............................................
        for (int i = 0 ; i < length ; i++){
            if (input.charAt(i) >= '0' && input.charAt(i) <= '9') {
                temp = "";
                while (i < length && input.charAt(i) >= '0' && input.charAt(i) <= '9'){
                    temp+=input.charAt(i);
                    i+=1;
                }
                operands.push(Long.parseLong(temp));
                i--;
            }
            else if (input.charAt(i) == '('){
                operator.push(input.charAt(i));
            }
            else if (input.charAt(i) == ')') {
                while (operator.peek() != '('){
                    operands.push(calculate(operator.pop(), operands.pop(), operands.pop()));
                }
                operator.pop();
            }
            else if (input.charAt(i) == '+' || input.charAt(i) == '-' || input.charAt(i) == '*' || input.charAt(i) == '/') {
                while (!operator.empty() && hasPrecedence(input.charAt(i), operator.peek())){
                    operands.push(calculate(operator.pop(), operands.pop(), operands.pop()));
                }
                operator.push(input.charAt(i));
            }
        }
        while (!operator.empty()){
            operands.push(calculate(operator.pop(), operands.pop(), operands.pop()));
        }
        System.out.println((operands.pop() % remain + remain) % remain);
    }
    public static boolean hasPrecedence(char op1, char op2) { // for implementing this I got help from Geeks for geeks
        if (op2 == '(' || op2 == ')')
            return false;
        if ((op1 == '*' || op1 == '/') &&
                (op2 == '+' || op2 == '-'))
            return false;
        else
            return true;
    }
    public static long calculate(char operator, long b, long a) {
        if (operator == '*'){
            return (((a*b) % remain + remain) % remain);
        }
        else if (operator == '+'){
            return (((a+b) % remain + remain) % remain);
        }
        else if (operator == '-'){
            return (((a-b) % remain + remain) % remain);
        }
        else if (operator == '/'){
            return (((a/b) % remain + remain) % remain);
        }
        return 0;
    }
}

