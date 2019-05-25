package me.rpn.command;

import me.rpn.utils.PackageStack;
import org.apache.commons.lang3.SerializationUtils;

import java.math.BigDecimal;
import java.util.LinkedList;


/**
 * 命令的抽象类
 * Create by songwenchao on 2019-05-25
 */
public abstract class AbstractCommand implements Command {

  protected LinkedList<BigDecimal> imageOfStack;

  protected PackageStack packageStack = null;

  public AbstractCommand(PackageStack packageStack) {

    this.packageStack = packageStack;
    imageOfStack = SerializationUtils.clone(packageStack.getStack());
  }

  @Override
  public abstract void execute();

  @Override
  public void undo() {
    packageStack.update(imageOfStack);
  }

}
