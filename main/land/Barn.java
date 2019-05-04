//#include "land.h"
package main.land;

public class Barn extends Land{

public void render() {
	if (this.getCreation() == null){
		if (getGrass() ){
			System.out.print( "*" ) ;
		}else{
			System.out.print( "x" );
		}
	}
	else
	{
		this.getCreation().render() ;	
	}
	
}


public int getIdentity() {
	return 0 ;
}

public Barn(boolean _r) {
	this.setGrass(_r) ;
}

public Barn() {
	this.setGrass(false) ;
}

}
