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
        ws.setRequiredNumber(3, 5, 4);
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


    
}


    