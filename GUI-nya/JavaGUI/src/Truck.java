import java.util.*;

class Truck extends Facility{
	private int truckTime;
	private int truckDuration;
	private Deque<String> productDeck;
	
	public char render() {
		return 'T' ;
		//System.out.print( "T" );
	}

	public int getIdentity() {
		return 5 ;
	}

	public void update() {
		if (truckTime > 0 ){
			truckTime -= 1 ;
		}else {
			//productDeck.add( "Truck Ada" ) ) ;
		}
	}

	public void interact(int i) {
		showListOfProduct();
	
		//Transaksi dilakukan oleh player
	}

	public boolean isPossibleToInteract(int i) {
		return (truckTime == 0) ;	
	}

	public void showListOfProduct(){
		for (String element : productDeck){
			System.out.println(element);
		}
	
	}

	public void truckGo(){
		truckTime = truckDuration ;
	}
	
	public Truck(){
		truckTime = 0 ;
		truckDuration = 12 ;	
		
		productDeck = new ArrayDeque<String>(20);
		
		productDeck.add( "1. ChickenEgg, harga 1500" );
		productDeck.add( "2. ChickenMeat, harga 5000" );
		productDeck.add( "3. CowMeat, harga 10000" );
		productDeck.add( "4. CowMilk, harga 2500" );
		productDeck.add( "5. DuckEgg, harga 2000" );
		productDeck.add( "6. DuckMeat, harga 7000" );
		productDeck.add( "7. GooseEgg, harga 2500" );
		productDeck.add( "8. GooseMeat, harga 7000");
		productDeck.add( "9. GoatMeat, harga 9000");
	
		productDeck.add( "11. Beef Rolade, harga 15000" );
		productDeck.add( "12. Butter, harga 6000" );
		productDeck.add( "13. Omelet, harga 5000" );
		
		productDeck.add( "21. GoatMilk, harga 2000");
		productDeck.add( "22. SheepMeat, harga 9500");
	}
}
