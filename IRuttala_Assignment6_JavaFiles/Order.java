import java.util.ArrayList;
import java.util.Random;

public class Order implements OrderInterface, Comparable<Order> {

    private int orderNo;
    private int orderTime;
    private Day orderDay;
    private Customer customer;
    private ArrayList<Beverage> beverages;


    public Order(int orderTime, Day orderDay, Customer cust) {
        this.orderTime = orderTime;
        this.orderDay = orderDay;
        this.customer = new Customer(cust);
        this.orderNo = generateOrder();
        this.beverages = new ArrayList<>();
    }

    public int generateOrder() {
        Random rand = new Random();
        return rand.nextInt(80001) + 10000;
    }


    public int getOrderNo() {
        return orderNo;
    }

    public int getOrderTime() {
        return orderTime;
    }

    public Day getOrderDay() {
        return orderDay;
    }

    public Day getDay() {
        return orderDay;
    }

    public Customer getCustomer() {
        return new Customer(customer);
    }

    @Override
    public void addNewBeverage(String bevName, Size size) {
        beverages.add(new Alcohol(bevName, size, isWeekend()));
    }

    @Override
    public void addNewBeverage(String bevName, Size size, boolean extraShot, boolean extraSyrup) {
        beverages.add(new Coffee(bevName, size, extraShot, extraSyrup));
    }

    @Override
    public void addNewBeverage(String bevName, Size size, int numOfFruits, boolean addProtein) {
        beverages.add(new Smoothie(bevName, size, numOfFruits, addProtein));
    }

    @Override
    public double calcOrderTotal() {
        double total = 0.0;
        for (int i = 0; i < beverages.size(); i++) {
            total += beverages.get(i).calcPrice();
        }
        return total;
    }

    @Override
    public Beverage getBeverage(int itemNo) {
        if (itemNo >= 0 && itemNo < beverages.size()) {
            return beverages.get(itemNo); // Shallow copy
        }
        return null;
    }

    @Override
    public int getTotalItems() {
        return beverages.size();
    }

    @Override
    public int findNumOfBeveType(Type type) {
        int count = 0;
        for (int i = 0; i < beverages.size(); i++) {
            if (beverages.get(i).getType() == type) {
                count++;
            }
        }
        return count;
    }

    @Override
    public boolean isWeekend() {
        return orderDay == Day.SATURDAY || orderDay == Day.SUNDAY;
    }
    @Override
    public int compareTo(Order anotherOrder) {
        return Integer.compare(this.orderNo, anotherOrder.orderNo);
    }
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Order No: ").append(orderNo)
                .append(", Time: ").append(orderTime)
                .append(", Day: ").append(orderDay)
                .append(", Customer: ").append(customer)
                .append("\nBeverages:\n");
        for (int i = 0; i < beverages.size(); i++) {
            sb.append(beverages.get(i)).append("\n");
        }
        sb.append("Total Price: ").append(calcOrderTotal());
        return sb.toString();
    }

}
