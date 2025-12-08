import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

class BeverageTest {

    @org.junit.jupiter.api.Test
    void testgetBasePrice() {
        Coffee coffee = new Coffee("Latte", Size.MEDIUM, false, false);
        double expected = 2.0;
        assertEquals(expected, coffee.getBasePrice(),0.001);

    }

    @org.junit.jupiter.api.Test
    void testgetBevName() {
        Coffee coffee = new Coffee("Espresso", Size.SMALL, false, false);
        assertEquals("Espresso", coffee.getBevName());
    }

    @org.junit.jupiter.api.Test
    void testgetType() {
        Coffee coffee = new Coffee("Latte", Size.LARGE, false, false);
        assertEquals(Type.COFFEE, coffee.getType());
    }

    @org.junit.jupiter.api.Test
    void testgetSize() {
        Coffee coffee = new Coffee("Mocha", Size.MEDIUM, false, false);
        assertEquals(Size.MEDIUM, coffee.getSize());
    }

    @org.junit.jupiter.api.Test
    void testsetBevName() {
        Coffee coffee = new Coffee("Latte", Size.SMALL, false, false);
        coffee.setBevName("Cappuccino");
        assertEquals("Cappuccino", coffee.getBevName());
    }

    @org.junit.jupiter.api.Test
    void testsetType() {
        Coffee coffee = new Coffee("Latte", Size.SMALL, false, false);
        coffee.setType(Type.SMOOTHIE);
        assertEquals(Type.SMOOTHIE, coffee.getType());
    }

    @org.junit.jupiter.api.Test
    void testsetSize() {
        Coffee coffee = new Coffee("Latte", Size.SMALL, false, false);
        coffee.setSize(Size.LARGE);
        assertEquals(Size.LARGE, coffee.getSize());
    }

    @org.junit.jupiter.api.Test
    void testaddSizePrice() {
        Coffee small = new Coffee("Latte", Size.SMALL, false, false);
        Coffee medium = new Coffee("Latte", Size.MEDIUM, false, false);
        Coffee large = new Coffee("Latte", Size.LARGE, false, false);

        assertEquals(2.0, small.addSizePrice());
        assertEquals(2.5, medium.addSizePrice());
        assertEquals(3.0, large.addSizePrice());
    }

    @org.junit.jupiter.api.Test
    void testcalcPrice() {
        Coffee coffee1 = new Coffee("Latte", Size.SMALL, true, true); // base 2.0 + 0 size + 0.5 + 0.5
        Coffee coffee2 = new Coffee("Latte", Size.LARGE, false, true); // base 2.0 + 1.0 size + 0.5 syrup

        assertEquals(3.0, coffee1.calcPrice());
        assertEquals(3.5, coffee2.calcPrice());
    }
}