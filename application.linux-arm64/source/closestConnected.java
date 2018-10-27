import processing.core.*; 
import processing.data.*; 
import processing.event.*; 
import processing.opengl.*; 

import java.util.HashMap; 
import java.util.ArrayList; 
import java.io.File; 
import java.io.BufferedReader; 
import java.io.PrintWriter; 
import java.io.InputStream; 
import java.io.OutputStream; 
import java.io.IOException; 

public class closestConnected extends PApplet {


int counter = 0;

public void setup()
{
  
  
  connectDots();
}

public void draw() {
}

public void mouseClicked() {
  connectDots();
}

public void connectDots() {
  background(10);
  int dots = PApplet.parseInt(random(6, 500));
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

class RandomDots {
  int count, x, y;
  String loca;
  int lineColor;
  ArrayList<Point> points = new ArrayList<Point>();

  RandomDots()
  {
    this.x = PApplet.parseInt(random(width));
    this.y = PApplet.parseInt(random(height));
    this.count = 0;
    this.lineColor = color(PApplet.parseInt(random(255)));
  }
}
class Point {
  int x, y;
  Point(int x2, int y2) {
    this.x = x2;
    this.y = y2;
  }
}
  public void settings() {  size(1920, 1080);  smooth(); }
  static public void main(String[] passedArgs) {
    String[] appletArgs = new String[] { "--present", "--window-color=#666666", "--stop-color=#cccccc", "closestConnected" };
    if (passedArgs != null) {
      PApplet.main(concat(appletArgs, passedArgs));
    } else {
      PApplet.main(appletArgs);
    }
  }
}
