import java.util.Scanner;

class CalcException extends Exception{
    public String  CalcException (String s){
        s = "throws Exception";
        return s;
    }

}

public class Main {

    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);
        String task = reader.nextLine();
        reader.close();
        try{
            System.out.println(calc(task));
        } catch (CalcException s) {

        }
    }


    public static String calc(String input) throws CalcException {
        String task = input;
        String[] taskArr = task.split(" ");
        String error = " ";

        if (taskArr.length!=3){new CalcException();return error = "throws Exception";}

        int result = 0;
        int x = 0,y = 0;
        String operator = " ";

        try{
            x = Integer.parseInt(taskArr[0]);
            y = Integer.parseInt(taskArr[2]);
        }
        catch (NumberFormatException e){
            new CalcException();return error = "throws Exception";
        }

        if (x > 10 || y >10 || x <1 || y<1) {new CalcException();return error = "throws Exception";}
        operator = taskArr[1];


        switch (operator){
            case("+"):
                result = x + y;
                break;
            case("-"):
                result = x - y;
                break;
            case("*"):
                result = x * y;
                break;
            case("/"):
                result = x / y;
                break;
            default:
                new CalcException();return error = "throws Exception";
        }
        return String.valueOf(result);
    }
}