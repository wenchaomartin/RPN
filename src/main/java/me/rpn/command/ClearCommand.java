package me.rpn.command;

import me.rpn.utils.PackageStack;
import org.apache.commons.lang3.SerializationUtils;

import java.math.BigDecimal;
import java.util.LinkedList;
/**
 * clear命令
 * Create by songwenchao on 2019-05-25
 */
public class ClearCommand extends AbstractCommand implements Command {

  public ClearCommand(PackageStack packageStack) {
    super(packageStack);
  }

  @Override
  public void execute() {
    packageStack.getStack().clear();
  }

  @Override
  public void undo() {
    packageStack.update(imageOfStack);
  }
}
