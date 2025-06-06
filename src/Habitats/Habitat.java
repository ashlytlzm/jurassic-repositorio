
package Habitats;
import Dinosaurs.*;
import java.util.ArrayList;

public abstract class Habitat {
    private String ubication;
    private String name;
    private String habitatId;
    protected ArrayList<Dinosaur> dinosInHabitat = new ArrayList<>();
    
    public Habitat(){
        this.ubication = null;
        this.name = null;
    }
    public Habitat(String habitatId, String ubication, String name, ArrayList dinosInHabitat){
        this.dinosInHabitat = dinosInHabitat;
        this.sethabitatId(habitatId);
        this.setUbication(ubication);
        this.setName(name);
    }
    
    public void setUbication(String ubication){
        if(ubication == null || ubication.isBlank() || ubication.matches(".*[-!@#$%^&*()+=<>?/].*")){
            throw new IllegalArgumentException("The Ubication is not valid.");
        }else{
            this.ubication = ubication;
        }
    }
    public void sethabitatId(String habitatId) {
        if (habitatId == null || habitatId.isBlank() || !habitatId.matches("\\d+")) {
            throw new IllegalArgumentException("The vetId must contain only numbers.");
        } else {
            this.habitatId = habitatId;
        }
    }
    public void setName(String name){
        if(name == null || name.isBlank() || name.matches(".*[-!@#$%^&*()+=<>?/].*")){
            throw new IllegalArgumentException("The name is not valid");
        }else{
            this.name = name;
        }
    }
    public String getUbication(){
        return this.ubication;
    }
    public String getName(){
        return this.name;
    }
    
    public String getHabitatId(){
        return this.habitatId;
    }
    public void addDino(Dinosaur dino){
        this.dinosInHabitat.add(dino);
    }
    
    @Override
    public String toString() {
        String str = this.getClass().getSimpleName() + "\nUbication: " + this.getUbication() + "\nName: " + this.getName();
        return str;
    }
}
    
    

