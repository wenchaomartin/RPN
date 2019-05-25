import me.rpn.Calculator;
import me.rpn.exception.InsufficientParamException;
import org.junit.Assert;
import org.junit.Test;

import java.math.BigDecimal;

public class CalculatorTest {

  @Test
  public void calculateExample1() {
    Calculator calculator = new Calculator("5 2");
    Assert.assertEquals(calculator.calculate(), "5 2");
  }

  @Test
  public void calculateExample2() {
    Calculator calculator = new Calculator("2 sqrt");
    Assert.assertEquals(calculator.calculate(), "1.4142135624");
  }

  @Test
  public void calculateExample3() {
    Calculator calculator = new Calculator("clear 9 sqrt");
    Assert.assertEquals(calculator.calculate(), "3");
  }

  @Test
  public void calculateExample4() {
    Calculator calculator = new Calculator("5 2 -");
    Assert.assertEquals(calculator.calculate(), "3");
  }

  @Test
  public void calculateExample5() {
    Calculator calculator = new Calculator("5 4 3 2 undo undo *");
    Assert.assertEquals(calculator.calculate(), "20");
  }

  @Test
  public void calculateExample6() {
    Calculator calculator = new Calculator("5 20 * undo");
    Assert.assertEquals(calculator.calculate(), "5 20");
  }

  @Test
  public void calculateExample7() {
    Calculator calculator = new Calculator("7 12 2 /");
    Assert.assertEquals(calculator.calculate(), "7 6");
  }


  @Test
  public void calculateExample8() {
    Calculator calculator = new Calculator("7 12 2 / * 4 /");
    Assert.assertEquals(calculator.calculate(), "10.5");
  }

  @Test
  public void calculateExample9() {
    Calculator calculator = new Calculator("1 2 3 4 5 * * * *");
    Assert.assertEquals(calculator.calculate(), "120");
  }

  @Test(expected = InsufficientParamException.class)
  public void calculateExample10() {
    Calculator calculator = new Calculator("1 2 3 * 5 + * * 6 5");
    Assert.assertEquals(calculator.calculate(), "120");
  }

  @Test(expected = InsufficientParamException.class)
  public void calculateExample11() {
    Calculator calculator = new Calculator("+");
    Assert.assertEquals(calculator.calculate(), "120");
  }

  @Test
  public void calculateExample12() {
    Calculator calculator = new Calculator("1 2  3 +");
    Assert.assertEquals(calculator.calculate(), "1 5");
  }

  @Test(expected = InsufficientParamException.class)
  public void calculateExample13() {
    Calculator calculator = new Calculator("1 +");
    calculator.calculate();
  }

  @Test(expected = InsufficientParamException.class)
  public void calculateExample14() {
    Calculator calculator = new Calculator("sqrt");
    calculator.calculate();
  }

  @Test
  public void calculateExample15() {
    BigDecimal first = new BigDecimal("6");
    BigDecimal second = new BigDecimal("12");
    System.out.println(first.divide(second));
  }

}