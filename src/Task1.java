import javafx.application.Platform;

import java.util.Scanner;
import java.util.concurrent.*;

/*Пользователь вводит с консоли числа A и B.
Программа спрашивает пользователя какое математическое действие надо применить к этим числам:
+ - * / % == > <
Действие пользователь вводит в виде соответствующего символа
После чего программа в отдельном потоке выполняет действие.
Результат в консоль должен вывести main поток
Решить задачу без использования глобальных переменных
*/
public class Task1 {

    public static void main(String[] args) throws ExecutionException, InterruptedException {

        System.out.println("Введите число A");
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();

        System.out.println("Введите число B");
        Scanner sc2 = new Scanner(System.in);
        int b = sc2.nextInt();

        System.out.println("Какое математическое действие надо применить к этим числам: + - * / % == > <");
        Scanner sc3 = new Scanner(System.in);
        String c = sc3.nextLine();


        ExecutorService threadPool = Executors.newFixedThreadPool(1);

        Callable<Integer> callable = new Callable<Integer>() {
            @Override
            public Integer call() throws Exception {
                int result = 0;

                switch(c) {
                    case "+":
                        result = a + b;
                        break;
                    case "-":
                        result = a - b;
                        break;
                    case "*":
                        result = a * b;
                        break;
                    case "/":
                        result = a / b;
                        break;
                    case "%":
                        result = a % b;
                        break;
                    case "==":
                        System.out.println("Ваш ответ: " + (a==b));;
                        break;
                    case ">":
                        System.out.println("Ваш ответ: " + (a>b));;
                        break;
                    case "<":
                        System.out.println("Ваш ответ: " + (a<b));;
                        break;
                    default:
                        System.out.println("Такой задачи нет");;
                        break;
                }
                System.out.println("Ваш ответ: " + result);
                Thread.sleep(300);
                return result;
            }
        };

        Future<Integer> future = threadPool.submit(callable);
        FutureTask<Integer> futureTask = new FutureTask<Integer>(callable);
        threadPool.submit(futureTask);

        System.out.println("Задачи поставленны на выполнение: ");

       // System.out.println("Callable Value: " + future.get());
        //System.out.println("FutureTask Value: " + futureTask.get());

        threadPool.shutdown();
    }


}
