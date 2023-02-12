public class HelloNumbers {
  public static void main(String[] args) {
      int x = 0;
      int i = 0;
      while (x < 10) {
          System.out.print(i + " ");
          x = x + 1;
          i += x;
      }
  }
}