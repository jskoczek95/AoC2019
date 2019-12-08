package AOC2019.day2;

import Utils.AOCINPUTREADER;
import java.util.List;

@SuppressWarnings("Duplicates")
public class Day2Part2 {

  private static final int OUTPUT = 19690720;

  public static void main(String[] args) {

    List<Integer> testList;

    for(int i=0; i<100; i++) {
      for(int j=0; j<100; j++) {
        testList = AOCINPUTREADER.readNumList(2);
        testList.set(1, i);
        testList.set(2, j);
        if(gravityOutput(testList) == OUTPUT) {
          System.out.println("Noun " + testList.get(1) + " | Verb " + testList.get(2));
          break;
        }
      }
    }
  }

  private static int gravityOutput(List<Integer> testList) {
    for (int i = 0; i < testList.size(); i+=4) {
      if (testList.get(i) == 99) {
        break;
      } else {
        if (testList.get(i) == 1) {
          testList.set(testList.get(i+3), add(testList, testList.get(i + 1), testList.get(i + 2)));
        } else {
          testList.set(testList.get(i+3), multiply(testList, testList.get(i + 1), testList.get(i + 2)));
        }
      }
    }
    return testList.get(0);
  }

  static int add(List<Integer> list, int firstPosition, int secondPosition) {
    return list.get(firstPosition) + list.get(secondPosition);
  }

  static int multiply(List<Integer> list, int firstPosition, int secondPosition) {
    return list.get(firstPosition) * list.get(secondPosition);
  }
}
