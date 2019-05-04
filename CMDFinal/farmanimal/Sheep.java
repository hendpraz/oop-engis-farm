package farmanimal;
import javax.swing.JOptionPane;

import products.*;
import products.farm.*;

public class Sheep extends FarmAnimal implements MeatProducingFarmAnimal{
    public boolean IsMeatProducing(){
        return true;
    }

    public char render() {
        if (this.getHungry() ){
            return 'd' ; //System.out.print("d");
        }else{
            return 'D' ; // System.out.print("D");
        }
    }
    
    public void ToSound() {
        //System.out.println("Mee mee");
    	JOptionPane.showMessageDialog(null, "Mee mee");
    }
    
    public int getDurationForHungryTime() {
        return 20 ; 
    }
    
    public FarmProduct getMeatProduct() {
        FarmProduct p = new SheepMeat() ;
        return p ;
    }
}
