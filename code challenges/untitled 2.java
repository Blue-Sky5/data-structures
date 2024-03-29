import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int row ,col;
        row = input.nextInt();
        col = input.nextInt();
        String temp ;
        boolean check = true;
        //.........................................
        nody[][] board = new nody[row][col];
        temp = input.nextLine();
        for(int i = 0 ; i < row ; i++){
            temp = input.nextLine();
            for (int j = 0 ; j < col ; j++){
                if(temp.charAt(j) == '*'){
                    board[i][j] = new nody(0,true);
                }
                else {
                    board[i][j] = new nody(0,false);
                }
            }
        }

        while (check){
            check = ant_operation(board,row,col);
        }
        int fin_ans = 0;
        for(int i = 0 ; i < row ; i++){
            for (int j = 0 ; j < col ; j++){
                if(board[i][j].is_occupied){
                    fin_ans+=1;
                }
            }

        }
        System.out.println(fin_ans);
    }
    public static boolean ant_operation(nody[][] board , int row , int col){
        boolean result = false;
        int counter;
        for(int i = 0 ; i < row ; i++){
            for (int j = 0 ; j < col ; j++) {
                counter = 0;
                if(!board[i][j].is_occupied){
                    if(i != 0){
                        if(board[i-1][j].is_occupied){
                            counter+=1;
                        }
                    }
                    if(i != (row-1)){
                        if(board[i+1][j].is_occupied){
                            counter+=1;
                        }
                    }
                    if(j != 0){
                        if(board[i][j-1].is_occupied){
                            counter+=1;
                        }
                    }
                    if(j!= (col-1)){
                        if(board[i][j+1].is_occupied){
                            counter+=1;
                        }
                    }
                    if(counter>1){
                        board[i][j].is_occupied = true;
                        result = true;
                    }
                }
            }
        }
        return result;
    }

}
class nody {
    public int value;
    public boolean is_occupied;

    public nody(int value,boolean is_occupied) {
        this.value = value;
        this.is_occupied = is_occupied;
    }
}


