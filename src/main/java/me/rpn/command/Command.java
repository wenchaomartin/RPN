package me.rpn.command;
/**
 * 命令接口 对应的字类
 * <p></>
 * Create by songwenchao on 2019-05-25
 */
public interface Command{
  /**
   * 命令 执行
   */
  void execute();

  /**
   * 命令撤销
   */
  void undo();

}
