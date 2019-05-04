package land;
//#include "cell.h"
import src.Cell;

public class Land extends Cell{

private boolean grass ;
		
public char render() {
	return 'f' ; //none
}

public void interact(int i) {
	if (i == 0){
		//Grow
		this.setGrass(true) ;
	}else if (i == 1) {
		//Be Eaten
		this.setGrass(false) ;
	}
}

public boolean getGrass() {
	return grass ;
}

public void setGrass(boolean _grass) {
	grass = _grass ;
}

public boolean getAtribute(int i) {
	if (i == 0){
		return grass ;
	}
	return false ;
}


}
