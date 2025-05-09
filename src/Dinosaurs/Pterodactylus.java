
package Dinosaurs;


public class Pterodactylus extends Dinosaur{
    private double wingspan;
    private double flightRange;
    
    public Pterodactylus(){
        this.flightRange = 0;
        this.wingspan = 0;
    }
    public Pterodactylus(String name, int age, double weigth, double wingspan, double flightRange){
        super(name, age, weigth);
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
    public void glideLongDistances(){
    }
    public void diveAttack(){
    }
    
    @Override
    public String toString(){
        String str = super.toString() + "nWingspan: " + this.getWingspan() + "\nFlight Range: " + this.getFlightRange();
        return str;
    }
    
}
