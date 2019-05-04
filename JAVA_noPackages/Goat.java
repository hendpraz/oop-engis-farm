public class Goat extends FarmAnimal implements MilkProducingFarmAnimal, MeatProducingFarmAnimal{
    public boolean IsMeatProducing(){
        return true;
    }

    public boolean IsMilkProducing(){
        return true;
    }

    public void render() {
        if (this.getHungry() ){
            System.out.print("k");
        }else{
            System.out.print("K");
        }
    }
    
    public void ToSound() {
        System.out.println("Mbeeek");
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
    
    public Goat(){
		super.setMeatProducing(true);
	}
}
