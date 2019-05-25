package me.rpn.utils;

import java.math.BigDecimal;
import java.util.LinkedList;

public class PackageStack {

  private LinkedList<BigDecimal> stack;

  public PackageStack(LinkedList<BigDecimal> stack) {
    this.stack = stack;
  }

  public void update(LinkedList<BigDecimal> stack) {
    this.stack = stack;
  }

  public LinkedList<BigDecimal> getStack() {
    return stack;
  }


  @Override
  public String toString() {
    StringBuffer stringBuffer = new StringBuffer();

    for (int i = stack.size() - 1; i >= 0; i--) {
      stringBuffer.append(stack.get(i).setScale(10, BigDecimal.ROUND_HALF_EVEN).stripTrailingZeros().toPlainString()).append(" ");
    }
    return stringBuffer.toString().trim();

  }
}
