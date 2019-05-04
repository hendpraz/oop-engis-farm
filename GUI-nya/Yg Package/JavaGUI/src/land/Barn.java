//#include "land.h"
package land;

public class Barn extends Land{

public char render() {
	if (this.getCreation() == null){
		if (getGrass() ){
			return '*' ; //System.out.print( "*" ) ;
		}else{
			return 'x' ; //System.out.print( "x" );
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

public Barn(boolean _r) {
	this.setGrass(_r) ;
}

public Barn() {
	this.setGrass(false) ;
}

}
