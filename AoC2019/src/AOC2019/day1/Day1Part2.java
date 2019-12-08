package AOC2019.day1;

import static Utils.AOCINPUTREADER.readNumList;

public class Day1Part2 {

  public static void main(String[] args) {

    System.out.println(getSumOfFuel());
  }

  private static int getSumOfFuel() {
    return readNumList(1).stream()
          .map(Day1Part2::calculate)
          .reduce(Integer::sum).orElse(0);
  }

  private static Integer calculate(Integer input) {
     int res = (input / 3) - 2;
     int sum = 0;
     while (res > 0) {
       sum += res;
       res = (res / 3) - 2;
     }
     return sum;
  }
}
