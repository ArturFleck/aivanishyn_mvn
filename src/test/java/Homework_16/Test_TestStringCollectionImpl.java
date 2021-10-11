package Homework_16;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Test_TestStringCollectionImpl {

    @Test
    public void test_get(){
        StringCollectionImpl data = new StringCollectionImpl();
        data.add("one");
        data.add("two");
        Assertions.assertEquals("two",data.get(1));
    }


}
