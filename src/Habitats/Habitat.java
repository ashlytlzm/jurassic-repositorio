
package Habitats;
import Dinosaurs.*;
import java.util.ArrayList;

public abstract class Habitat {
    private String ubication;
    private String name;
    protected ArrayList<Dinosaur> dinosInHabitat = new ArrayList<>();
    
    public Habitat(){
        this.ubication = null;
        this.name = null;
    }
    public Habitat(String ubication, String name){
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
    
    abstract void addDino(Dinosaur dino);
    
    @Override
    public String toString(){
        String str = "\nUbication: " + this.getUbication() + "\nName: " + this.getName();
        return str;
    }
    
    
}
