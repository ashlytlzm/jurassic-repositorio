
package Staff;
import jurassicpark_project.*;


public class Shopkeeper extends Person{
    
    public int inventoryManaged;
    public double workOvertime;
    
    public Shopkeeper(){
        this.inventoryManaged = 0;
        this.workOvertime = 0;
    }
    public Shopkeeper(String name, int age,int inventoryManaged, double workOvertime){
        super(name, age);
        this.setInventoryManaged(inventoryManaged);
        this.setWorkOvertime(workOvertime);
    }
    
    public void setInventoryManaged(int inventoryManaged){
        if(inventoryManaged < 1){
        }else{
            this.inventoryManaged = inventoryManaged;
        }
    }
    public void setWorkOvertime(double workOvertime){
        if(workOvertime < 0){
        }else{
            this.workOvertime = workOvertime;
        }
    }
    public int getInventoryManaged(){
        return this.inventoryManaged;
    }
    public double getWorkOvertime(){
        return this.workOvertime;
    }
    
    @Override
    public double getSalary(){
        double salary = 1800 + (20*this.workOvertime);
        return salary;
    }
    
    @Override
    public String toString(){
        String str = super.toString() + "\nInventory Managed: " + this.getInventoryManaged() +
                "\nWorkOvertime: " + this.getWorkOvertime() + " hours";
        return str;
    }
}
