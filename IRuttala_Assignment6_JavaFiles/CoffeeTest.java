import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CoffeeTest {

    @Test
    void getExtraShot() {
        Coffee c = new Coffee("Latte", Size.MEDIUM, true, false);
        assertTrue(c.getExtraShot(), "Coffee should have extra shot");
        Coffee c1 = new Coffee("Latte", Size.MEDIUM, false, false);
        assertFalse(c1.getExtraShot(), "Coffee should not have extra shot");
    }

    @Test
    void getExtraSyrup() {
        Coffee c = new Coffee("Latte", Size.MEDIUM, false, true);
        assertTrue(c.getExtraSyrup(), "Coffee should have extra syrup");
        assertFalse(new Coffee("Latte", Size.MEDIUM, false, false).getExtraSyrup());
    }

    @Test
    void setExtraShot() {
        Coffee c = new Coffee("Espresso", Size.SMALL, false, false);
        assertFalse(c.getExtraShot());

        c.setExtraShot(true);
        assertTrue(c.getExtraShot(), "Extra shot should be updated to true");

        c.setExtraShot(false);
        assertFalse(c.getExtraShot(), "Extra shot should be updated to false");
    }

    @Test
    void setExtraSyrup() {
        Coffee c = new Coffee("Cappuccino", Size.SMALL, false, false);
        assertFalse(c.getExtraSyrup());

        c.setExtraSyrup(true);
        assertTrue(c.getExtraSyrup(), "Extra syrup should be updated to true");

        c.setExtraSyrup(false);
        assertFalse(c.getExtraSyrup(), "Extra syrup should be updated to false");
    }

    @Test
    void calcPrice() {
        // Base price 2.0, size MEDIUM +0.5, extra shot +0.5, extra syrup +0.5
        Coffee c1 = new Coffee("Latte", Size.SMALL, false, false);
        Coffee c2 = new Coffee("Latte", Size.MEDIUM, true, false);
        Coffee c3 = new Coffee("Latte", Size.LARGE, true, true);

        assertEquals(2.0, c1.calcPrice(), 0.001, "Small coffee no extras");
        assertEquals(2.0 + 0.5 + 0.5, c2.calcPrice(), 0.001, "Medium coffee with extra shot");
        assertEquals(2.0 + 1.0 + 0.5 + 0.5, c3.calcPrice(), 0.001, "Large coffee with extra shot and syrup");
    }
}