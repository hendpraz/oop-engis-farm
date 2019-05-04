//#include "land.h"

public class Barn extends Land{

public char render() {
	if (this.getCreation() == null){
		if (getGrass() ){
			//System.out.print( "*" ) ;
			return '*' ;
		}else{
			return 'x' ;
			//System.out.print( "x" );
		}
	}
	else
	{
		return this.getCreation().render() ;	
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
