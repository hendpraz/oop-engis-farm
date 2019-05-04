package main.src;
//#include "renderable.h"
//#include "creation.h"

public class Cell implements Renderable{

private Creation creation;

public void render() {
	if (this.getCreation() == null ){
		System.out.print( "n" );
	}
	else
	{
		this.getCreation().render() ;	
	}
}

public void interact(int i) {
	//Nothing
}

public void setCreation(Creation _c){
	creation = _c ;
}

public Creation getCreation(){
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
