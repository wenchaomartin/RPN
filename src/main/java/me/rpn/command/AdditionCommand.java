package me.rpn.command;

import me.rpn.exception.InsufficientParamException;
import me.rpn.utils.PackageStack;

import java.math.BigDecimal;
import java.util.LinkedList;

/**
 * 加法命令的
 * Create by songwenchao on 2019-05-25
 */
public class AdditionCommand extends AbstractCommand implements Command {

  public AdditionCommand(PackageStack packageStack) {
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

      BigDecimal result = first.add(second);
      //Todo offer an interface of strategy

      packageStack.getStack().push(result);
    } catch (Exception e) {
      StringBuffer accum = new StringBuffer("operator<+> insufficient params stack:");
      if (second != null) {
        accum.append(second);
      }
      throw new InsufficientParamException(accum.toString());
    }
  }

}
