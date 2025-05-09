
package Dinosaurs;


public abstract class Dinosaur {
    private String name;
    private int age;
    private double weigth;
    
    public Dinosaur(){
        this.name = null;
        this.age = 0;
        this.weigth = 0;
    }
    public Dinosaur(String name, int age, double weigth){
        this.setName(name);
        this.setAge(age);
        this.setWeigth(weigth);
    }
    
    public void setName(String name){
        if(name == null || name.isBlank() || name.matches(".*[-!@#$%^&*()+=<>?/].*")){
            throw new IllegalArgumentException("The age is not valid.");
        }else{
            this.name= name;
        }
    }
    public void setAge(int age){
        if(age< 1){
            throw new IllegalArgumentException("The Age is not valid.");
        }else{
            this.age = age;
        }
    }
    public void setWeigth(double weigth){
        if(weigth < 1){
            throw new IllegalArgumentException("The Weigth is not valid.");
        }else{
            this.weigth = weigth;
        }
    }
    public String getName(){
        return this.name;
    }
    public int getAge(){
        return this.age;
    }
    public double getWeigth(){
        return this.weigth;
    }
    
    @Override
    public String toString(){
        String str = "\nName: " + this.getName() + "\nAge: " + this.getAge() + "\nWeigth: " + this.getWeigth() + "kg";
        return str;
    }
}
