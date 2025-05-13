
package Dinosaurs;


public class Pterodactylus extends Dinosaur{
    private double wingspan;
    private double flightRange;
    
    public Pterodactylus(){
        this.flightRange = 0;
        this.wingspan = 0;
    }
    public Pterodactylus(String id, String vetId, String trainerId, String name, int age, double weigth, String typeOfFood, int dailyAmount, int frecuency, double wingspan, double flightRange){
        super(id, vetId, trainerId, name, age, weigth,typeOfFood, dailyAmount,frecuency);
        this.setWingspan(wingspan);
        this.setFlightRange(flightRange);
    }
    
    public void setWingspan(double wingspan){
        if(wingspan < 1){
            throw new IllegalArgumentException("The wingspan is not valid.");
        }else{
            this.wingspan = wingspan;
        }
    }
    public void setFlightRange(double flightRange){
        if(flightRange < 1){
            throw new IllegalArgumentException("The Flight Range is not valid.");
        }else{
            this.flightRange = flightRange;
        }
    }
    public double getWingspan(){
        return this.wingspan;
    }
    public double getFlightRange(){
        return this.flightRange;
    }

    
    @Override
    public String toString(){
        String str = super.toString() + "nWingspan: " + this.getWingspan() + "\nFlight Range: " + this.getFlightRange();
        return str;
    }
    
}
