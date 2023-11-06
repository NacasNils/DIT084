import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

public class insertTests {
    @Test
    public void insertIntoEmpty() {
        Set set = new Set();
        set.insert(1);
        int[] expected = {1};
        assertArrayEquals(expected, set.toArray());
    }

}
