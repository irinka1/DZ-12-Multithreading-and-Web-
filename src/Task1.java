import javafx.application.Platform;

import java.util.Scanner;
import java.util.concurrent.*;

/*The user enters numbers A and B from the console.
The program asks the user what mathematical action should be applied to these numbers:
+ - * /% ==> <
The user enters the action in the form of the corresponding symbol
After that the program executes the action in a separate thread.
The result in the console should output the main thread
Solve the problem without using global variables
*/
public class Task1 {

    public static void main(String[] args) throws ExecutionException, InterruptedException {

        System.out.println("Enter the number A");
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();

        System.out.println("Enter the number B");
        Scanner sc2 = new Scanner(System.in);
        int b = sc2.nextInt();

        System.out.println("What kind of mathematical action should be applied to these numbers?: + - * / % == > <");
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
                        System.out.println("Your Answer: " + (a==b));;
                        break;
                    case ">":
                        System.out.println("Your Answer: " + (a>b));;
                        break;
                    case "<":
                        System.out.println("Your Answer: " + (a<b));;
                        break;
                    default:
                        System.out.println("There is no such task");;
                        break;
                }
                System.out.println("Your Answer: " + result);
                Thread.sleep(300);
                return result;
            }
        };

        Future<Integer> future = threadPool.submit(callable);
        FutureTask<Integer> futureTask = new FutureTask<Integer>(callable);
        threadPool.submit(futureTask);

        System.out.println("Tasks are assigned to implementation: ");

       // System.out.println("Callable Value: " + future.get());
        //System.out.println("FutureTask Value: " + futureTask.get());

        threadPool.shutdown();
    }


}
