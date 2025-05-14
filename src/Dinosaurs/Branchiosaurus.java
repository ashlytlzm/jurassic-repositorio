
package Dinosaurs;


public class Branchiosaurus extends Dinosaur{
    private double neckLength;
    private double dailyFoodIntake;
    
    public Branchiosaurus(){
        this.neckLength = 0;
        this.dailyFoodIntake = 0;
    }
    public Branchiosaurus(String id, String vetId, String trainerId, String name, int age, double weigth, String typeOfFood, int dailyAmount, int frecuency, double neckLength, double dailyFoodIntake){
        super(id, vetId, trainerId, name, age, weigth,typeOfFood, dailyAmount,frecuency);
        this.setNeckLength(neckLength);
        this.setDailyFoodIntake(dailyFoodIntake);
    }
    
    public void setNeckLength(double neckLength){
        if(neckLength < 1 || neckLength >300){
            throw new IllegalArgumentException("The Neck Length is not valid.");
        }else{
            this.neckLength = neckLength;
        }
    }
    public void setDailyFoodIntake(double dailyFoodIntake){
        if(dailyFoodIntake < 1 || dailyFoodIntake > 28){
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

    
    @Override
    public String toString(){
        String str = super.toString() + "\nNeck Length: " + this.getNeckLength() + "cm" +
                "\nDaily Food Intake: " + this.getDailyFoodIntake();
        return str;
    }
    
}
