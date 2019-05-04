public class Goose extends FarmAnimal implements EggProducingFarmAnimal, MeatProducingFarmAnimal{
    public boolean IsMeatProducing(){
        return true;
    }

    public boolean IsEggProducing(){
        return true;
    }

    public void render() {
        if (this.getHungry() ){
            System.out.print("g");
        }else{
            System.out.print("G");
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
