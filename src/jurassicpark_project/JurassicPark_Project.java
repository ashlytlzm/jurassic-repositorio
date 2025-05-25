
package jurassicpark_project;
import Dinosaurs.*;
import Staff.*;
import Habitats.*;
import Feedings.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

public class JurassicPark_Project {

public static ArrayList<Dinosaur> readDinosaurs(String filePath) {
        ArrayList<Dinosaur> dinosaurs = new ArrayList<>();
        String line = "";
        String dino = "";
        String id = "";
        String vetId = "";
        String trainerId = "";
        String name = "";
        int age = 0;
        double weigth = 0;
        String typeOfFood = "";
        int amountPerMeal = 0;
        int frecuency = 0;

        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {

            while ((line = reader.readLine()) != null) {
                line = line.trim();  // elimina los espacios al incio y al final
                if (line.isEmpty()) { // ignnota lineas vacias
                    continue;
                }

                String[] parts = line.split(",");

                if (parts.length >= 10) {
                    dino = parts[0].trim();
                    id = parts[1].trim();
                    vetId = parts[2].trim();
                    trainerId = parts[3].trim();
                    name = parts[4].trim();
                    age = Integer.parseInt(parts[5].trim());
                    weigth = Double.parseDouble(parts[6].trim());
                    typeOfFood = parts[7].trim();
                    amountPerMeal = Integer.parseInt(parts[8].trim());
                    frecuency = Integer.parseInt(parts[9].trim());

                    switch (dino) {
                        case "Branchiosaurus" -> {
                            try {
                                double neckLength = Double.parseDouble(parts[10].trim());
                                double dailyWaterIntake = Double.parseDouble(parts[11].trim());
                                dinosaurs.add(new Branchiosaurus(id, vetId, trainerId, name, age, weigth, typeOfFood, amountPerMeal, frecuency, neckLength, dailyWaterIntake));

                            } catch (Exception e) {
                                System.out.println("Error creating the object: " + e.getMessage());
                            }
                        }
                        case "Pterodactylus" -> {
                            try {
                                double wingspan = Double.parseDouble(parts[10].trim());
                                double flightRange = Double.parseDouble(parts[11].trim());
                                dinosaurs.add(new Pterodactylus(id, vetId, trainerId, name, age, weigth, typeOfFood, amountPerMeal, frecuency, wingspan, flightRange));
                            } catch (Exception e) {
                                System.out.println("Error creating the object: " + e.getMessage());
                            }
                        }
                        case "Mosasaurus" -> {
                            try {
                                double swimDepth = Double.parseDouble(parts[10].trim());
                                String behaviour = parts[11].trim();
                                dinosaurs.add(new Mosasaurus(id, vetId, trainerId, name, age, weigth, typeOfFood, amountPerMeal, frecuency, swimDepth, behaviour));
                            } catch (Exception e) {
                                System.out.println("Error creating the object: " + e.getMessage());
                            }
                        }
                        case "Velociraptor" -> {
                            try {
                                int agilityLevel = Integer.parseInt(parts[10].trim());
                                double speed = Double.parseDouble(parts[11].trim());
                                dinosaurs.add(new Velociraptor(id, vetId, trainerId, name, age, weigth, typeOfFood, amountPerMeal, frecuency, agilityLevel, speed));
                            } catch (Exception e) {
                                System.out.println("Error creating the object: " + e.getMessage());
                            }
                        }
                        default -> {
                        }
                    }

                } else {
                    System.out.println("Not enough data to create the object...");
                }
            }
            reader.close();
        } catch (IOException e) {
            System.err.println("Error reading file: " + e.getMessage());
        }
        for(Dinosaur d: dinosaurs){
            d.addFeeding();
            
        }
        return dinosaurs;

    }

