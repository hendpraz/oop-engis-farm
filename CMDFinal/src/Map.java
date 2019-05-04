package src;
//#include <iostream>
//using namespace std ;

//#include "map.h"
//#include <vector>
//#include "cell.h"
//#include <vector>
//#include "creation.h"

public class Map{

//private vector<vector<Cell>> mc;  matrix of cell	
private Cell[][] mc;	
private int width , height ;

public Map(int w, int h) {	
	mc = new Cell[w][h];
	width = w;
	height = h ;	
}

public int getWidth(){
	return width ;
}

public int getHeight() {
	return height ;
}

public Cell getCell(int _i, int _j) {
	return mc[_i][_j] ;
}

public void setCell(int _i, int _j,Cell cell) {
	mc[_i][_j] = cell ;
}

public void setCreation(int _i, int _j,Creation _c) {
	Cell gcell = mc[_i][_j] ; 
	
	gcell.setCreation(_c) ;
}

public boolean IsReachable(int Brs_,int Kol_) {
	if ( Brs_ < 0 || Kol_ < 0 || Brs_ >= width  || Kol_ >= height  ){
		return false ;
	}else {
		return true ;
	}
}	

}
