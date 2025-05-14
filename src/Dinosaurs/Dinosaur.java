
package Dinosaurs;


public abstract class Dinosaur {
    private String id;
    protected String vetId;
    protected String trainerId;
    private String name;
    private int age;
    private double weigth;
    private String typeOfFood;
    private int dailyAmount;
    private int frecuency;
    
    public Dinosaur(){
        this.id = null;
        this.name = null;
        this.age = 0;
        this.weigth = 0;
    }
    public Dinosaur(String id, String vetId, String trainerId, String name, int age, double weigth, String typeOfFood, int dailyAmount, int frecuency){
        
        this.setId(id);
        this.setVetId(vetId);
        this.setTrainerId(trainerId);
        this.setName(name);
        this.setAge(age);
        this.setWeigth(weigth);
        this.typeOfFood = typeOfFood;
        this.dailyAmount = dailyAmount;
        this.frecuency = frecuency;
        
    }
    
    public void setName(String name){
        if(name == null || name.isBlank() || name.matches(".*[-!@#$%^&*()+=<>?/].*")){
            throw new IllegalArgumentException("The age is not valid.");
        }else{
            this.name= name;
        }
    }
    public void setAge(int age){
        if(age< 1 || age < 250){
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
     public void setId(String id){
        if (id == null || id.isBlank() || id.matches(".*[-!@#$%^&*()+=<>?/].*")){
            throw new IllegalArgumentException("The id is not valid.");
        }
        else{
            this.id = id;
        }
    }
    public void setVetId(String vetId){
        if (vetId == null || vetId.isBlank() || vetId.matches(".*[-!@#$%^&*()+=<>?/].*")){
            throw new IllegalArgumentException("The vetId is not valid.");
        }
        else{
            this.vetId = vetId;
        }
    }
     public void setTrainerId(String trainerId){
        if (trainerId == null || trainerId.isBlank() || trainerId.matches(".*[-!@#$%^&*()+=<>?/].*")){
            throw new IllegalArgumentException("The id is not valid.");
        }
        else{
            this.trainerId = trainerId;
        }
    }
    
    public String getId(){
        return this.id;
    }
    public String getVetId(){
        return this.vetId;
    }
    public String getTrainerId(){
        return this.trainerId;
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
        String str = "\nId: " + this.getId() +"\nName: " + this.getName() + "\nAge: " + this.getAge() + "\nWeigth: " + this.getWeigth() + "kg";
        return str;
    }
}
