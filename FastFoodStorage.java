/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package fastfoodstorage;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalDate;
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

        
        //creating three food items
        
    FoodItem burger = new FoodItem("Burger", 250, LocalDate.now().plusDays(5));
    
    FoodItem pizza = new FoodItem("Pizza", 400, LocalDate.now().plusDays(7));
    
    FoodItem fries = new FoodItem("Fries", 150, LocalDate.now().plusDays(3));
        
    //adding food to the storage 
    
    storage.addFood(burger);
    
    storage.addFood(pizza);
    
    storage.addFood(fries);
    
    // testing displayFood to show all food items in storage
storage.displayFood();
 

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

    }
    
     
}
