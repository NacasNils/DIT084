import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

public class DistinctClosed {

    UpdatedSet sets = new UpdatedSet();

    @Test 
    public void DistincteClosedTest(){
        boolean valid = false;
        UpdatedSet set = new UpdatedSet();
        
        set.insert(1);
        set.insert(2);
        set.insert(3);

        sets.distinctClosed((a,b) -> a + b);
       

        


    }
    
}
