
package Feedings;
import Dinosaurs.*;


public class Feeding {
    private String typeOfFood;
    private int amountPerMeal;
    private int frecuency;

     public Feeding() {
         this.typeOfFood = null;
         this.amountPerMeal = 0;
         this.frecuency = 0;
        
    }
    public Feeding(String typeOfFood, int dailyAmount, int frecuency) {
        this.typeOfFood = typeOfFood;
        this.amountPerMeal = dailyAmount;
        this.frecuency = frecuency;
    }
    public void setTypeOfFood(String typeOfFood) {
        if(typeOfFood == null || typeOfFood.isBlank() || typeOfFood.matches(".*[-!@#$%^&*()+=<>?/].*")){
            throw new IllegalArgumentException("The age is not valid.");
        }else{
            this.typeOfFood= typeOfFood;
        }
    }

    public void setAmountPerMeal(int amountPerMeal) {
        if(amountPerMeal< 1 || amountPerMeal < 30){
            throw new IllegalArgumentException("The Age is not valid.");
        }else{
            this.amountPerMeal = amountPerMeal;
        }
    }

    public void setFrecuency(int frecuency) {
        if(frecuency< 1 || frecuency < 250){
            throw new IllegalArgumentException("The Age is not valid.");
        }else{
            this.frecuency = frecuency;
        }
    }
     public String getTypeOfFood() {
        return this.typeOfFood;
    }

    public int getAmountPerMeal() {
        return this.amountPerMeal;
    }

    public int getFrecuency() {
        return this.frecuency;
    }
    
    
    @Override
    public String toString(){
        String str = "\nFEEDING: \nType of food: " + this.getTypeOfFood() + "\nAmount Per Meal: " +
                 this.getAmountPerMeal() + "\nFrecuency: " + this.getFrecuency();
        return str;
    }
    
}
