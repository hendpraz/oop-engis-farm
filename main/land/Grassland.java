package main.land;
//#include "grassland.h"
//#include "land.h"

public class Grassland extends Land{

public void render() {
	if (this.getCreation() == null){
		if (getGrass() ){
			System.out.print("+") ;
		}else{
			System.out.print("-") ;
		}
	}
	else
	{
		this.getCreation().render() ;	
	}
	
}

public int getIdentity() {
	return 2 ;
}

public Grassland() {
	this.setGrass(false) ;
}

public Grassland(boolean _r) {
	this.setGrass(_r) ;
}

}
