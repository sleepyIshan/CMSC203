import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class OrderTest {

    @Test
    void generateOrder() {
        Customer c = new Customer("Alice", 25);
        Order order1 = new Order(10, Day.MONDAY, c);
        Order order2 = new Order(11, Day.TUESDAY, c);

        assertTrue(order1.getOrderNo() >= 10000 && order1.getOrderNo() <= 90000);
        assertTrue(order2.getOrderNo() >= 10000 && order2.getOrderNo() <= 90000);
        assertNotEquals(order1.getOrderNo(), order2.getOrderNo(), "Order numbers should be unique");
    }

    @Test
    void getOrderNo() {
        Order order = new Order(12, Day.WEDNESDAY, new Customer("Bob", 30));
        int orderNo = order.getOrderNo();
        assertTrue(orderNo >= 10000 && orderNo <= 90000);
    }

    @Test
    void getOrderTime() {
        Order order = new Order(14, Day.THURSDAY, new Customer("Charlie", 40));
        assertEquals(14, order.getOrderTime());
    }

    @Test
    void getOrderDay() {
        Order order = new Order(14, Day.THURSDAY, new Customer("Charlie", 40));
        assertEquals(Day.THURSDAY, order.getOrderDay());

    }

    @Test
    void getDay() {
        Order order = new Order(14, Day.THURSDAY, new Customer("Charlie", 40));
        assertEquals(Day.THURSDAY, order.getDay());
    }

    @Test
    void getCustomer() {
        Customer cust = new Customer("David", 22);
        Order order = new Order(15, Day.FRIDAY, cust);
        Customer copy = order.getCustomer();

        assertEquals("David", copy.getName());
        assertEquals(22, copy.getAge());

        // Ensure a copy, not the same reference
        copy.setName("Changed");
        assertNotEquals(copy.getName(), order.getCustomer().getName());
    }

    @Test
    void addNewBeverage() {
        Customer c = new Customer("Eve", 28);
        Order order = new Order(10, Day.SATURDAY, c);

        order.addNewBeverage("Beer", Size.MEDIUM); // Alcohol
        order.addNewBeverage("Latte", Size.LARGE, true, true); // Coffee
        order.addNewBeverage("Smoothie", Size.SMALL, 2, true); // Smoothie

        assertEquals(3, order.getTotalItems());
        assertEquals(Type.ALCOHOL, order.getBeverage(0).getType());
        assertEquals(Type.COFFEE, order.getBeverage(1).getType());
        assertEquals(Type.SMOOTHIE, order.getBeverage(2).getType());
    }

    @Test
    void testAddNewBeverage() {
    }

    @Test
    void testAddNewBeverage1() {
    }

    @Test
    void calcOrderTotal() {
        Customer c = new Customer("Frank", 35);
        Order order = new Order(11, Day.SUNDAY, c);

        order.addNewBeverage("Beer", Size.SMALL); // Alcohol, weekend
        order.addNewBeverage("Latte", Size.MEDIUM, true, false); // Coffee

        double expected = 2.0 + 0.5; // Beer small base + weekend 0.5
        expected += 2.0 + 0.5 + 0.5; // Latte medium + extra shot
        assertEquals(expected, order.calcOrderTotal(), 0.001);
    }

    @Test
    void getBeverage() {
        Order order = new Order(12, Day.MONDAY, new Customer("Grace", 29));
        order.addNewBeverage("Beer", Size.SMALL);
        order.addNewBeverage("Latte", Size.MEDIUM, false, false);

        assertEquals(2, order.getTotalItems());
        assertEquals("Beer", order.getBeverage(0).getBevName());
        assertEquals("Latte", order.getBeverage(1).getBevName());
        assertNull(order.getBeverage(5), "Out of range index should return null");
    }

    @Test
    void getTotalItems() {
        Order order = new Order(12, Day.MONDAY, new Customer("Grace", 29));
        order.addNewBeverage("Beer", Size.SMALL);
        order.addNewBeverage("Latte", Size.MEDIUM, false, false);

    }

    @Test
    void findNumOfBeveType() {
        Order order = new Order(10, Day.FRIDAY, new Customer("Hank", 32));
        order.addNewBeverage("Beer", Size.SMALL);
        order.addNewBeverage("Wine", Size.LARGE);
        order.addNewBeverage("Latte", Size.MEDIUM, true, false);

        assertEquals(2, order.findNumOfBeveType(Type.ALCOHOL));
        assertEquals(1, order.findNumOfBeveType(Type.COFFEE));
        assertEquals(0, order.findNumOfBeveType(Type.SMOOTHIE));
    }


}

