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
    public void memberTest_1(){
        boolean valid = false;
        UpdatedSet set = new UpdatedSet();
        set.insert(5);
        if(set.member(5)){
            valid = true;
        }
        assert(valid);
    }

    @Test 
    public void memberTest_2(){
        boolean valid = false;
        UpdatedSet set = new UpdatedSet();
        if(!(set.member(2))){
            valid = true;
        }
        assert(valid);
    }

    @Test 
    public void intersect(){
        UpdatedSet fst_set = new UpdatedSet();
        UpdatedSet snd_set = new UpdatedSet();

        fst_set.insert(1);
        fst_set.insert(2);
        fst_set.insert(3);
      
        snd_set.insert(1);
        snd_set.insert(10);
        snd_set.insert(12);
        
        snd_set.intersect(fst_set);

        int[] arr = new int[]{1};
  
       assertArrayEquals(arr, snd_set.toArray());
    }

    


    

    

}
