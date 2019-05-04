//#include "renderable.h"
//#include "creation.h"

public class Cell implements Renderable{

private Creation creation;

public char render() {
	if (this.getCreation() == null ){
		//System.out.print( "n" );
		return 'n' ;
	}
	else
	{
		return this.getCreation().render() ;	
	}
}

public void interact(int i) {
	//Nothing
}

public void setCreation(Creation _c){
	creation = _c ;
}

Creation getCreation(){
	return creation ;
}

public int getIdentity() {
	return -1 ; //Cell Murni
}

public boolean getAtribute(int i) {
	return false ;
}

public void update() {
	if (this.getCreation() == null){
		//Nothing
	}
	else
	{
		this.getCreation().Action(1) ; // Update	
	}
}

public boolean isPossibleToInteract(int i) {
	return false ;	
}

}
