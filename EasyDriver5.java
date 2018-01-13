import java.util.*;

class EasyDriver5 {
  public static void main(String[] args) {
    Scanner keyboard = new Scanner(System.in);
    Random r = new Random();
    while(true) {
      int x = r.nextInt();
      Grid5 grid = new Grid5(x);
      for(int i = 0; i < 46; i++) {
        grid.makeNextGen();
      }
      System.out.println("Rule " + x);
      grid.print();
      keyboard.nextLine();
    }
  }
}
