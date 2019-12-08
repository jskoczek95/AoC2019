package AOC2019.day3;

import Utils.AOCINPUTREADER;
import java.util.List;

@SuppressWarnings("Duplicates")
public class Day3Part1 {

  static List<String> lines = AOCINPUTREADER.readEachLineToList(3);

  public static void main(String[] args) {

    Path p1 = new Path();
    p1.readInstruction(lines.get(0));

    Path p2 = new Path();
    p2.readInstruction(lines.get(1));

    p1.solveFirstPart(p2);
  }
}
