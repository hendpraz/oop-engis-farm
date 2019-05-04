package farmanimal;
import javax.swing.JOptionPane;

import products.*;
import products.farm.*;

public class Chicken extends FarmAnimal implements EggProducingFarmAnimal, MeatProducingFarmAnimal{
    public boolean IsEggProducing(){
        return true;
    }

    public boolean IsMeatProducing(){
        return true;
    }

    public char render() {
        if (this.getHungry() ){
            return 'a' ; //System.out.print("a");
        }else{
            return 'A' ; //System.out.print("A");
        }
    }
    
    public void ToSound() {
        //System.out.println("Petok petok");
    	JOptionPane.showMessageDialog(null, "Petok petok");
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
