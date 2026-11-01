
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fastfoodstorage;
import java.time.LocalDate;
/**
 *
 * @author mathe
 */
public class FoodStorage {

    // Maximum number of food trays
    private final int MAX_SIZE = 8;

    // Array to store the food items
    private FoodItem[] items = new FoodItem[MAX_SIZE];

    // Positions and number of items
    private int front = 0;
    private int count = 0;

    // to check if the storage is full
    public boolean isFull() {
        return count == MAX_SIZE;
    }

    // to check if the storage is empty
    public boolean isEmpty() {
        return count == 0;
    }

    // add a new food item to the storage
    public void addFood(FoodItem food) {

        if (isFull()) {
            System.out.println("Storage is full");
            return;
        }

        
        
        // Check if the food name is allowed
        String name = food.getName();

        if (name == null ||
            !(name.equalsIgnoreCase("Burger") ||
              name.equalsIgnoreCase("Pizza") ||
              name.equalsIgnoreCase("Fries") ||
              name.equalsIgnoreCase("Sandwich") ||
              name.equalsIgnoreCase("Hotdog"))) {

            System.out.println("Invalid food name!");
            return;
        }

        
        // Check if the food weight is valid
        if (food.getWeight() <= 0) {
            System.out.println("Invalid weight! Weight must be greater than 0.");
            return;
        }

        
        
        // Check if the best-before date is valid
        LocalDate today = LocalDate.now();

        if (food.getBestBeforeDate() == null ||
            
             food.getBestBeforeDate().isBefore(today) ||
            
             food.getBestBeforeDate().isAfter(today.plusDays(14))) {

            System.out.println("Invalid date! Food must be valid within 14 days.");
            return;
        }

        
        
        int position = (front + count) % MAX_SIZE;
        items[position] = food;
        count++;

        System.out.println("Food added successfully");
    }

    // to remove the oldest food item (FIFO)
    public FoodItem removeFoodFIFO() {

        if (isEmpty()) {
            System.out.println("Storage is empty!");
            return null;
        }

        FoodItem removedFood = items[front];
        items[front] = null;

        front = (front + 1) % MAX_SIZE;
        count--;

        System.out.println("Food removed: " + removedFood.getName());

        return removedFood;
    }

    // to remove the newest food item (LIFO)
    public FoodItem removeFoodLIFO() {

        if (isEmpty()) {
            System.out.println("Storage is empty!");
            return null;
        }

        int position = (front + count - 1) % MAX_SIZE;

        FoodItem removedFood = items[position];
        items[position] = null;
        count--;

        System.out.println("Food removed: " + removedFood.getName());

        return removedFood;
    }

    // Check the next food without removing it
    public FoodItem peekFood() {

        if (isEmpty()) {
            System.out.println("Storage is empty!");
            return null;
        }

        return items[front];
    }

    // Display all food items currently in storage
    public void displayFood() {

        if (isEmpty()) {
            System.out.println("Storage is empty!");
            return;
        }

        System.out.println("Food items in storage:");

        for (int i = 0; i < count; i++) {
            int position = (front + i) % MAX_SIZE;
            FoodItem food = items[position];

            System.out.println(
                food.getName() + " - " +
                food.getWeight() + "g - Best before: " +
                food.getBestBeforeDate()
            );
        }
    }

    // search for a food item by its name
    public FoodItem searchFood(String name) {

        for (int i = 0; i < count; i++) {
            int position = (front + i) % MAX_SIZE;
            FoodItem food = items[position];

            if (food.getName().equalsIgnoreCase(name)) {
                return food;
            }
        }

        return null;
    }
}
