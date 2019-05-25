package me.rpn.command;

import me.rpn.utils.PackageStack;
import org.apache.commons.lang3.SerializationUtils;

import java.math.BigDecimal;
import java.util.LinkedList;

/**
 * RPN 操作符直接进栈，进栈命令
 * Create by songwenchao on 2019-05-25
 */
public class PushStackCommand extends AbstractCommand implements Command {

  private BigDecimal number;

  public PushStackCommand(PackageStack packageStack, BigDecimal number) {
    super(packageStack);
    this.number = number;
  }

  @Override
  public void execute() {
    this.packageStack.getStack().push(number);
  }

  @Override
  public void undo() {
    packageStack.update(imageOfStack);
  }
}
