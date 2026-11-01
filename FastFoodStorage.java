
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package fastfoodstorage;
import java.time.LocalDate;
import java.util.Scanner;
/**
 *
 * @author mathe
 */
public class FastFoodStorage {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        FoodStorage storage = new FoodStorage();

       
        

// Scanner to read user input
Scanner scanner = new Scanner(System.in);
        
        //creating three food items
        
        // Menu options for the user
System.out.println("\n=== Fast Food Storage Menu ===");

System.out.println("1. Add food");

System.out.println("2. Remove food FIFO");

System.out.println("3. Remove food LIFO");

System.out.println("4. Display food");

System.out.println("5. Search food");

System.out.println("6. Peek food");

System.out.println("0. Exit");

// Read the option selected by the user
System.out.print("Choose an option: ");
String option = scanner.nextLine();

System.out.println("You selected: " + option);

// Check the selected menu option
if (option.equals("4")) {
    storage.displayFood();
}
        

// Remove the oldest food when option 2 is selected
if (option.equals("2")) {
    storage.removeFoodFIFO();
}

// Remove the newest food when option 3 is selected
if (option.equals("3")) {
    storage.removeFoodLIFO();
}

// Check the next food when option 6 is selected
if (option.equals("6")) {
    FoodItem next = storage.peekFood();

    if (next != null) {
        System.out.println("Next food: " + next.getName());
    }
}

// Search for food when option 5 is selected
if (option.equals("5")) {
    System.out.print("Enter food name: ");
    String foodName = scanner.nextLine();

    FoodItem found = storage.searchFood(foodName);

    if (found != null) {
        System.out.println("Food found: " + found.getName());
    } else {
        System.out.println("Food not found!");
    }
}

    FoodItem burger = new FoodItem("Burger", 250, LocalDate.now().plusDays(5));
    
    FoodItem pizza = new FoodItem("Pizza", 400, LocalDate.now().plusDays(7));
    
    FoodItem fries = new FoodItem("Fries", 150, LocalDate.now().plusDays(3));
        
    //adding food to the storage 
    
    storage.addFood(burger);
    
    storage.addFood(pizza);
    
    storage.addFood(fries);
    
    // an invalid food weight
FoodItem invalidBurger = new FoodItem("Burger", -100, LocalDate.now().plusDays(5));
storage.addFood(invalidBurger);
    

// testing a food item with an expired date
FoodItem expiredPizza = new FoodItem("Pizza", 400, LocalDate.now().minusDays(2));
storage.addFood(expiredPizza);

// Testing a food item with a date over 14 days
FoodItem futureBurger = new FoodItem("Burger", 250, LocalDate.now().plusDays(20));
storage.addFood(futureBurger);


    // displayFood to show all food items in storage
storage.displayFood();
 

// testing an invalid food name
FoodItem invalidFood = new FoodItem("Sushi", 200, LocalDate.now().plusDays(5));
storage.addFood(invalidFood);

// searchFood to find Pizza in storage
FoodItem foundFood = storage.searchFood("Pizza");

if (foundFood != null) {
    System.out.println("Food found: " + foundFood.getName());

} else {
    System.out.println("Food not found!");
}

// testing peekfood to see the next food without removint it 
FoodItem nextFood = storage.peekFood();

if (nextFood != null) {
    System.out.println("Next food: " + nextFood.getName());
}

    
     // testing FIFO First In, First Out
        System.out.println("\nTesting FIFO:");

        storage.removeFoodFIFO();
        
        storage.removeFoodFIFO();
        
        
        // testing LIFO Last In, First Out
        System.out.println("\nTesting LIFO:");

        storage.addFood(burger);
        storage.addFood(pizza);

        storage.removeFoodLIFO();
        storage.removeFoodLIFO();

        // Testing the maximum storage capacity of 8 trays
        FoodStorage fullStorage = new FoodStorage();

        for (int i = 0; i < 9; i++) {
            FoodItem testFood = new FoodItem("Burger", 250, LocalDate.now().plusDays(5));
            fullStorage.addFood(testFood);
        }

        
        
        // Testing removal from an empty storage
FoodStorage emptyStorage = new FoodStorage();

emptyStorage.removeFoodFIFO();
emptyStorage.removeFoodLIFO();


    }
    
     
    
    
}



