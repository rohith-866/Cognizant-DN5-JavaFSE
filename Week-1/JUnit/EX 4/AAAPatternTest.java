import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

public class AAAPatternTest {

    private List<Integer> numbers;

    @BeforeEach
    public void setUp() {
        numbers = new ArrayList<>();
        numbers.add(1);
        numbers.add(2);
        numbers.add(3);
    }

    @AfterEach
    public void tearDown() {
        numbers.clear();
    }

    @Test
    public void testAddElement() {
        numbers.add(4);
        assertEquals(4, numbers.size());
    }

    @Test
    public void testRemoveElement() {
        numbers.remove(Integer.valueOf(2));
        assertFalse(numbers.contains(2));
    }

    @Test
    public void testSumOfElements() {
        int sum = numbers.stream().mapToInt(Integer::intValue).sum();
        assertEquals(6, sum);
    }

    @Test
    public void testListIsNotEmptyAfterSetup() {
        assertFalse(numbers.isEmpty());
    }
}
