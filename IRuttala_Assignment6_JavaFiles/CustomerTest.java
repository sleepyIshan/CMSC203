import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CustomerTest {

    private Customer customer;

    @Test
    void getName() {
        Customer customer = new Customer("Anakin", 25);
        assertEquals("Anakin", customer.getName(), "The name should be Anakin");
    }

    @Test
    void getAge() {
        Customer customer = new Customer("Luke", 25);
        assertEquals(25, customer.getAge(), "The age should be 25");
    }

    @Test
    void setName() {
        Customer customer = new Customer("Obi-Wan", 25);
        customer.setName("Obi-Wan");
        assertEquals("Obi-Wan", customer.getName(), "The name should be Obi-Wan");
    }

    @Test
    void setAge() {
        Customer customer = new Customer("John", 25);
        customer.setAge(30);
        assertEquals(30, customer.getAge(), "The age should be 30");


    }

}