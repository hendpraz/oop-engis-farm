package main.land;
//#include "coop.h"
//#include "land.h"

public class Coop extends Land{

public void render() {
	if (this.getCreation() == null){
		if (getGrass() ){
			System.out.print("#") ;
		}else{
			System.out.print("=") ;
		}
	}
	else
	{
		this.getCreation().render() ;	
	}
	
}

public int getIdentity() {
	return 1 ;
}

public Coop() {
	this.setGrass(false) ;
}

public Coop(boolean _r) {
	this.setGrass(true) ;
}

}
