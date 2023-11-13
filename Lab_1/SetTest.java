import org.junit.jupiter.*;
public class SetTest {

    @Test
    void testIntsert(){
        valid = false;
        Set set = new Set ();
        insertedSet = set.insert(2);
        count = 0;
        for(int s : insertedSet){
            if(s == 2){
                count++;
            }
            if(count >= 1){
                valid = true;
            }
            
        }
        assert(valid);
    }

    /*
     * Manual whitebox testning
     */

     /*
      * Manual blackbox testning
      */
    
}
