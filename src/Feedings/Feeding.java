
package Feedings;


public class Feeding {
    private String typeOfFood;
    private int dailyAmount;
    private int frecuency;

     public Feeding() {
        
    }
    public Feeding(String typeOfFood, int dailyAmount, int frecuency) {
        this.typeOfFood = typeOfFood;
        this.dailyAmount = dailyAmount;
        this.frecuency = frecuency;
    }

    public String getTypeOfFood() {
        return typeOfFood;
    }

    public int getDailyAmount() {
        return dailyAmount;
    }

    public int getFrecuency() {
        return frecuency;
    }

    public void setTypeOfFood(String typeOfFood) {
        this.typeOfFood = typeOfFood;
    }

    public void setDailyAmount(int dailyAmount) {
        this.dailyAmount = dailyAmount;
    }

    public void setFrecuency(int frecuency) {
        this.frecuency = frecuency;
    }
    
    
    
    
}
