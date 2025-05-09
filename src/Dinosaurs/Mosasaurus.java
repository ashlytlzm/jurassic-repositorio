
package Dinosaurs;


public class Mosasaurus extends Dinosaur{
    private double SwimDepth;
    private String behavior;
    
    public Mosasaurus(){
        this.SwimDepth = 0;
        this.behavior = null;
    }
    public Mosasaurus(String name, int age, double weigth, double swimDepth, String behavior){
        super(name, age, weigth);
        this.setSwimDepth(swimDepth);
        this.setBehavior(behavior);
    }
    
    
    public void setSwimDepth(double swimDepth){
        if(swimDepth < 1){
            throw new IllegalArgumentException("The Swim Depth is not valid.");
        }else{
            this.SwimDepth = swimDepth;
        }
    }
    public void setBehavior(String behavior){
        if(behavior == null || behavior.isBlank() || behavior.matches(".*[-!@#$%^&*()+=<>?/].*")){
            throw new IllegalArgumentException("The behavior is not valid.");
        }else{
            this.behavior = behavior;
        }
    }
    public double getSwimDepth(){
        return this.SwimDepth;
    }
    public String getBehavior(){
        return this.behavior;
    }
    public void swimDeep(){
        
    }
    public void ambushFromBelow(){
    }
    
    @Override
    public String toString(){
        String str = super.toString() + "\nSwimDepth: " + this.getSwimDepth() + "\nBehavior: " + this.getBehavior();
        return str;
    }
}
