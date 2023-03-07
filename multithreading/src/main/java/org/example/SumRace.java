package org.example;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class SumRace {
    ArrayList<Integer> numbersToBeAdded = new ArrayList<>();
    int numOfElements = 1000;
    int numOfThreads = 5;

    public void populateList(){
        for(int i = 0; i < numOfElements; i++) {
            numbersToBeAdded.add(i);
        }
    }

    public void start() throws ExecutionException, InterruptedException {
        LocalTime startTime;
        LocalTime endTime;

        startTime = LocalTime.now();
        demoFunc();
        endTime = LocalTime.now();
        System.out.println("Start time: " + startTime);
        System.out.println("End time: " + endTime);
        System.out.println("Time elapsed: " + (endTime.getNano() - startTime.getNano()));

        startTime = LocalTime.now();
        demoFunc2Exec();
        endTime = LocalTime.now();
        System.out.println("Start time: " + startTime);
        System.out.println("End time: " + endTime);
        System.out.println("Time elapsed: " + (endTime.getNano() - startTime.getNano()));
    }

    public void demoFunc(){
        ArrayList<Thread> threads = new ArrayList<>();
        ArrayList<RunnableDemo> runnables = new ArrayList<>();

        populateList();

        for (int i = 0; i < numOfThreads; i++) {
            int startOfSubList = i * numOfElements / numOfThreads;
            int endOfSubList = (i + 1) * numOfElements / numOfThreads;
            List<Integer> partialList = numbersToBeAdded.subList(startOfSubList, endOfSubList);

            RunnableDemo sum = new RunnableDemo(partialList);
            Thread t = new Thread(sum);
            t.start();
            threads.add(t);
            runnables.add(sum);
        }

        for (Thread t : threads) {
            try {
                t.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        int totalSum = 0;
        for (RunnableDemo r : runnables) {
            totalSum += r.sum;
        }
        System.out.println(totalSum);
    }

    public void demoFunc2Exec() throws ExecutionException, InterruptedException {
        ExecutorService executor = Executors.newFixedThreadPool(5);
        Future<Integer> future = executor.submit(() -> sum(numbersToBeAdded));

        Integer totalSum = future.get();
        System.out.println(totalSum);

        executor.shutdown();
    }

    private int sum(List<Integer> list) {
        int sum = 0;
        for (int i : list) {
            sum += i;
        }
        return sum;
    }
}
