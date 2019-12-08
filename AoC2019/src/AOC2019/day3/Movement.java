package AOC2019.day3;

import static AOC2019.day3.Direction.*;

import java.util.ArrayList;
import java.util.List;

public class Movement {

  private final Direction direction;
  private final int length;

  Movement(Direction direction, int length) {
    this.direction = direction;
    this.length = length;
  }

  static Movement parse(String input) {
    if (input == null || input.length() == 0) {
      return null;
    }
    char dir = input.charAt(0);
    Direction res;
    switch (dir) {
      case 'U':
        res = UP;
        break;
      case 'R':
        res = RIGHT;
        break;
      case 'D':
        res = DOWN;
        break;
      case 'L':
        res = LEFT;
        break;
      default:
        return null;
    }

    int length = getNumber(input.substring(1));
    if (length < 0) {
      return null;
    }
    return new Movement(res, length);
  }

  int horizontal() {
    return direction == RIGHT ? length : direction == LEFT ? -length : 0;
  }

  int vertical() {
    return direction == DOWN ? length : direction == UP ? -length : 0;
  }

  private static int getNumber(String input) {
    try {
      return Integer.parseInt(input);
    } catch (NumberFormatException expected) {
      return -1;
    }
  }

  List<Point> getPoints(Point start) {
    List<Point> result = new ArrayList<>();
    int h = Integer.compare(horizontal(), 0); //1, -1 albo 0
    int v = Integer.compare(vertical(), 0);
    for (int i = 1; i <= length; i++) {
      result.add(start.copy().translate(h * i, v * i));
    }
    return result;
  }
}
