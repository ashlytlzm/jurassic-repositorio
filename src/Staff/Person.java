
package Staff;


public abstract class Person {
    private String name;
    private int age;
    protected int id;
    
    public Person(){
        this.name = null;
        this.age = 0;
    }
    public Person(String name, int age, int id){
        this.setName(name);
        this.setAge(age);
        this.setId(id);
    }
    
    public void setName(String name){
        if (name == null || name.isBlank() || name.matches(".*[-!@#$%^&*()+=<>?/].*")){
            throw new IllegalArgumentException("The name is not valid.");
        }
        else{
            this.name = name;
        }
    }
    public void setAge(int age){
        if (age<1 || age >120){
            throw new IllegalArgumentException("The age is not valid.");
        }
        else{
            this.age = age;
        }
    }
    public void setId(int id){
        if (id<01){
            throw new IllegalArgumentException("The id is not valid.");
        }
        else{
            this.id = id;
    
        }
    }
    public String getName(){
        return this.name;
    }
    public int getAge(){
        return this.age;
    }
    public int getId(){
        return this.id;
    }
    public abstract double getSalary();
    
    @Override
    public String toString(){
        String str = "\nName: " + this.getName() + "\nAge: " + this.getAge() + "\nId: " + this.getId();
        return str;
    }
    
}
