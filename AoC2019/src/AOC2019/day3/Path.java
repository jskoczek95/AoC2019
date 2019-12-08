package AOC2019.day3;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Path {

  private final List<Movement> movementList = new ArrayList<>();

  void readInstruction(String instruction) {
    if (instruction.contains(",")) {
      readInstructions(instruction.split(","));
      return;
    }

    Movement next = Movement.parse(instruction);
    movementList.add(next);
  }

  private void readInstructions(String... instructions) {
    for (String instruction : instructions) {
      readInstruction(instruction);
    }
  }

  void solveFirstPart(Path secondPath) {

    List<Point> otherPoints = secondPath.getAllPoints();
    List<Point> myPoints = getAllPoints();

    List<Point> intersections = myPoints.stream()
        .filter(item -> !item.equals(Point.ZERO))
        .filter(otherPoints::contains)
        .collect(Collectors.toList());

    intersections.sort(Comparator.comparingInt(Point::dist));

    System.out.println("SOLUTION PART ONE: " + intersections.get(0).dist());

    Map<Integer, Point> distances = new HashMap<>();
    intersections.forEach(i -> {
      int first = myPoints.indexOf(i);
      int second = otherPoints.indexOf(i);
      distances.put(first + second, i);
    });

    List<Integer> items = new ArrayList<>(distances.keySet());
    items.sort(Integer::compareTo);
    System.out.println("SOLUTION PART TWO: " + items.get(0));
  }


  private List<Point> getAllPoints() {
    List<Point> result = new ArrayList<>();

    result.add(new Point(0, 0));

    for (Movement movement : movementList) {
      result.addAll(movement.getPoints(result.get(result.size() - 1)));
    }

    return result;
  }
}
