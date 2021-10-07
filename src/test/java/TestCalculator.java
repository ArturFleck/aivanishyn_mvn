import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TestCalculator {

    @Test
    public void test_sum_normal_case() {
        Assertions.assertEquals(5, Calculator.sum(3, 2));
    }

    @Test
    public void test_mult_normal_case() {
        Assertions.assertEquals(6, Calculator.mult(3, 2));
    }

    @Test
    public void test_div_normal_case() {
        Assertions.assertEquals(2, Calculator.div(4, 2));
    }

    @Test
    public void test_division_by_zero(){
        Assertions.assertThrows(ArithmeticException.class, ()-> Calculator.div(4, 0) );
    }
}
