package Homework_18;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Task_1_Test {
    @Test
    public void testAverage(){
        List<Integer> average = new ArrayList<>(Arrays.asList(10,15,20,25));
        Assertions.assertEquals(17.5d,Task_1.average(average));
    }
}
