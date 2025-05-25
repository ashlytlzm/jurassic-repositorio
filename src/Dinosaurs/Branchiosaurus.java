
package Dinosaurs;


public class Branchiosaurus extends Dinosaur{
    private double neckLength;
    private double dailyWaterIntake;
    
    public Branchiosaurus(){
        this.neckLength = 0;
        this.dailyWaterIntake = 0;
    }
    public Branchiosaurus(String id, String vetId, String trainerId, String name, int age, double weigth, String typeOfFood, int amountPerMeal, int frecuency, double neckLength, double dailyWaterIntake){
        super(id, vetId, trainerId, name, age, weigth,typeOfFood, amountPerMeal,frecuency);
        this.setNeckLength(neckLength);
        this.setDailyWaterIntake(dailyWaterIntake);
    }
    
    public void setNeckLength(double neckLength){
        if(neckLength < 1 || neckLength >300){
            throw new IllegalArgumentException("The Neck Length is not valid.");
        }else{
            this.neckLength = neckLength;
        }
    }
    public void setDailyWaterIntake(double dailyWaterIntake){
        if(dailyWaterIntake < 1 || dailyWaterIntake > 300){
            throw new IllegalArgumentException("The Daily Water Intake is not valid.");
        }else{
            this.dailyWaterIntake = dailyWaterIntake;
        }
    }
    public double getNeckLength(){
        return this.neckLength;
    }
    public double getDailyWaterIntake(){
        return this.dailyWaterIntake;
    }

    
    @Override
    public String toString(){
        String str = super.toString() + "\nNeck Length: " + this.getNeckLength() + "cm" +
                "\nDaily Food Intake: " + this.getDailyWaterIntake() + "L";
        return str;
    }
    
}
