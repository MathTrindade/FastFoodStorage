package fastfoodstorage;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author mathe
 */




import java.time.LocalDate;
import java.time.LocalDateTime;

public class FoodItem {

    // Food information
    private String name;
    private double weight;
    private LocalDate bestBeforeDate;
    private LocalDateTime timeStored;

    // Constructor
    public FoodItem(String name, double weight, LocalDate bestBeforeDate) {
        this.name = name;
        this.weight = weight;
        this.bestBeforeDate = bestBeforeDate;
        this.timeStored = LocalDateTime.now();
    }
    
    // Getters
    // This methods return the food detail without changing the values
    public String getName() {
        return name;
    }
    
    public double getWeight() {
        return weight;
    }
    
    public LocalDate getBestBeforeDate() {
        return bestBeforeDate;
    }
    
    public LocalDateTime getTimeStored() {
       return timeStored;
    }
    
}
