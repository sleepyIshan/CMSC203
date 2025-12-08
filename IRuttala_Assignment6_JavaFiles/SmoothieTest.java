import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SmoothieTest {

    @Test
    void getNumOfFruits() {
        Smoothie s = new Smoothie("Berry Blast", Size.MEDIUM, 3, false);
        assertEquals(3, s.getNumOfFruits(), "Number of fruits should match");
    }

    @Test
    void getAddProtein() {
        Smoothie s = new Smoothie("Protein Smoothie", Size.LARGE, 2, true);
        assertTrue(s.getAddProtein(), "Smoothie should have protein");

        Smoothie s2 = new Smoothie("Regular Smoothie", Size.SMALL, 1, false);
        assertFalse(s2.getAddProtein(), "Smoothie should not have protein");
    }

    @Test
    void setNumOfFruits() {
        Smoothie s = new Smoothie("Fruit Mix", Size.SMALL, 2, false);
        s.setNumOfFruits(5);
        assertEquals(5, s.getNumOfFruits(), "Number of fruits should be updated");
    }

    @Test
    void setAddProtein() {
        Smoothie s = new Smoothie("Protein Mix", Size.MEDIUM, 3, false);
        assertFalse(s.getAddProtein());

        s.setAddProtein(true);
        assertTrue(s.getAddProtein(), "Protein flag should be updated to true");

        s.setAddProtein(false);
        assertFalse(s.getAddProtein(), "Protein flag should be updated to false");
    }

    @Test
    void calcPrice() {
        // Base 2.0 + size price + numOfFruits*0.5 + protein 1.5 if added
        Smoothie s1 = new Smoothie("Small Smoothie", Size.SMALL, 2, false);
        assertEquals(2.0 + 2*0.5, s1.calcPrice(), 0.001, "Small smoothie without protein");

        Smoothie s2 = new Smoothie("Medium Smoothie", Size.MEDIUM, 3, true);
        double expected = 2.0 + 0.5 + 3*0.5 + 1.5; // base + size + fruits + protein
        assertEquals(expected, s2.calcPrice(), 0.001, "Medium smoothie with protein");

        Smoothie s3 = new Smoothie("Large Smoothie", Size.LARGE, 0, true);
        expected = 2.0 + 2*0.5 + 0*0.5 + 1.5; // base + size + fruits + protein
        assertEquals(expected, s3.calcPrice(), 0.001, "Large smoothie with protein, no fruits");
    }
}