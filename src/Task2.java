import sun.nio.ch.ThreadPool;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.*;

import static java.lang.StrictMath.cos;
import static java.lang.StrictMath.sin;

/*Написать функцию которая создает массив интов размером size. Числа в массиве идут по возрастания от 1 до size.

С помощью этой функции создайте массив с size равным 80 000 000.

Подсчет
для каждого элемента массива подсчитать result = sin(x) + cos(x), где x - итый элемент массива.
Вывести в консоль сумму всех result для всего массива.
Распараллельте эту логику на потоки для ускорения вычислений.

Пользователю надо ввести N в консоль. N это кол-во раз, сколько надо повторить Подсчет.
Одновременно в программе может быть запущено только вычисление одного Подсчета. Но при этом саму итерацию подсчета нужно параллелить.

Программа должна во время одного запуска работать в двух режимах. И подсчитывать время которое она затратила на каждый из режимов работы.
Режим Thread. Программа создает каждый раз new Thread когда ей нужен поток.
Режим Thread Pool. Программа использует один thread pool  единожды созданный.
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

        System.out.println("Введите кол-во раз, сколько надо повторить Подсчет");
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
        System.out.println("Thread потратил времени: " + (System.currentTimeMillis() - startTime) + " Сумма = " + result6);
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
        System.out.println("ThreadPool потратил времени: " + (System.currentTimeMillis() - startTime) + " Сумма = " + result5);
    }

    private double summ(List<Integer> list, int size) {
        double result = 0;
        for (int i = 0; i < size; i++) {
            result += Math.sin(list.get(i)) + Math.cos(list.get(i));
        }
        return result;
    }


}

