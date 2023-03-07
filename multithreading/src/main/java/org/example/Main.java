package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;

public class Main {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        SumRace sumRace = new SumRace();
        sumRace.start();
    }
}