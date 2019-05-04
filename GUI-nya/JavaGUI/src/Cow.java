public class Cow extends FarmAnimal implements MilkProducingFarmAnimal, MeatProducingFarmAnimal{
    public boolean IsMeatProducing(){
        return true;
    }

    public boolean IsMilkProducing(){
        return true;
    }

    public char render() {
        if (this.getHungry() ){
            //System.out.print("s");
        	return 's' ;
        }else{
        	return 'S' ;
            //System.out.print("S");
        }
    }
    
    public void ToSound() {
        System.out.println("Mooo");
    }
    
    public int getDurationForHungryTime() {
        return 25 ; 
    }
    
    public FarmProduct createProduct() {
        FarmProduct p = new CowMilk() ;
        return p ;
    }
    
    public FarmProduct getMeatProduct() {
        FarmProduct p = new CowMeat() ;
        return p ;
    }
    
    public Cow(){
		super.setMeatProducing(true);
	}
}
