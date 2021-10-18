package homework_18;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Task_2_3_Test {

    private List<String> myList;

    @BeforeEach
    public void setUp(){
        myList = new ArrayList<>(Arrays.asList("my","new","array","contain","only","simple","Word"));
    }

    @Test   // Task 2
    public void testUppercaseAndVowels(){
        List<String> expected = new ArrayList<>(Arrays.asList("ARRAY","ONLY","WORD"));
        List<String> actual = new ArrayList<>(Task_2_3.sortList(myList));
        Assertions.assertEquals(expected,actual);
    }

    @Test
    public void testWordLengthAndLowercase(){
        List<String> expected = new ArrayList<>(List.of("only"));
        List<String> actual = new ArrayList<>(Task_2_3.sortByLowerCaseAndLength(myList));
        Assertions.assertEquals(expected,actual);
    }
}
