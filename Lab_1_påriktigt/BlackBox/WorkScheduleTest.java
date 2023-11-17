import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;


public class WorkScheduleTest {
    
    @Test 
    public void WorkScheduleTests(){
    boolean valid = false;

    int testSize = 5;
    int slots = 0;
    WorkSchedule ws = new WorkSchedule(testSize);

    System.out.print(ws.readSchedule(0).requiredNumber);
    System.out.print(ws.readSchedule(1).requiredNumber);
    System.out.print(ws.readSchedule(2).requiredNumber);
    System.out.print(ws.readSchedule(3).requiredNumber);
    System.out.print(ws.readSchedule(4).requiredNumber);


    
    for (int i = 0; i < testSize; i++) {
        if(ws.readSchedule(i).requiredNumber == 0){
            slots++;
        }
        if(slots == testSize){
            valid = true;
        }
        assertEquals(testSize, slots);
    }
    
    
    
    }




    public static void main(String[] args) {
        // Test Case for WorkSchedule Constructor with a Negative Size

        try {
            int negativeSize = -5;
            WorkSchedule schedule = new WorkSchedule(negativeSize);
            // The following line should not be reached because an exception is expected
            System.out.println("Test failed: No exception thrown for negative size.");
        } catch (IllegalArgumentException e) {
            // The constructor should throw an IllegalArgumentException for a negative size
            System.out.println("Test passed: Exception caught for negative size.");
            System.out.println("Exception Message: " + e.getMessage());
        }
    


   


}

}