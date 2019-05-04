package main.farmanimal;
import main.products.*;
import main.products.farm.*;

public class Chicken extends FarmAnimal implements EggProducingFarmAnimal, MeatProducingFarmAnimal{
    public boolean IsEggProducing(){
        return true;
    }

    public boolean IsMeatProducing(){
        return true;
    }

    public void render() {
        if (this.getHungry() ){
            System.out.print("a");
        }else{
            System.out.print("A");
        }
    }
    
    public void ToSound() {
        System.out.println("Petok petok");
    }
    
    public int getDurationForHungryTime() {
        return 15 ; 
    }
    
    public FarmProduct createProduct() {
        FarmProduct p = new ChickenEgg() ;
        return p ;
    }
    
    public FarmProduct getMeatProduct() {
        FarmProduct p = new ChickenMeat() ;
        return p ;
    }
}
