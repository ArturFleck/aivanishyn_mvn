package Homework_16;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

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
        //StringCollectionImpl data = new StringCollectionImpl();
        StringCollectionImpl data = Mockito.mock(StringCollectionImpl.class);
        data.add("one");
        data.add("two");
        String str = "Some Text";
        data.add(str);
        System.out.println(data.size());
        Mockito.when(data.get(2)).thenReturn(str);
        Assertions.assertEquals(str, data.get(2));
        Assertions.assertEquals(3,data.size());
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
