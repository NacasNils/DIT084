import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

public class insertTests {
    @Test
    public void insertIntoEmpty() {
        UpdatedSet set = new  UpdatedSet();
        set.insert(12);
        set.insert(1);
        set.insert(10);
        int[] expected = {1,10,12};
        assertArrayEquals(expected, set.toArray());
    }
    @Test 
    public void insertSameTwice(){
        UpdatedSet set = new UpdatedSet();
        set.insert(10);
        set.insert(9);
        set.insert(10);
        int[] expected = {9,10};
        assertArrayEquals(expected, set.toArray());
    }
    @Test
    void insertMaxMin() {
        UpdatedSet set = new UpdatedSet();
        int max = Integer.MAX_VALUE;
        int min = Integer.MIN_VALUE;
        set.insert(max);
        set.insert(min);
        int[] expected = {min,max};
        assertArrayEquals(expected, set.toArray());
    }
    @Test
    void inserInOrder(){
        UpdatedSet set = new UpdatedSet();
        set.insert(-1);
        set.insert(0);
        set.insert(1);
        set.insert(2);
        set.insert(3);
        set.insert(4);
        int[] expected = {-1,0,1,2,3,4};
        assertArrayEquals(expected, set.toArray());
    }

    

  

    


    

    

}
