public class Sheep extends FarmAnimal implements MeatProducingFarmAnimal{
    public boolean IsMeatProducing(){
        return true;
    }

    public void render() {
        if (this.getHungry() ){
            System.out.print("d");
        }else{
            System.out.print("D");
        }
    }
    
    public void ToSound() {
        System.out.println("Mee mee");
    }
    
    public int getDurationForHungryTime() {
        return 20 ; 
    }
    
    public FarmProduct getMeatProduct() {
        FarmProduct p = new SheepMeat() ;
        return p ;
    }
    
    public Sheep(){
		super.setMeatProducing(true);
	}
}
