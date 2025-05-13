
package Staff;
import Dinosaurs.*;
import jurassicpark_project.*;
import java.util.ArrayList;

public class Trainer  extends Person implements DinoStaffFunctions{
    private int experienceYears;
    private String speciality;
    protected ArrayList<Dinosaur> dinosToTrain = new ArrayList<>();
    
    public Trainer(){
        this.experienceYears = 0;
        this.speciality = null;
    }
    public Trainer(String name, int age, int id, int experienceYears, String speciality){
        super(name, age, id);
        this.setExperienceYears(experienceYears);
        this.setSpeciality(speciality);
    }
    public void setExperienceYears(int experienceYears){
        this.experienceYears= experienceYears;
    }
    public void setSpeciality(String speciality){
        if (speciality == null || speciality.isBlank() || speciality.matches(".*[-!@#$%^&*()+=<>?/].*")){
            throw new IllegalArgumentException("The speciality is not valid.");
        }
        else{
            this.speciality = speciality;
        }
    }
    public int getExperienceYears(){
        return this.experienceYears;
    }
    public String getSpeciality(){
        return this.speciality;
    }
    
    @Override
    public void addDino(Dinosaur dino){
        this.dinosToTrain.add(dino);
    }
    @Override
    public void getDinosInCharge(){
        for(Dinosaur p: dinosToTrain){
            System.out.println(p.toString());
        }
    }
    
    @Override
    public double getSalary(){
        double salary = 2100 + (200*this.experienceYears);
        switch(speciality){
            case "Branchiosaurus" -> salary +=8000;
            case "Mosasaurus" -> salary += 1500;
            case "Pterodactylus" -> salary +=2000;
            case "Velociraptor" -> salary +=1000;
            default -> salary += 0;
        }
        return salary;
    }
    
    @Override
    public String toString(){
        String str = super.toString() + "\nExperienceYears: " + this.getExperienceYears() + "\nSpeciality: " + this.getSpeciality(); 
        return str;
    }
}
