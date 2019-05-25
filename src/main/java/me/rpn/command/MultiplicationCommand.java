package me.rpn.command;

import me.rpn.exception.InsufficientParamException;
import me.rpn.utils.PackageStack;

import java.math.BigDecimal;
import java.util.LinkedList;

import static java.math.BigDecimal.ROUND_HALF_EVEN;

/**
 * 乘法命令
 * Create by songwenchao on 2019-05-25
 */
public class MultiplicationCommand extends AbstractCommand implements Command {

  public MultiplicationCommand(PackageStack packageStack) {
    super(packageStack);

  }

  @Override
  public void execute() {
    BigDecimal second = null;
    BigDecimal first = null;
    LinkedList<BigDecimal> stackImage = packageStack.getStack();
    try {

      second = stackImage.pop();
      first = stackImage.pop();

      BigDecimal result = first.multiply(second);
      result.setScale(15, ROUND_HALF_EVEN);
      packageStack.getStack().push(result);
    } catch (Exception e) {
      StringBuffer accum = new StringBuffer("operator<*> insufficient params stack:");
      if (second != null) {
        accum.append(second);
      }
      throw new InsufficientParamException(accum.toString());
    }
  }

}
