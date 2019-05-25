package me.rpn.command;

import me.rpn.exception.InsufficientParamException;
import me.rpn.utils.PackageStack;

import java.math.BigDecimal;
import java.util.LinkedList;

import static java.math.BigDecimal.ROUND_HALF_EVEN;

public class SubtractionCommand extends AbstractCommand implements Command {

  public SubtractionCommand(PackageStack packageStack) {
    super(packageStack);
  }

  @Override
  public void execute() {

    BigDecimal second;
    BigDecimal first = null;
    LinkedList<BigDecimal> stackImage = packageStack.getStack();
    try {
      second = stackImage.pop();
      first = stackImage.pop();

      BigDecimal result = first.subtract(second);
      result.setScale(15, ROUND_HALF_EVEN);

      packageStack.getStack().push(result);
    } catch (Exception e) {
      StringBuffer accum = new StringBuffer("operator<-> insufficient params stack:");
      if (first != null) {
        accum.append(first);
      }
      throw new InsufficientParamException(accum.toString());
    }
  }
}

