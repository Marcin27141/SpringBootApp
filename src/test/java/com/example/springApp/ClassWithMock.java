package com.example.springApp;

public class ClassWithMock {
    private final INumbersProvider numbersProvider;

    public ClassWithMock(INumbersProvider numbersProvider) {
        this.numbersProvider = numbersProvider;
    }

    public int getSmallestNumber() {
        var numbers = numbersProvider.numbers();
        if (numbers.length > 0) {
            int smallest = numbers[0];
            for (int number : numbersProvider.numbers()) {
                 if (number < smallest)
                     smallest = number;
            }
            return smallest;
        }
        return -1;
    }
}

