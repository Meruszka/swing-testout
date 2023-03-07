package org.example;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class SumRace {
    public LocalTime startTime;
    public LocalTime endTime;

    public void sumRace() {
    }

    public void start(){
        startTime = LocalTime.now();
        demoFunc();
        endTime = LocalTime.now();
        System.out.println("Start time: " + startTime);
        System.out.println("End time: " + endTime);
        System.out.println("Time elapsed: " + (endTime.getNano() - startTime.getNano()));
    }

    public void demoFunc(){
        ArrayList<Integer> numbersToBeAdded = new ArrayList<>();
        ArrayList<Thread> threads = new ArrayList<>();
        ArrayList<RunnableDemo> runnables = new ArrayList<>();
        int numOfElements = 10;
        int numOfThreads = 2;

        for(int i = 0; i < numOfElements; i++) {
            numbersToBeAdded.add(i);
        }
        for (int i = 0; i < numOfThreads; i++) {
            List<Integer> partialList = numbersToBeAdded.subList(i * numOfElements / numOfThreads, (i + 1) * numOfElements / numOfThreads);
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
}
