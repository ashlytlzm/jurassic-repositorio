
package Habitats;
import Dinosaurs.*;

public class Marine extends Habitat{
    private double waterTemperature;
    private double salinityLevel;
    
    public Marine(){
        this.waterTemperature = 0;
        this.salinityLevel = 0;
    }
    public Marine(String ubication, String name, double waterTemperature, double salinityLevel){
        super(ubication, name);
        this.setWaterTemperature(waterTemperature);
        this.setSalinityLevel(salinityLevel);
    }
    
    public void setWaterTemperature(double waterTemperature){
        if(waterTemperature < 0){
            throw new IllegalArgumentException("The Water Temperature is not valid.");
        }else{
            this.waterTemperature = waterTemperature;
        }
    }
    public void setSalinityLevel(double salinityLevel){
        if(salinityLevel<0 || salinityLevel > 60){
            throw new IllegalArgumentException("The Salinity Level is not valid.");
        }else{
            this.salinityLevel = salinityLevel;
        }
    }
    public double getWaterTemperature(){
        return this.waterTemperature;
    }
    public double getSalinityLevel(){
        return this.salinityLevel;
    }
    
    @Override
    public void addDino(Dinosaur dino){
    }
    
    @Override
    public String toString(){
        String str = super.toString() + "\nWater Temperature: " + this.getWaterTemperature() +
                "\nSalinity Level: " + this.getSalinityLevel() + "%";
        return str;
    }
       
}
