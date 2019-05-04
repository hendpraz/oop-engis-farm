package land;
//#include "coop.h"
//#include "land.h"

public class Coop extends Land{

public char render() {
	if (this.getCreation() == null){
		if (getGrass() ){
			return '#' ; //System.out.print("#") ;
		}else{
			return '+' ; //System.out.print("=") ;
		}
	}
	else
	{
		return this.getCreation().render() ;	
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
