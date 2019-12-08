package AOC2019.day1;

import static Utils.AOCINPUTREADER.readNumList;

@SuppressWarnings("Duplicates")
public class Day1Part1 {


  public static void main(String[] args) {

    int sum = readNumList(1).stream()
        .map(input -> input / 3 - 2)
        .reduce(Integer::sum).orElse(0);

    System.out.println(sum);
  }
}
