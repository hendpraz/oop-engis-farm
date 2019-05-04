//#include "land.h"

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

Barn(boolean _r) {
	this.setGrass(_r) ;
}

Barn() {
	this.setGrass(false) ;
}

}
