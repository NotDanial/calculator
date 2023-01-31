
import java.util.Scanner;

class CalcException extends Exception{
    public CalcException (String s){
        System.out.println("throws Exception");
    }

}

public class Main {

    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);
        String task = reader.nextLine();
        reader.close();
        try{
            calc(task);
        } catch (CalcException s) {

        }
    }


    public static void calc(String input) throws CalcException {
        String task = input;
        String[] taskArr = task.split(" ");

        if (taskArr.length!=3){new CalcException("Уравнение введенно неверно");return;}

        int result = 0;
        int x = 0,y = 0;
        char operator = ' ';

        try{
            x = Integer.parseInt(taskArr[0]);
            y = Integer.parseInt(taskArr[2]);
        }
        catch (NumberFormatException e){
            new CalcException("Переменные введены неверно");
            return;
        }

        operator = taskArr[1].charAt(0);


        switch (operator){
            case('+'):
                result = x + y;
                break;
            case('-'):
                result = x - y;
                break;
            case('*'):
                result = x * y;
                break;
            case('/'):
                result = x / y;
                break;
            default:
                new CalcException("Оператор введен неверно");
                return;
            }
        System.out.println(result);
    }
}

