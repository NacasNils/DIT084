import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

public class DistinctClosed {

    @Test 
    public void DistincteClosedTestfalse123(){
        UpdatedSet set = new UpdatedSet();
        
        set.insert(1);
        set.insert(2);
        set.insert(3);

        assertEquals(false , set.distinctClosed((a,b) -> a + b));
    }
    @Test 
    public void DistinctClosedTestTrue(){
        UpdatedSet set = new UpdatedSet();

        set.insert(-1);
        set.insert(1);
        set.insert(0);

        assertEquals(true, set.distinctClosed((a,b) -> a + b));
    }
    @Test
    public void DistinctClosedTestWeird(){
        UpdatedSet set = new UpdatedSet();
        set.insert(1);
        set.insert(0);

        assertEquals(true, set.distinctClosed((a,b) -> a + b));
        assertEquals(false, set.distinctClosed((a,b) -> a - b));

    }
    @Test
    public void TestThatRevealedBugInCode(){
        UpdatedSet set = new UpdatedSet();
        set.insert(0);
        set.insert(-1);
        // THIS TEST RETURNED TRUE BEFORE WE FIXED THE BUG, 
        // assertEquals(true, set.distinctClosed((a,b) -> a - b));
        assertEquals(false, set.distinctClosed((a,b) -> a - b));
    }
}
/*
 * 
 */
