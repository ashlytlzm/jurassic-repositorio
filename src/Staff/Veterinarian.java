
package Staff;
import Dinosaurs.*;
import jurassicpark_project.*;
import java.util.ArrayList;


public class Veterinarian extends Person implements DinoStaffFunctions{
    
    private String specialization;
    protected ArrayList <Dinosaur> dinosToCare = new ArrayList<>();
    protected ArrayList <Dinosaur> dinoVisits = new ArrayList <>();
    
    public Veterinarian(){
        this.specialization = null;
    }
    public Veterinarian(String name, int age, int id, String specialization){
        super(name, age, id);
        this.setSpecialization(specialization);
    }
    
    public void setSpecialization(String specialization){
        if(specialization == null || specialization.isBlank() || specialization.matches(".*[-!@#$%^&*()+=<>?/].*")){
        }else{
            this.specialization = specialization;
        }
    }
    public String getSpecialization(){
        return this.specialization;
    }
    public void addDinoVisit(Dinosaur dino){
        this.dinoVisits.add(dino);
    }
    
     @Override
    public void addDino(Dinosaur dino){
        this.dinosToCare.add(dino);
    }
    @Override
    public void getDinosInCharge(){
        for(Dinosaur p: dinosToCare){
            System.out.println(p.toString());
        }
    }
    
    @Override
    public double getSalary(){
        double salary = 2300 + (100*this.dinoVisits.size());
        switch(specialization){
            case "Medicine in exotic animals" -> salary +=2000000;
            case "Animal Nutrition" -> salary += 1500000;
            case "Animal Anesthesiology" -> salary +=1000000;
            default -> salary += 0;
        }
        return salary;
        
    }
    @Override
    public String toString(){
        String str = super.toString() + "\nSpecialization: " + this.getSpecialization();
         return str;
    }
}
