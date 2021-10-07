import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TestCalculator {

@Test
    public void test_sum_normal_case(){
    Assertions.assertEquals(4,Calculator.sum(3,2));
    }
}
