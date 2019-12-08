package AOC2019.day3;

import java.util.Objects;

public class Point {

  static final Point ZERO = new Point(0, 0);

  int x;
  int y;

  Point(int x, int y) {
    this.x = x;
    this.y = y;
  }

  int dist(Point other) {
    return Math.abs(other.x - x) + Math.abs(other.y - y);
  }

  int dist() {
    return dist(Point.ZERO);
  }

  Point translate(int x, int y) {
    this.x += x;
    this.y += y;
    return this;
  }

  Point copy() {
    return new Point(x, y);
  }

  @Override
  public boolean equals(Object o) {
    if (this == o)
      return true;
    if (o == null || getClass() != o.getClass())
      return false;
    Point point = (Point) o;
    return x == point.x &&
        y == point.y;
  }

  @Override
  public int hashCode() {
    return Objects.hash(x, y);
  }
}
