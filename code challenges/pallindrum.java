import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        String in = input.next();
        int end = in.length() - 1;
        int start = 0;
        boolean result = true;
        while ( (end - start)>1 ){
            if(in.charAt(start) != in.charAt(end)){
                result = false;
                break;
            }
            end-= 1;
            start +=1;
        }

        if(result){
            System.out.println("Yes");
        }
        else {
            System.out.println("No");
        }
    }
}

//asymptotic : O(n)
//memory cmmplx : average ( could be more efficient)