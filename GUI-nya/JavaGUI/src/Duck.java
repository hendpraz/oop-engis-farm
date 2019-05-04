public class Duck extends FarmAnimal implements EggProducingFarmAnimal, MeatProducingFarmAnimal{
    public boolean IsMeatProducing(){
        return true;
    }

    public boolean IsEggProducing(){
        return true;
    }

    public char render() {
        if (this.getHungry() ){
            return 'b' ;
        	//System.out.print("b");
        }else{
        	return 'B' ;
            //System.out.print("B");
        }
    }
    
    public void ToSound() {
        System.out.println("Kwek Kwek");
    }
    
    public int getDurationForHungryTime() {
        return 20 ; 
    }
    
    public FarmProduct createProduct() {
        FarmProduct p = new DuckEgg() ;
        return p ;
    }
    
    public FarmProduct getMeatProduct() {
        FarmProduct p = new DuckMeat() ;
        return p ;
    }
    
    public Duck(){
		super.setMeatProducing(true);
	}
}
