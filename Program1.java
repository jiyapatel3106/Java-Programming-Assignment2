// Program 1:
// Find prime numbers using multithreading (Thread,
// Runnable, Executor Framework)

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Program1 {
    public static boolean isPrime(int num) {
        if (num < 2)
            return false;
        for (int i = 2; i * i <= num; i++) {
            if (num % i == 0)
                return false;
        }
        return true;
    }

    public static void printPrimes(int start, int end, String type) {
        System.out.println(type + " -> Range: " + start + " to " + end);
        for (int i = start; i <= end; i++) {
            if (isPrime(i)) {
                System.out.print(i + " ");
            }
        }
        System.out.println("\n");
    }

    static class MyThread extends Thread {
        int start, end;

        MyThread(int start, int end) {
            this.start = start;
            this.end = end;
        }

        public void run() {
            printPrimes(start, end, "Thread");
        }
    }

    static class MyRunnable implements Runnable {
        int start, end;

        MyRunnable(int start, int end) {
            this.start = start;
            this.end = end;
        }

        public void run() {
            printPrimes(start, end, "Runnable");
        }
    }

public static void main(String[] args) {
    int start = 1;
    int end = 100;
    int mid = (start + end) / 2;
    // 1. Using Thread (split into 2 threads)
    MyThread t1 = new MyThread(start, mid);
    MyThread t2 = new MyThread(mid + 1, end);
    t1.start();
    t2.start();
    // 2. Using Runnable (split into 2 threads)
    Thread r1 = new Thread(new MyRunnable(start, mid));
    Thread r2 = new Thread(new MyRunnable(mid + 1, end));
    r1.start();
    r2.start();
    // 3. Using Executor Framework
    ExecutorService executor = Executors.newFixedThreadPool(2);
    executor.execute(new MyRunnable(start, mid));
    executor.execute(new MyRunnable(mid + 1, end));
    executor.shutdown();
    }
}