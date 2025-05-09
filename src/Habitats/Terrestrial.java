
package Habitats;
import Dinosaurs.*;

public class Terrestrial extends Habitat{
    private String soilType;
    private double averageHumidity;
    
    public Terrestrial(){
        this.soilType = null;
        this.averageHumidity = 0;
    }
    public Terrestrial(String ubication, String name, String soilType, double averageHumidity){
        super(ubication,name);
        this.setSoilType(soilType);
        this.setAverageHumidity(averageHumidity);
    }
    
    public void setSoilType(String soilType){
        if(soilType == null || soilType.isBlank() || soilType.matches(".*[-!@#$%^&*()+=<>?/].*")){
        }else{
            this.soilType = soilType;
        }
    }
    public void setAverageHumidity(double averageHumidity){
        if(averageHumidity < 1 || averageHumidity > 100){
            throw new IllegalArgumentException("The Average Humidity is not valid.");
        }else{
            this.averageHumidity = averageHumidity;
        }
    }
    public String getSoilType(){
        return this.soilType;
    }
    public double getAverageHumidity(){
        return this.averageHumidity;
    }
    
    @Override
    public void addDino(Dinosaur dino){
        this.dinosInHabitat.add(dino);
    }
    
    @Override
    public String toString(){
        String str = super.toString() + "\nSoil Type: " + this.getSoilType() +
                "\nAverage Humidity: " + this.getAverageHumidity();
        return str;
    }
    
}
