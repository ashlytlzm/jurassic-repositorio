
package Habitats;
import Dinosaurs.*;

public class Aerial extends Habitat{
    private double maxAltitude;
    private double windSpeedAvg;
    
    public Aerial(){
        this.maxAltitude = 0;
        this.windSpeedAvg = 0;
    }
    public Aerial(String ubication, String name, double maxAltitude, double windSpeedAvg){
        super(ubication,name);
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
    }
   
    @Override
    public String toString(){
        String str = super.toString() + "\nMax Altitude: " + this.getMaxAltitude() + "m" +
                "\nWind Speed Average: " + this.getWindSpeedAvg() + "m/s";
        return str;
    }
    
}
