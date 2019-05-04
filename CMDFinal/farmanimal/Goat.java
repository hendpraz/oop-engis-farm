package farmanimal;
import javax.swing.JOptionPane;

import products.*;
import products.farm.*;

public class Goat extends FarmAnimal implements MilkProducingFarmAnimal, MeatProducingFarmAnimal{
    public boolean IsMeatProducing(){
        return true;
    }

    public boolean IsMilkProducing(){
        return true;
    }

    public char render() {
        if (this.getHungry() ){
            return 'k' ; //System.out.print("k");
        }else{
            return 'K' ; //System.out.print("K");
        }
    }
    
    public void ToSound() {
        //System.out.println("Mbeeek");
    	JOptionPane.showMessageDialog(null, "Mbeeek");
    }
    
    public int getDurationForHungryTime() {
        return 25 ; 
    }
    
    public FarmProduct createProduct() {
        FarmProduct p = new GoatMilk() ;
        return p ;
    }
    
    public FarmProduct getMeatProduct() {
        FarmProduct p = new GoatMeat() ;
        return p ;
    }
}
