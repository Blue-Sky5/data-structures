import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main{
    public static void main(String[] args){
        boolean stay = true;
        Scanner input = new Scanner(System.in);
        int temp;
        Map<String ,Integer> data = new HashMap<>();
        //.........................
        while (stay){
            System.out.println("1. Enter new record.\n" +
                    "2. Print list of ages.\n" +
                    "3. Exit.");
            temp = input.nextInt();
            switch (temp) {
                case 3 -> stay = false;
                case 2 -> list_of_ages(data);
                case 1 -> new_record(data);
                default -> System.out.println("undefined input");
            }
        }
    }
    public static void new_record(Map<String ,Integer> data){
        Scanner input = new Scanner(System.in);
        Integer int_input;
        String String_input;
        //..............................
        System.out.println("Please Enter Name :");
        String_input = input.next();
        if(data.containsKey(String_input)){
            System.out.println("this name already is in the database. operation cancelled");
        }
        else {
            System.out.println("Please Enter Age :");
            int_input = input.nextInt();
            data.put(String_input,int_input);
        }
    }
    public static void list_of_ages(Map<String ,Integer> data){
        Map<Integer, Integer> data2 = new HashMap<>();
        if(data.isEmpty()){
            System.out.println("database is empty operation cancelled");
        }
        else {
            for(String a : data.keySet()){
                data2.put(data.get(a),0);
            }
            for(String a : data.keySet()){
                data2.replace(data.get(a), data2.get(data.get(a))+1);
            }
            for (Integer a : data2.keySet()){
                System.out.println(a +" --> "+ data2.get(a));
            }
        }
    }
}