import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static int k = 0;
    public static int[] new_vector(int[] vector,int ka){
        int index = 0 ;
        for(int i = vector.length -1; i>= 0; i--){
            if(vector[i] <= ka){
                index = i;
                break;
            }
        }
        return Arrays.copyOfRange(vector, 0, index+1);
    }
    public static int play(int[] vector, int ka){
        if(ka == 0){
            return 0;
        }
        vector = new_vector(vector,ka);
        int level = ka;
        int end = vector.length-1;
        int start = 0;
        while (end >= start) {
            if (vector[end] <= level) {
                end -= 1;
                start += 1;
                level -= 1;
            } else {
                end -= 1;
            }
        }
        if(level == 0){
            return ka;
        }
        else {
            return play(vector,ka-1);
        }
    }
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        int length = input.nextInt();
        int[] vector = new int[length];
        for( int i = 0 ; i < length ; i++){
            vector[i] = input.nextInt();
        }
        insertion(vector);
        for (int j : vector) {
            if (j == 1) {
                k += 1;
            } else {
                break;
            }
        }
        if(k==0){
            System.out.println(0);
        }
        else {
            System.out.println(play(vector,k));

        }

    }
    public static void insertion(int[] arr){
        int temp;
        int k;
        if(arr.length> 1) {
            for(int i = 1 ; i < arr.length;i++){
                k = i;
                for (int j = i-1 ; j >=0 ; j--){
                    if(arr[j]>arr[k]){
                        temp = arr[j];
                        arr[j] = arr[k];
                        arr[k] = temp;
                        k--;
                    }
                    else {
                        break;
                    }
                }
            }
        }
    }
}