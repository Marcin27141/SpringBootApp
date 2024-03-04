package com.example.springApp;

public class TestMethods {
    public static int calculateSum(int... numbers) {
        //return Arrays.stream(numbers).sum();
        int sum = 0;
        for(int number : numbers) {
            sum += number;
        }
        return sum;
    }
}
