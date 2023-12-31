import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.nio.file.ReadOnlyFileSystemException;

public class setRequiredNumberTests {

    @Test
    public void test_1(){                           // test only zeroes 
        WorkSchedule ws = new WorkSchedule(24);
        ws.setRequiredNumber(0, 0, 0);
        assertEquals(0,ws.readSchedule(0).requiredNumber);
        
    }

    @Test
    public void test_2() {                      
        WorkSchedule ws = new WorkSchedule(24);
        ws.setRequiredNumber(1,0,0);
        assertEquals(1, ws.readSchedule(0).requiredNumber);
    }

    @Test                                           // only employee value greater than zero 
    public void test_3(){
        WorkSchedule ws = new WorkSchedule(24);
        ws.setRequiredNumber(0, 3, 0);
        assertEquals(ws.readSchedule(0).requiredNumber,0);
    }

    @Test
    public void test_4(){
        WorkSchedule ws = new WorkSchedule(24);
        ws.setRequiredNumber(0, 0, 5);
        assertEquals(0,ws.readSchedule(5).requiredNumber);
    }

    @Test 
    public void test_5(){                           // Here, as stated in the specification the schedule is unchanged. 
        WorkSchedule ws = new WorkSchedule(24);
        ws.setRequiredNumber(3, 5, 0);
        assertNotEquals(3,ws.readSchedule(5).requiredNumber);
        assertEquals(0,ws.readSchedule(5).requiredNumber);
    }

    @Test 
    public void test_6(){
        WorkSchedule ws = new WorkSchedule(24);
        ws.setRequiredNumber(5, 0, 6);
        assertEquals(5,ws.readSchedule(6).requiredNumber);
    }

    @Test 
    public void test_7(){
        WorkSchedule ws = new WorkSchedule(24);
        ws.setRequiredNumber(0, 3, 3);
        assertEquals(0, ws.readSchedule(3).requiredNumber);
    }
    
    @Test 
    public void test_8(){
        WorkSchedule ws = new WorkSchedule(24);
        ws.setRequiredNumber(3, 4, 5);
        assertEquals(3,ws.readSchedule(4).requiredNumber);
        assertEquals(3,ws.readSchedule(5).requiredNumber);
    }

    @Test // FAILS BUG FOUND!
    public void test_9(){
        WorkSchedule ws = new WorkSchedule(24);
        ws.setRequiredNumber(1,2,Integer.MAX_VALUE);
        assertEquals(1,ws.readSchedule(3).requiredNumber);
    }

    @Test
    public void test_10(){
        WorkSchedule ws = new WorkSchedule(24);
        ws.setRequiredNumber(1, 0, 3);
        assertEquals(1, ws.readSchedule(1).requiredNumber);
    }

    @Test 
    public void test_11(){
        WorkSchedule ws = new WorkSchedule(24);
        ws.setRequiredNumber(Integer.MAX_VALUE, 2, 3);
        assertEquals(Integer.MAX_VALUE, ws.readSchedule(3).requiredNumber);
    }
    @Test 
    public void test_12(){
        WorkSchedule ws = new WorkSchedule(24);
        ws.setRequiredNumber(2, 0, 23);
        ws.addWorkingPeriod("Nils", 0, 23);
        ws.addWorkingPeriod("Oscar", 0, 23);
        assertEquals(2,ws.workingEmployees(0, 23).length);
        ws.setRequiredNumber(1, 0, 23);
        assertEquals(1,ws.workingEmployees(0, 23).length); 
    }

    /*
    -- DOESENT WORK, Requested array size exceeds VM limit!
    @Test
    public void test_9(){
        WorkSchedule ws = new WorkSchedule(Integer.MAX_VALUE);
        ws.setRequiredNumber(3, Integer.MAX_VALUE-1, Integer.MAX_VALUE);
        assertEquals(3,ws.Integer.MAX_VALUE-1.requiredNumber
    }
    */


    
}


    