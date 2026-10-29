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
