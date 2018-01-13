import java.util.*;

class EasyDriver {
  public static void main(String[] args) {
    Scanner keyboard = new Scanner(System.in);
    for(int x = 0; x < 256; x++) {
      Grid grid = new Grid(x);
      for(int i = 0; i < 46; i++) {
        grid.makeNextGen();
      }
      System.out.println("Rule " + x);
      grid.print();
      keyboard.nextLine();
    }
  }
}
