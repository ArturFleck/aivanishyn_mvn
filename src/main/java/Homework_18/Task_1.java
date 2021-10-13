package Homework_18;

import java.util.ArrayList;
import java.util.List;

public class Task_1 {
    public static void main(String[] args) {
        List<Integer> intList = new ArrayList<>();
        int sizeOfArray = 100;
        for (int i = 0; i < sizeOfArray; i++) intList.add(RandomGenerator.getIntValue(100));
        System.out.println(intList);
        System.out.println("Average of Array is: " + intList.stream().mapToInt(a ->a).average().orElse(-1));
    }
}

class RandomGenerator {
    public static int getIntValue(int maxValue) {
        return (int) (Math.random() * maxValue);
    }
}
