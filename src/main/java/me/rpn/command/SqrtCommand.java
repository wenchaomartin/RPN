package me.rpn.command;

import me.rpn.exception.InsufficientParamException;
import me.rpn.utils.BigDecimalUtils;
import me.rpn.utils.PackageStack;

import java.math.BigDecimal;
import java.util.LinkedList;

import static java.math.BigDecimal.ROUND_HALF_EVEN;

/**
 * sqrt
 * Create by songwenchao on 2019-05-25
 */
public class SqrtCommand extends AbstractCommand implements Command {

  public SqrtCommand(PackageStack packageStack) {
    super(packageStack);
  }

  @Override
  public void execute() {

    LinkedList<BigDecimal> stackImage = packageStack.getStack();
    BigDecimal first = null;
    try {
      first = stackImage.pop();

      BigDecimal result = BigDecimalUtils.sqrt(first, 15);
      packageStack.getStack().push(result);

    } catch (Exception e) {
      StringBuffer accum = new StringBuffer("operator<sqrt> insufficient params stack:");
      throw new InsufficientParamException(accum.toString());
    }
  }
}

