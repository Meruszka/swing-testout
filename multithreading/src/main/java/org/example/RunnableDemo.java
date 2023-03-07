package org.example;

import java.util.List;

public class RunnableDemo implements Runnable {
    List<Integer> partialList;
    int sum = 0;

    public RunnableDemo(List<Integer> partialList) {
        this.partialList = partialList;
    }
    public void run() {
        sum = partialList.stream().mapToInt(Integer::intValue).sum();
    }

}
