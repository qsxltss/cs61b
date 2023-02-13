import java.time.Year;

/** 模型？ */
public class NBody{
  /** 返回模型星系的星球个数 */
  private static int readNumber(String s)
  {
    In x = new In(s);
    int n = x.readInt();
    return n;
  }
  /** 返回模型星系的半径 */
  public static double readRadius(String s)
  {
    In x = new In (s);
    int n = x.readInt();
    double r = x.readDouble();
    return r;
  }
  /** 返回给定特性的星球s */
  public static Planet[] readPlanets(String s)
  {
    In x = new In(s);
    int n = x.readInt();//n个
    double r = x.readDouble(); //useless
    Planet[] y = new Planet [n];
    for(int i = 0; i<n; i++)
    {
      double xp = x.readDouble();
      double yp = x.readDouble();
      double xv = x.readDouble();
      double yv = x.readDouble();
      double m = x.readDouble();
      String file = x.readString();
      y[i] = new Planet(xp,yp,xv,yv,m,file);
    }
    return y;
  }
  public static void main(String[] args)
  {
    if(args.length != 3)
    {
      System.out.println("参数个数有误");
    }
    double T = Double.parseDouble(args[0]);
    double dt = Double.parseDouble(args[1]);
    String filename = args[2];
    double r = readRadius(filename);
    int n = readNumber(filename);
    Planet []p = readPlanets(filename);

    /*背景 */
    StdDraw.setScale(-r, r);
    String pic_file = "images/starfield.jpg";
    StdDraw.picture(0,0, pic_file);
    
    /* 画上星球 */
    for(Planet x : p)
    {
      x.draw();
    }
    /* 动态 */
    StdDraw.enableDoubleBuffering();
    int time = 0;
    while(time < T)
    {
      double[] xforces = new double[n];
      double[] yforces = new double[n];
      for(int i = 0; i<n; i++)
      {
        xforces[i] = p[i].calcNetForceExertedByX(p);
        yforces[i] = p[i].calcNetForceExertedByY(p);
      }
      for(int i = 0; i<n; i++)
      {
        p[i].update(dt, xforces[i], yforces[i]);
        p[i].draw();
      }
      StdDraw.show();
      StdDraw.pause(10);
      time += dt;
    }
    StdOut.printf("%d\n", p.length);
    StdOut.printf("%.2e\n", r);
    for (int i = 0; i < p.length; i++) 
    {
      StdOut.printf("%11.4e %11.4e %11.4e %11.4e %11.4e %12s\n",p[i].xxPos, p[i].yyPos, p[i].xxVel,p[i].yyVel, p[i].mass, p[i].imgFileName);   
    }
  }
}
