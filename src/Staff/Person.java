
package Staff;


public abstract class Person {
    private String name;
    private int age;
    protected String jobDescription;
    
    public Person(){
        this.name = null;
        this.age = 0;
    }
    public Person(String name, int age){
        this.setName(name);
        this.setAge(age);
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
        this.age = age;
    }
    public String getName(){
        return this.name;
    }
    public int getAge(){
        return this.age;
    }
    public abstract double getSalary();
    
    @Override
    public String toString(){
        String str = "\nName: " + this.getName() + "\nAge: " + this.getAge();
        return str;
    }
    
}
