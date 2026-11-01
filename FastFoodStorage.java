
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
        // main method start the program
        FoodStorage storage = new FoodStorage();

       

// scanner is used to get information typed by the user
Scanner scanner = new Scanner(System.in);
        
        // here i create three food items to test the storage

    FoodItem burger = new FoodItem("Burger", 250, LocalDate.now().plusDays(5));
    
    FoodItem pizza = new FoodItem("Pizza", 400, LocalDate.now().plusDays(7));
    
    FoodItem fries = new FoodItem("Fries", 150, LocalDate.now().plusDays(3));
        
    // adding the three foods inside the storage
    
    storage.addFood(burger);
    
    storage.addFood(pizza);
    
    storage.addFood(fries);


// this loop keep showing the menu until user select exit
while (true) {
        
        // showing all the options available for the user
System.out.println("\n=== Fast Food Storage Menu ===");

System.out.println("1. Add food");

System.out.println("2. Remove food FIFO");

System.out.println("3. Remove food LIFO");

System.out.println("4. Display food");

System.out.println("5. Search food");

System.out.println("6. Peek food");

System.out.println("0. Exit");

// reading the option entered in the console
System.out.print("Choose an option: ");
String option = scanner.nextLine();

System.out.println("You selected: " + option);

// option 4 show the food currently inside storage
if (option.equals("4")) {
    storage.displayFood();
}
        

// fifo remove the food that was added first
if (option.equals("2")) {
    storage.removeFoodFIFO();
}

// lifo remove the food that was added last
if (option.equals("3")) {
    storage.removeFoodLIFO();
}

// peek check the next food without removing from storage
if (option.equals("6")) {
    FoodItem next = storage.peekFood();

    // only show the name if there is a food available
    if (next != null) {
        System.out.println("Next food: " + next.getName());
    }
}


// option 5 let the user search a food using the name
if (option.equals("5")) {
    System.out.print("Enter food name: ");
    String foodName = scanner.nextLine();

    // searching the food inside storage
    FoodItem found = storage.searchFood(foodName);

    // show if the food was found or not
    if (found != null) {
        System.out.println("Food found: " + found.getName());
    } else {
        System.out.println("Food not found!");
    }
}

    // option 1 is used to add a new food from user input
if (option.equals("1")) {
    try {
    // asking the name of the food
    System.out.print("Enter food name: ");
    String foodName = scanner.nextLine();

    // asking the weight and converting text to a number
    System.out.print("Enter food weight in grams: ");
    double weight = Double.parseDouble(scanner.nextLine());

    // asking the best before date of the food
    System.out.print("Enter best-before date (YYYY-MM-DD): ");
    LocalDate date = LocalDate.parse(scanner.nextLine());

    // creating the food object and trying to add in storage
    FoodItem newFood = new FoodItem(foodName, weight, date);
    storage.addFood(newFood);

    // this catch show message if the weight is not a number
    } catch (NumberFormatException e) {
        System.out.println("Invalid weight! Please enter a number.");

    // this catch show message if date format is incorrect
    } catch (java.time.format.DateTimeParseException e) {
        System.out.println("Invalid date! Please use YYYY-MM-DD.");
    }
}

// option 0 stop the menu loop
if (option.equals("0")) {
    System.out.println("Exiting Fast Food Storage...");
    break;
}

// checking if user entered an option outside the menu
if (!option.equals("0") &&
    !option.equals("1") &&
    !option.equals("2") &&
    !option.equals("3") &&
    !option.equals("4") &&
    !option.equals("5") &&
    !option.equals("6")) {

    System.out.println("Invalid option! Please choose between 0 and 6.");
}

}

// testing if the program reject a negative food weight
FoodItem invalidBurger = new FoodItem("Burger", -100, LocalDate.now().plusDays(5));
storage.addFood(invalidBurger);
    

// testing if the program reject a food with expired date
FoodItem expiredPizza = new FoodItem("Pizza", 400, LocalDate.now().minusDays(2));
storage.addFood(expiredPizza);

// testing if the program reject a date more than 14 days
FoodItem futureBurger = new FoodItem("Burger", 250, LocalDate.now().plusDays(20));
storage.addFood(futureBurger);


    // showing all the foods after the validation tests
storage.displayFood();
 

// testing if the program reject a food name not allowed
FoodItem invalidFood = new FoodItem("Sushi", 200, LocalDate.now().plusDays(5));
storage.addFood(invalidFood);

// testing the search method using pizza
FoodItem foundFood = storage.searchFood("Pizza");

// checking if pizza was found inside storage
if (foundFood != null) {
    System.out.println("Food found: " + foundFood.getName());

} else {
    System.out.println("Food not found!");
}

// testing peek to check the first food without removing
FoodItem nextFood = storage.peekFood();

if (nextFood != null) {
    System.out.println("Next food: " + nextFood.getName());
}


    
     // testing fifo to remove the oldest food first
        System.out.println("\nTesting FIFO:");

        storage.removeFoodFIFO();
        
        storage.removeFoodFIFO();
        
        
        // testing lifo to remove the newest food first
        System.out.println("\nTesting LIFO:");

        storage.addFood(burger);
        storage.addFood(pizza);

        storage.removeFoodLIFO();
        storage.removeFoodLIFO();

        // testing the maximum capacity of eight food trays
        FoodStorage fullStorage = new FoodStorage();

        // trying to add nine foods to check the storage limit
        for (int i = 0; i < 9; i++) {
            FoodItem testFood = new FoodItem("Burger", 250, LocalDate.now().plusDays(5));
            fullStorage.addFood(testFood);
        }

        
        
        
        // creating an empty storage to test removal
FoodStorage emptyStorage = new FoodStorage();

// testing fifo and lifo when there is no food inside
emptyStorage.removeFoodFIFO();
emptyStorage.removeFoodLIFO();


    }
    
     
    
    
}
