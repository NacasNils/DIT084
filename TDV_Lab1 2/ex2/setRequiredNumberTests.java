import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class setRequiredNumberTests {
    @Test
    public void testSimple() {
        WorkSchedule ws = new WorkSchedule(24);
        ws.setRequiredNumber(1,0 ,0);
        assertEquals(1, ws.readSchedule(0).requiredNumber);
    }
}


    