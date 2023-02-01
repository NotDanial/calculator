import java.util.Scanner;

class CalcException extends Exception{
    static String error = " ";
    String exc = "throws Exception";
    public CalcException (String s){
        error = s;
        System.out.println(exc);
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
            /*  В случае нужды вывода описания ошибки - убрать комментирование
            System.out.println(CalcException.error);*/
        }

    }


    public static String calc(String input) throws CalcException {
        String task = input;
        String[] taskArr = task.split(" ");
        /*Если уравнение содержит больше двух переменных,или в случае наличия одной переменной*/
        if (task.length()<5 || taskArr.length>7){throw new CalcException("Уравнение введенно неверно");}

        int result = 0;
        int x = 0,y = 0;
        String operator = " ";

        try{
            x = Integer.parseInt(taskArr[0]);
            y = Integer.parseInt(taskArr[2]);
        } /*Если переменными не являются целые числа*/
        catch (NumberFormatException e){
            throw new CalcException("Переменные введены неверно");
        }
        /*Если переменнымые больше 10 или меньше 1*/
        if (x > 10 || y >10 || x <1 || y<1) {throw new CalcException("Переменные могут принимать значение в области [1,10]");}

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
                /*Неуверен в нужде данной проверки,так как переменная не может быть равна 0*/
                try {result = x / y;} catch (ArithmeticException s){ throw new CalcException("Не дели на ноль...");}
                break;
            default:
                /*Оператор введен некоректно*/
                throw new CalcException("Оператор введен некорректно (+,*,/,-)");
        }
        return String.valueOf(result);
    }
}