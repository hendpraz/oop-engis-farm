public class Goose extends FarmAnimal implements EggProducingFarmAnimal, MeatProducingFarmAnimal{
    public boolean IsMeatProducing(){
        return true;
    }

    public boolean IsEggProducing(){
        return true;
    }

    public char render() {
        if (this.getHungry() ){
            return 'g' ;
        	//System.out.print("g");
        }else{
        	return 'G' ;
            //System.out.print("G");
        }
    }
    
    public void ToSound() {
        System.out.println("Kwok Kwok");
    }
    
    public int getDurationForHungryTime() {
        return 15 ; 
    }
    
    public FarmProduct createProduct() {
        FarmProduct p = new GooseEgg() ;
        return p ;
    }
    
    public FarmProduct getMeatProduct() {
        FarmProduct p = new GooseMeat() ;
        return p ;
    }
    
    public Goose(){
		super.setMeatProducing(true);
	}
}
