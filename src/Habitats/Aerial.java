
package Habitats;
import Dinosaurs.*;
import java.util.ArrayList;

public class Aerial extends Habitat{
    private double maxAltitude;
    private double windSpeedAvg;
    
    public Aerial(){
        this.maxAltitude = 0;
        this.windSpeedAvg = 0;
    }
    public Aerial(String habitatId, String ubication, String name,ArrayList<Dinosaur> dinosInHabitat, double maxAltitude, double windSpeedAvg){
        super(habitatId, ubication,name, dinosInHabitat);
        this.setMaxAltitude(maxAltitude);
        this.setWindSpeedAvg(windSpeedAvg);
    }
    
    public void setMaxAltitude(double maxAltitude){
        if(maxAltitude < 1){
        }else{
            this.maxAltitude = maxAltitude;
        }
    }
    public void setWindSpeedAvg(double windSpeedAvg){
        if(windSpeedAvg < 1){
        }else{
            this.windSpeedAvg = windSpeedAvg;
        }
    }
    public double getMaxAltitude(){
        return this.maxAltitude;
    }
    public double getWindSpeedAvg(){
        return this.windSpeedAvg;
    }
   
    @Override
    public void addDino(Dinosaur dino){
        this.dinosInHabitat.add(dino);
    }
   
    @Override
    public String toString(){
        String str = super.toString() + "\nMax Altitude: " + this.getMaxAltitude() + "m" + 
                "\nWind Speed Average: " + this.getWindSpeedAvg() + "m/s";
        return str;
    }
    
}
