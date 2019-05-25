package me.rpn.utils;

import java.math.BigDecimal;

import static java.math.BigDecimal.*;

/**
 * refer
 */
public class BigDecimalUtils {
  private static final BigDecimal TWO = BigDecimal.valueOf(2L);

  private BigDecimalUtils() {
  }

  public static BigDecimal sqrt(BigDecimal A, final int SCALE) {
    BigDecimal x0 = new BigDecimal("0");
    BigDecimal x1 = new BigDecimal(Math.sqrt(A.doubleValue()));
    while (!x0.equals(x1)) {
      x0 = x1;
      x1 = A.divide(x0, SCALE, ROUND_HALF_UP);
      x1 = x1.add(x0);
      x1 = x1.divide(TWO, SCALE, ROUND_HALF_UP);

    }
    return x1;
  }
}
