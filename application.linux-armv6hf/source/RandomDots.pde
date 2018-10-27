
class RandomDots {
  int count, x, y;
  String loca;
  color lineColor;
  ArrayList<Point> points = new ArrayList<Point>();

  RandomDots()
  {
    this.x = int(random(width));
    this.y = int(random(height));
    this.count = 0;
    this.lineColor = color(int(random(255)));
  }
}
