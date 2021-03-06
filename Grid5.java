import java.util.*;

class Grid5 {
  //Beginnings
  private int size = 129;
  private int rule = 30;
  private static int[] startstate;
  //So on
  private ArrayList<int[]> generations;

  public Grid5() {
    init();
  }

  public Grid5(int aRule) {
    rule = aRule;
    init();
  }

  public Grid5(int aRule, int aSize) {
    rule = aRule;
    size = aSize;
    init();
  }

  private void init() {
    startstate = new int[size];
    startstate[size/2] = 1;
    generations = new ArrayList<int[]>();
    generations.add(startstate);
  }

  private int[] getLastGen() {
    return generations.get(generations.size()-1);
  }

  private int getValue(int index) { //Out of bounds replace with 0
    if(index < 0) return 0;
    if(index >= getLastGen().length) return 0;
    return getLastGen()[index];
  }

  private int getRuleInput(int index) {
    return (getValue(index-2) << 4) + (getValue(index-1) << 3) + (getValue(index) << 2) + (getValue(index+1) << 1) + getValue(index+2);
  }

  public void makeNextGen() {
    int[] nextGen = new int[size];
    for(int i = 0; i < size; i++) {
      nextGen[i] = (((1 << getRuleInput(i)) & rule) != 0) ? 1 : 0;
    }
    generations.add(nextGen);
  }

  public void print() {
    for(int[] generation : generations) {
      for(int block : generation) {
        System.out.print((block == 1) ? "\u2588" : " ");
      }
      System.out.println();
    }
  }
}
