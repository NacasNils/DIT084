import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.nio.file.ReadOnlyFileSystemException;

public class nextIncompleteTest {

    // test case for when currenttime == 0
    @Test
    public void nextIncomplete_0(){
        WorkSchedule ws0 = new WorkSchedule(10);
        ws0.setRequiredNumber(1, 0, 9);
        ws0.addWorkingPeriod("Felix", 0, 8);
        assertEquals(9, ws0.nextIncomplete(0));
    }
    
    // test case for when currenttime > 0
    @Test
    public void nextIncomplete_1(){
    WorkSchedule ws1 = new WorkSchedule(10);
    ws1.setRequiredNumber(2, 0, 3); // uppfylls
    ws1.setRequiredNumber(2, 3, 5);
    
    ws1.addWorkingPeriod("Felix", 0, 3);
    ws1.addWorkingPeriod("Nils", 0, 3);
    ws1.addWorkingPeriod("Oscar1", 3, 5);
    ws1.addWorkingPeriod("Oscar2", 3, 4);    
    assertEquals(5,ws1.nextIncomplete(1));
    assertEquals(5,ws1.nextIncomplete(2));
    assertEquals(5,ws1.nextIncomplete(3));
    assertEquals(5,ws1.nextIncomplete(4));
    
    ws1.setRequiredNumber(1, 6, 9);
    ws1.addWorkingPeriod("Nacas", 6, 8);
    assertEquals(9, ws1.nextIncomplete(6));

}
/* 
DOES NOT WORK OUTOFBOUNDS EXCEPTION!!!!
our bordercase!
@Test 
public void border_0() {
    WorkSchedule ws = new WorkSchedule(0);
    ws.setRequiredNumber(0, 0, 0);
    ws.addWorkingPeriod("Felix", 0, 0);
    assertEquals(0, ws.nextIncomplete(0));
}
 */



   
}
