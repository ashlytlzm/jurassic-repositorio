
package jurassicpark_project;
import Dinosaurs.*;
import Staff.*;
import Habitats.*;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

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
    public static void writeFile(ArrayList<Dinosaur> dinosaurs){
        String filePath = "jpdinos.txt";
        try(BufferedWriter w = new BufferedWriter(new FileWriter(filePath))){
           w.write("<<LIST OF DINOSAURS>>\n");
            for(Dinosaur d: dinosaurs){
                w.write(d.toString());
                w.write(d.getFeeding().toString() + "\n");
                w.newLine();
            }
            w.write(
    "           __\n" +
    "          /*_*)\n" +
    "  _.----._/ /\n" +
    " /         /\n" +
    "/  (|  (|  |\n" +
    "\\_/|_/\\_|_/\n" );

            w.close();
            System.out.println("File: " + filePath + " created successfully");

        }catch(IOException ioe){
            System.out.println("Error writing file:" + filePath);
            ioe.printStackTrace();
        }
    }
    
    public static void writeFile2(ArrayList<Habitat> habitats){
        String filePath = "jphabitats.txt";
        try(BufferedWriter w = new BufferedWriter(new FileWriter(filePath))){
            w.write("<<LIST OF HABITATS>>\n");
           for (Habitat h : habitats) {
               if(h instanceof Aerial){
                w.write(h.toString());
                w.newLine();
            }else if(h instanceof Marine){
                w.write(h.toString());
                w.newLine();
            }else if(h instanceof Terrestrial){
                w.write(h.toString());
                w.newLine();    
             }else{
                w.newLine();
              }
            }
           w.write(
    "     &&&     &&&     &&&\n" +
    "    &&&&&   &&&&&   &&&&&\n" +
    "      ||      ||      ||\n" +
    "      ||      ||      ||\n" +
    "  -------------------------\n");

            w.close();
            System.out.println("File: " + filePath + " created successfully");

        }catch(IOException ioe){
            System.out.println("Error writing file:" + filePath);
            ioe.printStackTrace();
        }
    }
    
     public static void writeFile3( ArrayList<Person> staff){
        String filePath = "jpstaff.txt";
        try(BufferedWriter w = new BufferedWriter(new FileWriter(filePath))){
            w.write("<<LIST OF STAFF>>\n");
            for(Person p: staff){
            if(p instanceof Veterinarian){
                w.write(p.toString());
                w.newLine();
            }else if(p instanceof Trainer){
                w.write(p.toString());
                w.newLine();
            }else if(p instanceof Shopkeeper){
                w.write(p.toString());
                w.newLine();    
             }else{
                w.newLine();
              }
            }
            w.write(
    "   ██████   \n" +
    "   ██████   \n" +
    "██████████\n" +
    "██████████\n" +
    "   ██████   \n" +
    "   ██████   \n" +
    " Veterinarian");
            w.newLine();
            w.write(
    "   _____\n" +                
    "  |_____|\n" +
    "  ( ^_^ )\n" +
    "  /|_|_|\\\n" +
    "    |_|\n" +
    "   /   \\\n" +
    "  Trainer"
);

            
            w.close();
            System.out.println("File: " + filePath + " created successfully");

        }catch(IOException ioe){
            System.out.println("Error writing file:" + filePath);
            ioe.printStackTrace();
        }
    }
    
    public static void modifyDinoName(ArrayList<Dinosaur> dinosaurs){
        Scanner scanner = new Scanner(System.in);
        System.out.print("Insert the ID of the Dinosaur you want to search: ");
        String idSearch = scanner.nextLine();

        boolean found = false;
        for (Dinosaur d : dinosaurs) {
            if (d.getId().equals(idSearch)) {
                System.out.print("ID found, insert the new name of the Dinosaur " + idSearch + ": ");
                String newName = scanner.nextLine();
                d.setName(newName);
                System.out.println("_______________________");
                System.out.println("New Dinosaur data: " + d.toString());
                found = true;
                break;
            }
        }
        if(found != true){
            System.out.println("Dinosaur with the ID: " + idSearch + " not found...");
        }
    }
    
    public static void createTrainer(ArrayList<Person> staff){
        Scanner scanner = new Scanner(System.in);
        try{
            System.out.print("\nEnter the name of the Trainer: ");
            String name = scanner.nextLine();
            System.out.print("\nEnter the age of the Trainer: ");
            int age = scanner.nextInt();
            System.out.print("\nEnter the ID of the Trainer: ");
            String id = scanner.nextLine();
            scanner.nextLine();
            System.out.print("\nEnter the years of experience of the Trainer: ");
            int experienceYears = scanner.nextInt();
            System.out.print("\nEnter the speciality of the Trainer: ");
            String speciality = scanner.nextLine();
            Trainer intern1 = new Trainer(name,age,id,experienceYears,speciality);
            staff.add(intern1);
        }catch(IllegalArgumentException e){
            System.out.println("Error: " + e.getMessage());
        }catch(Exception e){
            System.out.println("Error: Some parameter was entered incorrectly. "
                    + "The object could not be created, there were errors in the entered data.");
        }
    }
    
    public static void createVeterinarian(ArrayList<Person> staff){
        Scanner scanner = new Scanner(System.in);
        try{
            System.out.print("\nEnter the name of the Veterinarian: ");
            String name = scanner.nextLine();
            System.out.print("\nEnter the age of the Veterinarian: ");
            int age = scanner.nextInt();
            System.out.print("\nEnter the id of the Veterinarian: ");
            String id = scanner.nextLine();
            scanner.nextLine();
            System.out.print("\nEnter the specialization of the Veterinarian: ");
            String specialization = scanner.nextLine();
            Veterinarian intern2 = new Veterinarian(name,age,id,specialization);
            staff.add(intern2);
        }catch(IllegalArgumentException e){
            System.out.println("Error: " + e.getMessage());
        }catch(Exception e){
            System.out.println("Error: Some parameter was entered incorrectly. "
                    + "The object could not be created, there were errors in the entered data.");
        }
    }
    
    public static void main(String[] args) {
        ArrayList<Dinosaur> dinosaurs;
        ArrayList<Habitat> habitats;
        ArrayList<Person> staff;
        Scanner scanner = new Scanner(System.in);
        dinosaurs = readDinosaurs("./Listadinosaur.txt");
        habitats = readHabitats("./ListaHabitats.txt", dinosaurs);
        staff = readStaff("./Listastaff.txt", dinosaurs);
        System.out.println("Creating the lists...");
        int option;
        boolean condition = false;
        try{
            while(!condition){
                System.out.println("****************************");
                System.out.println("    JURASSIC PARK'S MENU    ");
                System.out.println(
                                        "           __\n" +
                                        "          / _)\n" +
                                        "   .-^^^-/ /\n" +
                                        "__/       /\n" +
                                        "<__.|_|-|_|\n");
                System.out.println("****************************");
                System.out.println("1.) Modify a Dinosaur's name.");
                System.out.println("2.) Create a Trainer.");
                System.out.println("3.) Create a Veterinarian.");
                System.out.println("4.) Generete data reports.");
                System.out.println("5.) Exit.");
                System.out.println("\nChoose an option according to what you want to do: ");
                option = scanner.nextInt();
                
                if (option == 1){
                    modifyDinoName(dinosaurs);
                } else if(option == 2){
                    createTrainer(staff);
                }else if(option == 3){
                    createVeterinarian(staff);
                }else if(option == 4){
                    writeFile(dinosaurs);
                    writeFile2(habitats);
                    writeFile3(staff);
                }else if(option == 5){
                    condition = true;
                }else{
                    System.out.println("The selected option does not exist, please try again.");
                }
            }
        
        }catch(Exception e){
            System.out.println("Error: Incorrect information has been entered.");
        }   
    }
}

