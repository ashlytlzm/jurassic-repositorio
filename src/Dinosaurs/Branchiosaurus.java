
package Dinosaurs;


public class Branchiosaurus extends Dinosaur{
    private double neckLength;
    private double dailyFoodIntake;
    
    public Branchiosaurus(){
        this.neckLength = 0;
        this.dailyFoodIntake = 0;
    }
    public Branchiosaurus(String name, int age, double weigth, double neckLength, double dailyFoodIntake){
        super(name, age, weigth);
        this.setNeckLength(neckLength);
        this.setDailyFoodIntake(dailyFoodIntake);
    }
    
    public void setNeckLength(double neckLength){
        if(neckLength < 1){
            throw new IllegalArgumentException("The Neck Length is not valid.");
        }else{
            this.neckLength = neckLength;
        }
    }
    public void setDailyFoodIntake(double dailyFoodIntake){
        if(dailyFoodIntake < 1){
            throw new IllegalArgumentException("The Daily Food Intake is not valid.");
        }else{
            this.dailyFoodIntake = dailyFoodIntake;
        }
    }
    public double getNeckLength(){
        return this.neckLength;
    }
    public double getDailyFoodIntake(){
        return this.dailyFoodIntake;
    }
    public void eadtFromTallTrees(){
    }
    public void stompGround(){
    }
    
    @Override
    public String toString(){
        String str = "";
        return str;
    }
    
}
