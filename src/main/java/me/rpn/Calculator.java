package me.rpn;

import me.rpn.command.*;
import me.rpn.utils.PackageStack;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.LinkedList;

/**
 * 计算器
 */
public class Calculator {

  private LinkedList<Command> commands = new LinkedList<>();

  private PackageStack packageStack = new PackageStack(new LinkedList<>());

  private String readStr;

  public Calculator(String readStr) {
    this.readStr = readStr;
  }

  public Calculator() {
  }

  public String calculate() {

    String[] todoCalculation = readStr.split("\\s+");
    LinkedList<String> todoCalculationStack = new LinkedList(Arrays.asList(todoCalculation));

    while (todoCalculationStack.size() > 0) {
      String todoStr = todoCalculationStack.pop();
      switch (todoStr) {

        case "+": {
          AdditionCommand additionCommand = new AdditionCommand(packageStack);
          additionCommand.execute();
          commands.push(additionCommand);
          break;
        }

        case "-": {
          SubtractionCommand subtractionCommand = new SubtractionCommand(packageStack);
          subtractionCommand.execute();
          commands.push(subtractionCommand);
          break;
        }

        case "*": {
          MultiplicationCommand multiplicationCommand = new MultiplicationCommand(packageStack);
          multiplicationCommand.execute();
          commands.push(multiplicationCommand);
          break;

        }
        case "/": {
          DivisionCommand divisionCommand = new DivisionCommand(packageStack);
          divisionCommand.execute();
          commands.push(divisionCommand);
          break;

        }
        case "sqrt": {
          SqrtCommand sqrtCommand = new SqrtCommand(packageStack);
          sqrtCommand.execute();
          commands.push(sqrtCommand);
          break;

        }
        case "clear": {
          ClearCommand clearCommand = new ClearCommand(packageStack);
          clearCommand.execute();
          commands.push(clearCommand);
          break;
        }
        case "undo": {
          Command command = commands.pop();
          command.undo();
          break;
        }
        default: {
          BigDecimal bigDecimal = new BigDecimal(todoStr);
          PushStackCommand pushStackCommand = new PushStackCommand(packageStack, bigDecimal);
          pushStackCommand.execute();
          commands.push(pushStackCommand);
        }
      }
    }
    return packageStack.toString();
  }

  public void setReadStr(String readStr) {
    this.readStr = readStr;
  }
}
