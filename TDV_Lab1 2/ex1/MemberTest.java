import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

public class MemberTest {
    
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
    public void memberTest_3(){
        UpdatedSet set = new UpdatedSet();
        set.insert(0);
        set.insert(1);
        set.insert(2);
        set.insert(3);
        set.insert(4);
        
        assertEquals(true, set.member(2));
    }
    
}   