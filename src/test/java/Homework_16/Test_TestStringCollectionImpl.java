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

    @Test
    public void test_add(){
        StringCollectionImpl data = new StringCollectionImpl();
        String str = "Some Text";
        Assertions.assertEquals(data.add(str), data.contains(str));
    }

    @Test
    public void test_addByIndex(){
        StringCollectionImpl data = new StringCollectionImpl();
        data.add("one");
        data.add("two");
        String str = "Some Text";
        Assertions.assertEquals(data.add(1,str), data.contains(str));
    }


}
