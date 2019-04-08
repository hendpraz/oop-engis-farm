#include <iostream>
using namespace std ;

#include "map.h"
#include <vector>

Map::Map(int w, int h) {	
	mc = vector<vector<Cell* > > (w, vector<Cell*>(h) );
	width = w;
	height = h ;	
}

int Map::getWidth(){
	return width ;
}

int Map::getHeight() {
	return height ;
}

Cell* Map::getCell(int _i, int _j) {
	return mc[_i][_j] ;
}

void Map::setCell(int _i, int _j,Cell* cell) {
	mc[_i][_j] = cell ;
}

void Map::setCreation(int _i, int _j,Creation* _c) {
	Cell* gcell = mc[_i][_j] ; 
	
	gcell->setCreation(_c) ;
}

bool Map::IsReachable(int Brs_,int Kol_) {
	if ( Brs_ < 0 || Kol_ < 0 || Brs_ >= width  || Kol_ >= height  ){
		return false ;
	}else {
		return true ;
	}
}

