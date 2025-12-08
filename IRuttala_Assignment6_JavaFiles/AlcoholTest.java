import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class AlcoholTest {

    @Test
    void testisWeekend() {
        Alcohol a1 = new Alcohol("Beer", Size.MEDIUM, true);
        assertTrue(a1.isWeekend(), "Alcohol should be weekend");
        Alcohol a2 = new Alcohol("Beer", Size.SMALL, false);
        assertFalse(a2.isWeekend(), "Alcohol should not be weekend");

    }

    @Test
    void testsetWeekend() {
        Alcohol a = new Alcohol("Whiskey", Size.SMALL, false);
        assertFalse(a.isWeekend());

        a.setWeekend(true);
        assertTrue(a.isWeekend(), "Weekend flag should be updated to true");

        a.setWeekend(false);
        assertFalse(a.isWeekend(), "Weekend flag should be updated to false");
    }

    @Test
    void testcalcPrice() {
        Alcohol a1 = new Alcohol("Beer", Size.SMALL, false);
        Alcohol a2 = new Alcohol("Wine", Size.MEDIUM, true);
        Alcohol a3 = new Alcohol("Whiskey", Size.LARGE, true);

        // Base price + size price +weekend
        assertEquals(2.0, a1.calcPrice(), 0.001, "Small non-weekend alcohol price");
        assertEquals(2.5 + 0.5, a2.calcPrice(), 0.001, "Medium weekend alcohol price");
        assertEquals(2.0 + 2*0.5 + 0.5, a3.calcPrice(), 0.001, "Large weekend alcohol price");
    }
}