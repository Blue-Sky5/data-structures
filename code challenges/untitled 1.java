import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int total = input.nextInt();
        int target = input.nextInt();
        int[][] board = new int[total][total];
        int a,b;
        int counter = 0;
        boolean root = true;
        int trigger = 0;
        //........................................

        for (int i = 0 ; i < total ; i++){
            for (int j = 0 ; j < total ; j++){
                board[i][j] = 0;
            }
        }
        for (int i = 0 ; i < total-1 ; i++){
            a = input.nextInt();
            b = input.nextInt();
            board[a-1][b-1] +=1;
            board[b-1][a-1] +=1;
        }
        for(int i = 0 ; i < total ; i++){
            if (board[target - 1][i] == 1) {
                counter+=1;
            }
        }
        if(counter == 1){
            System.out.println("Mahmood");
        }
        else {
            for(int i = 0 ; i < total ; i++){
                if(board[target-1][i] == 1){
                    trigger += salvation(board,i,target-1,total);
                }
            }
            if(counter == 2){
                if(trigger % 2 != 0){
                    System.out.println("Mahmood");
                }
                else {
                    System.out.println("Shahrooz");
                }
            }
            else {
                if(trigger % 2 != 0){
                    System.out.println("Mahmood");
                }
                else {
                    System.out.println("Shahrooz");
                }
            }
        }
    }
    public static int salvation(int[][] board , int start,int father , int limit){
        int count = 1;
        for(int i = 0 ; i < limit;i++){
            if(board[start][i] == 1 && i != father){
                count+=salvation(board,i,start,limit);
            }
        }
        return count;
    }
}


//        for (int i = 0 ; i < total ; i++){
//            for (int j = 0 ; j < total ; j++){
//                System.out.print(board[i][j]+" ");
//            }
//            System.out.println();
//        }