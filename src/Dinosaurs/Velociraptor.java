
package Dinosaurs;


public class Velociraptor extends Dinosaur{
    private int agilityLevel;
    private double speed;
    
    public Velociraptor(){
        this.agilityLevel = 0;
        this.speed= 0;
    }
    public Velociraptor(String id, String vetId, String trainerId, String name, int age, double weigth, String typeOfFood, int dailyAmount, int frecuency, int agilityLevel, double speed){
        super(id, vetId, trainerId, name, age, weigth,typeOfFood, dailyAmount,frecuency);
        this.setAgilityLevel(agilityLevel);
        this.setSpeed(speed);
    }
    
    public void setAgilityLevel(int agilityLevel){
        if(agilityLevel < 1){
        }else{
            this.agilityLevel = agilityLevel;
        }
    }
    public void setSpeed(double speed){
        if(speed < 1){
            throw new IllegalArgumentException("The Speed is not valid.");
        }else{
            this.speed= speed;
        }
    }
    public int getAgilityLevel(){
        return this.agilityLevel;
    }
    public double getSpeed(){
        return this.speed;
    }

    
    @Override
    public String toString(){
        String str= super.toString() + "nAgility Level: " + this.getAgilityLevel() + "\nSpeed: " + this.getSpeed();
        return str;
    }
    
}
