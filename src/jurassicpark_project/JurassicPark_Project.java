
package jurassicpark_project;
import Dinosaurs.*;
import Staff.*;
import Habitats.*;
import Feedings.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;


public class JurassicPark_Project {

   
    public static void main(String[] args) {
        System.out.println("hola");
        ArrayList<Dinosaur> dinosaurs = new ArrayList<>();
        ArrayList<Person> staff = new ArrayList<>();
        ArrayList<Habitat> habitats = new ArrayList<>();
        
        
        
        for(Dinosaur a: dinosaurs){
            for(Person b: staff){
             if((a.getVetId()).matches(b.getId())){
                 ((Veterinarian) b).addDino(a);
             }
             if((a.getTrainerId()).matches(b.getId())){
                 ((Trainer) b).addDino(a);
             }
            }   
        }
        for(Dinosaur a: dinosaurs){
            for(Habitat b : habitats){
                if(a instanceof Velociraptor){
                    if(b instanceof Terrestrial){
                        ((Terrestrial)b).addDino(a);
                    }
                }
                if(a instanceof Mosasaurus){
                    if(b instanceof Marine){
                        ((Marine)b).addDino(a);
                    }
                }
                if(a instanceof Pterodactylus){
                    if(b instanceof Aerial){
                        ((Aerial)b).addDino(a);
                    }
                }
                if(a instanceof Branchiosaurus){
                    if(b instanceof Terrestrial){
                        ((Terrestrial)b).addDino(a);
                    }
                }
            }
        }
    }
    
}
