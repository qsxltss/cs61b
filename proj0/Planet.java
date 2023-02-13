public class Planet {
  public double xxPos ;
  public double yyPos ;
  public double xxVel ;
  public double yyVel ;
  public double mass ; //质量
  public String imgFileName;
  static double G = 6.67e-11;
  /** 第一种构造 */
  public Planet(double xP, double yP, double xV, double yV, double m, String img)
  {
    this.xxPos = xP;
    this.yyPos = yP;
    this.xxVel = xV;
    this.yyVel = yV;
    this.mass = m;
    this.imgFileName = img;
  }
  /** 第二种构造 */
  public Planet(Planet p)
  {
    this.xxPos = p.xxPos;
    this.yyPos = p.yyPos;
    this.xxVel = p.xxVel;
    this.yyVel = p.yyVel;
    this.mass = p.mass;
    this.imgFileName = p.imgFileName;
  }
  /** 第三种构造 */
  public Planet()
  {
    xxPos = 0;
    yyPos = 0;
    xxVel = 0;
    yyVel = 0;
    mass = 0;
    imgFileName = "";
  }
  /** 计算距离*/
  public double calcDistance(Planet p)
  {
    double dis_x = (this.xxPos - p.xxPos) * (this.xxPos - p.xxPos);
    double dis_y = (this.yyPos - p.yyPos) * (this.yyPos - p.yyPos);
    return Math.sqrt(dis_x+dis_y); //java的开根
  }
  /** 计算受力 */
  public double calcForceExertedBy(Planet p)
  {
    double dist = calcDistance(p);
    if(dist == 0) return 0;
    return G * this.mass * p.mass / (dist * dist);
  }
  /** 计算X Y轴的受力 */
  public double calcForceExertedByX(Planet p)
  {
    double dis_x = p.xxPos - this.xxPos;
    double F = calcForceExertedBy(p);
    double dist = calcDistance(p);
    if(dist == 0) return 0;
    return F * dis_x / dist;
  }
  public double calcForceExertedByY(Planet p)
  {
    double dis_y = p.yyPos - this.yyPos;
    double F = calcForceExertedBy(p);
    double dist = calcDistance(p);
    if(dist == 0) return 0;
    return F * dis_y / dist;
  }
  /** 合力 */
  public double calcNetForceExertedByX(Planet[] p)
  {
    double sum = 0;
    for(int i = 0; i<p.length ; i++)
    {
      sum += calcForceExertedByX(p[i]);
    }
    return sum;
  }
  public double calcNetForceExertedByY(Planet[] p)
  {
    double sum = 0;
    for(Planet x:p)
    {
      sum += calcForceExertedByY(x);
    }
    return sum;
  }
  public void update(double dt,double fx,double fy)
  {
    double ax = fx/this.mass;
    double ay = fy/this.mass;
    this.xxVel += ax * dt;
    this.yyVel += ay * dt;
    this.xxPos += this.xxVel * dt;
    this.yyPos += this.yyVel * dt;
  }
  /** 画出这个星球 */
  public void draw()
  {
    String img = "images/"+imgFileName;
    StdDraw.picture(this.xxPos, this.yyPos, img);
  }
}
