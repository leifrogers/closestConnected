
int counter = 0;

void setup()
{
  size(1920, 1080);
  smooth();
  connectDots();
}

void draw() {
}

void mouseClicked() {
  connectDots();
}

void connectDots() {
  background(10);
  int dots = int(random(6, 500));
  RandomDots [] lines0 = new RandomDots[dots];
  float [] distances = new float[dots];
  for (int i=1; i<lines0.length; i++)
  {
    lines0[i] = new RandomDots();
    fill(255);
  }
  for (int i=1; i<lines0.length; i++)
  {

    for (int j=1; j<lines0.length; j++)
    {
      distances[j] = dist(lines0[i].x, lines0[i].y, lines0[j].x, lines0[j].y);
    }
    distances = sort(distances);
    for (int r=1; r<6; r++)
    {
      for (int j=1; j<lines0.length; j++)
      {
        if (distances[r] == dist(lines0[i].x, lines0[i].y, lines0[j].x, lines0[j].y))
        {
          stroke(255, 100);
          lines0[i].points.add(new Point(lines0[j].x, lines0[j].y));
        }
      }
    }
  }
  for (int i=1; i<lines0.length; i++)
  {
    int[] x3 = new int[lines0[i].points.size()];
    int[] y3 = new int[lines0[i].points.size()];
    for (int t = 0; t < lines0[i].points.size(); t++) {
      Point part = lines0[i].points.get(t);
      x3[t]=part.x;
      y3[t]=part.y;
    }
    PShape s;
    s = createShape();
    s.beginShape();
    s.fill(random(255), random(255), random(255));
    s.noStroke();
    for (int z =0; z<lines0[i].points.size(); z++) {
      s.vertex(x3[z], y3[z]);
    }
    s.endShape(CLOSE);
    shape(s);
  }
  saveFrame("closest-######.jpg");
}
