
package fastfoodstorage;

import java.time.LocalDate;

public class FoodStorage {

    // this is the maximum number of food trays i can have
    private final int MAX_SIZE = 8;

    // this array is where i keep all the food objects
    private FoodItem[] items = new FoodItem[MAX_SIZE];

    // front show where is the first food in storage
    private int front = 0;

    // count is used to know how many foods are inside
    private int count = 0;


    // this method check if the storage is already full
    public boolean isFull() {

        return count == MAX_SIZE;
    }


    // this method check if there is no food in storage
    public boolean isEmpty() {

        return count == 0;
    }


    // here i add a new food inside the storage
    public void addFood(FoodItem food) {

        // first i check if the eight trays are already used
        if (isFull()) {
            System.out.println("Storage is full");
            return;
        }


        // checking if the food object is null
        if (food == null) {
            System.out.println("Invalid food!");
            return;
        }


        // getting the name from the food object
        String name = food.getName();


        // only these five food names are accepted in the program
        // equalsignorecase allow the name with small or capital letters
        if (name == null ||
            !(name.equalsIgnoreCase("Burger") ||
              name.equalsIgnoreCase("Pizza") ||
              name.equalsIgnoreCase("Fries") ||
              name.equalsIgnoreCase("Sandwich") ||
              name.equalsIgnoreCase("Hotdog"))) {

            System.out.println("Invalid food name!");
            return;
        }


        // food weight need to be a valid number bigger than zero
        if (!Double.isFinite(food.getWeight()) || food.getWeight() <= 0) {
            System.out.println("Invalid weight! Weight must be greater than 0.");
            return;
        }


        // getting today date to compare with the food date
        LocalDate today = LocalDate.now();


        // here i check if the food is expired or more than 14 days
        // if the date is not accepted the food cannot enter storage
        if (food.getBestBeforeDate() == null ||
            food.getBestBeforeDate().isBefore(today) ||
            food.getBestBeforeDate().isAfter(today.plusDays(14))) {

            System.out.println("Invalid date! Food must be valid within 14 days.");
            return;
        }


        // this calculation find the next free position in the array
        // the percentage operator help the position go back to zero
        int position = (front + count) % MAX_SIZE;


        // updating the time when food is put inside storage
        food.setTimeStored();


        // saving the food in the position calculated before
        items[position] = food;

        // increasing the number of foods inside storage
        count++;

        System.out.println("Food added successfully");
    }


    // fifo mean first in first out
    // here i remove the food that entered first
    public FoodItem removeFoodFIFO() {

        // cannot remove food if storage is empty
        if (isEmpty()) {
            System.out.println("Storage is empty!");
            return null;
        }


        // getting the food from the front position
        FoodItem removedFood = items[front];


        // making this position empty again
        items[front] = null;

        // moving front to the next position in the array
        front = (front + 1) % MAX_SIZE;

        // one food was removed so count go down
        count--;

        System.out.println("Food removed: " + removedFood.getName());

        return removedFood;
    }


    // lifo mean last in first out
    // here i remove the last food added in storage
    public FoodItem removeFoodLIFO() {

        // checking if there is food to remove
        if (isEmpty()) {
            System.out.println("Storage is empty!");
            return null;
        }


        // finding the position of the newest food
        int position = (front + count - 1) % MAX_SIZE;


        // getting the food from this position
        FoodItem removedFood = items[position];


        // removing the food from the array
        items[position] = null;

        // decreasing the number of foods
        count--;

        System.out.println("Food removed: " + removedFood.getName());

        return removedFood;
    }


    // peek is used to see the first food without remove it
    public FoodItem peekFood() {

        // checking if storage have any food
        if (isEmpty()) {
            System.out.println("Storage is empty!");
            return null;
        }


        // returning the first food but keeping inside storage
        return items[front];
    }


    // this method print all foods currently in storage
    public void displayFood() {

        // if there is no food i show this message
        if (isEmpty()) {
            System.out.println("Storage is empty!");
            return;
        }


        System.out.println("Food items in storage:");


        // this loop go through all foods that are stored
        for (int i = 0; i < count; i++) {

            // calculating the correct position for each food
            int position = (front + i) % MAX_SIZE;


            // getting the food from the array
            FoodItem food = items[position];


            // showing name, weight, date and time stored
            System.out.println(
                food.getName() + " - " +
                food.getWeight() + "g - Best before: " +
                food.getBestBeforeDate() +
                " - Stored at: " + food.getTimeStored()
            );
        }
    }


    // this method search for a food using the name
    public FoodItem searchFood(String name) {

        // cannot search if name is null
        if (name == null) {
            return null;
        }


        // checking each food in the storage
        for (int i = 0; i < count; i++) {

            // getting the position of the food
            int position = (front + i) % MAX_SIZE;


            FoodItem food = items[position];


            // comparing the food name with the name user entered
            if (food.getName().equalsIgnoreCase(name)) {
                return food;
            }
        }


        // if no food was found this method return null
        return null;
    }
}
