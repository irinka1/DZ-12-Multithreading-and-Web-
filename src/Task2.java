import sun.nio.ch.ThreadPool;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.*;

import static java.lang.StrictMath.cos;
import static java.lang.StrictMath.sin;

/*Write a function that creates an array of ints of size. The numbers in the array are ascending from 1 to size.

With this function, create an array with size equal to 80,000,000.

Count
for each element of the array, calculate result = sin (x) + cos (x), where x is the element of the array.
Output to the console the sum of all result for the entire array.
Parallel this logic to threads for faster computation.

The user must enter N into the console. N is the number of times to repeat the Count.
At the same time, only one calculation can be started in the program. But the iteration of counting should be paralleled.

The program must operate in two modes during one run. And to count the time that she spent on each of the modes of operation.
Thread mode. The program creates each time a new Thread when it needs a thread.
Thread Pool Mode. The program uses one thread pool once created.
*/
public class Task2 {

    public int size = 8;
    ExecutorService threadPool = Executors.newFixedThreadPool(4);

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        Task2 task2 = new Task2();
        task2.start();
    }

    public void start()throws ExecutionException, InterruptedException{
        int size = 8;

        System.out.println("Enter the number of times you want to repeat Counting");
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        List<Integer> result = new ArrayList<>(size);

        for (int i = 0; i < size; i++) {
            result.add(i);
        }
        for (int i1 = 0; i1 < N; i1++){
            threadMethod(result);
            threadPoolMethod(result);
        }
    }

    private void threadMethod(List<Integer> result) throws ExecutionException, InterruptedException {
        long startTime = System.currentTimeMillis();
        List<FutureTask> result4 = new ArrayList<>();
            FutureTask<Double> futureTask = new FutureTask<>(() -> summ(result, size));
            new Thread(futureTask).start();
            result4.add(futureTask);
        double result6 = 0;
        for (FutureTask future : result4) {
            result6 += (double) future.get();
        }
        System.out.println("Thread spent time: " + (System.currentTimeMillis() - startTime) + " Amount = " + result6);
    }


    private void threadPoolMethod(List<Integer> result) throws ExecutionException, InterruptedException {
        long startTime = System.currentTimeMillis();
        List <FutureTask> result3 = new ArrayList<>();
            FutureTask <Double> futureTask = new FutureTask<>(() ->
                    summ(result,size));
        threadPool.submit(futureTask);
        result3.add(futureTask);

        double result5 = 0;
        for (FutureTask future : result3) {
            result5 += (double) future.get();
        }
        System.out.println("ThreadPool spent time: " + (System.currentTimeMillis() - startTime) + " Amount = " + result5);
    }

    private double summ(List<Integer> list, int size) {
        double result = 0;
        for (int i = 0; i < size; i++) {
            result += Math.sin(list.get(i)) + Math.cos(list.get(i));
        }
        return result;
    }


}

