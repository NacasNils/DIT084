import java.util.*;
import java.util.function.IntBinaryOperator;

public class UpdatedSet {
  private ArrayList<Integer> a;

  public UpdatedSet() {
    a = new ArrayList<Integer>();
  }

  public int[] toArray() {
    int[] ia = new int[a.size()];
    for (int i = 0; i < ia.length; i++) {
      ia[i] = a.get(i);
    }
    return ia;
  }

  public void insert(int x) {
    for (int i = 0; i < a.size(); i++) {
      if (a.get(i) > x) {
        a.add(i, x);
        return;
      } else {
        if (a.get(i) == x) {
        return;
        }
      }
    }
    a.add(x);
}

  public boolean member(int x) {
    for (int i = 0; i < a.size(); i++) {
      if (a.get(i) > x) {
        return false;
      } else {
        if (a.get(i) == x) {
          return true;
        }
      }
    }
    return false;
  }

  public void intersect(UpdatedSet s) {
    UpdatedSet b = new UpdatedSet(); 
    for (int i = 0; i < a.toArray().length; i++) {
      for (int j = 0; j < s.a.toArray().length; j++) {
        if (a.get(i) == s.a.get(j)){
          b.insert(a.get(i));
          break;
        }
      }
    }
    a = b.a;
  }

  // Try with:
  //   (a, b) -> a + b;
  //   (a, b) -> a - b;
  public boolean distinctClosed(IntBinaryOperator f) {
    int vi,vj;
    for (int i = 0; i < a.size(); i++) {
      for (int j = 0; j < a.size(); j++) {
        System.out.println("felix!!");
        vi = a.get(i);
        vj = a.get(j);
        if (!(member(f.applyAsInt(vi, vj)) || vi == vj)) return false;
      }
    }
    return true;
  }
}

    

