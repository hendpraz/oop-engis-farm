#include <iostream>
using namespace std ;

#include "coop.h"

void Coop::render() {
	if (!this->getCreation() ){
		if (getGrass() ){
			cout << "#" ;
		}else{
			cout << "=" ;
		}
	}
	else
	{
		this->getCreation()->render() ;	
	}
	
}


int Coop::getIdentity() {
	return 1 ;
}

Coop::Coop() {
	this->setGrass(false) ;
}

Coop::Coop(bool _r) {
	this->setGrass(true) ;
}
