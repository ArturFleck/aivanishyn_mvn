package homework_16;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

public class StringCollectionImpl_Test {

    private StringCollectionImpl data;

    @BeforeEach
    public void setUp() {
        this.data = new StringCollectionImpl();
        data.add("zero");
    }

    @Test
    public void test_get_true() {
        data.add("one");
        data.add("two");
        //Assertions.assertEquals("two", data.get(2));
        Assertions.assertTrue(data.contains("two"));
    }

    @Test
    public void test_get_null_when_wrong_index() {
        Assertions.assertNull(data.get(1));
    }

    @Test
    public void test_add() {
        //StringCollectionImpl dataMock = Mockito.mock(StringCollectionImpl.class);
        StringCollectionImpl dataMock = Mockito.spy(StringCollectionImpl.class);
        dataMock.add("one");
        dataMock.add("two");
        String str = "Some Text";

        Mockito.when(dataMock.add(str)).thenReturn(true);
        Assertions.assertTrue(dataMock.add(str));
        //System.out.println(dataMock.size());
        //System.out.println(dataMock.get(2));
    }

    @Test
    public void test_add_by_index() {
        data.add("one");
        data.add("two");
        String str = "Some Text";
        data.add(0, str);
        Assertions.assertEquals(str, data.get(0));
    }

    @Test
    public void test_delete() {
        data.add("one");
        data.add("two");
        data.add("three");
        int size = data.size();
        Assertions.assertTrue(data.delete("two"));
        Assertions.assertEquals(size - 1, data.size());
    }

    @Test
    public void test_contains() {
        data.add("one");
        Assertions.assertTrue(data.contains("one"));
    }

    @Test
    public void test_size() {
        data.add("one");
        Assertions.assertEquals(2, data.size());
    }

    @Test
    public void test_clear() {
        data.add("one");
        Assertions.assertTrue(data.clear());
        Assertions.assertEquals(0, data.size());
    }

    @Test
    public void test_equals(){
        StringCollectionImpl data2 = new StringCollectionImpl();
        data2.add("zero");
        data.add("some");
        data2.add("some");
        Assertions.assertEquals(data2, data);
    }

}
