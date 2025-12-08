import java.util.Scanner;

public class BevShopDriverApp {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        BevShop shop = new BevShop();

        System.out.println("The current order in process can have at most " + shop.getMaxOrderForAlcohol() + " alcoholic beverages.");
        System.out.println("The minimum age to order alcohol drink is " + shop.getMinAgeForAlcohol());

        boolean addMoreOrders = true;

        while (addMoreOrders) {
            System.out.println("\nStart a new order:");
            System.out.print("Enter customer name: ");
            String name = sc.nextLine();

            System.out.print("Enter customer age: ");
            int age = sc.nextInt();
            sc.nextLine();
            shop.startNewOrder(12, Day.FRIDAY, name, age);

            System.out.println("Your Total Order for now is 0.0");

            boolean addMoreDrinks = true;

            while (addMoreDrinks) {
                System.out.println("\nSelect a beverage to add:");
               // if (shop.isValidAge(age)) {
                    System.out.println("1. Alcohol");
             //   }
                System.out.println("2. Coffee");
                System.out.println("3. Smoothie");
                System.out.println("4. Finish order");

                System.out.print("Enter choice: ");
                int choice = sc.nextInt();
                sc.nextLine();

                switch (choice) {
                    case 1: // Alcohol
                        System.out.println("Would you please add a drink ");
                        if (shop.isValidAge(age)) {
                            if (shop.isEligibleForMore()) {
                                System.out.print("Enter alcohol name: ");
                                String alcName = sc.nextLine();
                                System.out.print("Enter size (SMALL, MEDIUM, LARGE): ");
                                Size alcSize = Size.valueOf(sc.nextLine().toUpperCase());
                                shop.processAlcoholOrder(alcName, alcSize);
                                System.out.println("The current order of drinks is " + shop.getCurrentOrder().getTotalItems());
                                System.out.println("The Total price on the Order is " + shop.getCurrentOrder().calcOrderTotal());
                            } else {
                                System.out.println("You have reached the maximum alcohol drinks for this order");
                            }
                        } else {
                            System.out.println("Your Age is not appropriate for alcohol drink!!");
                        }
                        break;


                    case 2:
                        System.out.print("Enter coffee name: ");
                        String coffeeName = sc.nextLine();
                        System.out.print("Enter size (SMALL, MEDIUM, LARGE): ");
                        Size coffeeSize = Size.valueOf(sc.nextLine().toUpperCase());
                        System.out.print("Extra shot (true/false): ");
                        boolean extraShot = sc.nextBoolean();
                        System.out.print("Extra syrup (true/false): ");
                        boolean extraSyrup = sc.nextBoolean();
                        sc.nextLine(); // consume newline
                        shop.processCoffeeOrder(coffeeName, coffeeSize, extraShot, extraSyrup);
                        System.out.println("The current order of drinks is " + shop.getCurrentOrder().getTotalItems());
                        System.out.println("The Total price on the Order is " + shop.getCurrentOrder().calcOrderTotal());
                        break;

                    case 3:
                        System.out.print("Enter smoothie name: ");
                        String smoothieName = sc.nextLine();
                        System.out.print("Enter size (SMALL, MEDIUM, LARGE): ");
                        Size smSize = Size.valueOf(sc.nextLine().toUpperCase());
                        System.out.print("Number of fruits: ");
                        int fruits = sc.nextInt();
                        System.out.print("Add protein (true/false): ");
                        boolean addProtein = sc.nextBoolean();
                        sc.nextLine(); // consume newline

                        // Check max fruits
                        int currentFruits = 0;
                        for (int i = 0; i < shop.getCurrentOrder().getTotalItems(); i++) {
                            Beverage b = shop.getCurrentOrder().getBeverage(i);
                            if (b instanceof Smoothie) {
                                currentFruits += ((Smoothie) b).getNumOfFruits();
                            }
                        }
                        if (currentFruits + fruits > shop.getMaxNumOfFruits()) {
                            System.out.println("You reached a Maximum number of fruits");
                        } else {
                            shop.processSmoothieOrder(smoothieName, smSize, fruits, addProtein);
                            System.out.println("The current order of drinks is " + shop.getCurrentOrder().getTotalItems());
                            System.out.println("The Total price on the Order is " + shop.getCurrentOrder().calcOrderTotal());
                        }
                        break;

                    case 4:
                        addMoreDrinks = false;
                        break;

                    default:
                        System.out.println("Invalid choice, try again.");
                }
            }

            System.out.println("\nFinished order: Total Price: " + shop.getCurrentOrder().calcOrderTotal());

            System.out.print("\nDo you want to start a new order? (true/false): ");
            addMoreOrders = sc.nextBoolean();
            sc.nextLine(); // consume newline
        }

        // Final report
        System.out.println("\nAll Orders Summary:");
        System.out.println(shop);

        sc.close();
    }
}
