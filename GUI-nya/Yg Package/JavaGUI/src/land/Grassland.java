package land;
//#include "grassland.h"
//#include "land.h"

public class Grassland extends Land{

public char render() {
	if (this.getCreation() == null){
		if (getGrass() ){
			return '+' ; //System.out.print("+") ;
		}else{
			return '-' ; //System.out.print("-") ;
		}
	}
	else
	{
		return this.getCreation().render() ;	
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
