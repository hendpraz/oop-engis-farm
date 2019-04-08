#include <iostream>
using namespace std ;

#include "barn.h"

void Barn::render() {
	if (!this->getCreation() ){
		if (getGrass() ){
			cout << "*" ;
		}else{
			cout << "x" ;
		}
	}
	else
	{
		this->getCreation()->render() ;	
	}
	
}


int Barn::getIdentity() {
	return 0 ;
}

Barn::Barn(bool _r) {
	this->setGrass(_r) ;
}

Barn::Barn() {
	this->setGrass(false) ;
}