    public static ArrayList<Habitat> readHabitats(String filePath, ArrayList<Dinosaur> dinosaurs) {

        ArrayList<Habitat> habitats = new ArrayList<>();

        String line = "";
        String habitat = "";
        String ubication = "";
        String name = "";
        String habitatId = "";
        Dinosaur tempDino = null;
        

        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {

            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                ArrayList<Dinosaur> dinosInHabitat = new ArrayList<>();

                if (parts.length >= 6) {
                    
                    habitatId = parts[0].trim();
                    habitat =  parts[1].trim();
                    ubication = parts[2].trim();
                    name = parts[3].trim();
                    switch (habitat) {
                        case "Aerial" -> {
                            try {

                                double maxAltitude = Double.parseDouble(parts[4].trim());
                                double windSpeedAvg = Double.parseDouble(parts[5].trim());
                                for(Dinosaur d: dinosaurs){
                                    if(habitatId.equals(d.getId())){
                                        dinosInHabitat.add(d);
                                        
                                    }
                                }
                                habitats.add(new Aerial(habitatId, ubication, name,dinosInHabitat, maxAltitude, windSpeedAvg));
                            } catch (Exception e) {
                                System.out.println("Error creating the object: " + e.getMessage());
                            }
                        }
                        case "Marine" -> {
                            try {
                                double waterTemperature = Double.parseDouble(parts[4].trim());
                                double salinityLevel = Double.parseDouble(parts[5].trim());
                                for(Dinosaur d: dinosaurs){
                                    if(habitatId.equals(d.getId())){
                                        dinosInHabitat.add(d);
                                        
                                    }
                                }
                                habitats.add(new Marine(habitatId, ubication, name,dinosInHabitat, waterTemperature, salinityLevel));
                            } catch (Exception e) {
                                System.out.println("Error creating the object: " + e.getMessage());
                            }
                        }
                        case "Terrestrial" -> {
                            try {
                                
                                String soilType = parts[4].trim();
                                double averageHumidity = Double.parseDouble(parts[5].trim());
                                for(Dinosaur d: dinosaurs){
                                    if(habitatId.equals(d.getId())){
                                        dinosInHabitat.add(d);
                                        
                                    }
                                }

                                habitats.add(new Terrestrial(habitatId, ubication, name,dinosInHabitat, soilType, averageHumidity));
                            } catch (Exception e) {
                                System.out.println("Error creating the object: " + e.getMessage());
                            }
                        }
                        default -> {
                        }
                    }
                } else {
                    System.out.println("Not enough data to create the object...");
                }
            }
            reader.close();
        } catch (IOException e) {
            System.err.println("Error reading file: " + e.getMessage());
        }
        return habitats;

    }
    
    public static void agregacion(ArrayList<Dinosaur> dinosaurs, ArrayList<Habitat> habitats) {
        for (Dinosaur a : dinosaurs) {
            for (Habitat b : habitats) {
                if (a instanceof Velociraptor) {
                    if (b instanceof Terrestrial) {
                        ((Terrestrial) b).addDino(a);
                    }
                }
                if (a instanceof Mosasaurus) {
                    if (b instanceof Marine) {
                        ((Marine) b).addDino(a);
                    }
                }
                if (a instanceof Pterodactylus) {
                    if (b instanceof Aerial) {
                        ((Aerial) b).addDino(a);
                    }
                }
                if (a instanceof Branchiosaurus) {
                    if (b instanceof Terrestrial) {
                        ((Terrestrial) b).addDino(a);
                    }
                }
            }

        }
    }
    
    public static ArrayList<Person> readStaff(String filePath, ArrayList<Dinosaur> dinosaurs){
        ArrayList<Person> staff = new ArrayList<>();
        String line = "";
        String typePerson = "";
        String name = "";
        int age = 0;
        String staffId = "";

        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                ArrayList<Dinosaur> dinosToTrain = new ArrayList<>();
                ArrayList<Dinosaur> dinosToCare = new ArrayList<>();
                ArrayList<Dinosaur> dinoVisits = new ArrayList<>();

                if (parts.length >= 5) {
                    typePerson = parts[0].trim();
                    name = parts[1].trim();
                    age = Integer.parseInt(parts[2].trim());
                    staffId = parts[3].trim();

                    switch (typePerson) {
                        case "Veterinarian" -> {
                            try {
                                String specialization = parts[4].trim();
                                staff.add(new Veterinarian(name, age, staffId, specialization));
                                for (Dinosaur d : dinosaurs) {
                                    if (staffId.equals(d.getVetId())) {
                                        for (Person p : staff) {
                                            if (p instanceof Veterinarian) {
                                                ((Veterinarian) p).addDino(d);
                                            }
                                        }
                                    }
                                }
                            } catch (Exception e) {
                                System.out.println("Error creating the object: " + e.getMessage());
                            }

                        }
                        case "Trainer" -> {
                            try {
                                int experienceYears = Integer.parseInt(parts[4].trim());
                                String speciality = parts[5].trim();
                                staff.add(new Trainer(name, age, staffId, experienceYears, speciality));
                                for (Dinosaur d : dinosaurs) {
                                    if (staffId.equals(d.getTrainerId())) {
                                        for (Person p : staff) {
                                            if (p instanceof Trainer) {
                                                ((Trainer) p).addDino(d);
                                            }
                                        }
                                    }
                                }
                            } catch (Exception e) {
                                System.out.println("Error creating the object: " + e.getMessage());
                            }

                        }
                        case "Shopkeeper" -> {
                            try {
                                int inventoryManaged = Integer.parseInt(parts[4].trim());
                                double workOvertime = Double.parseDouble(parts[5].trim());
                                staff.add(new Shopkeeper(name, age, staffId, inventoryManaged, workOvertime));
                            } catch (Exception e) {
                                System.out.println("Error creating the object: " + e.getMessage());
                            }

                        }
                        default -> {
                        }

                    }
                    
                }
                else{
                    System.out.println("Not enough data to create the object..." + Arrays.toString(parts));    
                        }
                
            }
            reader.close();
        } catch(IOException e){
            System.err.println("Error reading file: " + e.getMessage());
        }
        return staff;
        
    }

    public static void main(String[] args) {
        ArrayList<Dinosaur> dinosaurs;
        ArrayList<Habitat> habitats;
        ArrayList<Person> staff;
        System.out.println("Creating the list...");
        dinosaurs = readDinosaurs("./Listadinosaur.txt");
        habitats = readHabitats("./ListaHabitats.txt", dinosaurs);
        staff = readStaff("./Listastaff.txt", dinosaurs);
        for (Habitat h : habitats) {
            System.out.println(h.toString());
        }
        System.out.println("");
        for(Dinosaur d: dinosaurs){
            System.out.println(d.toString());
            System.out.println(d.getFeeding().toString());
        }  
        System.out.println("");
        for(Person p: staff){
            System.out.println(p.toString());
        }
        
        
        
        
}
}

        /*for(Dinosaur a: dinosaurs){
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
    
}*/
