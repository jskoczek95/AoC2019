package AOC2019.day2;

import Utils.AOCINPUTREADER;
import java.util.List;

@SuppressWarnings("Duplicates")
public class Day2Part1 {

  public static void main(String[] args) {

    List<Integer> testList = AOCINPUTREADER.readNumList(2);

    testList.set(1,12);
    testList.set(2,2);

    for (int i = 0; i < testList.size(); i+=4) {
      if (testList.get(i) == 99) {
        System.out.println(testList);
        break;
      } else {
        if (testList.get(i) == 1) {
          testList.set(testList.get(i+3), add(testList, testList.get(i + 1), testList.get(i + 2)));
        } else {
          testList.set(testList.get(i+3), multiply(testList, testList.get(i + 1), testList.get(i + 2)));
        }
      }
    }
  }

  static int add(List<Integer> list, int firstPosition, int secondPosition) {
    return list.get(firstPosition) + list.get(secondPosition);
  }

  static int multiply(List<Integer> list, int firstPosition, int secondPosition) {
    return list.get(firstPosition) * list.get(secondPosition);
  }
}
