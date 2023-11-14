import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

public class intersectTesting {

// En samma

     @Test 
    public void intersect1(){
      
    UpdatedSet s1 = new UpdatedSet();
    UpdatedSet s2 = new UpdatedSet();

    s2.insert(3);
    s2.insert(-1);
    s2.insert(0);

    s1.insert(2);
    s1.insert(-1);
    s1.insert(12);

    s2.intersect(s1);

    assertArrayEquals(new int[]{-1}, s2.toArray());
    }
    

    

    // Intersecting two empty sets should result in an empty set.

     @Test 
    public void intersect2(){

    UpdatedSet s3 = new UpdatedSet();
    UpdatedSet s4 = new UpdatedSet();

    s4.intersect(s3);

    assertArrayEquals(new int[]{}, s4.toArray());
    }

    // Intersecting a non-empty set with an empty set should still result in an empty set.

         @Test 
    public void intersect3(){
    UpdatedSet s5 = new UpdatedSet();
    UpdatedSet s6 = new UpdatedSet();

    s6.insert(3);
    s6.insert(-1);
    s6.insert(0);

    s5.intersect(s6);

    assertArrayEquals(new int[]{}, s5.toArray());
    }

    // Intersecting two sets with no common elements.
         @Test 
    public void intersect4(){

    UpdatedSet s7 = new UpdatedSet();
    UpdatedSet s8 = new UpdatedSet();

    s7.insert(-5);
    s7.insert(17);
    s7.insert(0);

    s8.insert(1);
    s8.insert(16);
    s8.insert(7);
    
    s7.intersect(s8);
    assertArrayEquals(new int[]{}, s7.toArray());
    }

    // Intersecting sets with multiple common elements.
         @Test 
    public void intersect5(){

    UpdatedSet s9 = new UpdatedSet();
    UpdatedSet s0 = new UpdatedSet();

    s9.insert(-5);
    s9.insert(17);
    s9.insert(7);

    s0.insert(-5);
    s0.insert(16);
    s0.insert(7);
    
    s0.intersect(s9);

    assertArrayEquals(new int[]{-5,7}, s0.toArray());

    }
}