import java.util.Scanner;

import static java.lang.String.*;

public class Main {


    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);
        System.out.println("Enter a task: ");
        String task = reader.nextLine();
        reader.close();
        calc(task);
    }

    public static void calc(String input) {
        String task = input;
        char[] taskArr = task.toCharArray();
        String x = "";
        String y = "";
        String operator ="";
        for (int i =0; i < taskArr.length ; i++){
            if (taskArr[i] == '+' || taskArr[i] == '-' || taskArr[i] == '*'|| taskArr[i] == '/') {operator += taskArr[i];}
            else if (operator == "") {if(taskArr[i]!=' '){x += taskArr[i];}} else {if(taskArr[i]!=' '){y += taskArr[i];}}
        }

        if (operator.length() != 1 ) {System.out.println("Оператор введен неверно!");return;}

        int xI = 0; int yI = 0;

        try{
            xI = Integer.parseInt(x);
            yI = Integer.parseInt(y);
            if (xI > 10){System.out.println("Переменная введена неверно");return;}
            if (yI > 10){System.out.println("Переменная введена неверно");return;}
        } catch (java.lang.NumberFormatException e){System.out.println("Неверный формат переменной/ых");return;}


        if (operator.equals("+")){System.out.println(xI + yI);return;}
        else if (operator.equals("-")){System.out.println(xI - yI);return;}
        else if (operator.equals("/")){System.out.println(xI / yI);return;}
        else if (operator.equals("*")){System.out.println(xI * yI);return;} else {System.out.println("Оператор введен неверно!");return;}

    }
}

