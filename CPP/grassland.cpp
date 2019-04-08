#include <iostream>
using namespace std ;

#include "grassland.h"

void Grassland::render() {
	if (!this->getCreation() ){
		if (getGrass() ){
			cout << "+" ;
		}else{
			cout << "-" ;
		}
	}
	else
	{
		this->getCreation()->render() ;	
	}
	
}

int Grassland::getIdentity() {
	return 2 ;
}

Grassland::Grassland() {
	this->setGrass(false) ;
}

Grassland::Grassland(bool _r) {
	this->setGrass(_r) ;
}
